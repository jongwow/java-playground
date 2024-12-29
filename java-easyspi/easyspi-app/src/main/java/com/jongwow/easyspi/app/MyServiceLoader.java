package com.jongwow.easyspi.app;

import com.jongwow.easyspi.api.MyServiceProviderInterface;

import java.nio.file.ProviderNotFoundException;
import java.util.ServiceLoader;

public class MyServiceLoader {
    private static final String DEFAULT_PROVIDER = "com.jongwow.easyspi.impl.MyServiceProviderImpl1";

    public static MyServiceProviderInterface defaultProvider() {
        return provider(DEFAULT_PROVIDER);
    }

    public static MyServiceProviderInterface provider(String providerName) {
        ServiceLoader<MyServiceProviderInterface> loader = ServiceLoader.load(MyServiceProviderInterface.class);

        for (MyServiceProviderInterface providerInterface : loader) {
            if (providerInterface.getClass().getName().equals(providerName)) {
                return providerInterface;
            }
        }
        throw new ProviderNotFoundException("Provider: " + providerName + " not found");

    }
}
