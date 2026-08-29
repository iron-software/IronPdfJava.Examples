package com.ironsoftware.ironpdfjava.examples.howTo.javaMergePdfTutorial;

import java.io.IOException;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf.PdfDocument;

public class Section5 {
    public static void run() throws IOException {
            // Load existing PDFs
            PdfDocument existingPdf = PdfDocument.fromFile(Paths.get("source.pdf"));
            PdfDocument newPages = PdfDocument.fromFile(Paths.get("additional.pdf"));

            // Copy pages 2 to 4 out of the second document. Page 1 is index 0, and both
            // indices are inclusive.
            PdfDocument selectedPages = newPages.copyPages(1, 3);

            // Merge the copied pages with the existing PDF
            PdfDocument finalPdf = PdfDocument.merge(existingPdf, selectedPages);
            finalPdf.saveAs(Paths.get("merged_selective.pdf"));
    }
}
