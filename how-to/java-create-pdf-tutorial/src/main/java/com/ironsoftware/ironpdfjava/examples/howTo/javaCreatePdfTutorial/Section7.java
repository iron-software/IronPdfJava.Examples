package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import java.io.IOException;

import com.ironsoftware.ironpdf.security.SecurityManager;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.security.SecurityOptions;

public class Section7 {
    public static void run() throws IOException {
            // The page opens this before the snippet; opened here so the
            // section stands on its own.
            PdfDocument urlToPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
            SecurityOptions securityOptions = new SecurityOptions();
            securityOptions.setUserPassword("shareable");

            // Apply security options to the PDF
            SecurityManager securityManager = urlToPdf.getSecurity();
            securityManager.setSecurityOptions(securityOptions);
            
            // Save the password-protected PDF document
            urlToPdf.saveAs("protected.pdf");
    }
}
