package com.ironsoftware.ironpdfjava.examples.extractTextFromPdf;

import com.ironsoftware.ironpdf.*;

public class Program {
    public static void main(String[] args) {
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://unsplash.com/");
            String text = pdf.extractAllText();
            System.out.println("Text extracted from the website: " + text);
    }
}
