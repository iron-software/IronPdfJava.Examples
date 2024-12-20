package com.ironsoftware.ironpdfjava.examples.howTo.javaPrintPdfTutorial;

import java.nio.file.Paths;

import com.ironsoftware.ironpdf.*;

public class Section2 {
    public static void run() {
        License.setLicenseKey("Enter-Your-License");  
        PdfDocument pdf = new PdfDocument(Paths.get("MyPdf.pdf"));
    }
}
