package com.ruoyi.web.controller.passengers;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travel.domain.PassengersTable;
import com.ruoyi.travel.service.IPassengersTableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 旅客数据Controller
 * 
 * @author ljh
 * @date 2020-01-29
 */
@Controller
@RequestMapping("/passengers/passengerscrud")
public class PassengersTableController extends BaseController
{
    private String prefix = "passengers/passengerscrud";

    @Autowired
    private IPassengersTableService passengersTableService;

    @RequiresPermissions("passengers:passengerscrud:view")
    @GetMapping()
    public String passengerscrud()
    {
        return prefix + "/passengerscrud";
    }

    /**
     * 查询旅客数据列表
     */
    @RequiresPermissions("passengers:passengerscrud:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PassengersTable passengersTable)
    {
        startPage();
        List<PassengersTable> list = passengersTableService.selectPassengersTableList(passengersTable);
        return getDataTable(list);
    }

    /**
     * 导出旅客数据列表
     */
    @RequiresPermissions("passengers:passengerscrud:export")
    @Log(title = "旅客数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PassengersTable passengersTable)
    {
        List<PassengersTable> list = passengersTableService.selectPassengersTableList(passengersTable);
        ExcelUtil<PassengersTable> util = new ExcelUtil<PassengersTable>(PassengersTable.class);
        return util.exportExcel(list, "passengerscrud");
    }

    /**
     * 新增旅客数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存旅客数据
     */
    @RequiresPermissions("passengers:passengerscrud:add")
    @Log(title = "旅客数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PassengersTable passengersTable)
    {
        return toAjax(passengersTableService.insertPassengersTable(passengersTable));
    }

    /**
     * 修改旅客数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PassengersTable passengersTable = passengersTableService.selectPassengersTableById(id);
        mmap.put("passengersTable", passengersTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存旅客数据
     */
    @RequiresPermissions("passengers:passengerscrud:edit")
    @Log(title = "旅客数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PassengersTable passengersTable)
    {
        return toAjax(passengersTableService.updatePassengersTable(passengersTable));
    }

    /**
     * 删除旅客数据
     */
    @RequiresPermissions("passengers:passengerscrud:remove")
    @Log(title = "旅客数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(passengersTableService.deletePassengersTableByIds(ids));
    }
}
