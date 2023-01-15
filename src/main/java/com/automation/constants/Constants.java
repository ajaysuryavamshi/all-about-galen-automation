package com.automation.constants;

import java.io.File;

public class Constants {

    private static final String USER_DIR = System.getProperty("user.dir") + File.separator;
    private static final String RESOURCES_DIR = USER_DIR + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public static final String SPECS_DIR = RESOURCES_DIR + "specs" + File.separator;

}
