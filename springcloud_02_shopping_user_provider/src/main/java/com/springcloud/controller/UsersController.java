package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * 控制层：接收视图层的数据，并调用模型层相应的方法，将数据返回到视图层中
 * @author 春望
 * @param <RseultValue>
 *
 */
@RestController
public class UsersController<RseultValue> {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/login")
	public ResultValue login(@RequestParam("userId") Integer userId,@RequestParam("userPsw") String userPsw,@RequestParam("permissionId") Integer permissionId) {
		ResultValue rv = new ResultValue();
		
		try {
			Users login = this.usersService.login(userId, userPsw, permissionId);
			if(login != null) {
				rv.setCode(0);
				
				Map<String, Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);
				
				return rv;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("登录信息不正确，请重新输入！！！");
		return rv;
	}
	
	@RequestMapping(value = "/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			Users insert = this.usersService.insert(users);
			if(insert != null) {
				rv.setCode(0);
				rv.setMessage("用户录入成功！！！");
				return rv;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("用户录入失败");
		return rv;
	}
	
	/**
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/select")
	public ResultValue select(Users users, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		
		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			//获取分页数据
			List<Users> list = page.getContent();
			//判断是否查询到了数据
			if(list != null & list.size() > 0) {
				rv.setCode(0);
				
				Map<String, Object> map = new HashMap<>();
				//将分页的数据添加到map中
				map.put("userList", list);
				
				PageUtils pageUtils = new PageUtils((int)page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				//将分页信息的数据添加到map中
				map.put("pageUtils", pageUtils);
				
				rv.setDataMap(map);
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId, @RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer status = this.usersService.updateStatus(userId, userStatus);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("修改用户状态成功！！！");
				return rv;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户状态修改失败！！");
		return rv;
	}
	
	/**
	 * 查询指定编号的用户信息
	 * @param userId	用户编号
	 * @return
	 */
	@RequestMapping(value = "/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		
		try {
			//调用service中的方法，并获得查询的结果
			Users users = this.usersService.selectById(userId);
			//如果成功
			if(users != null) {
				//设置结果的状态为0
				rv.setCode(0);
				//创建Map集合保存查询结果
				Map<String, Object> map = new HashMap<>();
				//将查询结果保存到Map集合中
				map.put("users", users);
				//将Map集合添加到ResultValue对象中
				rv.setDataMap(map);
				//返回ResultValue对象
				return rv;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("获取用户信息失败！！！");
		return rv;
	}
	
	@RequestMapping(value = "/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			//调用修改service中相应的方法修改用户信息，并获得修改是否正确
			Integer update = this.usersService.update(users);
			//如果成功
			if(update > 0) {
				//设置结果的状态为0
				rv.setCode(0);
				//返回ResultValue对象
				return rv;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("用户信息修改失败！！！");
		return rv;
	}
	
	@RequestMapping(value = "/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer updateMessage = this.usersService.updateMessage(users);
			if(updateMessage > 0) {
				rv.setCode(0);
				rv.setMessage("修改信息成功！！！");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("修改信息失败！！！");
		return rv;
	}
}
