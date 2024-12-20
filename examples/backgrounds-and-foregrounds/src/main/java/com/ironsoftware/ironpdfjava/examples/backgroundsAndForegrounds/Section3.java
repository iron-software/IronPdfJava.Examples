package com.ironsoftware.ironpdfjava.examples.backgroundsAndForegrounds;

import com.ironsoftware.ironpdf.*;

public class Section3 {
    public static void run() {
            // Add the background to page 5 of the working PDF  
            pdf.addBackground(backgroundPdf, PageSelection.singlePage(6));  
             
            // Add a different background on pages 7 through 16 of the working PDF  
            pdf.addBackground(backgroundPdf, PageSelection.pageRange(6, 15));  
             
            // Add another background to just the first page.  
            pdf.addBackground(backgroundPdf, PageSelection.firstPage());
    }
}
