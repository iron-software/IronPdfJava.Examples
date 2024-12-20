package com.ironsoftware.ironpdfjava.examples.quickstart;

import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.*;

public class Section2 {
    public static void run() throws IOException {           
            // Apply your license key
            License.setLicenseKey("YOUR-LICENSE-KEY");
            
            // Set a log path
            Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
            
            // Render the URL as a PDF. Stored in myPdf as type PdfDocument
            PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("url_saved.pdf"));
            
            PdfDocument pdfDocument = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");
    }
}
