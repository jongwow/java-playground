package kr.jongwow.logger.httplogger;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class HttpLoggerFactory implements ILoggerFactory {
    @Override
    public Logger getLogger(String s) {
        return new HttpLogger(s, "http://localhost:9090/v1/log");
    }
}
