# How to Reduce PDF File Sizes in Java

***Based on <https://ironpdf.com/how-to/compress-pdf-java-tutorial/>***


PDFs are widely used for document storage and distribution, but their sizes can become cumbersome. This becomes an issue during transmissions or when space conservation is important. One effective solution to this problem is to compress PDF files, and IronPDF, a Java-based PDF library, provides an excellent tool for this purpose. Compressing a PDF involves minimizing its size by eliminating redundant components like embedded fonts and images.

This guide will discuss how IronPDF can be used to decrease PDF file sizes in Java, including a practical code example to aid you in integrating this functionality into your projects.

## IronPDF: A Comprehensive Java PDF Library

IronPDF serves as a robust [Java PDF library](https://ironpdf.com/java/) that allows developers to create, manipulate, compress, and retrieve PDF files across any programming environment. It excels in generating precise documents and includes features such as document management, form automation, image integration, compression, and more.

IronPDF distinguishes itself with its compression capabilities, enabling significant reduction of PDF file sizes without compromising the quality of the output. This feature is particularly beneficial for large documents that need to be transmitted efficiently over the internet or via email while maintaining file integrity.

## Steps to Compress PDF Files with IronPDF

Here’s how you can compress PDF files using IronPDF:

### Setting Up IronPDF in a Java Maven Project

- To utilize IronPDF in a [Maven project](https://ironpdf.com/java/docs/), first add the IronPDF Maven repository and dependencies into your `pom.xml` file.

- Incorporate the IronPDF dependency by inserting the following lines into the `<dependencies>` section of your `pom.xml` file:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>LATEST_VERSION</version>
</dependency>
```

- After updating your `pom.xml` file, execute **MVN install** to incorporate the IronPDF library into your project.

Once these steps are finalized, the IronPDF classes will be ready for use within your application.

### Java Example to Compress a PDF File

Review this Java snippet that applies the IronPDF library to [compress a PDF](https://ironpdf.com/java/examples/pdf-compression/):

```java
import com.ironsoftware.ironpdf.*;
import java.io.IOException;
import java.nio.file.Paths;

public class App {
    public static void main(String [] args) throws IOException {
        String sourcePath = "C:\\Image-based PDF.pdf";
        PdfDocument pdfDoc = PdfDocument.fromFile(Paths.get(sourcePath));

        // Compress images to 60% of their original quality
        pdfDoc.compressImages(60);
        pdfDoc.saveAs(Paths.get("assets/document_compressed.pdf"));

        // Optionally, compress images further to 90% and modify the image resolution
        // based on their visible size in the PDF, potentially altering image clarity
        pdfDoc.compressImages(90, true);
        String destinationPath = "C:\\Compressed.pdf";
        pdfDoc.saveAs(Paths.get(destinationPath));
    }
}
```

The program loads a PDF named "Image-based PDF.pdf", compresses its images first by 60% and then by 90% with adjusted resolution settings, and saves the outputs in specified locations.

### Visual Comparison of Compression

#### Before Compression

![Original PDF](https://ironpdf.com/static-assets/ironpdf-java/howto/compress-pdf-java-tutorial/compress-pdf-java-tutorial-1.webp)

#### After Compression

![Compressed PDF Output](https://ironpdf.com/static-assets/ironpdf-java/howto/compress-pdf-java-tutorial/compress-pdf-java-tutorial-1.webp)

## Conclusion

IronPDF proves to be an effective and affordable option for reducing PDF file sizes in Java, featuring capabilities like page rotation, HTML to PDF transformation, and image adjustments. Its various features make it an ideal choice for developers seeking cost-effective solutions for PDF compression without sacrificing functionality.

Explore [license pricing and options](https://ironpdf.com/java/licensing/) starting at just `$liteLicense` for budget-friendly access to quality software. Given its capabilities, IronPDF represents a solid choice for reliable and efficient PDF compression solutions.