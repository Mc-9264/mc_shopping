package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;

/**
 * 	���ڶ���һ������ڶ������ģ��ķ���
 * @author ����
 *
 */
public interface TypeService {

	/**
	 * 	��ѯ����һ��������Ϣ
	 * @return	�ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	public abstract List<TypeOne> selectAllTypeOne();
	
	/**
	 * 	����һ������Ų�ѯ��Ӧ�Ķ������
	 * @param typeOneId	һ�������
	 * @return	�ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	public abstract List<TypeTwo> selectTypeTwoBypeOneId(Integer typeOneId);
	
}
