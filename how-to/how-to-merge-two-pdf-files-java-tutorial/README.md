# How to Combine Multiple PDFs into One Using Java

> Docs: [IronPDF for Java documentation](https://ironpdf.com/java/docs/?utm_source=github)


## 1. Overview

This tutorial explains the process of combining several PDF documents into one using Java. Combining PDFs is an essential task in fields like document management and reporting. Throughout this guide, we will use [IronPDF for Java](https://ironpdf.com/java/?utm_source=github) to demonstrate merging multiple PDF documents into a unified file. By the end of this tutorial, you’ll have learned to set up your Java environment, integrate the IronPDF library, and effectively merge PDF files.

## 2. What is IronPDF for Java?

IronPDF for Java is an influential tool that facilitates the creation of PDFs from various formats and the merging of existing PDFs into one comprehensive document. The library is user-friendly featuring a straightforward API that permits easy PDF manipulation which includes text and image adjustments, among other functionalities.

## 3. System Requirements

Before initiating the merging process, ensure the following prerequisites are satisfied:

1. Java must be installed on your system with the correct environment variable settings. If Java is not yet installed, see the [Java download instructions](https://www.java.com/en/download/help/download_options.html#windows).
2. A Java IDE such as Eclipse or IntelliJ is necessary. Eclipse can be obtained from the [Eclipse downloads](https://www.eclipse.org/downloads/), while IntelliJ can be downloaded from [IntelliJ’s website](https://www.jetbrains.com/idea/download/#section=windows).
3. The IronPDF library for Java needs to be included as a project dependency. Visit the IronPDF [installation page](https://ironpdf.com/java/?utm_source=github) for setup instructions.
4. Maven should be installed and configured in your IDE. For installation guidance, check out this [Maven installation tutorial](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-maven/installing-maven/).

## 4. Installing IronPDF for Java

With the prerequisites in place, installing IronPDF for Java is straightforward.

Start by launching JetBrains IntelliJ IDEA and creating a new Maven project. 

![](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial-how-to-merge-two-pdf-files-java-tutorial-1.webp)

A setup window will pop up; enter your project's name and finalize by clicking 'Finish'.

![](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial-how-to-merge-two-pdf-files-java-tutorial-2.webp)

In your new Maven project, open the POM.XML file to add IronPDF as a dependency or download the JAR directly from the [Maven repository](https://search.maven.org/artifact/com.ironsoftware/ironpdf/2022.11.0/jar).

```xml
<dependency>
  <groupId>com.ironsoftware</groupId>
  <artifactId>ironpdf</artifactId>
  <version>2022.11.0</version>
</dependency>
```
Once added, a notification will appear in IntelliJ to install the dependencies.

![](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial-how-to-merge-two-pdf-files-java-tutorial-3.webp)

## 5. Combining PDF Documents

IronPDF facilitates various techniques for merging PDFs:

### 5.1. Generating and Merging New PDFs

Create and combine PDFs as shown below using HTML content.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String htmlContent1 = "<p>Document one.</p><p>First PDF file.</p>";
        String htmlContent2 = "<p>Document two.</p><p>Second PDF file.</p>";

        PdfDocument doc1 = PdfDocument.renderHtmlAsPdf(htmlContent1);
        PdfDocument doc2 = PdfDocument.renderHtmlAsPdf(htmlContent2);

        PdfDocument mergedDoc = PdfDocument.merge(doc1, doc2);
        mergedDoc.saveAs(Paths.get("output/mergedOutput.pdf"));
    }
}
```

![](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial-how-to-merge-two-pdf-files-java-tutorial-4.webp)

### 5.2. Combining Pre-existing PDF Files

Merge existing documents by specifying their file paths.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        PdfDocument firstPdf = PdfDocument.fromFile(Paths.get("assets/pdf1.pdf"));
        PdfDocument secondPdf = PdfDocument.fromFile(Paths.get("assets/pdf2.pdf"));

        PdfDocument combinedPdf = PdfDocument.merge(firstPdf, secondPdf);
        combinedPdf.saveAs(Paths.get("output/finalCombined.pdf"));
    }
}
```

### 5.3. Merging Multiple PDF Documents

You can also merge an array of PDFs using IronPDF for Java as follows.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        PdfDocument docA = PdfDocument.fromFile(Paths.get("assets/doc1.pdf"));
        PdfDocument docB = PdfDocument.fromFile(Paths.get("assets/doc2.pdf"));
        PdfDocument docC = PdfDocument.fromFile(Paths.get("assets/doc3.pdf"));

        PdfDocument resultDoc = PdfDocument.merge(docA, docB, docC);
        resultDoc.saveAs(Paths.get("output/combinedResult.pdf"));
    }
}
```

## 6. Wrap Up

This tutorial provides a detailed guide on using Java and the IronPDF library to merge multiple PDFs into a single file. The methods shown will help you in setting up, importing your library, and merging documents efficiently. For more details on PDF merging in Java using IronPDF, refer to the [merge PDF examples](https://ironpdf.com/java/examples/merge-pdfs/?utm_source=github).

For further documentation on manipulating PDFs with Java, please view the [IronPDF guide](https://ironpdf.com/java/docs/?utm_source=github). For creating PDFs from HTML, explore the [HTML to PDF conversion guide](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/?utm_source=github).

IronPDF for Java is freely available for development but commercial use requires licensing. Learn about licensing on the [IronPDF licensing information page](https://ironpdf.com/java/licensing/?utm_source=github).