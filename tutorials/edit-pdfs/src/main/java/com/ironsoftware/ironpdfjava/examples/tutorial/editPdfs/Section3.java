package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section3 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            PDF.removePages(PageSelection.lastPage()).saveAs(Paths.get("assets/lastPageRemove.pdf"));
    }
}
