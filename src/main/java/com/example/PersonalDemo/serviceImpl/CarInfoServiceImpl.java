package com.example.PersonalDemo.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.PersonalDemo.abstractTransfer.AbstractFactory;
import com.example.PersonalDemo.abstractTransfer.AbstractTransport;
import com.example.PersonalDemo.pojo.CarInfo;
import com.example.PersonalDemo.dao.CarInfoMapper;
import com.example.PersonalDemo.service.CarInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BBq
 * @since 2021-05-07
 */
@Service
@Slf4j
public class CarInfoServiceImpl extends ServiceImpl<CarInfoMapper, CarInfo> implements CarInfoService {
    @Autowired
    CarInfoMapper carInfoMapper;

    public List<CarInfo> check(){
        EntityWrapper<CarInfo> carInfoEntityWrapper = new EntityWrapper<>();
        carInfoEntityWrapper.eq("type","商务");
        List<CarInfo> carInfos = carInfoMapper.selectList(carInfoEntityWrapper);

        AbstractTransport abstractTransport = AbstractFactory.carAction(1);
        abstractTransport.transfer();
//        AbstractTransport subway = new Subway();
//        subway.transfer();
//        log.info("===============");
        return carInfos;
    }
}
