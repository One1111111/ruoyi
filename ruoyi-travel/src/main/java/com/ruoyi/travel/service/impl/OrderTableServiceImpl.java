package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.OrderTableMapper;
import com.ruoyi.travel.domain.OrderTable;
import com.ruoyi.travel.service.IOrderTableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单管理Service业务层处理
 * 
 * @author cy
 * @date 2020-02-19
 */
@Service
public class OrderTableServiceImpl implements IOrderTableService 
{
    @Autowired
    private OrderTableMapper orderTableMapper;

    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    @Override
    public OrderTable selectOrderTableById(Long id)
    {
        return orderTableMapper.selectOrderTableById(id);
    }

    /**
     * 查询订单管理列表
     * 
     * @param orderTable 订单管理
     * @return 订单管理
     */
    @Override
    public List<OrderTable> selectOrderTableList(OrderTable orderTable)
    {
        return orderTableMapper.selectOrderTableList(orderTable);
    }

    /**
     * 新增订单管理
     * 
     * @param orderTable 订单管理
     * @return 结果
     */
    @Override
    public int insertOrderTable(OrderTable orderTable)
    {
        return orderTableMapper.insertOrderTable(orderTable);
    }

    /**
     * 修改订单管理
     * 
     * @param orderTable 订单管理
     * @return 结果
     */
    @Override
    public int updateOrderTable(OrderTable orderTable)
    {
        return orderTableMapper.updateOrderTable(orderTable);
    }

    /**
     * 删除订单管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderTableByIds(String ids)
    {
        return orderTableMapper.deleteOrderTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteOrderTableById(Long id)
    {
        return orderTableMapper.deleteOrderTableById(id);
    }
}
