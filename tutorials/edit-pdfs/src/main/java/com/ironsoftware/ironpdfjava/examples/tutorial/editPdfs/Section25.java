package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.stamp.VerticalAlignment;
import com.ironsoftware.ironpdf;

public class Section25 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            BarcodeStamper QRStamp = new BarcodeStamper("IronPDF", BarcodeEncoding.QRCode);
            QRStamp.setHeight(50);
            QRStamp.setWidth(50);
            QRStamp.setHorizontalAlignment(HorizontalAlignment.LEFT);
            QRStamp.setVerticalAlignment(VerticalAlignment.BOTTOM);
            PDF.applyStamp(QRStamp);
    }
}
