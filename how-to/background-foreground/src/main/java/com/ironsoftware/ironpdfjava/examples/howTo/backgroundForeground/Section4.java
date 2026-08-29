package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;
import java.nio.file.Paths;

public class Section4 {
    public static void run() throws IOException {
            // Load the target PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Render the foreground content from HTML
            PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");
            
            // Add the foreground to a specific page range (from page 2 to page 8)
            pdf.addForegroundPdf(foreground, PageSelection.pageRange(2, 8));
            
            // Save the modified PDF with a new name
            pdf.saveAs(Paths.get("overlayForeground.pdf"));
    }
}
