package com.ironsoftware.ironpdfjava.examples.howTo.printPdf;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            // Set the license key for IronPDF
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Render HTML to a PDF document
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>testing</h1>");
            
            // Print the PDF with a print dialog for user interaction
            pdf.print();
    }
}
