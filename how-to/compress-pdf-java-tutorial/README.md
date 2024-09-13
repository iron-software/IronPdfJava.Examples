# How to Compress PDF Files in Java

PDF files are widely used for document storage and distribution, but their large size can sometimes be problematic, especially when it comes to uploading or sharing. Fortunately, using IronPDF—a Java PDF library—you can compress PDFs efficiently. This compression reduces file size by eliminating unnecessary elements such as embedded fonts and redundant images.

This guide will walk you through the process of using IronPDF to compress PDF files in Java and includes a practical code sample to aid in integration into your projects.

## IronPDF: A Comprehensive PDF Library

IronPDF is a robust [Java PDF library](https://ironpdf.com/java/) that enables developers to create, manipulate, compress, and read PDF files across different programming environments. It excels in generating accurate PDFs with features like document management, filling forms, embedding images, and, notably, PDF compression.

A key feature of IronPDF is its ability to compress existing PDF files, greatly reducing their size while maintaining high-quality output. This is particularly useful for large files that must be transferred quickly over the web or via email.

## Steps to Compress a PDF File Using IronPDF

### Setting Up IronPDF in a Java Maven Project

To get started with IronPDF in a Java Maven setup, you'll have to include the IronPDF Maven repository and its dependency in your `pom.xml` file:

- First, add IronPDF to your Maven project by configuring the repository and dependency. Insert the following lines into the **<dependencies>** section of your `pom.xml`:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>latest-version</version>
</dependency>
```

- After updating your `pom.xml` file, execute **mvn install** to incorporate IronPDF into your project.

With these steps done, you can now utilize the IronPDF library's classes in your Java project.

### Java Code to Compress a PDF Document

Below is a Java example demonstrating how to compress a PDF using IronPDF:

```java
import com.ironsoftware.ironpdf.*;
import java.io.IOException;
import java.nio.file.Paths;

public class CompressPDF {
    public static void main(String [] args) throws IOException {
        String sourcePath = "C:\\Image based PDF.pdf";
        PdfDocument document = PdfDocument.fromFile(Paths.get(sourcePath));
        
        // Compress images to 60% of original quality
        document.compressImages(60);
        document.saveAs(Paths.get("assets/document_compressed.pdf"));
        
        // Optionally reduce image resolution based on visibility in PDF, possibly altering image appearance
        document.compressImages(90, true); 
        String outputPath =  "C:\\Compressed.pdf";
        document.saveAs(Paths.get(outputPath));
    }
}
```

This code snippet imports the necessary IronPDF classes and performs image compression first at 60%, saving the result. It then compresses again at 90%, with an optional parameter to adjust image resolution based on display size, and saves the final output.

### Visual Comparison of Compression Results

#### Before Compression

![Original PDF](https://ironpdf.com/static-assets/ironpdf-java/howto/compress-pdf-java-tutorial/compress-pdf-java-tutorial-1.webp)

#### After Compression

![Compressed PDF Output](https://ironpdf.com/static-assets/ironpdf-java/howto/compress-pdf-java-tutorial/compress-pdf-java-tutorial-1.webp)

## Conclusion

IronPDF provides robust and cost-effective solutions for PDF compression in Java, along with additional functionalities like page rotation and HTML to PDF conversion. Starting from an affordable [license price](https://ironpdf.com/java/licensing/), this library offers excellent value for developers needing comprehensive PDF handling capabilities. IronPDF is the ideal choice for seamless, efficient PDF compression.