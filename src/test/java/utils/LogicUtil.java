package utils;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class LogicUtil {

    private static final Logger log = LogManager.getLogger(LogicUtil.class);
    public int randomNumberGenerator() {
        int randomNumber = (int) (Math.random() * 2) + 1; //Dropdown value is max 2, hence changed the logic here for array index bound error
        log.info("Generated random number is {}", randomNumber);
        return randomNumber;
    }

}
