package com.ironsoftware.ironpdfjava.examples.howTo.javaPrintPdfTutorial;

import java.io.IOException;
import java.awt.print.PrinterException;
import java.nio.file.Paths;
import com.ironsoftware.ironpdf.PdfDocument;


public class Section3 {
    public static void run() throws IOException, PrinterException {
            // The page opens this before the snippet; opened here so the
            // section stands on its own.
            PdfDocument pdf = new PdfDocument(Paths.get("MyPdf.pdf"));

            // Print PDF document using default printer settings without showing a print dialog
            pdf.printWithoutDialog();
    }
}
