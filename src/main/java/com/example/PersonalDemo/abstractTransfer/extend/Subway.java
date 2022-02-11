package com.example.PersonalDemo.abstractTransfer.extend;

import com.example.PersonalDemo.abstractTransfer.AbstractTransport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Subway extends AbstractTransport {
    @Override
    public void fixed() {
        log.info("地铁修理！==============");
    }

    @Override
    public void driver() {
        log.info("地铁驾驶！==============");
    }

    @Override
    public void filling() {
        log.info("地铁加油！==============");
    }

    @Override
    public void transfer() {
        log.info("地铁交通！==============");
    }

    public void ground(){
        log.info("地面！==============");
    }
}
