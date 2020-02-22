package com.ruoyi.web.controller.passengers;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import com.ruoyi.travel.domain.TrainTable;
import com.ruoyi.travel.service.ITrainTableService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 列车管理Controller
 *
 * @author cy
 * @date 2020-02-16
 */
@Controller
@RequestMapping("/travel/travelcrud")
public class TrainTableController extends BaseController {
    private String prefix = "travel/travelcrud";

    @Autowired
    private ITrainTableService trainTableService;

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    SysUserServiceImpl sysUserService;


    @RequiresPermissions("travel:travelcrud:view")
    @GetMapping()
    public String travelcrud() {
        return prefix + "/travelcrud";
    }

    /**
     * 查询列车管理列表
     */
    @RequiresPermissions("travel:travelcrud:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrainTable trainTable) {
        startPage();
        List<TrainTable> list = trainTableService.selectTrainTableList(trainTable);
        return getDataTable(list);
    }

    /**
     * 导出列车管理列表
     */
    @RequiresPermissions("travel:travelcrud:export")
    @Log(title = "列车管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrainTable trainTable) {
        List<TrainTable> list = trainTableService.selectTrainTableList(trainTable);
        ExcelUtil<TrainTable> util = new ExcelUtil<TrainTable>(TrainTable.class);
        return util.exportExcel(list, "travelcrud");
    }

    /**
     * 新增列车管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存列车管理
     */
    @RequiresPermissions("travel:travelcrud:add")
    @Log(title = "列车管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrainTable trainTable) {
        return toAjax(trainTableService.insertTrainTable(trainTable));
    }

    /**
     * 修改列车管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TrainTable trainTable = trainTableService.selectTrainTableById(id);
        mmap.put("trainTable", trainTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存列车管理
     */
    @RequiresPermissions("travel:travelcrud:edit")
    @Log(title = "列车管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrainTable trainTable) {
        return toAjax(trainTableService.updateTrainTable(trainTable));
    }

    /**
     * 删除列车管理
     */
    @RequiresPermissions("travel:travelcrud:remove")
    @Log(title = "列车管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(trainTableService.deleteTrainTableByIds(ids));
    }


    /**
     * 购票
     */
    @RequestMapping("ticket/{id}")
    @ResponseBody
    public AjaxResult buyTicket(@PathVariable("id") Integer id, Map<String, Object> map) {
        AjaxResult ajaxResult = new AjaxResult();
        TrainTable trainTable = trainTableService.selectTrainTableById(Long.valueOf(id));
        String username = redisTemplate.opsForValue().get("username").toString();
        SysUser sysUser = sysUserService.selectUserByLoginName(username);
        ajaxResult.put("ticketInfo", trainTable);
        ajaxResult.put("user",sysUser);
        return ajaxResult;
    }


}
