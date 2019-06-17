package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * ����ģ��ģ�Ͳ�Ľӿڣ����ڶ��嶩��ģ�͵ķ���
 * 
 * @author ����
 *
 */
public interface OrdersService {

	/**
	 * ��ѯ���������Ķ�����Ϣ����ҳ���ܣ�
	 * 
	 * @param orders ��ѯ����
	 * @return ����com.github.pagehelper.PageInfo<Orders>���͵�ʵ��
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber);
	
	/**
	 * �޸�ָ����Ŷ����Ķ���״̬
	 * @param orders	�޸Ķ�������Ϣ
	 * @return	�ɹ����ش���0 �����������򷵻�С��0��С��0 ������
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
}
