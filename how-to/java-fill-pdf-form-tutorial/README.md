# Filling Out PDF Forms Programmatically in Java (Tutorial)

***Based on <https://ironpdf.com/how-to/java-fill-pdf-form-tutorial/>***


While one might typically think of manually entering data into each field of a PDF, today we shift our focus towards automating this process through programming. This is particularly useful in scenarios where user interfaces enhance user interactions but require the generation of electronic PDF documents for storage or further processing.

In scenarios like a library system, after gathering user inputs, there might be a need to programmatically generate filled PDF forms. These forms can be stored for later use or could be modified. Various Java libraries such as PDF Box, IText7, and IronPDF are available for handling PDFs. This tutorial will guide you on using IronPDF to interactively fill PDF forms.

## Overview of IronPDF – a Java Library

IronPDF is a [comprehensive Java PDF library](https://ironsoftware.com/java/) designed for the creation, editing, and manipulation of PDF documents within Java applications. This library supports seamless integration into Java projects, enabling developers to incorporate PDF functionalities with minimal coding effort.

IronPDF offers a suite of features including text and image manipulation, secure document processing, and support for digital signatures. This makes it an invaluable tool for developers looking to produce high-quality PDF documents efficiently.

## Filling PDF Forms with IronPDF

Here's how you can use IronPDF to programmatically fill PDF forms in a Java environment.

### Setting Up IronPDF in a Maven Project

To [incorporate IronPDF into your Maven project](https://ironsoftware.com/java/docs/), proceed with the following steps:

1. Open your project's `pom.xml`.
2. Insert the following dependency tags within the `<dependencies>` section:
3. Save the modifications to `pom.xml` and run the command `mvn install` in your project directory to install IronPDF and its dependencies. Refer to the [Sonatype Central Repository](https://central.sonatype.com/artifact/com.ironsoftware/ironpdf/2023.1.1) for more details.

IronPDF is now ready to be used within your Java code.

### Programmatically Filling PDF Forms Using Java

Below is a code snippet demonstrating the use of IronPDF to create and fill PDF forms using HTML markup.

```java
import com.ironsoftware.ironpdf.PdfDocument;  
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;  
import java.io.IOException;  
import java.nio.file.*;

public class Application {
    public static void main(String [] args) throws IOException {
        Path outputLocation = Paths.get("assets/CompletedForm.pdf");  
        String formHTML = "<html>"
            + "<body>"
            + "<h2>PDF Form</h2>"
            + "<form>"
            + "First Name:<br> <input type='text' name='firstname' value=''><br>"
            + "Last Name:<br> <input type='text' name='lastname' value=''>"
            + "</form>"
            + "</body>"
            + "</html>";  
        
        ChromePdfRenderOptions options = new ChromePdfRenderOptions();  
        options.setCreatePdfFormsFromHtml(true);  
        PdfDocument.renderHtmlAsPdf(formHTML, options).saveAs(outputLocation);

        // Using the created form to input values  
        PdfDocument document = PdfDocument.fromFile(outputLocation);  
        
        // Assign values to firstname and lastname fields
        document.getForm().setFieldValue("firstname", "Daisy");  
        document.getForm().setFieldValue("lastname", "Duck");  
        
        // Save the updated PDF Form
        document.saveAs(Paths.get("assets/CompletedForm_Filled.pdf"));
    }
}
```

The first segment of the code generates a PDF form by transforming HTML markup into a PDF document, using the `renderHtmlAsPdf` method with `createPdfFormsFromHtml` set to true. This editable PDF is then stored at the specified location.

In the second segment, the created form is prepared for inputting the data. The `fromFile` method reads the PDF, `getForm` accesses form fields, `setFieldValue` assigns values to these fields, and finally, it’s saved as a new PDF document.

### Outputs

The initial block renders a basic PDF document with editable form fields designed to capture textual input. Below is the depiction of this initial PDF output:

![](https://ironsoftware.com/static-assets/ironpdf-java/howto/java-fill-pdf-form-tutorial/java-fill-pdf-form-tutorial-1.webp)

After setting the form values, the filled PDF looks as follows:

![](https://ironsoftware.com/static-assets/ironpdf-java/howto/java-fill-pdf-form-tutorial/java-fill-pdf-form-tutorial-2.webp)

## Conclusion

IronPDF presents itself as a dependable and efficient choice for managing PDF documents in Java, especially with features that support the automatic filling of forms. Its trial version is free and [varied licensing options](https://ironsoftware.com/java/licensing/) start from `$liteLicense`, making it an economical solution for both developers and businesses.