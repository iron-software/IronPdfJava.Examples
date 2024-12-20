package com.ironsoftware.ironpdfjava.examples.tutorials.formatPdfs;

import com.ironsoftware.ironpdf;

public class Section4 {
    public static void run() {
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
            pdf.saveAs("htmlstring_to_pdf.pdf");
    }
}
