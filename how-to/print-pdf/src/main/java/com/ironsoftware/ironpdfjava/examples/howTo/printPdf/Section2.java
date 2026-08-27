package com.ironsoftware.ironpdfjava.examples.howTo.printPdf;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

public class Section2 {
    public static void run() throws IOException {
            // Set the license key for IronPDF
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Render HTML to a PDF document
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>testing</h1>");
            
            // Print the PDF directly without showing a print dialog
            pdf.printWithoutDialog();
    }
}
