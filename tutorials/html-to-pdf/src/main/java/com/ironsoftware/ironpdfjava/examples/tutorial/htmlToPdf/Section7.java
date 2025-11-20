package com.ironsoftware.ironpdfjava.examples.tutorials.htmlToPdf;

import com.ironsoftware.ironpdf;

public class Section7 {
    public static void run() {
            // Convert an HTML file to PDF
            PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
            // Save the PDF document
            pdf.saveAs("htmlfile_to_pdf.pdf");
    }
}
