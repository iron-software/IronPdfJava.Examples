package com.ironsoftware.ironpdfjava.examples.tutorial.generatePdfs;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section7 {
    public static void run() throws IOException {
            // Convert local HTML file to PDF
            PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
            // Save the PDF to a local file
            pdf.saveAs("htmlfile_to_pdf.pdf");
    }
}
