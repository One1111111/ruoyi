package com.ruoyi.travel.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.travel.domain.FileTable;
import com.ruoyi.travel.mapper.FileTableMapper;
import com.ruoyi.travel.service.IFileTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 发布文件Service业务层处理
 * 
 * @author cy
 * @date 2020-02-27
 */
@Service
public class FileTableServiceImpl implements IFileTableService 
{
    @Resource
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

    /**
     * 时间查询处理
     */
    public List<FileTable> selectFileTableListWithDate(FileTable fileTable,String s,String e){
        List<FileTable> fileTables = fileTableMapper.selectFileTableList(fileTable);
        List<FileTable> result = new ArrayList();
        fileTables.forEach(u ->{
            Calendar c = Calendar.getInstance();
            c.setTime(u.getReleaseTime());//填入当前时间
            SimpleDateFormat us = new SimpleDateFormat("yyyyMMdd");
            String curDate = us.format(c.getTime());  //当前日期
            Integer integer = Integer.valueOf(curDate);
            Integer integer1 = Integer.valueOf(s.replace("-", ""));
            Integer integer2 = Integer.valueOf(e.replace( "-", ""));
            if(integer >= integer1 && integer <= integer2){
                result.add(u);
            }
        });
        return  result;
    }

}
