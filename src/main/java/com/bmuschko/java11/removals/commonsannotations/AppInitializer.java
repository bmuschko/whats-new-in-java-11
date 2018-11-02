package com.bmuschko.java11.removals.commonsannotations;

import javax.annotation.PostConstruct;

public class AppInitializer {
    @PostConstruct
    public void upAndRunning() {
        System.out.println("The application has been started successfully!");
    }
}
