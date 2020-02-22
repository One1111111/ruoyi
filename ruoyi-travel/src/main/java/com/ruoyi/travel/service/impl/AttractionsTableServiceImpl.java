package com.ruoyi.travel.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.travel.domain.AttractionsTable;
import com.ruoyi.travel.mapper.AttractionsTableMapper;
import com.ruoyi.travel.service.IAttractionsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 景点数据Service业务层处理
 * 
 * @author cy
 * @date 2020-01-30
 */
@Service
public class AttractionsTableServiceImpl implements IAttractionsTableService 
{
    @Autowired
    private AttractionsTableMapper attractionsTableMapper;

    /**
     * 查询景点数据
     * 
     * @param id 景点数据ID
     * @return 景点数据
     */
    @Override
    public AttractionsTable selectAttractionsTableById(Long id)
    {
        return attractionsTableMapper.selectAttractionsTableById(id);
    }

    /**
     * 查询景点数据列表
     * 
     * @param attractionsTable 景点数据
     * @return 景点数据
     */
    @Override
    public List<AttractionsTable> selectAttractionsTableList(AttractionsTable attractionsTable)
    {
        return attractionsTableMapper.selectAttractionsTableList(attractionsTable);
    }

    /**
     * 新增景点数据
     * 
     * @param attractionsTable 景点数据
     * @return 结果
     */
    @Override
    public int insertAttractionsTable(AttractionsTable attractionsTable)
    {
        return attractionsTableMapper.insertAttractionsTable(attractionsTable);
    }

    /**
     * 修改景点数据
     * 
     * @param attractionsTable 景点数据
     * @return 结果
     */
    @Override
    public int updateAttractionsTable(AttractionsTable attractionsTable)
    {
        return attractionsTableMapper.updateAttractionsTable(attractionsTable);
    }

    /**
     * 删除景点数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttractionsTableByIds(String ids)
    {
        return attractionsTableMapper.deleteAttractionsTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除景点数据信息
     * 
     * @param id 景点数据ID
     * @return 结果
     */
    @Override
    public int deleteAttractionsTableById(Long id)
    {
        return attractionsTableMapper.deleteAttractionsTableById(id);
    }


    @Override
    public List<AttractionsTable> selectRankingList(){
        return attractionsTableMapper.selectRankingList();
    }
}
