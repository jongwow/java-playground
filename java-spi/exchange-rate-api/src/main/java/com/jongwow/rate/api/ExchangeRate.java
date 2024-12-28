package com.jongwow.rate.api;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

// utility class
public class ExchangeRate {
    private static final String DEFAULT_PROVIDER = "com.jongwow.rate.api.UpbitOpenApiExchangeRateProvider";

    // All Providers
    public static List<ExchangeRateProvider> providers() {
        List<ExchangeRateProvider> services = new ArrayList<ExchangeRateProvider>();
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        loader.forEach(services::add);
        System.out.println("SERVICE:" + services.size());
        return services;
    }

    // Default Provider
    public static ExchangeRateProvider provider() {
        return provider(DEFAULT_PROVIDER);
    }

    public static ExchangeRateProvider provider(String providerName) {
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        Iterator<ExchangeRateProvider> it = loader.iterator();
        while (it.hasNext()) {
            ExchangeRateProvider provider = it.next();

            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("Exchange Rate Provider " + providerName + " not found");
    }
    // this utility class is not required to be part of the api project. Client code can choose to invoke ServiceLoader methods itself.
}
