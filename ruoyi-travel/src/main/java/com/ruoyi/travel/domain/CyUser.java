package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 cy_user
 * 
 * @author cy
 * @date 2020-03-01
 */
public class CyUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 密码 */
    @Excel(name = "密码")
    private String passWord;

    /** 兴趣爱好 */
    @Excel(name = "兴趣爱好")
    private String hobbies;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String familyAddress;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String signature;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassWord(String passWord) 
    {
        this.passWord = passWord;
    }

    public String getPassWord() 
    {
        return passWord;
    }
    public void setHobbies(String hobbies) 
    {
        this.hobbies = hobbies;
    }

    public String getHobbies() 
    {
        return hobbies;
    }
    public void setFamilyAddress(String familyAddress) 
    {
        this.familyAddress = familyAddress;
    }

    public String getFamilyAddress() 
    {
        return familyAddress;
    }
    public void setSignature(String signature) 
    {
        this.signature = signature;
    }

    public String getSignature() 
    {
        return signature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("passWord", getPassWord())
            .append("hobbies", getHobbies())
            .append("familyAddress", getFamilyAddress())
            .append("signature", getSignature())
            .toString();
    }
}
