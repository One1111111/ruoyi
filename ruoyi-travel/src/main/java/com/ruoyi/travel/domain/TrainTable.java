package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 列车管理对象 train_table
 * 
 * @author cy
 * @date 2020-02-16
 */
public class TrainTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 列车类型 */
    @Excel(name = "列车类型")
    private String type;

    /** 发站 */
    @Excel(name = "发站")
    private String hairstanding;

    /** 到站 */
    @Excel(name = "到站")
    private String theterminal;

    /** 中转站 */
    @Excel(name = "中转站")
    private String transferstation;

    /** 开车时间 */
    @Excel(name = "开车时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date drivingtime;

    /** 到达时间 */
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date timeofarrival;

    /** 车次 */
    @Excel(name = "车次")
    private String trains;

    /** 站数 */
    @Excel(name = "站数")
    private Long standNumber;

    /** 票价 */
    @Excel(name = "票价")
    private Long price;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setHairstanding(String hairstanding) 
    {
        this.hairstanding = hairstanding;
    }

    public String getHairstanding() 
    {
        return hairstanding;
    }
    public void setTheterminal(String theterminal) 
    {
        this.theterminal = theterminal;
    }

    public String getTheterminal() 
    {
        return theterminal;
    }
    public void setTransferstation(String transferstation) 
    {
        this.transferstation = transferstation;
    }

    public String getTransferstation() 
    {
        return transferstation;
    }
    public void setDrivingtime(Date drivingtime) 
    {
        this.drivingtime = drivingtime;
    }

    public Date getDrivingtime() 
    {
        return drivingtime;
    }
    public void setTimeofarrival(Date timeofarrival) 
    {
        this.timeofarrival = timeofarrival;
    }

    public Date getTimeofarrival() 
    {
        return timeofarrival;
    }
    public void setTrains(String trains) 
    {
        this.trains = trains;
    }

    public String getTrains() 
    {
        return trains;
    }
    public void setStandNumber(Long standNumber) 
    {
        this.standNumber = standNumber;
    }

    public Long getStandNumber() 
    {
        return standNumber;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("hairstanding", getHairstanding())
            .append("theterminal", getTheterminal())
            .append("transferstation", getTransferstation())
            .append("drivingtime", getDrivingtime())
            .append("timeofarrival", getTimeofarrival())
            .append("trains", getTrains())
            .append("standNumber", getStandNumber())
            .append("price", getPrice())
            .toString();
    }
}
