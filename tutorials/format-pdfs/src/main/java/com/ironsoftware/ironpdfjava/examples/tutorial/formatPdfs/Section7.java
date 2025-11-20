package com.ironsoftware.ironpdfjava.examples.tutorials.formatPdfs;

import com.ironsoftware.ironpdf;

public class Section7 {
    public static void run() {
            // Convert a local HTML file to a PDF document
            PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
            // Save the PDF document to the filesystem
            pdf.saveAs("htmlfile_to_pdf.pdf");
    }
}
