# How to Programmatically Fill PDF Forms in Java (Tutorial)

***Based on <https://ironpdf.com/how-to/java-fill-pdf-form-tutorial/>***


Filling out a PDF form field-by-field can be tedious, so automating this process programmatically might often be more efficient, especially when paired with a user interface that enhances the experience while maintaining the documents in a digital format for archival purposes.

Imagine a scenario where a librarian needs to generate PDF forms programmatically after gathering data from users. These documents can then be stored or updated as needed. While numerous Java PDF Libraries, including PDF Box, IText7, and IronPDF exist, this tutorial focuses on employing IronPDF to fill out interactive forms.

## IronPDF for Java

IronPDF is a [robust Java library designed for PDF manipulation](https://ironsoftware.com/java/), enabling developers to create, edit, and handle PDF files seamlessly within Java applications. It is entirely compatible with Java environments and integrates effortlessly into Java projects.

Among its numerous features, IronPDF supports text and image editing, document security, and digital signature options. These capabilities allow developers to rapidly produce high-quality PDF documents, making IronPDF an invaluable tool for Java-based applications.

## How to Use IronPDF for Filling PDF Forms

Below, we'll go through the steps to use IronPDF in a Java application to fill PDF forms programmatically.

### Installing IronPDF in a Maven Project

To [add IronPDF Java to your project using Maven](https://ironsoftware.com/java/docs/), you'll need to:

1. Navigate to the `pom.xml` file in your project.
2. Insert the necessary dependencies within the `<dependencies>` tag.
3. After saving the file, execute "mvn install" in your project's directory to incorporate IronPDF Java along with its dependencies into your Maven project, as detailed on the [Sonatype Central Repository Page for IronPDF](https://central.sonatype.com/artifact/com.ironsoftware/ironpdf/2023.1.1).

Now, IronPDF is ready for use in your Java code.

### Filling PDF Forms with Java using IronPDF

The following Java code snippet illustrates how to programatically create and fill PDF forms with IronPDF by converting HTML forms to PDF. This example imports necessary IronPDF classes and sets the path for saving the filled PDF:

```java
import com.ironsoftware.ironpdf.PdfDocument;  
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;  
import java.io.IOException;  
import java.nio.file.*;

public class App {
    public static void main(String[] args) throws IOException {
        Path outputLocation = Paths.get("assets/BasicForm.pdf");  
        String formHTML = "<html>"  
                          + "<body>"  
                          + "<h1>Fillable PDF Form</h1>"  
                          + "<form>"  
                          + "First Name:<br> <input type='text' name='firstname'><br>"  
                          + "Last Name:<br> <input type='text' name='lastname'>"  
                          + "</form>"  
                          + "</body>"  
                          + "</html>";  

        ChromePdfRenderOptions options = new ChromePdfRenderOptions();  
        options.setCreatePdfFormsFromHtml(true);  
        PdfDocument.renderHtmlAsPdf(formHTML, options).saveAs(outputLocation);

        // Writing values to the PDF form  
        PdfDocument filledForm = PdfDocument.fromFile(outputLocation);  
        filledForm.getForm().setFieldValue("firstname", "Mickey");
        filledForm.getForm().setFieldValue("lastname", "Mouse");
        filledForm.saveAs(Paths.get("assets/FilledBasicForm.pdf"));
    }
}
```

Initially, the code creates a PDF form by converting an HTML structure into a fillable PDF. The `ChromePdfRenderOptions` is configured to make HTML forms editable within the PDF. Then, the PDF is saved, and subsequent code blocks populate fields and save the filled PDF.

### Visual Outputs

Initially, IronPDF generates a basic PDF with two editable text boxes:

![](https://ironsoftware.com/static-assets/ironpdf-java/howto/java-fill-pdf-form-tutorial/java-fill-pdf-form-tutorial-1.webp)

The subsequent code fills in each form field and saves it, as shown below:

![](https://ironsoftware.com/static-assets/ironpdf-java/howto/java-fill-pdf-form-tutorial/java-fill-pdf-form-tutorial-2.webp)

## Summary

To wrap it up, IronPDF is not just capable but also highly efficient for handling PDFs in Java, particularly for filling forms programmatically—a boon for automating document workflows.

IronPDF is available for a free trial and offers [competitive licensing options for its Java library](https://ironsoftware.com/java/licensing/), starting at `$liteLicense`, rendering it an economical option for both businesses and individual developers.