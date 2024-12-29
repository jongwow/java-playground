package com.jongwow.easyspi.app;

import com.jongwow.easyspi.api.MyService;

public class MainApp {
    public static void main(String[] args) {
        MyService service = MyServiceLoader.defaultProvider().getService();
        service.doSomething();
    }
}
