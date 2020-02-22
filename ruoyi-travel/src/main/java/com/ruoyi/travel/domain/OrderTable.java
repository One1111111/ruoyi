package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 订单管理对象 order_table
 * 
 * @author cy
 * @date 2020-02-19
 */
public class OrderTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long orderStatus;

    /** 订单日期 */
    @Excel(name = "订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 用户手机号码 */
    @Excel(name = "用户手机号码")
    private String userPhoneNumber;

    /** 车次 */
    @Excel(name = "车次")
    private String train;

    /** 出发站 */
    @Excel(name = "出发站")
    private String departureStation;

    /** 到达站 */
    @Excel(name = "到达站")
    private String destinationStation;

    /** 出发时间 */
    @Excel(name = "出发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureDate;

    /** 到达时间 */
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date destinationDate;

    /** 车票价格 */
    @Excel(name = "车票价格")
    private Double trainPrice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setOrderStatus(Long orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public Long getOrderStatus() 
    {
        return orderStatus;
    }
    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserPhoneNumber(String userPhoneNumber) 
    {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPhoneNumber() 
    {
        return userPhoneNumber;
    }
    public void setTrain(String train) 
    {
        this.train = train;
    }

    public String getTrain() 
    {
        return train;
    }
    public void setDepartureStation(String departureStation) 
    {
        this.departureStation = departureStation;
    }

    public String getDepartureStation() 
    {
        return departureStation;
    }
    public void setDestinationStation(String destinationStation) 
    {
        this.destinationStation = destinationStation;
    }

    public String getDestinationStation() 
    {
        return destinationStation;
    }
    public void setDepartureDate(Date departureDate) 
    {
        this.departureDate = departureDate;
    }

    public Date getDepartureDate() 
    {
        return departureDate;
    }
    public void setDestinationDate(Date destinationDate) 
    {
        this.destinationDate = destinationDate;
    }

    public Date getDestinationDate() 
    {
        return destinationDate;
    }
    public void setTrainPrice(Double trainPrice) 
    {
        this.trainPrice = trainPrice;
    }

    public Double getTrainPrice() 
    {
        return trainPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNumber", getOrderNumber())
            .append("orderStatus", getOrderStatus())
            .append("orderDate", getOrderDate())
            .append("userName", getUserName())
            .append("userPhoneNumber", getUserPhoneNumber())
            .append("train", getTrain())
            .append("departureStation", getDepartureStation())
            .append("destinationStation", getDestinationStation())
            .append("departureDate", getDepartureDate())
            .append("destinationDate", getDestinationDate())
            .append("trainPrice", getTrainPrice())
            .toString();
    }
}
