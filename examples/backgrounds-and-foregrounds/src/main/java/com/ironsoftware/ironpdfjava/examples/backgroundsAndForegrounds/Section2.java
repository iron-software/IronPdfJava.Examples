package com.ironsoftware.ironpdfjava.examples.backgroundsAndForegrounds;

import com.ironsoftware.ironpdf.*;

public class Section2 {
    public static void run() {
            PdfDocument pdf;
            PdfDocument backgroundPdf;
            // Use the third page of the background PDF as the background of every page  
            // in the working PDF  
            pdf.addBackground(backgroundPdf, 2);  
             
            // Use the second page of the foreground PDF as the foreground of every page  
            // of the working PDF  
            pdf.addForeground(foregroundPdf, 1);
    }
}
