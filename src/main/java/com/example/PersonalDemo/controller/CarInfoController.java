package com.example.PersonalDemo.controller;


import com.example.PersonalDemo.pojo.CarInfo;
import com.example.PersonalDemo.service.CarInfoService;
import com.example.PersonalDemo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.PersonalDemo.proxy.CarInfoServiceProxy;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BBq
 * @since 2021-05-07
 */
@RestController
@RequestMapping("/carInfo")
public class CarInfoController {

    @Autowired
//    @Qualifier("carInfoServiceImpl")
    CarInfoService carInfoService;


    @Autowired
    CarInfoServiceProxy CarInfoServiceProxy;


    @Autowired
    DriverService driverService;

    @GetMapping("/check")
//    @OperLog(operModul = "汽车",operType = "car",operDesc = "down")
    public List<CarInfo> check(){
        return carInfoService.check();
    }

    @GetMapping("/proxy")
    public void proxy(){
        CarInfoServiceProxy.check();
    }


    @GetMapping("/jdk-proxy")
    public void JDKproxy(){
        driverService.driverJDKproxy();
    }

}

