package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.stamp.ImageStamper;
import com.ironsoftware.ironpdf;

public class Section23 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            ImageStamper imageStamper = new ImageStamper(Paths.get("assets/logo.png"));
            // Apply to every page, one page, or some pages
            PDF.applyStamp(imageStamper);
            PDF.applyStamp(imageStamper, PageSelection.singlePage(2));
            PDF.applyStamp(imageStamper, PageSelection.pageRange(0, 2));
    }
}
