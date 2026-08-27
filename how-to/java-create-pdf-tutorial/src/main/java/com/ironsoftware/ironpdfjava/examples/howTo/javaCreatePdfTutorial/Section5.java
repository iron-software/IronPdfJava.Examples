package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf.PdfDocument;
import java.nio.file.Paths;

public class Section5 {
    public static void run() throws IOException {
            // Convert a URL to PDF
            PdfDocument urlToPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
            
            // Save the PdfDocument to a file
            urlToPdf.saveAs(Paths.get("urlToPdf.pdf"));
    }
}
