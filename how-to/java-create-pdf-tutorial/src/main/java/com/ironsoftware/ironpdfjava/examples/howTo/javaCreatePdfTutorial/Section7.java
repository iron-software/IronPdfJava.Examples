package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf;

public class Section7 {
    public static void run() {
            // Apply security options to the PDF
            SecurityManager securityManager = urlToPdf.getSecurity();
            securityManager.setSecurityOptions(securityOptions);
            
            // Save the password-protected PDF document
            urlToPdf.saveAs("protected.pdf");
    }
}
