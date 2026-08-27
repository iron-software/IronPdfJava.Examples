package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import java.nio.file.Paths;

public class Section3 {
    public static void run() throws IOException {
            // HTML content to be converted to PDF
            String htmlString = "<h1>Hello World!</h1><p>This is an example HTML string.</p>";
            
            // Convert HTML string to PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlString);
            
            // Save the PDF document to a file
            pdf.saveAs(Paths.get("html.pdf"));
    }
}
