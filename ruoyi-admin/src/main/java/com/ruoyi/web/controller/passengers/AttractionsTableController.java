package com.ruoyi.web.controller.passengers;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.travel.domain.AttractionsTable;
import com.ruoyi.travel.service.IAttractionsTableService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 景点数据Controller
 * 
 * @author cy
 * @date 2020-01-30
 */
@Controller
@RequestMapping("/scenic/table")
public class AttractionsTableController extends BaseController
{
    private String prefix = "scenic/table";

    @Autowired
    private IAttractionsTableService attractionsTableService;

    @RequiresPermissions("scenic:table:view")
    @GetMapping()
    public String table()
    {
        return prefix + "/table";
    }

    /**
     * 查询景点数据列表
     */
    @RequiresPermissions("scenic:table:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AttractionsTable attractionsTable)
    {
        startPage();
        List<AttractionsTable> list = attractionsTableService.selectAttractionsTableList(attractionsTable);
        return getDataTable(list);
    }

    /**
     * 导出景点数据列表
     */
    @RequiresPermissions("scenic:table:export")
    @Log(title = "景点数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttractionsTable attractionsTable)
    {
        List<AttractionsTable> list = attractionsTableService.selectAttractionsTableList(attractionsTable);
        ExcelUtil<AttractionsTable> util = new ExcelUtil<AttractionsTable>(AttractionsTable.class);
        return util.exportExcel(list, "table");
    }

    /**
     * 新增景点数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存景点数据
     */
    @RequiresPermissions("scenic:table:add")
    @Log(title = "景点数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttractionsTable attractionsTable)
    {
        return toAjax(attractionsTableService.insertAttractionsTable(attractionsTable));
    }

    /**
     * 修改景点数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttractionsTable attractionsTable = attractionsTableService.selectAttractionsTableById(id);
        mmap.put("attractionsTable", attractionsTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存景点数据
     */
    @RequiresPermissions("scenic:table:edit")
    @Log(title = "景点数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttractionsTable attractionsTable)
    {
        return toAjax(attractionsTableService.updateAttractionsTable(attractionsTable));
    }

    /**
     * 删除景点数据
     */
    @RequiresPermissions("scenic:table:remove")
    @Log(title = "景点数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attractionsTableService.deleteAttractionsTableByIds(ids));
    }
}
