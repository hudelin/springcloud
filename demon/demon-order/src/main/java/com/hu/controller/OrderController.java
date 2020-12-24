package com.hu.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.hu.init.Initialization;
import com.hu.pojo.vo.MsgClient;
import com.hu.pojo.vo.OrderPageVO;
import com.hu.redisson.RedissonService;
import com.hu.result.ResultMessage;
import com.hu.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : hudelin
 * @className :OrderController
 * @description : 订单控制器
 * @date: 2020-07-01 15:33
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {



    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public ResultMessage submit() throws Exception {
        return ResultMessage.success(orderService.submit());
    }

    @GetMapping(value = "/listorder")
    public ResultMessage listOrder(@RequestBody @Valid OrderPageVO orderPageVO) throws Exception {
        return ResultMessage.success(orderService.listOrder(orderPageVO));
    }

    @Autowired
    private RedissonService redissonService;

    @RequestMapping(value = "/payment/test",method = RequestMethod.POST)
    public ResultMessage payment() throws Exception {
//        scoreService.test();
        String key = (String) redisTemplate.opsForHash().get("channel_" + "SSC20200322181100000231" + "_hash", "channel_key");
        System.out.println(Initialization.PAY_STRATEGY_MAP);

//        RLock lock = redissonService.getRLock(key);
//        try {
//            boolean bs = lock.tryLock(1, 10, TimeUnit.SECONDS);
//            if (bs) {
//                // 业务代码
//                log.info("进入业务代码: " + key);
//                redissonService.unlock(lock);
//            } else {
//                Thread.sleep(30000);
//            }
//        } catch (Exception e) {
//            log.error("", e);
//            redissonService.unlock(lock);
//        }

        return ResultMessage.success().message(key);
    }

    @RequestMapping(value = "/export",method = RequestMethod.POST)
    public ResultMessage export() throws Exception {
        List<MsgClient> list = new ArrayList<>();
        List<MsgClient> listAll = new ArrayList<>();
        Workbook workbook = null;
        Date start = new Date();
        ExportParams params = new ExportParams("大数据测试", "测试");
        //一百万数据量
        for (int i = 0; i < 2000000; i++) {
            MsgClient client = new MsgClient();
            client.setBirthday(new Date());
            client.setClientName("小明" + i);
            client.setClientPhone("18797" + i);
            client.setCreateBy("JueYue");
            client.setId("1" + i);
            client.setRemark("测试" + i);
//            MsgClientGroup group = new MsgClientGroup();
//            group.setGroupName("测试" + i);
//            client.setGroup(group);
            list.add(client);
            if(list.size() == 10000){
                workbook = ExcelExportUtil.exportBigExcel(params, MsgClient.class, list);
                listAll.addAll(list);
                list.clear();
            }
        }
        ExcelExportUtil.closeExportBigExcel();
//        System.out.println(System.currentTimeMillis() - start.getTime());
        File savefile = new File("E:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("E:/excel/ExcelExportBigData.bigDataExport.xlsx");
        workbook.write(fos);
        fos.close();
        return ResultMessage.success();
    }

}
