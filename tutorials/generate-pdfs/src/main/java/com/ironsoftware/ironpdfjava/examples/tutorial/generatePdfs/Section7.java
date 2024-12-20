package com.ironsoftware.ironpdfjava.examples.tutorials.generatePdfs;

import com.ironsoftware.ironpdf;

public class Section7 {
    public static void run() {
            PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
            pdf.saveAs("htmlfile_to_pdf.pdf");
    }
}
