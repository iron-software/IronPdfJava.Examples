# How To Combine PDF Documents Using Java

## 1. Introduction

In this tutorial, we will explore the process of combining several PDF documents into one file using Java. This capability is frequently necessary in various sectors such as enterprise document management, archiving, and reporting.

Throughout this guide, we'll exemplify the merging of multiple PDF files by using the [IronPDF for Java](https://ironpdf.com/java/). This includes setting up your development environment, integrating the library, handling input files, and combining these files into a unified PDF document. By the end of this guide, you'll be equipped with the necessary knowledge to employ IronPDF for Java for PDF merging tasks.

## 2. IronPDF for Java

IronPDF for Java is a robust solution designed to facilitate the generation of new PDFs from scratch, and the conversion of varied file formats into PDF. Additionally, it offers the functionality to combine several PDF files into a single document.

This library features a straightforward and user-friendly API that simplifies PDF development tasks for programmers. It supports a variety of functions such as editing of text and images, and completing forms.

## 3. Prerequisites

To execute the PDF merging process, several prerequisites need to be satisfied:

1. Java must be installed on your computer, and its path should be appropriately set within the environment variables. If Java is not installed yet, you can find installation instructions [here](https://www.java.com/en/download/help/download_options.html#windows).
2. An Integrated Development Environment (IDE) for Java, either Eclipse or IntelliJ, should be installed. Eclipse can be downloaded from [this link](https://www.eclipse.org/downloads/), and IntelliJ from [this link](https://www.jetbrains.com/idea/download/#section=windows).
3. The IronPDF library for Java should be obtained and added as a project dependency. Instructions for this can be found on the IronPDF website.
4. Maven should also be installed and configured within your IDE. For a guide on installing Maven and configuring it, please see [this link](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-maven/installing-maven/).

## 4. Installing IronPDF for Java

With all requirements in place, installing IronPDF for Java is straightforward, even for those new to Java.

In this guide, we utilize IntelliJ IDEA. Begin by opening IntelliJ and creating a new Maven project.

![1](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-1.webp)

In the subsequent window, provide the project name and finalize the creation.

![2](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-2.webp)

Once the project initializes, navigate to the POM.XML file to add IronPDF's Maven dependencies.

![3](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-3.webp)

The required dependencies can be found [here](https://search.maven.org/artifact/com.ironsoftware/ironpdf/2022.11.0/jar). 

After importing dependencies, an icon appears at the top corner of the POM.XML.

![4](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-4.webp)

Clicking this icon will initiate the installation of Maven dependencies for IronPDF for Java. This process may take a few minutes depending on your internet speed.

## 5. Combining Multiple PDF Files

IronPDF supports multiple methodologies to amalgamate PDFs:

### 5.1. Creating and Merging New PDF Documents

Here, we demonstrate creating and combining multiple PDF documents using IronPDF for Java and an input stream.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException {
        String htmlA = "<p>Document 1</p><p>This is the first PDF</p>";
        String htmlB = "<p>Document 2</p><p>This is the second PDF</p>";

        PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
        PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
        PdfDocument mergedPdf = PdfDocument.merge(pdfA, pdfB);

        mergedPdf.saveAs(Paths.get("path-to-save/merged-document.pdf"));
    }
}
```

![5](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-5.webp)

### 5.2. Merging Preexisting PDF Files

This method illustrates combining existing PDFs into a unified file. Just specify the list of input PDFs, and IronPDF will combine them into a single document and save it.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException {
        PdfDocument pdfA = PdfDocument.fromFile(Paths.get("path-to/first.pdf"));
        PdfDocument pdfB = PdfDocument.fromFile(Paths.get("path-to/second.pdf"));
        PdfDocument mergedPdf = PdfDocument.merge(pdfA, pdfB);

        mergedPdf.saveAs(Paths.get("path-to-save/merged-document.pdf"));
    }
}
```

![6](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-6.webp)

### 5.3. Combining Multiple PDF Documents

IronPDF facilitates the merger of more than two PDF files effortlessly. The result contains all combined PDFs.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException {
        PdfDocument pdfA = PdfDocument.fromFile(Paths.get("path-to/first.pdf"));
        PdfDocument pdfB = PdfDocument.fromFile(Paths.get("path-to/second.pdf"));
        PdfDocument pdfC = PdfDocument.fromFile(Paths.get("path-to/third.pdf"));
        PdfDocument mergedPdf = PdfDocument.merge(pdfA, pdfB, pdfC);

        mergedPdf.saveAs(Paths.get("path-to-save/merged-document.pdf"));
    }
}
```

## 6. Conclusion

This guide has provided a detailed walkthrough for merging PDF files using Java and the IronPDF library. By following the described steps, you're now prepared to set up your development environment, integrate the library, process input files, and merge them into one document. IronPDF for Java is an efficient tool for PDF creation and conversion, capable of merging multiple files into one. For additional resources on merging PDFs in Java, see [this link](https://ironpdf.com/java/examples/merge-pdfs/).

Explore more about IronPDF for Java and other tutorials on PDF manipulation using Java at [this link](https://ironpdf.com/java/docs/). For guidance on creating PDFs using Java, refer to [this tutorial](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/).

IronPDF for Java is available for development use at no cost, but a license is necessary for commercial applications. More details on licensing are available at [this link](https://ironpdf.com/java/licensing/).