package com.ironsoftware.ironpdfjava.examples.tutorials.generatePdfs;

import com.ironsoftware.ironpdf;

public class Section4 {
    public static void run() {
            // Convert HTML string to PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
            // Save the PDF to a file
            pdf.saveAs("htmlstring_to_pdf.pdf");
    }
}
