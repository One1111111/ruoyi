package com.ruoyi.Test;

import com.ruoyi.travel.domain.AttractionsTable;
import com.ruoyi.travel.domain.TrainTable;
import com.ruoyi.travel.service.impl.AttractionsTableServiceImpl;
import com.ruoyi.travel.service.impl.PassengersTableServiceImpl;
import com.ruoyi.travel.service.impl.TrainTableServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static com.ruoyi.Test.Pc.getAddress;
import static com.ruoyi.Test.TT.getRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Absfnlskf {

    @Resource
    AttractionsTableServiceImpl attractionsTableService;

    @Autowired
    TrainTableServiceImpl tableService;

    @Resource
    PassengersTableServiceImpl passengersTableService;

 /*   @Test
    public void sayHello() throws Exception {
        PassengersTable passengersTable = new PassengersTable();
        Random rand = new Random();
        List<String> cxfs = Arrays.asList("自驾游", "旅游团", "飞机", "高铁", "自行车");
        List<String> gjz = Arrays.asList("特色美食", "特色民宿", "周边游", "避暑", "免签","中国古镇","夜游","博物馆");
        String[] s = Pc.getAddress();

        while (true) {
//            passengersTable = null;
            passengersTable.setName(getChineseName.ChineseName());
            passengersTable.setSex(Long.valueOf(rand.nextInt(2)));
            passengersTable.setAge(Long.valueOf(rand.nextInt(101)));
            passengersTable.setPlace(s[rand.nextInt(s.length)]);
            passengersTable.setSearch(gjz.get(rand.nextInt(gjz.size())));
            passengersTable.setTripMode(cxfs.get(rand.nextInt(cxfs.size())));
            passengersTable.setTravelCost(Double.valueOf(rand.nextInt(5000)+5000));
            passengersTableService.insertPassengersTable(passengersTable);

        }
    }*/  //添加passengersTable数据

    @Test
    public void upAteattra() {
        List<AttractionsTable> attractionsTables = attractionsTableService.selectAttractionsTableList(new AttractionsTable());
        Random random = new Random();
        for (int i = 0; i < attractionsTables.size(); i++) {
            AttractionsTable attractionsTable = attractionsTables.get(i);
            attractionsTable.setHumanTraffic(Long.valueOf(random.nextInt(10000) + 1000));
            attractionsTableService.updateAttractionsTable(attractionsTable);
        }
        System.out.println("66666");
    }


    /**
     * 列车数据添加
     */
    @Test
    public void a() {
        Calendar rightNow = Calendar.getInstance();
        TrainTable trainTable = new TrainTable();
        ArrayList<String> Lt = new ArrayList<>();
        ArrayList<String> dt = new ArrayList<>();
        String[] address = getAddress();//省份地址
        Random rand = new Random();
        int n = 0;
        Lt.add("G"); //高速动车
        Lt.add("C"); //城际动车
        Lt.add("D"); //普通动车
        Lt.add("Z"); //直达特快列车
        Lt.add("T"); //特快列车
        Lt.add("K"); //快速列车
        Lt.add("L"); //临客列车
        Lt.add("Y"); //旅游列车
        dt.add("高速动车");
        dt.add("城际动车");
        dt.add("普通动车");
        dt.add("直达特快列车");
        dt.add("特快列车");
        dt.add("快速列车");
        dt.add("临客列车");
        dt.add("旅游列车");
        while ( true) {
            trainTable.setType(dt.get(rand.nextInt(dt.size())));
            trainTable.setHairstanding(address[rand.nextInt(address.length)]);
            trainTable.setTheterminal(address[rand.nextInt(address.length)]);
            if (trainTable.getHairstanding().equals(trainTable.getTheterminal())) {
                trainTable.setTheterminal(address[rand.nextInt(address.length)]);
            }
            trainTable.setTransferstation(address[rand.nextInt(address.length)]);

            //出发时间 到站时间
            rightNow.set(Calendar.HOUR,rand.nextInt(25));
            rightNow.set(Calendar.MINUTE, rand.nextInt(60));
            trainTable.setDrivingtime(rightNow.getTime());
            int i = rightNow.get(rightNow.HOUR);
            int m = rightNow.get(rightNow.MINUTE);
            rightNow.set(rightNow.HOUR, i+rand.nextInt(4)+1);
            rightNow.set(rightNow.MINUTE, m+rand.nextInt(60)+10);
            trainTable.setTimeofarrival(rightNow.getTime());
            trainTable.setStandNumber(Long.valueOf(rand.nextInt(20) + 5));
            switch (trainTable.getType()) {
                case "高速动车":
                    trainTable.setTrains("G" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*18));
                    break;
                case "城际动车":
                    trainTable.setTrains("C" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*17));
                    break;
                case "普通动车":
                    trainTable.setTrains("D" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*16));
                    break;
                case "直达特快列车":
                    trainTable.setTrains("Z" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*15));
                    break;
                case "特快列车":
                    trainTable.setTrains("T" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*14));
                    break;
                case "快速列车":
                    trainTable.setTrains("K" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*13));
                    break;
                case "临客列车":
                    trainTable.setTrains("L" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*12));
                    break;
                case "旅游列车":
                    trainTable.setTrains("Y" + getRandom(4));
                    trainTable.setPrice(Long.valueOf(trainTable.getStandNumber()*11));
                    break;
            }

            List<TrainTable> trainTables = tableService.selectTrainTableList(new TrainTable());
            trainTables.forEach(item -> {
                if (item.getHairstanding().equals(trainTable.getHairstanding()) && item.getTheterminal().equals(trainTable.getTheterminal())) {
                    trainTable.setStandNumber(item.getStandNumber());
                    trainTable.setPrice(item.getPrice());
                }
            });
            n++;
            tableService.insertTrainTable(trainTable);
        }
    }

//    /**
//     * 文件上传测试
//     */
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(@RequestParam("file") MultipartFile file, FileInfo fileInfo) throws IOException
//    {
//        // 上传文件路径
//        String filePath = RuoYiConfig.getUploadPath();
//        // 上传并返回新文件名称
//        String fileName = FileUploadUtils.upload(filePath, file);
//        fileInfo.setFilePath(fileName);
//        return toAjax(fileInfoService.insertFileInfo(fileInfo));
//    }

}
