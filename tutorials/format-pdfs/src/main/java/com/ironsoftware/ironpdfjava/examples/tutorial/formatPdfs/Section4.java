package com.ironsoftware.ironpdfjava.examples.tutorial.formatPdfs;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section4 {
    public static void run() throws IOException {
            // Convert a simple HTML string to a PDF document
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
            // Save the PDF document to the filesystem
            pdf.saveAs("htmlstring_to_pdf.pdf");
    }
}
