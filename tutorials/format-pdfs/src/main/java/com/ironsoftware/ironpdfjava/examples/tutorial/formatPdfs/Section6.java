package com.ironsoftware.ironpdfjava.examples.tutorials.formatPdfs;

import com.ironsoftware.ironpdf;

public class Section6 {
    public static void run() {
            // Convert a webpage from a URL to a PDF document
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
            // Save the PDF document to the filesystem
            pdf.saveAs("url_to_pdf.pdf");
    }
}
