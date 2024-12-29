package com.jongwow.easyspi.impl;

import com.jongwow.easyspi.api.MyService;
import com.jongwow.easyspi.api.MyServiceProviderInterface;

public class MyServiceProviderImpl1 implements MyServiceProviderInterface {
    @Override
    public MyService getService() {
        return new MyServiceImpl1();
    }

}
