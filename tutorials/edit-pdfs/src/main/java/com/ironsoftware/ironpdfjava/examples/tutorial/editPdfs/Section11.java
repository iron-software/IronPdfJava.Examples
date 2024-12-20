package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Section11 {
    public static void run() {
            // Load background PDFs from the filesystem (or create them programmatically)  
            PdfDocument backgroundPdf = PdfDocument.fromFile(Paths.get("assets/MyBackground.pdf"));  
              
            // Render content (HTML, URL, etc) as a PDF Document  
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.nuget.org/packages/IronPdf");  
              
            // Add the background PDFs to the newly-rendered document.  
            pdf.addBackgroundPdf(backgroundPdf);  
              
            pdf.saveAs(Paths.get("assets/BackgroundPdf.pdf"));
    }
}
