package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf.PdfDocument;
import java.nio.file.Paths;

public class Section4 {
    public static void run() throws IOException {
            // Convert HTML file to PDF
            PdfDocument myPdf = PdfDocument.renderHtmlFileAsPdf("example.html");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("html_file_saved.pdf"));
    }
}
