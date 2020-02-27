package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 发布文件对象 file_table
 * 
 * @author cy
 * @date 2020-02-27
 */
public class FileTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 发布者 */
    @Excel(name = "发布者")
    private String promulgator;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件状态 */
    @Excel(name = "文件状态")
    private Long fileStatus;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 文件描述 */
    private String fileDescriptor;

    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPromulgator(String promulgator) 
    {
        this.promulgator = promulgator;
    }

    public String getPromulgator() 
    {
        return promulgator;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileStatus(Long fileStatus) 
    {
        this.fileStatus = fileStatus;
    }

    public Long getFileStatus() 
    {
        return fileStatus;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileDescriptor(String fileDescriptor) 
    {
        this.fileDescriptor = fileDescriptor;
    }

    public String getFileDescriptor() 
    {
        return fileDescriptor;
    }
    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("promulgator", getPromulgator())
            .append("fileName", getFileName())
            .append("fileStatus", getFileStatus())
            .append("filePath", getFilePath())
            .append("fileDescriptor", getFileDescriptor())
            .append("releaseTime", getReleaseTime())
            .toString();
    }
}
