package com.ironsoftware.ironpdfjava.examples.tutorial.formatPdfs;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section6 {
    public static void run() throws IOException {
            // Convert a webpage from a URL to a PDF document
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
            // Save the PDF document to the filesystem
            pdf.saveAs("url_to_pdf.pdf");
    }
}
