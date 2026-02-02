package utils;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class LogicUtil {

    private static final Logger log = LogManager.getLogger(LogicUtil.class);
    public int randomNumberGenerator(int max) {
        int randomNumber = (int) (Math.random() * (max + 1)) + 1;
        log.info("Generated random number is {}", randomNumber);
        return randomNumber;
    }

}
