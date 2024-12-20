package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section26 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            String html = "<h1> Example Title <h1/>";
            int watermarkOpacity = 30;
            PDF.applyWatermark(html, watermarkOpacity);
    }
}
