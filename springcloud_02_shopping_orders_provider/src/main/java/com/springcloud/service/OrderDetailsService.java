package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetails;

/**
 * ������ϸģ��ģ�Ͳ�Ľӿڣ����ڶ��嶩����ϸģ��ķ���
 * @author ����
 *
 */
public interface OrderDetailsService {

	/**
	 * ��ѯָ��������ŵĶ�����ϸ��Ϣ����ҳ���ܣ�
	 * @param orderId	�������
	 * @param pageNumber	ҳ��
	 * @return	�ɹ�����com.github.pagehelper.PageInfo<OrderDetails>���͵�ʵ��
	 */
	public abstract PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber);
}
