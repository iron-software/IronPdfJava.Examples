package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Load the PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Load the background PDF
            PdfDocument background = PdfDocument.renderHtmlAsPdf("<body style='background-color: cyan;'></body>");
            
            // Add the background to all pages
            pdf.addBackgroundPdf(background);
            
            // Save the modified PDF
            pdf.saveAs(Paths.get("addBackground.pdf"));
    }
}
