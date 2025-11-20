# Java Merge PDF Files into a Single PDF

***Based on <https://ironpdf.com/how-to/java-merge-pdf-tutorial/>***


PDF stands for **Portable Document Format**, which is a digital representation of documents incorporating text and images. This format maintains consistent presentation and structure across varying platforms, devices, and software.

Java, known for its high-level, platform-independent capabilities, mirrors the universal nature of PDFs. This similarity facilitates seamless transitions across different computing environments. However, handling source PDF files and input streams in Java might pose complexities. **IronPDF**, a Java library, simplifies these tasks by providing robust tools for manipulating existing PDFs.

This tutorial will guide you through installing the IronPDF Java library and combining several PDF documents into one.

## IronPDF: A Java Library

IronPDF serves as a toolkit for Java, enabling the creation, reading, and modification of single or multiple PDF documents. It empowers users to construct PDFs from scratch, incorporating rich content and style via HTML rendering, and also facilitates the insertion of metadata like titles and author details. Furthermore, it supports merging various PDFs into a single output file. This undertaking demands no auxiliary libraries, frameworks, or platform-specific integrations. IronPDF boasts **Cross-Platform Support** and is specifically engineered for **Java 8+, Kotlin, and Scala** across **Windows**, **Linux**, and various **Cloud platforms**.

## Prerequisites

Before initiating the merge process, ensure you have:

1. A Java-capable IDE (e.g., Netbeans, Eclipse, IntelliJ) — for this demonstration, IntelliJ will be used.
2. A Maven project set up in your IDE.

## Install IronPDF

To start merging PDF files, the first step involves integrating the IronPDF Java library into your project. There are several methods to achieve this:

1. Insert the IronPDF dependency into the `pom.xml` of your Maven project and utilize either the command-line or an IDE to facilitate automatic library retrieval from the central repository.
2. Alternatively, procure the latest IronPDF version directly from the Maven repository [here](https://search.maven.org/artifact/com.ironsoftware/ironpdf).
3. Another option is to download from the IronPDF official website using this [link](https://ironpdf.com/java/).

Add the following dependency snippet to your `pom.xml`:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>YOUR_VERSION_HERE</version>
</dependency>
```

Additionally, to merge PDFs, include `Slf4j-simple` in your project via this dependency or visit the Maven repository [here](https://search.maven.org/artifact/org.slf4j/slf4j-simple).

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.5</version>
</dependency>
```

### Imports Needed

The following import statements are necessary in your `main.java` file to take advantage of the IronPDF's functionalities:

```java
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;
```

## Merge Two PDF Source Files in Java using IronPDF

To [merge PDF files](https://ironpdf.com/java/examples/merge-pdfs/), starting with PDF creation and culminating in a combined PDF file, use the following example:

```java
String htmlA = "<p>PDF_A Content</p>