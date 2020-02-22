package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.TrainTableMapper;
import com.ruoyi.travel.domain.TrainTable;
import com.ruoyi.travel.service.ITrainTableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 列车管理Service业务层处理
 * 
 * @author cy
 * @date 2020-02-16
 */
@Service
public class TrainTableServiceImpl implements ITrainTableService 
{
    @Autowired
    private TrainTableMapper trainTableMapper;

    /**
     * 查询列车管理
     * 
     * @param id 列车管理ID
     * @return 列车管理
     */
    @Override
    public TrainTable selectTrainTableById(Long id)
    {
        return trainTableMapper.selectTrainTableById(id);
    }

    /**
     * 查询列车管理列表
     * 
     * @param trainTable 列车管理
     * @return 列车管理
     */
    @Override
    public List<TrainTable> selectTrainTableList(TrainTable trainTable)
    {
        return trainTableMapper.selectTrainTableList(trainTable);
    }

    /**
     * 新增列车管理
     * 
     * @param trainTable 列车管理
     * @return 结果
     */
    @Override
    public int insertTrainTable(TrainTable trainTable)
    {
        return trainTableMapper.insertTrainTable(trainTable);
    }

    /**
     * 修改列车管理
     * 
     * @param trainTable 列车管理
     * @return 结果
     */
    @Override
    public int updateTrainTable(TrainTable trainTable)
    {
        return trainTableMapper.updateTrainTable(trainTable);
    }

    /**
     * 删除列车管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTrainTableByIds(String ids)
    {
        return trainTableMapper.deleteTrainTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除列车管理信息
     * 
     * @param id 列车管理ID
     * @return 结果
     */
    @Override
    public int deleteTrainTableById(Long id)
    {
        return trainTableMapper.deleteTrainTableById(id);
    }
}
