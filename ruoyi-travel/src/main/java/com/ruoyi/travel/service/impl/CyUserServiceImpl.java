package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.CyUserMapper;
import com.ruoyi.travel.domain.CyUser;
import com.ruoyi.travel.service.ICyUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户管理Service业务层处理
 * 
 * @author cy
 * @date 2020-03-01
 */
@Service
public class CyUserServiceImpl implements ICyUserService 
{
    @Autowired
    private CyUserMapper cyUserMapper;

    /**
     * 查询用户管理
     * 
     * @param id 用户管理ID
     * @return 用户管理
     */
    @Override
    public CyUser selectCyUserById(Long id)
    {
        return cyUserMapper.selectCyUserById(id);
    }

    /**
     * 查询用户管理列表
     * 
     * @param cyUser 用户管理
     * @return 用户管理
     */
    @Override
    public List<CyUser> selectCyUserList(CyUser cyUser)
    {
        return cyUserMapper.selectCyUserList(cyUser);
    }

    /**
     * 新增用户管理
     * 
     * @param cyUser 用户管理
     * @return 结果
     */
    @Override
    public int insertCyUser(CyUser cyUser)
    {
        return cyUserMapper.insertCyUser(cyUser);
    }

    /**
     * 修改用户管理
     * 
     * @param cyUser 用户管理
     * @return 结果
     */
    @Override
    public int updateCyUser(CyUser cyUser)
    {
        return cyUserMapper.updateCyUser(cyUser);
    }

    /**
     * 删除用户管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCyUserByIds(String ids)
    {
        return cyUserMapper.deleteCyUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理ID
     * @return 结果
     */
    @Override
    public int deleteCyUserById(Long id)
    {
        return cyUserMapper.deleteCyUserById(id);
    }
}
