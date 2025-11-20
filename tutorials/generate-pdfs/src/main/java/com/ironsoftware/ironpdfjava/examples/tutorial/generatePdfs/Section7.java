package com.ironsoftware.ironpdfjava.examples.tutorials.generatePdfs;

import com.ironsoftware.ironpdf;

public class Section7 {
    public static void run() {
            // Convert local HTML file to PDF
            PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
            // Save the PDF to a local file
            pdf.saveAs("htmlfile_to_pdf.pdf");
    }
}
