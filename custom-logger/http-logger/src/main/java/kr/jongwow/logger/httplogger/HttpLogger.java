package kr.jongwow.logger.httplogger;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.spi.LoggingEventBuilder;

public class HttpLogger implements Logger {
    private final String name;
    private final String url;

    public HttpLogger(String name, String url) {
        this.name = name;
        this.url = url; // http://localhost:9090/v1/log
    }

    private void sendLogToServer(String level, String message) {
        try {
            String payload = String.format("{\"level\":\"%s\",\"message\":\"%s\"}", level, message);
            java.net.URL url = new java.net.URL(this.url);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.getOutputStream().write(payload.getBytes());
            conn.getOutputStream().close();
            conn.getResponseCode(); // Ensure the request is sent
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return Logger.super.makeLoggingEventBuilder(level);
    }

    @Override
    public LoggingEventBuilder atLevel(Level level) {
        return Logger.super.atLevel(level);
    }

    @Override
    public boolean isEnabledForLevel(Level level) {
        return Logger.super.isEnabledForLevel(level);
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String s) {
        sendLogToServer("TRACE", s);
    }

    @Override
    public void trace(String s, Object o) {
        trace(s);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        trace(s);
    }

    @Override
    public void trace(String s, Object... objects) {
        trace(s);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        trace(s);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public LoggingEventBuilder atTrace() {
        return Logger.super.atTrace();
    }

    @Override
    public void trace(Marker marker, String s) {
        trace(s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        trace(s);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        trace(s);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        trace(s);

    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        trace(s);

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(String s) {
        sendLogToServer("DEBUG", s);
    }

    @Override
    public void debug(String s, Object o) {
        debug(s);
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        debug(s);
    }

    @Override
    public void debug(String s, Object... objects) {
        debug(s);
    }

    @Override
    public void debug(String s, Throwable throwable) {
        debug(s);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String s) {
        debug(s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        debug(s);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        debug(s);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        debug(s);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        debug(s);
    }

    @Override
    public LoggingEventBuilder atDebug() {
        return Logger.super.atDebug();
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(String s) {
        sendLogToServer("INFO", s);
    }

    @Override
    public void info(String s, Object o) {
        info(s);
        info(s);
    }

    @Override
    public void info(String s, Object o, Object o1) {
        info(s);
    }

    @Override
    public void info(String s, Object... objects) {
        info(s);
    }

    @Override
    public void info(String s, Throwable throwable) {
        info(s);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String s) {
        info(s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        info(s);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        info(s);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        info(s);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        info(s);
    }

    @Override
    public LoggingEventBuilder atInfo() {
        return Logger.super.atInfo();
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(String s) {
        sendLogToServer("WARN", s);
    }

    @Override
    public void warn(String s, Object o) {
        warn(s);
    }

    @Override
    public void warn(String s, Object... objects) {
        warn(s);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        warn(s);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        warn(s);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String s) {
        warn(s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        warn(s);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        warn(s);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        warn(s);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        warn(s);
    }

    @Override
    public LoggingEventBuilder atWarn() {
        return Logger.super.atWarn();
    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(String s) {
        sendLogToServer("ERROR", s);
    }

    @Override
    public void error(String s, Object o) {

        error(s);
    }

    @Override
    public void error(String s, Object o, Object o1) {

        error(s);
    }

    @Override
    public void error(String s, Object... objects) {

        error(s);
    }

    @Override
    public void error(String s, Throwable throwable) {

        error(s);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String s) {

        error(s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {

        error(s);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {

        error(s);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {

        error(s);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {

        error(s);
    }

    @Override
    public LoggingEventBuilder atError() {
        return Logger.super.atError();
    }
}
