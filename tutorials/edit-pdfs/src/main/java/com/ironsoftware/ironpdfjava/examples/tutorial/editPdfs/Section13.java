package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf;

public class Section13 {
    public static void run() {
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://unsplash.com/");
            String text = pdf.extractAllText();
            System.out.println("Text extracted from the website: " + text);
    }
}
