package com.ironsoftware.ironpdfjava.examples.tutorials.generatePdfs;

import com.ironsoftware.ironpdf;

public class Section6 {
    public static void run() {
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
            pdf.saveAs("url_to_pdf.pdf");
    }
}
