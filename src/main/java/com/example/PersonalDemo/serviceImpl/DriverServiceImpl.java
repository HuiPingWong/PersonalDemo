package com.example.PersonalDemo.serviceImpl;

import com.example.PersonalDemo.proxy.CarInfoServiceProxy;
import com.example.PersonalDemo.service.CarInfoService;
import com.example.PersonalDemo.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DriverServiceImpl implements DriverService {

    @Autowired
    CarInfoServiceProxy carInfoServiceProxy;

     @Qualifier("carInfoServiceImpl")
    CarInfoService carInfoService;

//    @Autowired
//    @Qualifier("carInfoServiceImpl")
//    CarInfoService carInfoService;

    @Override
//    @OperLog(operModul = "开车",operType = "car",operDesc = "1")
    public void driverBMW() {
        System.out.println("开BMW!");
    }

    @Override
    public void driverAny() {
        carInfoServiceProxy.check();

    }

    @Override
    public void driverJDKproxy() {

//        CarInfoService carInfoService = new CarInfoServiceImpl();
//        CarInfoService carInfoService = ApplicationContextUtil.getBean(CarInfoServiceImpl.class);


//        CarInfoService proxyInstance = (CarInfoService)new ProxyFactory(carInfoService).getProxyInstance();
//        List<CarInfo> check = proxyInstance.check();
//        log.info(check.toString());
        List<Object>list=new ArrayList<>();
    }
}
