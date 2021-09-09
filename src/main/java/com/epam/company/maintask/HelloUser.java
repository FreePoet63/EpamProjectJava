package com.epam.company.maintask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class HelloUser {
    private static Logger log = LogManager.getLogger(HelloUser.class);

    public static void setUserConsole() {
        log.info("Start application!!!");
        Scanner setName = new Scanner(System.in);
        log.info("Hello " + setName.next());
    }
}
