package com.jongwow.easyspi.impl;

import com.jongwow.easyspi.api.MyService;

public class MyServiceImpl1 implements MyService {
    @Override
    public void doSomething() {
        System.out.println("MyServiceImpl1 do something.");
    }
}
