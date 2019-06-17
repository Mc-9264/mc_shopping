package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;
import com.springcloud.vo.ResultValue;

/**
 * 商品控制层
 * @author 春望
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 添加新商品信息
	 * @param goods 新商品信息
	 * @return
	 */
	@RequestMapping(value="/insert")
	public ResultValue insert(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer insert = this.goodsService.insert(goods);
			if(insert > 0) {
				rv.setCode(0);
				rv.setMessage("商品信息录入成功！！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("商品信息录入失败！！！");
		return rv;
	}
	@RequestMapping(value = "/select")
	public ResultValue select(Goods goods, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			//查询满足条件的商品信息
			PageInfo<Goods> pageInfo = this.goodsService.select(goods, pageNumber);
			//从分页信息中获取商品信息
			List<Goods> list = pageInfo.getList();
			//如果查询到了满足条件的商品信息
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				
				Map<String, Object> map = new HashMap<>();
				//将商品信息以指定的键存入Map集合中
				map.put("goodsList", list);
				
				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				//将分页信息以指定名字存入Map集合中
				map.put("pageUtils", pageUtils);
				
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		rv.setCode(1);
		rv.setMessage("没有找到满足添加的商品信息！！！");
		return rv;
	}
	
	@RequestMapping(value="/updateById")
	public ResultValue updateById(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer update = this.goodsService.updateGoodsById(goods);
			if(update > 0) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功！！！");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("修改商品信息失败！！！");
		return rv;
	}
	
	/**
	 * 修改商品信息
	 * @param goods	修改商品信息
	 * @return
	 */
	@RequestMapping(value="/update")
	public ResultValue update(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer update = this.goodsService.update(goods);
			if(update != null) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功！！！");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("修改商品信息失败！！！");
		return rv;
	}
}
