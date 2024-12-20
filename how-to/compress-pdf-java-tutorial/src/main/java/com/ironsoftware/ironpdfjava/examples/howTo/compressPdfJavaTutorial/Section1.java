package com.ironsoftware.ironpdfjava.examples.howTo.compressPdfJavaTutorial;

import java.io.IOException;
import java.nio.file.Paths;
import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() throws IOException {
        String src = "C:\\Image based PDF.pdf";
        PdfDocument pdf = PdfDocument.fromFile(Paths.get(src));  
        
        // Valid image compression values range from 1 to 100, where 100 
        // represents 100% of the original image quality.  
        pdf.compressImages(60);  
        pdf.saveAs(Paths.get("assets/document_compressed.pdf"));  
        
        // The second, optional parameter can scale down the image resolution 
        // according to its visible size in the PDF document. Note that this may cause distortion with some image configurations  
        pdf.compressImages(90, true); 
        String dest =  "C:\\Compressed.pdf";
        pdf.saveAs(Paths.get(dest));
    }
}
