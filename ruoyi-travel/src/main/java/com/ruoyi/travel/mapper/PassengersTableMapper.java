package com.ruoyi.travel.mapper;

import com.ruoyi.travel.domain.PassengersTable;

import java.util.List;

/**
 * 旅客数据Mapper接口
 *
 * @author ljh
 * @date 2020-01-29
 */
public interface PassengersTableMapper {
    /**
     * 查询旅客数据
     *
     * @param id 旅客数据ID
     * @return 旅客数据
     */
    public PassengersTable selectPassengersTableById(Long id);

    /**
     * 查询旅客数据列表
     *
     * @param passengersTable 旅客数据
     * @return 旅客数据集合
     */
    public List<PassengersTable> selectPassengersTableList(PassengersTable passengersTable);

    /**
     * 新增旅客数据
     *
     * @param passengersTable 旅客数据
     * @return 结果
     */
    public int insertPassengersTable(PassengersTable passengersTable);

    /**
     * 修改旅客数据
     *
     * @param passengersTable 旅客数据
     * @return 结果
     */
    public int updatePassengersTable(PassengersTable passengersTable);

    /**
     * 删除旅客数据
     *
     * @param id 旅客数据ID
     * @return 结果
     */
    public int deletePassengersTableById(Long id);

    /**
     * 批量删除旅客数据
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePassengersTableByIds(String[] ids);

}
