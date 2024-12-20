package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Section12 {
    public static void run() {
            // Load foreground PDFs from the filesystem (or create them programmatically)  
            PdfDocument foregroundPdf = PdfDocument.fromFile(Paths.get("assets/MyForeground.pdf"));  
              
            // Render content (HTML, URL, etc) as a PDF Document  
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.nuget.org/packages/IronPdf");  
              
            // Add the foreground PDFs to the newly-rendered document.  
            pdf.addForegroundPdf(foregroundPdf);  
              
            pdf.saveAs(Paths.get("assets/BackgroundForegroundPdf.pdf"));
    }
}
