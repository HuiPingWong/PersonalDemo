package com.example.PersonalDemo.abstractTransfer.extend;

import com.example.PersonalDemo.abstractTransfer.AbstractTransport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Airplane extends AbstractTransport {

    @Override
    public void fixed() {

    }

    @Override
    public void driver() {

    }

    @Override
    public void filling() {

    }

    @Override
    public void transfer() {

    }

    public void sky(){
        log.info("天空！==============");
    }
}
