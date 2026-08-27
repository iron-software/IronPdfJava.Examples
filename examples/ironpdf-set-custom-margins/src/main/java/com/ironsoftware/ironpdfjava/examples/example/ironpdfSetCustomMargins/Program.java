package com.ironsoftware.ironpdfjava.examples.example.ironpdfSetCustomMargins;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
            // Set Margins (in millimeters)  
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
            renderOptions.setMarginTop(40);  
            renderOptions.setMarginLeft(20);  
            renderOptions.setMarginRight(20);  
            renderOptions.setMarginBottom(40);  
              
            PdfDocument.renderHtmlFileAsPdf("assets/wikipedia.html", renderOptions).saveAs(Paths.get("assets/MyContent.pdf"));
    }
}
