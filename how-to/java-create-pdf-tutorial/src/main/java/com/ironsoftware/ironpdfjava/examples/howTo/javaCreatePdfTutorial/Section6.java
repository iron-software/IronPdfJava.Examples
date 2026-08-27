package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf.security.SecurityOptions;

public class Section6 {
    public static void run() {
            // Create security options and set user password
            SecurityOptions securityOptions = new SecurityOptions();
            securityOptions.setUserPassword("shareable");
    }
}
