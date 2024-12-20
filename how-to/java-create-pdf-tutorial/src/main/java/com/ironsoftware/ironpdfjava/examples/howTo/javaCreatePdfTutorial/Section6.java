package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf.*;

public class Section6 {
    public static void run() {
        PdfDocument urlToPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
        // Save the PdfDocument to a file
        urlToPdf.saveAs(Paths.get("urlToPdf.pdf"));
    }
}
