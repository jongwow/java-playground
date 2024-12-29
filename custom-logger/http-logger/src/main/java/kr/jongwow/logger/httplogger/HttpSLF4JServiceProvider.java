package kr.jongwow.logger.httplogger;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class HttpSLF4JServiceProvider implements SLF4JServiceProvider {
    private static final String REQUESTED_API_VERSION = "2.0.99"; // SLF4J API version
    private HttpLoggerFactory loggerFactory;

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    @Override
    public IMarkerFactory getMarkerFactory() {
        return null;
    }

    @Override
    public MDCAdapter getMDCAdapter() {
        return null;
    }

    @Override
    public String getRequestedApiVersion() {
        return REQUESTED_API_VERSION; // 필요할까?
    }

    @Override
    public void initialize() {
        this.loggerFactory = new HttpLoggerFactory();
    }
}
