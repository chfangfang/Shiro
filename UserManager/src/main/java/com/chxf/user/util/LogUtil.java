package com.chxf.user.util;

import org.apache.log4j.Logger;

public class LogUtil {
    private static final Logger log = Logger.getLogger(LogUtil.class);

    public static void info(Object message) {
        log.info(message);
    }

    public static void debug(Object message) {
        log.debug(message);
    }

    public static void error(Object message) {
        log.error(message);
    }
}
