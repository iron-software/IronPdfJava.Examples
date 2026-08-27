package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import java.nio.file.Paths;

public class Section3 {
    public static void run() throws IOException {
            // Set the license key for using IronPDF
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Load the target PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Render the foreground content from HTML
            PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");
            
            // Add the rendered foreground to all pages of the PDF
            pdf.addForegroundPdf(foreground);
            
            // Save the modified PDF with a new name
            pdf.saveAs(Paths.get("overlayForeground.pdf"));
    }
}
