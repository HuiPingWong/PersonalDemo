package com.example.PersonalDemo.proxy;

import com.example.PersonalDemo.pojo.CarInfo;
import com.example.PersonalDemo.service.CarInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class CarInfoServiceProxy  {

    @Autowired
    @Qualifier("carInfoServiceImpl")
    private CarInfoService carInfoService;
//    @Qualifier("carInfoServiceImpl")一个接口两个实现类指定一个实现类
//    public CarInfoServiceProxy( @Qualifier("carInfoServiceImpl") CarInfoService carInfoService){
//        this.carInfoService=carInfoService;
//    }



    public List<CarInfo> check() {
        log.info("CarInfoServiceProxy代理执行内容====================");
        carInfoService.check();
        return null;
    }
}
