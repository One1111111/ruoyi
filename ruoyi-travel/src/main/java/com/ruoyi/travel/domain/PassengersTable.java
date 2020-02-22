package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 旅客数据对象 passengers_table
 * 
 * @author ljh
 * @date 2020-01-29
 */
public class PassengersTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 喜欢去的地方 */
    @Excel(name = "喜欢去的地方")
    private String place;

    /** 搜索关键字 */
    @Excel(name = "搜索关键字")
    private String search;

    /** 出行方式 */
    @Excel(name = "出行方式")
    private String tripMode;

    /** 出行花费 */
    @Excel(name = "出行花费")
    private Double travelCost;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setSearch(String search) 
    {
        this.search = search;
    }

    public String getSearch() 
    {
        return search;
    }
    public void setTripMode(String tripMode) 
    {
        this.tripMode = tripMode;
    }

    public String getTripMode() 
    {
        return tripMode;
    }
    public void setTravelCost(Double travelCost) 
    {
        this.travelCost = travelCost;
    }

    public Double getTravelCost() 
    {
        return travelCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("place", getPlace())
            .append("search", getSearch())
            .append("tripMode", getTripMode())
            .append("travelCost", getTravelCost())
            .toString();
    }
}
