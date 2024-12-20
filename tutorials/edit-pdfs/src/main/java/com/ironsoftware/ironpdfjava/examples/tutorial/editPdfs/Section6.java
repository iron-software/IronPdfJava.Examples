package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Section6 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            PdfDocument copied = PDF.copyPage(0);
            copied.saveAs("assets/Split.pdf");
    }
}
