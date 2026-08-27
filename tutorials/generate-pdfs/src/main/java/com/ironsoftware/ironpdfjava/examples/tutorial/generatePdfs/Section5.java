package com.ironsoftware.ironpdfjava.examples.tutorial.generatePdfs;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section5 {
    public static void run() throws IOException {
            // HTML content with references to local assets
            String html = "<html>" +
                              "<head>" +
                                "<title>Hello world!</title>" +
                                "<link rel='stylesheet' type='text/css' href='style.css'>" +
                              "</head>" +
                              "<body>" +
                                "<div class='content'>" +
                                  "<h1>Hello from IronPDF!</h1>" +
                                  "<a href='https://ironpdf.com/java/'>" +
                                    "<img src='logo.png' alt='Logo'/>" +
                                  "</a>" +
                                "</div>" +
                              "</body>" +
                            "</html>";
            // Convert to PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
            // Save the PDF to a local file
            pdf.saveAs("output.pdf");
    }
}
