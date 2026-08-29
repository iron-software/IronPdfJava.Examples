package com.ironsoftware.ironpdfjava.examples.example.printingPdfs;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import java.awt.print.PrinterException;

public class Program {
    public static void main(String[] args) throws IOException {
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Created with IronPDF!</h1>");
            try {
                pdf.print();
            } catch(PrinterException exception) {
                System.out.println("Failed to print PDF");
                exception.printStackTrace();
            }
    }
}
