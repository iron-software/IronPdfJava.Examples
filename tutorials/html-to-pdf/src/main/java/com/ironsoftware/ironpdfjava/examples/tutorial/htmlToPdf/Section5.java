package com.ironsoftware.ironpdfjava.examples.tutorials.htmlToPdf;

import com.ironsoftware.ironpdf;

public class Section5 {
    public static void run() {
            // HTML string with external assets
            String html = "<html><head><title>Hello world!</title><link rel='stylesheet' href='assets/style.css'></head><body><h1>Hello from IronPDF!</h1><a href='https://ironpdf.com/java/'><img src='assets/logo.png' /></a></body></html>";
            // Convert HTML to PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
            // Save the PDF document
            pdf.saveAs("output.pdf");
    }
}
