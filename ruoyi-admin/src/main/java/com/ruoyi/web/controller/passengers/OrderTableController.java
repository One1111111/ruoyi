package com.ruoyi.web.controller.passengers;

import com.ruoyi.Test.TT;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import com.ruoyi.travel.domain.OrderTable;
import com.ruoyi.travel.domain.TrainTable;
import com.ruoyi.travel.service.IOrderTableService;
import com.ruoyi.travel.service.impl.TrainTableServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单管理Controller
 *
 * @author cy
 * @date 2020-02-19
 */
@Controller
@RequestMapping("/order/ordercrud")
public class OrderTableController extends BaseController {
    private String prefix = "order/ordercrud";
    private Double pricesum = 0.0 ;
    @Autowired
    private IOrderTableService orderTableService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private TrainTableServiceImpl tableService;

    @RequiresPermissions("order:ordercrud:view")
    @GetMapping()
    public String ordercrud() {
        return prefix + "/ordercrud";
    }

    /**
     * 查询订单管理列表
     */
    @RequiresPermissions("order:ordercrud:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderTable orderTable) {
        startPage();
        List<OrderTable> list = orderTableService.selectOrderTableList(orderTable);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @RequiresPermissions("order:ordercrud:export")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderTable orderTable) {
        List<OrderTable> list = orderTableService.selectOrderTableList(orderTable);
        ExcelUtil<OrderTable> util = new ExcelUtil<OrderTable>(OrderTable.class);
        return util.exportExcel(list, "ordercrud");
    }

    /**
     * 新增订单管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存订单管理
     */
    @RequiresPermissions("order:ordercrud:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderTable orderTable) {
        return toAjax(orderTableService.insertOrderTable(orderTable));
    }

    /**
     * 修改订单管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        OrderTable orderTable = orderTableService.selectOrderTableById(id);
        mmap.put("orderTable", orderTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单管理
     */
    @RequiresPermissions("order:ordercrud:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderTable orderTable) {
        return toAjax(orderTableService.updateOrderTable(orderTable));
    }

    /**
     * 删除订单管理
     */
    @RequiresPermissions("order:ordercrud:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(orderTableService.deleteOrderTableByIds(ids));
    }

    /**
     * 添加订单
     */
    @RequestMapping("addOrder/{id}")
    @ResponseBody
    public AjaxResult addOrder(@PathVariable Integer id) {
        TrainTable trainTable = tableService.selectTrainTableById(Long.valueOf(id));
        String username = redisTemplate.opsForValue().get("username").toString();
        SysUser user = sysUserService.selectUserByLoginName(username);
        OrderTable orderTable = new OrderTable();
        AjaxResult ajaxResult = new AjaxResult();
        Calendar rightNow = Calendar.getInstance();
        if (user != null && trainTable != null) {
            orderTable.setOrderNumber(TT.getDateString() + user.getPhonenumber());
            orderTable.setOrderStatus(Long.valueOf(0));
            orderTable.setOrderDate(new Date());
            orderTable.setUserName(user.getUserName());
            orderTable.setUserPhoneNumber(user.getPhonenumber());
            orderTable.setTrain(trainTable.getTrains());
            orderTable.setDepartureStation(trainTable.getHairstanding());
            orderTable.setDepartureDate(trainTable.getDrivingtime());
            orderTable.setDestinationStation(trainTable.getTransferstation());
            orderTable.setDestinationDate(trainTable.getTimeofarrival());
            orderTable.setTrainPrice(Double.valueOf(trainTable.getPrice()));
            int i = orderTableService.insertOrderTable(orderTable);
            if (i == 1) {
                ajaxResult.put("msg", 1);
            } else {
                ajaxResult.put("msg", 0);
            }
        }
        return ajaxResult;
    }

    /**
     * 支付订单
     */
    @RequestMapping("payment/{id}")
    @ResponseBody
    public AjaxResult buyOrder(@PathVariable Integer id, Map<String,Object> map) {
        AjaxResult ajaxResult = new AjaxResult();
        OrderTable orderTable = orderTableService.selectOrderTableById(Long.valueOf(id));
        int msg = 0 ;
        if(orderTable.getOrderStatus() != 0){
            msg = 0;
        }else{
            orderTable.setOrderStatus(Long.valueOf(1));
            orderTableService.updateOrderTable(orderTable);
            msg = 1;
        }
        ajaxResult.put("msg", msg);
        System.out.println("555");
        return ajaxResult;
    }
}
