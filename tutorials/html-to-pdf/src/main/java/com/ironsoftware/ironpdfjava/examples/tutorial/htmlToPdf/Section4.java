package com.ironsoftware.ironpdfjava.examples.tutorial.htmlToPdf;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section4 {
    public static void run() throws IOException {
            // Convert HTML string to PDF document
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
            // Save the PDF document
            pdf.saveAs("htmlstring_to_pdf.pdf");
    }
}
