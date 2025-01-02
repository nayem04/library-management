package com.librarymanagement.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExitController {
    private final ApplicationContext applicationContext;

    public ExitController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostMapping("/exit")
    public String shutdownApplication() {
        System.out.println("Application is shutting down....");

        // Start a new thread to close the application context
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Delay to ensure response is sent
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ((ConfigurableApplicationContext) applicationContext).close();
        }).start();

        return "Application has been shut down.";
    }
}
