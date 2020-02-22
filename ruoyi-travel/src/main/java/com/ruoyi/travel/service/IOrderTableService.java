package com.ruoyi.travel.service;

import com.ruoyi.travel.domain.OrderTable;
import java.util.List;

/**
 * 订单管理Service接口
 * 
 * @author cy
 * @date 2020-02-19
 */
public interface IOrderTableService 
{
    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    public OrderTable selectOrderTableById(Long id);

    /**
     * 查询订单管理列表
     * 
     * @param orderTable 订单管理
     * @return 订单管理集合
     */
    public List<OrderTable> selectOrderTableList(OrderTable orderTable);

    /**
     * 新增订单管理
     * 
     * @param orderTable 订单管理
     * @return 结果
     */
    public int insertOrderTable(OrderTable orderTable);

    /**
     * 修改订单管理
     * 
     * @param orderTable 订单管理
     * @return 结果
     */
    public int updateOrderTable(OrderTable orderTable);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderTableByIds(String ids);

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    public int deleteOrderTableById(Long id);
}
