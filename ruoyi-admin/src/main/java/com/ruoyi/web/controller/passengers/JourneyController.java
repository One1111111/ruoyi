package com.ruoyi.web.controller.passengers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.travel.domain.TrainTable;
import com.ruoyi.travel.service.impl.TrainTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.ruoyi.Test.Pc.getAddress;

@Controller
public class JourneyController extends BaseController {

    @Autowired
    TrainTableServiceImpl tableService;

    @RequestMapping("route")
    public String sayHello(){
        return "/homepage/journey.html";
    }

    /**
     * 省份校验
     */
    @RequestMapping("provinceVerify")
    @ResponseBody
    public AjaxResult provinceverify(){
        AjaxResult ajaxResult = new AjaxResult();
        String[] address = getAddress();
        ajaxResult.put("province", address);
        return ajaxResult;
    }

    @RequestMapping("trainList")
    @ResponseBody
    public AjaxResult getTrain(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int limit){
        PageHelper.startPage(page,limit);
        List<TrainTable> trainTables = tableService.selectTrainTableList(new TrainTable());
        PageInfo pageInfo = new PageInfo(trainTables);
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("data", pageInfo);
        return  ajaxResult;
    }



}
