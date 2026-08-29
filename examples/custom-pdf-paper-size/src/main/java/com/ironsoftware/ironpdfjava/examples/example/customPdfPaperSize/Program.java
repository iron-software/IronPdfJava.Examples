package com.ironsoftware.ironpdfjava.examples.example.customPdfPaperSize;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;
import com.ironsoftware.ironpdf.render.PaperSize;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
            String html = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>";  
              
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
            renderOptions.setPaperSize(PaperSize.Custom);  
              
            /*  
             * Setting page sizes using different measuring units: * 1. setCustomPaperWidth( width ) / setCustomPaperHeight( height ): for inches * 2. setCustomPaperSizeInCentimeters( width, height ): for centimeters. * 3. setCustomPaperSizeInMillimeters( width, height ): for millimeters * 4. setCustomPaperSizeInPixelsOrPoints( width, height ): for pixels/points */renderOptions.setCustomPaperSizeInCentimeters(13.97, 13.97);  
              
            PdfDocument.renderHtmlAsPdf(html, renderOptions).saveAs(Paths.get("assets/CustomPaperSize.pdf"));
    }
}
