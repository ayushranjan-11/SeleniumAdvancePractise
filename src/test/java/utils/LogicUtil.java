package utils;

import base.BaseTestClass;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class LogicUtil extends BaseTestClass {
    private static final Logger log = LogManager.getLogger(LogicUtil.class);
    public int randomNumberGenerator() {
        int randomNumber = (int) (Math.random() * 2) + 1; //Dropdown value is max 2, hence changed the logic here for array index bound error
        log.info("Generated random number is {}", randomNumber);
        return randomNumber;
    }

    public void checkErrorMessageContent(String actualMessage){
        //TODO: This method is dependent, make it independent for any actual and expected text or string.
        if(actualMessage.contains(properties.getProperty("expectedLoginErrorMessage")) && actualMessage.contains(properties.getProperty("expectedLoginErrorMessage2"))){
            log.info("Login error message is showing as expected");
        } else log.error("Login error message is not as per expected. Message{}",actualMessage);
    }

}
