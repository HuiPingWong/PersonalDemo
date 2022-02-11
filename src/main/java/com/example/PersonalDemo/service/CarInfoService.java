package com.example.PersonalDemo.service;

import com.example.PersonalDemo.pojo.CarInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BBq
 * @since 2021-05-07
 */
public interface CarInfoService extends IService<CarInfo> {
    public List<CarInfo> check();



}
