package com.ruoyi.web.controller.passengers;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.travel.domain.FileTable;
import com.ruoyi.travel.service.IFileTableService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 发布文件Controller
 *
 * @author cy
 * @date 2020-02-27
 */
@Controller
@RequestMapping("/file/table")
public class FileTableController extends BaseController {
    private String prefix = "file/table";

    @Autowired
    private IFileTableService fileTableService;

    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("file:table:view")
    @GetMapping()
    public String table(ModelMap mmap) {
        mmap.put("users", iSysUserService.selectUserList(new SysUser()));
        return prefix + "/table";
    }

    /**
     * 查询发布文件列表
     */
    @RequiresPermissions("file:table:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam("startTime") String s,@RequestParam("endTime") String e,FileTable fileTable, ModelMap mmap) {

        startPage();
        List<FileTable> list = fileTableService.selectFileTableList(fileTable);
        if(!StringUtils.isEmpty(s) && !StringUtils.isEmpty(e)){
            return getDataTable( fileTableService.selectFileTableListWithDate(fileTable,s,e));
        }
        return getDataTable(list);
    }

    /**
     * 导出发布文件列表
     */
    @RequiresPermissions("file:table:export")
    @Log(title = "发布文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FileTable fileTable) {
        List<FileTable> list = fileTableService.selectFileTableList(fileTable);
        ExcelUtil<FileTable> util = new ExcelUtil<FileTable>(FileTable.class);
        return util.exportExcel(list, "table");
    }

    /**
     * 新增发布文件
     */
    @GetMapping("/add")
    public String add(Map<String, Object> map) {
        map.put("users", iSysUserService.selectUserList(new SysUser()));
        return prefix + "/add";
    }

    /**
     * 新增保存发布文件
     */
    @RequiresPermissions("file:table:add")
    @Log(title = "发布文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file, FileTable fileTable) throws Exception {
        fileTable.setFilePath(FileUploadUtils.upload(Global.getUploadPath(), file));
        fileTable.setFileName(file.getOriginalFilename());
        return toAjax(fileTableService.insertFileTable(fileTable));
    }

    /**
     * 修改发布文件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        FileTable fileTable = fileTableService.selectFileTableById(id);
        mmap.put("users", iSysUserService.selectUserList(new SysUser()));
        mmap.put("fileTable", fileTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存发布文件
     */
    @RequiresPermissions("file:table:edit")
    @Log(title = "发布文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FileTable fileTable) {
        return toAjax(fileTableService.updateFileTable(fileTable));
    }

    /**
     * 删除发布文件
     */
    @RequiresPermissions("file:table:remove")
    @Log(title = "发布文件", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(fileTableService.deleteFileTableByIds(ids));
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());

    }
}
