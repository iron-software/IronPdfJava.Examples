package com.ironsoftware.ironpdfjava.examples.example.extractTextFromPdf;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;

public class Program {
    public static void main(String[] args) throws IOException {
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://unsplash.com/");
            String text = pdf.extractAllText();
            System.out.println("Text extracted from the website: " + text);
    }
}
