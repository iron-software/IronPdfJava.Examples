package com.ironsoftware.ironpdfjava.examples.tutorials.formatPdfs;

import com.ironsoftware.ironpdf;

public class Section5 {
    public static void run() {
            // HTML string containing local stylesheet and image references
            String html = "<html><head><title>Hello world!</title><link rel='stylesheet' type='text/css' href='style.css'></link></head><body><div><h1>Hello from IronPDF!</h1><a href='https://ironpdf.com/java/'><img src='logo.png' /></a></div></body></html>";
            // Render the HTML to a PDF document
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
            // Save the PDF document to the filesystem
            pdf.saveAs("output.pdf");
    }
}
