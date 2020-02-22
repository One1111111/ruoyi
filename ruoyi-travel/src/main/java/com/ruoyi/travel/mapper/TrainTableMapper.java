package com.ruoyi.travel.mapper;

import com.ruoyi.travel.domain.TrainTable;
import java.util.List;

/**
 * 列车管理Mapper接口
 * 
 * @author cy
 * @date 2020-02-16
 */
public interface TrainTableMapper 
{
    /**
     * 查询列车管理
     * 
     * @param id 列车管理ID
     * @return 列车管理
     */
    public TrainTable selectTrainTableById(Long id);

    /**
     * 查询列车管理列表
     * 
     * @param trainTable 列车管理
     * @return 列车管理集合
     */
    public List<TrainTable> selectTrainTableList(TrainTable trainTable);

    /**
     * 新增列车管理
     * 
     * @param trainTable 列车管理
     * @return 结果
     */
    public int insertTrainTable(TrainTable trainTable);

    /**
     * 修改列车管理
     * 
     * @param trainTable 列车管理
     * @return 结果
     */
    public int updateTrainTable(TrainTable trainTable);

    /**
     * 删除列车管理
     * 
     * @param id 列车管理ID
     * @return 结果
     */
    public int deleteTrainTableById(Long id);

    /**
     * 批量删除列车管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTrainTableByIds(String[] ids);
}
