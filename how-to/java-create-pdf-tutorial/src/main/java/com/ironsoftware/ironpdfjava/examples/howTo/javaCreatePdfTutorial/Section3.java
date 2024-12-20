package com.ironsoftware.ironpdfjava.examples.howTo.javaCreatePdfTutorial;

import com.ironsoftware.ironpdf.*;

public class Section3 {
    public static void run() {
        String htmlString = "<h1>Hello World!</h1><p>This is an example HTML string.</p>";
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlString);
    }
}
