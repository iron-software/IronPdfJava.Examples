package com.ironsoftware.ironpdfjava.examples.tutorials.formatPdfs;

import com.ironsoftware.ironpdf;

public class Section4 {
    public static void run() {
            // Convert a simple HTML string to a PDF document
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
            // Save the PDF document to the filesystem
            pdf.saveAs("htmlstring_to_pdf.pdf");
    }
}
