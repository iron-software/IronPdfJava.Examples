package com.ironsoftware.ironpdfjava.examples.howTo.backgroundForeground;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;
import java.nio.file.Paths;

public class Section2 {
    public static void run() throws IOException {
            // Load the target PDF file
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));
            
            // Load the background PDF from a file
            PdfDocument background = PdfDocument.fromFile(Paths.get("background.pdf"));
            
            // Add the first page of the background PDF to the first page of the target PDF
            pdf.addBackgroundPdf(background, 0, PageSelection.firstPage());
            
            // Save the modified PDF with a new name
            pdf.saveAs(Paths.get("addBackgroundToSpecificPage.pdf"));
    }
}
