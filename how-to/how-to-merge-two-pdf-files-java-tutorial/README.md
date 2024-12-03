# How To Combine Two PDF Files Using Java

***Based on <https://ironpdf.com/how-to/how-to-merge-two-pdf-files-java-tutorial/>***


## 1. Introduction

This tutorial will guide you through the process of combining multiple PDF files into one document using Java. This is a frequent requirement in various sectors like document management, reporting, and others.

We will use [IronPDF for Java](https://ironpdf.com/java/) to demonstrate how to merge PDF documents. This includes setting up your development environment, integrating the necessary library, handling input files, and combining them. By the end of this tutorial, you will have a clear understanding of how to utilize IronPDF for Java for PDF merging tasks.

## 2. IronPDF for Java

IronPDF for Java is a robust library designed to facilitate the creation and conversion of PDF documents from various file formats. Its capabilities include merging several PDFs into one unified document.

The library is user-friendly with an intuitive API that simplifies PDF processing tasks, supporting functionalities such as text and image modifications, form completion, and more.

## 3. Prerequisites

Before getting started, ensure the following prerequisites are met:

1. Java must be installed on your machine with the JAVA_HOME environment variable properly configured. If Java is not installed, you can follow the instructions on this [Java download page](https://www.java.com/en/download/help/download_options.html#windows).
2. An IDE like Eclipse or IntelliJ is necessary. You can get Eclipse from the [Eclipse download page](https://www.eclipse.org/downloads/) and IntelliJ from the [IntelliJ download page](https://www.jetbrains.com/idea/download/#section=windows).
3. Download and integrate the IronPDF library by following the steps in the IronPDF [installation guide](https://ironpdf.com/java/).
4. Ensure Maven is installed and integrated with your IDE. For installation and setup, refer to this [Maven tutorial](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-maven/installing-maven/).

## 4. Installing IronPDF for Java

Once the prerequisites are checked, installing IronPDF for Java is straightforward.

Using JetBrains IntelliJ IDEA, create a new Maven project.

![Creating a new project](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-1.webp)

Name your project and finalize it.

![Project naming](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-2.webp)

In the newly created project, open the POM.XML file to manage dependencies.

![POM.XML](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-3.webp)

Add Maven dependencies for IronPDF, or download the JAR from this [Maven repository](https://search.maven.org/artifact/com.ironsoftware/ironpdf/2022.11.0/jar).

```xml
<!-- Add Maven Dependencies Here -->
```

Click the installation icon that appears in the POM.XML to install the dependencies.

![Dependency installation](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-4.webp)

## 5. Merging PDF Documents

IronPDF facilitates the combining of multiple PDF files into a single file in various ways.

### 5.1. Creating and Merging PDF Documents

Using IronPDF for Java, begin by generating PDF documents from HTML content and then merge them.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        String htmlContent1 = "<p>Document 1 content</p>";
        String htmlContent2 = "<p>Document 2 content</p>";

        PdfDocument document1 = PdfDocument.renderHtmlAsPdf(htmlContent1);
        PdfDocument document2 = PdfDocument.renderHtmlAsPdf(htmlContent2);
        PdfDocument mergedDocument = PdfDocument.merge(document1, document2);

        mergedDocument.saveAs(Paths.get("assets/combined.pdf"));
    }
}
```

### 5.2. Merging Existing PDF Files

You can also merge already existing PDF files into a single document.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        PdfDocument firstDocument = PdfDocument.fromFile(Paths.get("assets/first.pdf"));
        PdfDocument secondDocument = PdfDocument.fromFile(Paths.get("assets/second.pdf"));
        PdfDocument combinedDocument = PdfDocument.merge(firstDocument, secondDocument);

        combinedDocument.saveAs(Paths.get("assets/combined.pdf"));
    }
}
```

### 5.3. Combining Multiple PDF Documents

Merging more than two documents is just as straightforward with IronPDF.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        PdfDocument docA = PdfDocument.fromFile(Paths.get("assets/docA.pdf"));
        PdfDocument docB = PdfDocument.fromFile(Paths.get("assets/docB.pdf"));
        PdfDocument docC = PdfDocument.fromFile(Paths.get("assets/docC.pdf"));
        PdfDocument merged = PdfDocument.merge(docA, docB, docC);

        merged.saveAs(Paths.get("assets/all-merged.pdf"));
    }
}
```

## 6. Conclusion

This guide has covered the essentials of merging PDF files using Java with the IronPDF library. By following the described steps, you can successfully set up your environment, import the necessary libraries, handle the input files, and merge them into a single document. For more details on merging PDFs using Java, visit the [IronPDF merge examples page](https://ironpdf.com/java/examples/merge-pdfs/).

For further learning and tutorials on manipulating PDFs with Java, dive into the [IronPDF documentation](https://ironpdf.com/java/docs/). To explore creating PDFs from HTML, check out this guide on [converting HTML to PDF](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/).

IronPDF for Java is free for development but requires a commercial license for production use. Explore the [licensing options](https://ironpdf.com/java/licensing/) for more details.