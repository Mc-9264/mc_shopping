package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order���Ӧ��ʵ���࣬���ڷ�װһ�б���ϸ��Ϣ
 * @author ����
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements java.io.Serializable {
    
	private static final long serialVersionUID = -3857392721920542241L;

	/**
	 * �������
	 */
	private Integer orderId;

	/**
	 * �û����
	 */
    private Users user;

    /**
     * �ջ�������,���ʡ��Ĭ��Ϊ�û����е��û�����
     */
    private String receiverName;

    /**
     * �ջ��˵绰,���ʡ��Ĭ��Ϊ�û����е���ϵ�绰
     */
    private String receiverTel;

    /**
     * �ջ��˵�ַ,���ʡ��Ĭ��Ϊ�û����е��ջ���ַ
     */
    private String receiverAddr;

    /**
     * �µ�ʱ��,Ĭ��Ϊ��ǰʱ��
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTime;

    /**
     * �����ܶ�
     */
    private Double orderTotal;

    /**
     * ����״̬:0������,1������,2���ջ�,3�Ѹ���,4���˻�
     */
    private Integer orderStatus;
    
    /**
     * �µ�ʱ������
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDateMin;
    
    /**
     * �µ�ʱ������
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDateMax;
}