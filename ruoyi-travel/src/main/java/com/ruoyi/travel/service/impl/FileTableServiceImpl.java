package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.FileTableMapper;
import com.ruoyi.travel.domain.FileTable;
import com.ruoyi.travel.service.IFileTableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 发布文件Service业务层处理
 * 
 * @author cy
 * @date 2020-02-27
 */
@Service
public class FileTableServiceImpl implements IFileTableService 
{
    @Autowired
    private FileTableMapper fileTableMapper;

    /**
     * 查询发布文件
     * 
     * @param id 发布文件ID
     * @return 发布文件
     */
    @Override
    public FileTable selectFileTableById(Long id)
    {
        return fileTableMapper.selectFileTableById(id);
    }

    /**
     * 查询发布文件列表
     * 
     * @param fileTable 发布文件
     * @return 发布文件
     */
    @Override
    public List<FileTable> selectFileTableList(FileTable fileTable)
    {
        return fileTableMapper.selectFileTableList(fileTable);
    }

    /**
     * 新增发布文件
     * 
     * @param fileTable 发布文件
     * @return 结果
     */
    @Override
    public int insertFileTable(FileTable fileTable)
    {
        return fileTableMapper.insertFileTable(fileTable);
    }

    /**
     * 修改发布文件
     * 
     * @param fileTable 发布文件
     * @return 结果
     */
    @Override
    public int updateFileTable(FileTable fileTable)
    {
        return fileTableMapper.updateFileTable(fileTable);
    }

    /**
     * 删除发布文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFileTableByIds(String ids)
    {
        return fileTableMapper.deleteFileTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除发布文件信息
     * 
     * @param id 发布文件ID
     * @return 结果
     */
    @Override
    public int deleteFileTableById(Long id)
    {
        return fileTableMapper.deleteFileTableById(id);
    }
}
