# Java Merge PDF Files into a Single PDF

> Full guide: [Java Merge PDF Files into a Single PDF](https://ironpdf.com/java/how-to/java-merge-pdf-tutorial/)


PDF stands for **Portable Document Format**, which is a digital representation of documents incorporating text and images. This format maintains consistent presentation and structure across varying platforms, devices, and software.

Java is platform-independent in much the same way, which is why the two travel well together across operating systems. Reading source PDF files and input streams from Java is another matter, and is awkward without help. **IronPDF** is a Java library that handles it.

This tutorial will guide you through installing the IronPDF Java library and combining several PDF documents into one.

## IronPDF: A Java Library

IronPDF creates, reads and edits PDF documents from Java. It builds a PDF from scratch, styling the content through HTML rendering, and sets metadata such as the title and author. It also merges several PDFs into one output file. None of this needs a second library, a framework or a platform-specific integration. IronPDF targets **Java 8+, Kotlin, and Scala** on **Windows**, **Linux**, and **cloud platforms**.

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
String htmlA = "<p> [PDF_A] </p>"
        + "<p> [PDF_A] 1st Page </p>"
        + "<div style='page-break-after: always;'></div>"
        + "<p> [PDF_A] 2nd Page</p>";
String htmlB = "<p> [PDF_B] </p>"
        + "<p> [PDF_B] 1st Page </p>"
        + "<div style='page-break-after: always;'></div>"
        + "<p> [PDF_B] 2nd Page</p>";

// Create PdfDocument objects using the HTML content
PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);

// Merge the two PDF documents into a single document
PdfDocument merged = PdfDocument.merge(pdfA, pdfB);
```

The code above builds two strings of HTML markup, each spanning two pages, and
`renderHtmlAsPdf` turns each string into its own PDF document.

`PdfDocument.merge` then combines them. The result is a new `PdfDocument`
holding the content of the second document appended to the end of the first.

## Save the Merged PDF Document

Write the merged document to its destination path with a single line:

```java
merged.saveAs(Paths.get("assets/merged.pdf"));
```

## Merge More Than Two PDF Files at Once

To merge more than two documents, collect the `PdfDocument` objects in a list
and pass that list to `PdfDocument.merge` as a single argument:

```java
import java.util.List;
import java.util.ArrayList;

public static void main(String[] args) throws IOException {
    String htmlA = "<p> [PDF_A] </p>"
            + "<p> [PDF_A] 1st Page </p>"
            + "<div style='page-break-after: always;'></div>"
            + "<p> [PDF_A] 2nd Page</p>";
    String htmlB = "<p> [PDF_B] </p>"
            + "<p> [PDF_B] 1st Page </p>"
            + "<div style='page-break-after: always;'></div>"
            + "<p> [PDF_B] 2nd Page</p>";
    String htmlC = "<p> [PDF_C] </p>"
            + "<p> [PDF_C] 1st Page </p>"
            + "<div style='page-break-after: always;'></div>"
            + "<p> [PDF_C] 2nd Page</p>";
    String htmlD = "<p> [PDF_D] </p>"
            + "<p> [PDF_D] 1st Page </p>"
            + "<div style='page-break-after: always;'></div>"
            + "<p> [PDF_D] 2nd Page</p>";

    // Creating PdfDocument objects
    PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
    PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
    PdfDocument pdfC = PdfDocument.renderHtmlAsPdf(htmlC);
    PdfDocument pdfD = PdfDocument.renderHtmlAsPdf(htmlD);

    // Add documents to a list
    List<PdfDocument> pdfs = new ArrayList<>();
    pdfs.add(pdfA);
    pdfs.add(pdfB);
    pdfs.add(pdfC);
    pdfs.add(pdfD);

    // Merge all documents into a single PDF
    PdfDocument merged = PdfDocument.merge(pdfs);

    // Save the merged PDF document
    merged.saveAs(Paths.get("assets/more_than_two_merged.pdf"));
}
```

## Advanced Merging Options

Past the basic merge, IronPDF also covers:

* **Selective page merging**: copy a range of pages out of a source document
  before merging it.
* **Insertion at a position**: add a PDF at a chosen point in an existing
  document rather than at the end.
* **Metadata**: document properties survive the merge.
* **Large files**: long documents are processed without holding every page in
  memory at once.

Selective page merging looks like this:

```java
// Load existing PDFs
PdfDocument existingPdf = PdfDocument.fromFile(Paths.get("source.pdf"));
PdfDocument newPages = PdfDocument.fromFile(Paths.get("additional.pdf"));

// Copy pages 2 to 4 out of the second document. Page 1 is index 0, and both
// indices are inclusive.
PdfDocument selectedPages = newPages.copyPages(1, 3);

// Merge the copied pages with the existing PDF
PdfDocument finalPdf = PdfDocument.merge(existingPdf, selectedPages);
finalPdf.saveAs(Paths.get("merged_selective.pdf"));
```

> The guide writes that call as `newPages.extractPages(1, 3)`. There is no
> `extractPages` method in IronPDF for Java — it is an error on the page, not a
> renamed or removed API. The method that copies a page range is
> `copyPages(startIndex, endIndex)`, which is what this example uses. The
> library's naming is consistent on this point: everything named `extract*`
> returns page *content* (`extractAllText`, `extractAllImages`), never pages.

## Summary

This guide installed IronPDF for Java through Maven, produced PDF documents
with the HTML rendering methods, and merged two and then several of them into a
single file.

The Java engine converts HTML, a URL or a string into a PDF using open standard
document types (HTML, CSS, JS, JPG and PNG) and is built on the same
rendering work as IronPDF for .NET. For cloud deployment, see the guides for
[AWS](https://ironpdf.com/java/get-started/aws/),
[Azure](https://ironpdf.com/java/get-started/azure/) and
[Google Cloud](https://ironpdf.com/java/get-started/google-cloud/).

The [code examples pages](https://ironpdf.com/java/examples/) cover the rest of
the API. IronPDF is free for development and licensed for commercial use.

## Frequently Asked Questions

**How do I merge two PDF files in Java?**
Create or load the two documents, call `PdfDocument.merge(pdfA, pdfB)`, then
save the result with `saveAs`.

**What Java version is required?**
Java 8 or higher. Kotlin and Scala are supported too, on Windows, Linux and
cloud platforms, with no third-party libraries required.

**Can I merge more than two PDFs at once?**
Yes. Put the documents in a `List<PdfDocument>` and pass the list to `merge`.

**How do I add the library to a Maven project?**
Add the `com.ironsoftware` group and `ironpdf` artifact to `pom.xml`, as shown
above.

**Does merging preserve the original formatting?**
Yes. Layout and document properties from each source document are kept.

**Can I create PDFs from HTML before merging them?**
Yes. `renderHtmlAsPdf` produces a `PdfDocument` from HTML, and those documents
merge like any other.
