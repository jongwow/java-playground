package com.jongwow.easyspi.app;

public class MainApp {
    public static void main(String[] args) {
        MyServiceLoader.defaultProvider().getService().doSomething();
    }
}
