package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            // Set the license key for using IronPDF
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Load the target PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Render a background PDF from HTML content
            PdfDocument background = PdfDocument.renderHtmlAsPdf("<body style='background-color: cyan;'></body>");
            
            // Add the rendered background to all pages of the target PDF
            pdf.addBackgroundPdf(background);
            
            // Save the modified PDF with a new name
            pdf.saveAs(Paths.get("addBackground.pdf"));
    }
}
