package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.stamp.VerticalAlignment;
import com.ironsoftware.ironpdf;

public class Section22 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            TextStamper stamper1 = new TextStamper();
            stamper1.setText("Hello World! Stamp One Here!");
            stamper1.setFontFamily("Bungee Spice");
            stamper1.setUseGoogleFont(true);
            
            stamper1.setFontSize(100);
            stamper1.setBold(true);
            stamper1.setItalic(false);
            stamper1.setVerticalAlignment(VerticalAlignment.TOP);
            
            
            PDF.applyStamp(stamper1);
    }
}
