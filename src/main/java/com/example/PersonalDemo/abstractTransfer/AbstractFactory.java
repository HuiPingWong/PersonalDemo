package com.example.PersonalDemo.abstractTransfer;

import com.example.PersonalDemo.abstractTransfer.extend.Airplane;
import com.example.PersonalDemo.abstractTransfer.extend.Subway;
import com.example.PersonalDemo.utils.ApplicationContextUtil;

public class AbstractFactory {
    public static AbstractTransport carAction(Integer key) {
        AbstractTransport abstractTransport = null;

        switch (key) {
            case 1:
                abstractTransport = ApplicationContextUtil.getBean(Subway.class);
                break;

            case 2:
                abstractTransport = ApplicationContextUtil.getBean(Airplane.class);
                break;
        }
        return abstractTransport;
    }
}
