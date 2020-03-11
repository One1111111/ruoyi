package com.ruoyi.travel.service;

import com.ruoyi.travel.domain.FileTable;
import java.util.List;

/**
 * 发布文件Service接口
 * 
 * @author cy
 * @date 2020-02-27
 */
public interface IFileTableService 
{
    /**
     * 查询发布文件
     * 
     * @param id 发布文件ID
     * @return 发布文件
     */
    public FileTable selectFileTableById(Long id);

    /**
     * 查询发布文件列表
     * 
     * @param fileTable 发布文件
     * @return 发布文件集合
     */
    public List<FileTable> selectFileTableList(FileTable fileTable);

    /**
     * 新增发布文件
     * 
     * @param fileTable 发布文件
     * @return 结果
     */
    public int insertFileTable(FileTable fileTable);

    /**
     * 修改发布文件
     * 
     * @param fileTable 发布文件
     * @return 结果
     */
    public int updateFileTable(FileTable fileTable);

    /**
     * 批量删除发布文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFileTableByIds(String ids);

    /**
     * 删除发布文件信息
     * 
     * @param id 发布文件ID
     * @return 结果
     */
    public int deleteFileTableById(Long id);


    /**
     * 时间处理
     * @param fileTable
     * @param s
     * @param e
     * @return
     */
    public List<FileTable> selectFileTableListWithDate(FileTable fileTable,String s,String e);
}
