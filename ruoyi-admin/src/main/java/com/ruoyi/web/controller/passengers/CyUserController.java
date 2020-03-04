package com.ruoyi.web.controller.passengers;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.travel.domain.CyUser;
import com.ruoyi.travel.service.ICyUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理Controller
 * 
 * @author cy
 * @date 2020-03-01
 */
@Controller
@RequestMapping("/user/table")
public class CyUserController extends BaseController
{
    private String prefix = "user/table";

    @Autowired
    private ICyUserService cyUserService;

    @RequiresPermissions("user:table:view")
    @GetMapping()
    public String table()
    {
        return prefix + "/table";
    }

    /**
     * 查询用户管理列表
     */
    @RequiresPermissions("user:table:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CyUser cyUser)
    {
        startPage();
        List<CyUser> list = cyUserService.selectCyUserList(cyUser);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @RequiresPermissions("user:table:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CyUser cyUser)
    {
        List<CyUser> list = cyUserService.selectCyUserList(cyUser);
        ExcelUtil<CyUser> util = new ExcelUtil<CyUser>(CyUser.class);
        return util.exportExcel(list, "table");
    }

    /**
     * 新增用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户管理
     */
    @RequiresPermissions("user:table:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CyUser cyUser)
    {
        return toAjax(cyUserService.insertCyUser(cyUser));
    }

    /**
     * 修改用户管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CyUser cyUser = cyUserService.selectCyUserById(id);
        mmap.put("cyUser", cyUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户管理
     */
    @RequiresPermissions("user:table:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CyUser cyUser)
    {
        return toAjax(cyUserService.updateCyUser(cyUser));
    }

    /**
     * 删除用户管理
     */
    @RequiresPermissions("user:table:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cyUserService.deleteCyUserByIds(ids));
    }

    @RequestMapping("t")
    public String hello(){
        return "demo/cyDemo/index";
    }
}
