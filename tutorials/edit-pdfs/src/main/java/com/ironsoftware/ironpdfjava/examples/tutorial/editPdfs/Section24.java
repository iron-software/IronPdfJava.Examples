package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.stamp.VerticalAlignment;
import com.ironsoftware.ironpdf;

public class Section24 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            BarcodeStamper barcodeStamp = new BarcodeStamper("IronPDF", BarcodeEncoding.Code39);
            
            barcodeStamp.setHorizontalAlignment(HorizontalAlignment.LEFT);
            barcodeStamp.setVerticalAlignment(VerticalAlignment.BOTTOM);
            
            PDF.applyStamp(barcodeStamp);
    }
}
