package com.ruoyi.web.controller.passengers;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.travel.domain.DynamicInfo;
import com.ruoyi.travel.domain.Phone;
import com.ruoyi.travel.domain.PhoneInfo;
import com.ruoyi.travel.service.PhoneService;
import com.ruoyi.travel.service.impl.AttractionsTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("homepage")
public class HomePageController {

    List<Phone> phones = Arrays.asList(
            new Phone(1, "苹果"),
            new Phone(2, "小米"),
            new Phone(3, "华为"),
            new Phone(4, "oppo"),
            new Phone(5, "vivo"));

    @Autowired
    private PhoneService phoneService;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    AttractionsTableServiceImpl attractionsTableService;

    @RequestMapping("home")
    public String home(Map<String,Object> map){

        //排行榜
        for (Phone phone : phones) {
            int ranking = phoneService.phoneRank(phone.getId()) + 1;
            phone.setRanking(ranking == 0 ? "榜上无名" : "销量排名：" + ranking);
        }
        map.put("phones", phones);

        List<PhoneInfo> phbList = phoneService.getPhbList();
        List<DynamicInfo> dynamicList = phoneService.getBuyDynamic();
        map.put("dynamicList", dynamicList);
        map.put("phbList", phbList);


        String username = redisTemplate.opsForValue().get("username").toString();
        map.put("username", username);
        return "homepage/Home.html";
    }

    @RequestMapping("travel")
    public String getTravel(Map<String,Object> map){
        return "order/ordercrud/ordercrud.html";
    }

    @RequestMapping("rankingList")
    @ResponseBody
    public AjaxResult getrankingLis(Map<String,Object> map){

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", Integer.valueOf(0));
        ajaxResult.put("msg", "");
        ajaxResult.put("data", attractionsTableService.selectRankingList());
        return  ajaxResult;
    }

    /**
     * 模拟购买手机
     *
     * @param phoneId
     * @return
     */
    @RequestMapping("/buy/{phoneId}")
    public String buyPhone(@PathVariable int phoneId) {
        System.out.println("2314");
        phoneService.buyPhone(phoneId);
        return "redirect:/homepage/home";
    }

    /**
     * 清空缓存
     * @return
     */
    @RequestMapping("/clear")
    public String clear() {
        phoneService.clear();
        return "redirect:/homepage/home";
    }

}
