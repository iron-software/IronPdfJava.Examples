package com.ironsoftware.ironpdfjava.examples.howTo.javaPrintPdfTutorial;

import com.ironsoftware.ironpdf;

public class Section2 {
    public static void run() {
            // Set the license key for IronPDF
            License.setLicenseKey("Enter-Your-License");  
            
            // Load PDF from the filesystem
            PdfDocument pdf = new PdfDocument(Paths.get("MyPdf.pdf"));
    }
}
