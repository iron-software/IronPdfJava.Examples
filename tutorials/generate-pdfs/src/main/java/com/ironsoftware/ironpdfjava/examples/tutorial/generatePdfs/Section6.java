package com.ironsoftware.ironpdfjava.examples.tutorials.generatePdfs;

import com.ironsoftware.ironpdf;

public class Section6 {
    public static void run() {
            // Convert a URL to PDF
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
            // Save the PDF to a file
            pdf.saveAs("url_to_pdf.pdf");
    }
}
