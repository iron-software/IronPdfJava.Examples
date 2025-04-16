package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import com.ironsoftware.ironpdf.edit.PageSelection;
import com.ironsoftware.ironpdf;

public class Section2 {
    public static void run() {
            // Load the PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Load the background PDF
            PdfDocument background = PdfDocument.fromFile(Paths.get("background.pdf"));
            
            // Add background only to the first page of the target PDF
            // The second parameter (0) refers to the first page of the background PDF
            pdf.addBackgroundPdf(background, 0, PageSelection.firstPage());
            
            // Save the modified PDF
            pdf.saveAs(Paths.get("addBackgroundToSpecificPage.pdf"));
    }
}
