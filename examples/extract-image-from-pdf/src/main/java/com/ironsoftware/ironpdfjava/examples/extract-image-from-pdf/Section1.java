package com.ironsoftware.ironpdfjava.examples.extractImageFromPdf;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));  
            List<BufferedImage> pageRangeImages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
    }
}
