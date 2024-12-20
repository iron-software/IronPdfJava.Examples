package com.ironsoftware.ironpdfjava.examples.pdfPageOrientation;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.firstPage());  
            existingPdf.rotatePage(PageRotation.CLOCKWISE_180, PageSelection.lastPage());  
            existingPdf.rotatePage(PageRotation.CLOCKWISE_90, PageSelection.singlePage(8)); // Rotate page 9  
            existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.pageRange(9, 14)); // Rotate pages 10 - 15
    }
}
