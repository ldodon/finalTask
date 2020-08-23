package com.finalProject.utils;

import java.util.ResourceBundle;

public class ResourceBundleReader {
    private static ResourceBundle resourceBundle;

    private ResourceBundleReader(){resourceBundle= ResourceBundle.getBundle("application");}

    public static ResourceBundle getResourceBundle(){
        if(resourceBundle== null){
            new ResourceBundleReader();
        } return resourceBundle;
    }
}

