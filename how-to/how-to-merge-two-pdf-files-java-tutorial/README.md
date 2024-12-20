# How To Combine PDF Documents with Java

***Based on <https://ironpdf.com/how-to/how-to-merge-two-pdf-files-java-tutorial/>***


## Introduction

This tutorial will explore combining multiple PDFs into a single document using Java. Combining PDF files is frequently needed in industries such as document management and reporting.

Throughout this tutorial, we will use [IronPDF for Java](https://ironpdf.com/java/) to demonstrate how to merge multiple PDFs. We will cover setting up your development environment, incorporating the library, loading PDFs, and merging them into one unified document. By the end of this guide, you'll be able to seamlessly integrate PDF merging capabilities using IronPDF for Java in your applications.

## IronPDF for Java

IronPDF for Java is a versatile library designed for developers to construct new PDFs from scratch or convert different file formats into PDFs, including the capacity to combine several PDF files into a single output file.

The API provided by IronPDF for Java is straightforward and intuitive, making the PDF creation and manipulation accessible. It supports a variety of functionalities, including text and image management, form processing, and much more.

## Prerequisites

A few requirements need to be fulfilled to begin creating PDFs:

1. Ensure Java is installed on your machine and properly configured in your environment variables. If you haven't installed Java, you can follow the steps on this [Java download instructions page](https://www.java.com/en/download/help/download_options.html#windows).
2. An IDE for Java such as Eclipse or IntelliJ should be installed. You can obtain Eclipse from the [Eclipse downloads page](https://www.eclipse.org/downloads/) and IntelliJ from the [IntelliJ download section](https://www.jetbrains.com/idea/download/#section=windows).
3. Download and integrate the IronPDF library into your Java project. Instructional guidance can be found in the IronPDF [installation guide](https://ironpdf.com/java/).
4. Ensure Maven is installed and configured in your IDE. For Maven installation and setup, refer to this [Maven installation tutorial](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-maven/installing-maven/).

## Installing IronPDF for Java

With all the prerequisites in place, installing IronPDF for Java is straightforward.

We will use JetBrains IntelliJ IDEA for the installation and example setup.

Open IntelliJ IDEA and create a new Maven project.

![Step 1](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-1.webp)

A setup window will appear. Here, name your project and hit 'Finish'.

![Step 2](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-2.webp)

Once you finish, your project will open with a POM.XML file where you can insert Maven dependencies for IronPDF for Java.

![Step 3](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-3.webp)

Add IronPDF dependencies in the POM.XML file or download the JAR directly from this [Maven repository](https://search.maven.org/artifact/com.ironsoftware/ironpdf/2022.11.0/jar).

![Step 4](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-4.webp)

Click the icon in the upper right of the XML file to start installing the Maven dependencies. This should only take a moment, depending on your internet speed.

## Merging Multiple PDF Documents

IronPDF facilitates the merging of multiple PDF documents into one using Java. Here are the methods supported by IronPDF:

1. Generate two individual PDF documents and combine them into one.
2. Combine existing PDF files into a unified PDF document.
3. Merge several PDF documents.

### Generating and Merging PDF Files

We'll start by creating and combining multiple PDF documents using IronPDF, employing an input stream.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException {
        String htmlA = "<p> [PDF_1] </p>"
                + "<p> Welcome to the first PDF  </p>";
        String htmlB = "<p> [PDF_2] </p>"
                + "<p> Welcome to the second PDF </p>";

        PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
        PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
        PdfDocument merged = PdfDocument.merge(pdfA, pdfB);

        merged.saveAs(Paths.get("assets/merged.pdf"));
    }
}
```

![Output Preview 1](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-5.webp)

### Combining Existing PDF Files

Merging existing PDF files into a single document is also straightforward. Just specify the input files, and IronPDF will combine them.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException {
        PdfDocument pdfA = PdfDocument.fromFile(Paths.get("assets/1.pdf"));
        PdfDocument pdfB = PdfDocument.fromFile(Paths.get("assets/2.pdf"));
        PdfDocument merged = PdfDocument.merge(pdfA, pdfB);

        merged.saveAs(Paths.get("assets/merged.pdf"));
    }
}
```

![Output Preview 2](https://ironpdf.com/static-assets/ironpdf-java/howto/how-to-merge-two-pdf-files-java-tutorial/how-to-merge-two-pdf-files-java-tutorial-6.webp)

### Merging More Than Two Documents

To merge more than two PDFs, simply specify all the files. The merged result will contain all specified documents.

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException {
        PdfDocument pdfA = PdfDocument.fromFile(Paths.get("assets/1.pdf"));
        PdfDocument pdfB = PdfDocument.fromFile(Paths.get("assets/2.pdf"));
        PdfDocument pdfC = PdfDocument.fromFile(Paths.get("assets/3.pdf"));
        PdfDocument merged = PdfDocument.merge(pdfA, pdfB, pdfC);

        merged.saveAs(Paths.get("assets/merged.pdf"));
    }
}
```

## Conclusion

This guide has meticulously walked you through the process of merging PDF documents using Java and IronPDF. By adhering to the outlined steps, you are now equipped to set up your development environment, integrate the IronPDF library, load and merge PDF files into a single document. IronPDF is a robust tool that enables the creation, conversion, and merging of PDFs effortlessly. For further details on merging PDFs in Java, explore the [IronPDF merge examples](https://ironpdf.com/java/examples/merge-pdfs/).

For additional tutorials on PDF manipulation using Java, refer to the [IronPDF documentation](https://ironpdf.com/java/docs/). Guidance on generating PDFs from HTML can be found in this [HTML to PDF conversion guide](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/).

IronPDF for Java is free for development and requires a license for commercial deployment. More information on licensing can be found on the [IronPDF licensing information page](https://ironpdf.com/java/licensing/).