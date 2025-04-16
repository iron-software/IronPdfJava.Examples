package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf;

public class Section3 {
    public static void run() {
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Load the PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Create the foreground PDF using HTML content
            PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");
            
            // Add the foreground to all pages
            pdf.addForegroundPdf(foreground);
            
            // Save the modified PDF
            pdf.saveAs(Paths.get("overlayForeground.pdf"));
    }
}
