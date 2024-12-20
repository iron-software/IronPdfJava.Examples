package com.ironsoftware.ironpdfjava.examples.tutorials.generatePdfs;

import com.ironsoftware.ironpdf;

public class Section5 {
    public static void run() {
            String html = "<html><head><title>Hello world!</title><style class='text/css' href='style.css'></style></head><body><div class=''><h1>Hello from IronPDF!</h1><a href='https://ironpdf.com/java/'><img src='logo.png' /></a></div></body></html>";
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
            pdf.saveAs("output.pdf");
    }
}
