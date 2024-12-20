package com.ironsoftware.ironpdfjava.examples.customPdfPaperSize;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
            renderOptions.setPaperSize(PaperSize.B5);  
            PdfDocument.renderHtmlFileAsPdf("mycontent.html", renderOptions);
    }
}
