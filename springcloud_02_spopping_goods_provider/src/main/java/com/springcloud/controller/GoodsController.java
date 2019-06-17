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
 * ��Ʒ���Ʋ�
 * @author ����
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	/**
	 * �������Ʒ��Ϣ
	 * @param goods ����Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value="/insert")
	public ResultValue insert(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer insert = this.goodsService.insert(goods);
			if(insert > 0) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ¼��ɹ�������");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("��Ʒ��Ϣ¼��ʧ�ܣ�����");
		return rv;
	}
	@RequestMapping(value = "/select")
	public ResultValue select(Goods goods, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			//��ѯ������������Ʒ��Ϣ
			PageInfo<Goods> pageInfo = this.goodsService.select(goods, pageNumber);
			//�ӷ�ҳ��Ϣ�л�ȡ��Ʒ��Ϣ
			List<Goods> list = pageInfo.getList();
			//�����ѯ����������������Ʒ��Ϣ
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				
				Map<String, Object> map = new HashMap<>();
				//����Ʒ��Ϣ��ָ���ļ�����Map������
				map.put("goodsList", list);
				
				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				//����ҳ��Ϣ��ָ�����ִ���Map������
				map.put("pageUtils", pageUtils);
				
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		rv.setCode(1);
		rv.setMessage("û���ҵ�������ӵ���Ʒ��Ϣ������");
		return rv;
	}
	
	@RequestMapping(value="/updateById")
	public ResultValue updateById(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer update = this.goodsService.updateGoodsById(goods);
			if(update > 0) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ�޸ĳɹ�������");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�޸���Ʒ��Ϣʧ�ܣ�����");
		return rv;
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param goods	�޸���Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value="/update")
	public ResultValue update(Goods goods) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer update = this.goodsService.update(goods);
			if(update != null) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ�޸ĳɹ�������");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�޸���Ʒ��Ϣʧ�ܣ�����");
		return rv;
	}
}
