package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import java.io.IOException;

import com.ironsoftware.ironpdf.security.SecurityManager;

public class Section7 {
    public static void run() throws IOException {
            // Apply security options to the PDF
            SecurityManager securityManager = urlToPdf.getSecurity();
            securityManager.setSecurityOptions(securityOptions);
            
            // Save the password-protected PDF document
            urlToPdf.saveAs("protected.pdf");
    }
}
