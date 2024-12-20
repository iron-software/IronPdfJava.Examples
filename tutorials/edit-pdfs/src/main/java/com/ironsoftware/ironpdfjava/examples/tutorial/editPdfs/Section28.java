package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import java.nio.file.*;
import com.ironsoftware.ironpdf;

public class Section28 {
    public static void run() {
            PdfDocument form = PdfDocument.fromFile("assets/pdfform.pdf");  
              
            // Set the value of the firstname input field.  
            form.getForm().setFieldValue("firstname", "Minnie");  
              
            // Set the value of the lastname input field.  
            form.getForm().setFieldValue("lastname", "Mouse");  
              
            // Save the changes to the PDF Form.  
            form.saveAs(Paths.get("assets/BasicForm_Filled.pdf"));
    }
}
