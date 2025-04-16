package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import com.ironsoftware.ironpdf.edit.PageSelection;
import com.ironsoftware.ironpdf;

public class Section4 {
    public static void run() {
            // Load the PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Create the foreground PDF using HTML content
            PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");
            
            // Add the foreground to a specific page range (from page 2 to page 8)
            pdf.addForegroundPdf(foreground, PageSelection.pageRange(2, 8));
            
            // Save the modified PDF
            pdf.saveAs(Paths.get("overlayForeground.pdf"));
    }
}
