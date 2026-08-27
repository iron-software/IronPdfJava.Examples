package com.ironsoftware.ironpdfjava.examples.howTo.javaPrintPdfTutorial;

import java.io.IOException;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import java.nio.file.Paths;

public class Section2 {
    public static void run() throws IOException {
            // Set the license key for IronPDF
            License.setLicenseKey("Enter-Your-License");  
            
            // Load PDF from the filesystem
            PdfDocument pdf = new PdfDocument(Paths.get("MyPdf.pdf"));
    }
}
