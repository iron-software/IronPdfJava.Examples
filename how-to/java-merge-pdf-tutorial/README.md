# Merge Multiple PDFs into a Single PDF using Java

***Based on <https://ironpdf.com/how-to/java-merge-pdf-tutorial/>***


PDFs, or **Portable Document Formats**, are widely used to maintain consistent content and layout across different platforms, devices, and software applications. Java, a high-level programming language, shares this platform independence, making it well-suited for PDF manipulations across various computer systems. Leveraging **IronPDF**, a robust Java library, simplifies tasks like merging multiple PDF documents.

In this guide, we will explore how to integrate the IronPDF Java library into your project to consolidate several PDF files into a single document.

## Overview of IronPDF Java Library

IronPDF is a comprehensive Java library that supports not only the creation and editing of single or multiple PDF documents but also facilitates the merging of several PDFs into one. Users can construct PDFs from scratch or manipulate existing PDFs with features that include HTML rendering and editing metadata like titles and authors. The library supports Java 8+, Kotlin, and Scala on Windows, Linux, and Cloud-based environments without the need for any third-party libraries or external frameworks.

## Prerequisites for Merging PDFs

Before you begin merging PDF files, ensure you have the following:

1. A Java-supported IDE such as Netbeans, Eclipse, or IntelliJ. We'll use IntelliJ for our examples.
2. A Maven project set up within your IDE.

## Installing IronPDF

To use IronPDF for merging PDF documents, you need to first install the library. Here are the methods to do so:

1. Add the IronPDF dependency to your project's `pom.xml` file and let Maven handle the installation using the command line or through your IDE.
   
   ```xml
   <!-- Add a placeholder for IronPDF dependency code -->
   ```

2. Alternatively, download the latest version of IronPDF from the Maven Central Repository directly [here](https://search.maven.org/artifact/com.ironsoftware/ironpdf).

3. Visit the IronPDF site and download the library directly through this [link](https://ironpdf.com/java/).

Additionally, include the `Slf4j-simple` dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.5</version>
</dependency>
```

For your Java project, incorporate the required imports to facilitate the merging of PDF documents:

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;
```

## Merging Two PDF Source Files

Begin by creating and then combining two PDF documents into one. Here's how you can accomplish that:

```java
String htmlA = "<p>PDF_A Content</p>"
        + "<p>First Page of PDF_A</p>"
        + "<div style='page-break-after: always;'></div>"
        + "<p>Second Page of PDF_A</p>";
String htmlB = "<p>PDF_B Content</p>"
        + "<p>First Page of PDF_B</p>"
        + "<div style='page-break-after: always;'></div>"
        + "<p>Second Page of PDF_B</p>";

PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
PdfDocument merged = PdfDocument.merge(pdfA, pdfB);
```

Each `PdfDocument` object represents a PDF generated from HTML strings. The PDFs are then merged into a single document using the `PdfDocument.merge` method.

### Save the Merged PDF

To save the merged PDF to a desired file path:

```java
merged.saveAs(Paths.get("assets/merged.pdf"));
```

### Merging More Than Two PDF Files

If merging more than two PDFs, you can extend the process as follows:

```java
import java.util.ArrayList;
import java.util.List;

public static void main(String [] args) throws IOException {
    List<String> htmlPages = generateHtmlPages(); // A hypothetical method to generate HTML content.
    List<PdfDocument> pdfDocuments = new ArrayList<>();

    for (String html : htmlPages) {
        pdfDocuments.add(PdfDocument.renderHtmlAsPdf(html));
    }

    PdfDocument mergedDocument = PdfDocument.merge(pdfDocuments);
    mergedDocument.saveAs(Paths.get("assets/multiple_merged.pdf"));
}
```

## Conclusion

This guide demonstrated how to merge PDF files using the versatile IronPDF library for Java. Starting from installing IronPDF, through generating PDFs from HTML, and finally merging them, each step helps you streamline the process of working with PDF files in Java.

For further information and advanced usage examples, visit the IronPDF [Code Examples](https://ironsoftware.com/java/examples/using-html-to-create-a-pdf/) page. IronPDF is available under a development-free license, with commercial licenses accessible through their [licensing page](https://ironsoftware.com/java/licensing/).