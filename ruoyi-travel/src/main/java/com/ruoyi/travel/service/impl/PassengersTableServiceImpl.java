package com.ruoyi.travel.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.travel.domain.PassengersTable;
import com.ruoyi.travel.mapper.PassengersTableMapper;
import com.ruoyi.travel.service.IPassengersTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 旅客数据Service业务层处理
 * 
 * @author ljh
 * @date 2020-01-29
 */
@Service
public class PassengersTableServiceImpl implements IPassengersTableService 
{
    @Autowired
    private PassengersTableMapper passengersTableMapper;

    /**
     * 查询旅客数据
     * 
     * @param id 旅客数据ID
     * @return 旅客数据
     */
    @Override
    public PassengersTable selectPassengersTableById(Long id)
    {
        return passengersTableMapper.selectPassengersTableById(id);
    }

    /**
     * 查询旅客数据列表
     * 
     * @param passengersTable 旅客数据
     * @return 旅客数据
     */
    @Override
    public List<PassengersTable> selectPassengersTableList(PassengersTable passengersTable)
    {
        return passengersTableMapper.selectPassengersTableList(passengersTable);
    }

    /**
     * 新增旅客数据
     * 
     * @param passengersTable 旅客数据
     * @return 结果
     */
    @Override
    public int insertPassengersTable(PassengersTable passengersTable)
    {
        return passengersTableMapper.insertPassengersTable(passengersTable);
    }

    /**
     * 修改旅客数据
     * 
     * @param passengersTable 旅客数据
     * @return 结果
     */
    @Override
    public int updatePassengersTable(PassengersTable passengersTable)
    {
        return passengersTableMapper.updatePassengersTable(passengersTable);
    }

    /**
     * 删除旅客数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePassengersTableByIds(String ids)
    {
        return passengersTableMapper.deletePassengersTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除旅客数据信息
     * 
     * @param id 旅客数据ID
     * @return 结果
     */
    @Override
    public int deletePassengersTableById(Long id)
    {
        return passengersTableMapper.deletePassengersTableById(id);
    }


}
