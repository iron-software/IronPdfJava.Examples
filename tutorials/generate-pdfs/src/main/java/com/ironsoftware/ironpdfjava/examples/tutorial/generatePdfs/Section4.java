package com.ironsoftware.ironpdfjava.examples.tutorial.generatePdfs;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section4 {
    public static void run() throws IOException {
            // Convert HTML string to PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
            // Save the PDF to a file
            pdf.saveAs("htmlstring_to_pdf.pdf");
    }
}
