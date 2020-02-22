package com.ruoyi.travel.mapper;

import com.ruoyi.travel.domain.AttractionsTable;

import java.util.List;

/**
 * 景点数据Mapper接口
 * 
 * @author cy
 * @date 2020-01-30
 */
public interface AttractionsTableMapper 
{
    /**
     * 查询景点数据
     * 
     * @param id 景点数据ID
     * @return 景点数据
     */
    public AttractionsTable selectAttractionsTableById(Long id);

    /**
     * 查询景点数据列表
     * 
     * @param attractionsTable 景点数据
     * @return 景点数据集合
     */
    public List<AttractionsTable> selectAttractionsTableList(AttractionsTable attractionsTable);

    /**
     * 新增景点数据
     * 
     * @param attractionsTable 景点数据
     * @return 结果
     */
    public int insertAttractionsTable(AttractionsTable attractionsTable);

    /**
     * 修改景点数据
     * 
     * @param attractionsTable 景点数据
     * @return 结果
     */
    public int updateAttractionsTable(AttractionsTable attractionsTable);

    /**
     * 删除景点数据
     * 
     * @param id 景点数据ID
     * @return 结果
     */
    public int deleteAttractionsTableById(Long id);

    /**
     * 批量删除景点数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAttractionsTableByIds(String[] ids);

    /**
     * 查询出各个省份游客最多的景点
     */
    public List<AttractionsTable> selectRankingList();
}
