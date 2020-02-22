package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景点数据对象 attractions_table
 * 
 * @author cy
 * @date 2020-01-30
 */
public class AttractionsTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 景点地址 */
    @Excel(name = "景点地址")
    private String address;

    /** x坐标 */
    @Excel(name = "x坐标")
    private String lat;

    /** y坐标 */
    @Excel(name = "y坐标")
    private String lng;

    /** 景点名称 */
    @Excel(name = "景点名称")
    private String dest;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 游客人数 */
    @Excel(name = "游客人数")
    private Long humanTraffic;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setLng(String lng) 
    {
        this.lng = lng;
    }

    public String getLng() 
    {
        return lng;
    }
    public void setDest(String dest) 
    {
        this.dest = dest;
    }

    public String getDest() 
    {
        return dest;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setHumanTraffic(Long humanTraffic) 
    {
        this.humanTraffic = humanTraffic;
    }

    public Long getHumanTraffic() 
    {
        return humanTraffic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("address", getAddress())
            .append("lat", getLat())
            .append("lng", getLng())
            .append("dest", getDest())
            .append("city", getCity())
            .append("province", getProvince())
            .append("humanTraffic", getHumanTraffic())
            .toString();
    }
}
