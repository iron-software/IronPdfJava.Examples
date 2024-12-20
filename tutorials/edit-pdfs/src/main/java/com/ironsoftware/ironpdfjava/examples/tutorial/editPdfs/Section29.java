package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import java.awt.print.PrinterException;
import com.ironsoftware.ironpdf;

public class Section29 {
    public static void run() {
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Created with IronPDF!</h1>");
            try {
                pdf.print();
            } catch(PrinterException exception) {
                System.out.println("Failed to print PDF");
                exception.printStackTrace();
            }
    }
}
