package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order表对应的实体类，用于封装一行表单明细信息
 * @author 春望
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements java.io.Serializable {
    
	private static final long serialVersionUID = -3857392721920542241L;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 用户编号
	 */
    private Users user;

    /**
     * 收货人姓名,如果省略默认为用户表中的用户姓名
     */
    private String receiverName;

    /**
     * 收货人电话,如果省略默认为用户表中的联系电话
     */
    private String receiverTel;

    /**
     * 收货人地址,如果省略默认为用户表中的收货地址
     */
    private String receiverAddr;

    /**
     * 下单时间,默认为当前时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTime;

    /**
     * 订单总额
     */
    private Double orderTotal;

    /**
     * 订单状态:0待付款,1待发货,2待收货,3已付款,4已退货
     */
    private Integer orderStatus;
    
    /**
     * 下单时间下限
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDateMin;
    
    /**
     * 下单时间上限
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDateMax;
}