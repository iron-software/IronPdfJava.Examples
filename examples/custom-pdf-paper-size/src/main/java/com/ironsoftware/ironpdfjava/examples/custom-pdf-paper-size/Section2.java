package com.ironsoftware.ironpdfjava.examples.customPdfPaperSize;

import com.ironsoftware.ironpdf.*;

public class Section2 {
    public static void run() {
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
            renderOptions.setPaperSize(PaperSize.Custom);  
            renderOptions.setCustomPaperWidth(11);   // in inches  
            renderOptions.setCustomPaperHeight(17);  // in inches
    }
}
