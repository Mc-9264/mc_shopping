package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * 订单模块模型层的接口，用于定义订单模型的方法
 * 
 * @author 春望
 *
 */
public interface OrdersService {

	/**
	 * 查询满足条件的订单信息（分页功能）
	 * 
	 * @param orders 查询条件
	 * @return 返回com.github.pagehelper.PageInfo<Orders>类型的实例
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber);
	
	/**
	 * 修改指定编号订单的订单状态
	 * @param orders	修改订单的信息
	 * @return	成功返回大于0 的整数，否则返回小于0或小于0 的整数
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
}
