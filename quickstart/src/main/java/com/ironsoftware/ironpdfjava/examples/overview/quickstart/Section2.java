package com.ironsoftware.ironpdfjava.examples.overview.quickstart;

import com.ironsoftware.ironpdf.*;

import java.io.IOException;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.Settings;
import java.nio.file.Paths;

public class Section2 {
    public static void run() throws IOException {
            // Import statement for IronPDF Java

            
            // Apply your license key
            License.setLicenseKey("YOUR-LICENSE-KEY");
            
            // Set a log path
            Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
            
            // Render the URL as a PDF. Stored in myPdf as type PdfDocument
            PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("url_saved.pdf"));
    }
}
