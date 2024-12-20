package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf.*;

public class Section5 {
    public static void run() {
        PdfDocument myPdf = PdfDocument.renderHtmlFileAsPdf("example.html");
        // Save the PdfDocument to a file
        myPdf.saveAs(Paths.get("html_file_saved.pdf"));
    }
}
