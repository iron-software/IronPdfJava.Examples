package com.ironsoftware.ironpdfjava.examples.tutorial.htmlToPdf;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section6 {
    public static void run() throws IOException {
            // Convert a URL to PDF
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
            // Save the PDF document
            pdf.saveAs("url_to_pdf.pdf");
    }
}
