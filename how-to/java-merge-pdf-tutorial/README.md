# Combine PDFs into a Single Document using Java

PDF stands for **Portable Document Format** and is designed to display consistent content and layout across various devices and operating systems. Similarly, Java is a high-level language celebrated for its platform independence, which simplifies the transfer of software applications across different systems. However, managing PDFs in Java can be complex. **IronPDF**, a dedicated Java library, simplifies the manipulation of PDF documents.

In this guide, we'll discuss how to set up the IronPDF library and combine several PDF files into one using Java.

## IronPDF: A Java Library for PDF Manipulation

IronPDF serves as a robust tool for Java developers, enabling the creation, reading, and modification of PDF documents. This library allows developers to generate completely new PDFs from scratch, employing HTML for content design and adding metadata such as titles and authors. Moreover, it facilitates the merging of multiple PDFs into a single file without the need for additional libraries or external frameworks. This functionality is supported on various platforms like **Windows**, **Linux**, and cloud environments, designed specifically for **Java 8+, Kotlin, and Scala**.

## Setup Requirements

Before merging PDFs, ensure you have:

1. A Java-compatible IDE such as Netbeans, Eclipse, or IntelliJ. Here, we will use IntelliJ.
2. A Maven project configured in your IDE.

## Installing IronPDF

To get started with merging PDF files, first integrate the IronPDF Java library into your project. There are several ways to install IronPDF:

1. Insert the IronPDF dependency into your project's `pom.xml` and use Maven via command line or IDE to fetch it from the central repository.
2. Download the latest IronPDF version from the Maven website [directly from this link](https://search.maven.org/artifact/com.ironsoftware/ironpdf).
3. Download directly from the IronPDF website through this [link](https://ironpdf.com/java/).

In your `pom.xml`, you'll include the following dependency:

```xml
<!-- IronPDF dependency for merging PDFs -->
```

Additionally, the Slf4j-simple dependency is needed:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.5</version>
</dependency>
```

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-merge-pdf/java-merge-pdf-1.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-merge-pdf/java-merge-pdf-1.webp" alt="Java Merge PDFs - Figure 1: pom.xml dependencies" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Dependencies in pom.xml</p>
	</div>
</div>

You'll also need to include these imports in your `Main.java`:

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;
```

## How to Merge PDF Files in Java with IronPDF

Firstly, create the individual PDF files as follows, and then combine them:

```java
String htmlA = "<p> [PDF_A] </p>"
        + "<p> [PDF_A] 1st Page </p>"
        + "<div style='page-break-after: always;'></div>"
        + "<p> [PDF_A] 2nd Page</p>";
String htmlB = "<p> [PDF_B] </p>"
        + "<p> [PDF_B] 1st Page </p>"
        + "<div style='page-break-after: always;'></div>"
        + "<p> [PDF_B] 2nd Page</p>";

PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
PdfDocument merged = PdfDocument.merge(pdfA, pdfB);
```

This code snippet defines HTML content for two PDFs, which are then rendered to PDF using IronPDF. The `PdfDocument.merge` method combines these documents into a single PDF.

### Saving the Merged PDF

To save your newly merged PDF document to the desired location, execute:

```java
merged.saveAs(Paths.get("assets/merged.pdf"));
```

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-merge-pdf/java-merge-pdf-2.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-merge-pdf/java-merge-pdf-2.webp" alt="Java Merge PDFs - Figure 2: Merged Multiple PDF Documents" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Merged Multiple PDF Documents</p>
	</div>
</div>

### Combining Over Two PDFs

For merging more than two PDF documents, use this approach:

```java
import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) throws IOException {
    // Create various HTML content for PDFs
    String htmlC = "<p> [PDF_C] </p>"
            + "<p> [PDF_C] 1st Page </p>"
            + "<div style='page-break-after: always;'></div>"
            + "<p> [PDF_C] 2nd Page</p>";
    String htmlD = "<p> [PDF_D] </p>"
            + "<p> [PDF_D] 1st Page </p>"
            + "<div style='page-break-after: always;'></div>"
            + "<p> [PDF_D] 2nd Page</p>";

    // Instantiate and merge documents
    PdfDocument pdfC = PdfDocument.renderHtmlAsPdf(htmlC);
    PdfDocument pdfD = PdfDocument.renderHtmlAsPdf(htmlD);
    List<PdfDocument> pdfList = new ArrayList<>(List.of(pdfA, pdfB, pdfC, pdfD));
    PdfDocument mergedAll = PdfDocument.merge(pdfList);

    mergedAll.saveAs(Paths.get("assets/more_than_two_merged.pdf"));
}
```

Four PDFs are created and merged into one, using IronPDF's efficient rendering and merging capabilities.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-merge-pdf/java-merge-pdf-3.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-merge-pdf/java-merge-pdf-3.webp" alt="Java Merge PDFs - Figure 3: More Than Two Merged PDF Files" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">More Than Two Merged PDF Files</p>
	</div>
</div>

## Conclusion

This guide covered the entire process of setting up IronPDF in Java, generating PDFs with HTML, and merging multiple documents. IronPDF's performance and accuracy make it an optimal solution for managing PDF tasks in Java applications.

Find more details and examples on using IronPDF for Java in our [Code Examples](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/).

For development purposes, IronPDF is freely available. For commercial usage, visit [our licensing page](https://ironpdf.com/java/licensing/) for more details.