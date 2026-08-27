package com.ironsoftware.ironpdfjava.examples.tutorial.htmlToPdf;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section7 {
    public static void run() throws IOException {
            // Convert an HTML file to PDF
            PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
            // Save the PDF document
            pdf.saveAs("htmlfile_to_pdf.pdf");
    }
}
