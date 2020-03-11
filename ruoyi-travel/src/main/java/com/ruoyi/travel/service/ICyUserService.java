package com.ruoyi.travel.service;

import com.ruoyi.travel.domain.CyUser;
import java.util.List;

/**
 * 用户管理Service接口
 * 
 * @author cy
 * @date 2020-03-01
 */
public interface ICyUserService 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理ID
     * @return 用户管理
     */
    public CyUser selectCyUserById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param cyUser 用户管理
     * @return 用户管理集合
     */
    public List<CyUser> selectCyUserList(CyUser cyUser);

    /**
     * 新增用户管理
     * 
     * @param cyUser 用户管理
     * @return 结果
     */
    public int insertCyUser(CyUser cyUser);

    /**
     * 修改用户管理
     * 
     * @param cyUser 用户管理
     * @return 结果
     */
    public int updateCyUser(CyUser cyUser);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCyUserByIds(String ids);

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理ID
     * @return 结果
     */
    public int deleteCyUserById(Long id);

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importUser(List<CyUser> userList, Boolean isUpdateSupport, String operName);
}
