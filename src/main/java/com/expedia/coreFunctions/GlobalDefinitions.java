package com.expedia.coreFunctions;

public class GlobalDefinitions {
    static final String GECKO_DRIVER_PATH = System.getProperty("user.dir").concat("\\drivers\\geckoDriver\\");
    static final String CHROME_DRIVER_PATH = System.getProperty("user.dir").concat("\\drivers\\chromeDriver\\");

    protected static final String URL = "https://www.expedia.com/";

    public static final int DELAY = 30;
    public static final int IMPLICITDELAY = 50;

    public static final String XPATH = "xpath";
    public static final String CSS = "css";
}