package com.ironsoftware.ironpdfjava.examples.extractTextFromPdf;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));  
            String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
    }
}
