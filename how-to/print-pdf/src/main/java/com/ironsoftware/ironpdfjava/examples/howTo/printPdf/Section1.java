package com.ironsoftware.ironpdfjava.examples.howTo.printPdf;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Render HTML to PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>testing</h1>");
            
            // Print with Dialog
            pdf.print();
    }
}
