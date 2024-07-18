package org.epam.dsa.logger;

import org.apache.log4j.*;

public class LoggerClass {
    private static final Logger logger = LogManager.getLogger(LoggerClass.class);

    public static void main(String[] args) {
        System.out.println(logger);
        System.out.println("Hello, user!");
        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
    }
}
