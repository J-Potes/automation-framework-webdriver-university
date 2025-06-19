package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;

public class Base_PO {
    public Base_PO() {}

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }
}
