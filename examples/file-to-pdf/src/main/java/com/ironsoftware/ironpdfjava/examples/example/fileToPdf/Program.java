package com.ironsoftware.ironpdfjava.examples.example.fileToPdf;

import java.io.IOException;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.Settings;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
            // Apply your license key
            License.setLicenseKey("YOUR-LICENSE-KEY");
            
            // Set a log path
            Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
            
            // Render the HTML as a PDF. Stored in myPdf as type PdfDocument;
            PdfDocument myPdf = PdfDocument.renderHtmlFileAsPdf("example.html");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("html_file_saved.pdf"));
    }
}
