# HTML to PDF Conversion using IronPDF in Java

*This guide explains how Java developers can leverage the IronPDF library to transform HTML content into high-quality PDF documents.*

*IronPDF, a versatile PDF conversion and manipulation library, supports both [.NET](https://ironpdf.com) and [Java](https://ironpdf.com/java/) environments. Although this tutorial focuses on Java for HTML to PDF conversion, a similar guide for .NET is available [here](https://ironpdf.com/tutorials/html-to-pdf/).*

<hr class="separator">

## Overview

<hr style="clear: both;" class="separator">

## Getting Started

### Installing IronPDF Library for Java

#### Installing with Maven

Add IronPDF to your Java project as a Maven dependency by inserting the following lines into your project’s `pom.xml`:

```xml
<dependency>
  <groupId>com.ironsoftware</groupId>
  <artifactId>ironpdf</artifactId>
  <version>2022.12.0</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-simple</artifactId>
  <version>2.0.5</version>
</dependency>
```

Here, the first dependency is for the [latest version](https://ironpdf.com/java/product-updates/changelog/) of IronPDF, and the second is for an SLF4J implementation necessary for logging during PDF rendering. You may replace this with another logging framework, such as Logback or [Log4J](https://logging.apache.org/log4j/2.x/), or skip it if logging is not required.

Execute `mvn install` in your project’s root folder to download the dependencies.

#### Manual Installation

If you prefer not using Maven, you can [download the IronPDF Java library JAR](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2022.12.0-fat-jar.jar) and manually incorporate it into your project’s classpath along with the optional SLF4J implementation from the Maven Repository.

Download the JAR file directly [here](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2022.12.0-fat-jar.jar).

#### Import the IronPDF Package

Import IronPDF's classes by adding the following to your Java code files:

```java
// Import IronPDF classes
import com.ironsoftware.ironpdf.*;
```

#### Set Up the License Key (Optional)

IronPDF is usable without a license but will add a watermark to PDFs. Set a license key to remove this watermark:

```java
// Setting up the license key
License.setLicenseKey("YOUR-LICENSE-KEY");
```

Configure the license key prior to creating or processing PDFs for watermark-free documents. Purchase or obtain a trial key [here](https://ironpdf.com/java/licensing/).

Set the log file path using `Settings.setLogPath` to specify where logs should reside:

```java
// Customizing log file path
Settings.setLogPath(Paths.get("IronPdfEngine.log"));
```

This method must be called before any PDF manipulation methods to effectively change log settings.

<hr class="separator">

## How-To Guide and Code Examples

### HTML to PDF Conversion

IronPDF’s `PdfDocument` class provides methods to convert HTML content to PDF in several ways: directly from HTML strings, from HTML files, and via URLs. Each approach allows developers to handle different scenarios efficiently.

#### Convert HTML String to PDF

Here’s how you convert HTML string content into a PDF:

```java
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
pdf.saveAs("converted-from-html-string.pdf");
```

The `renderHtmlAsPdf` method processes all W3C-compliant HTML and CSS, ensuring that the PDF looks as it would in a modern browser. It also handles all related assets like images, CSS, and JavaScript accurately.

#### Convert from URL to PDF

Convert web pages to PDFs using the `renderUrlAsPdf` method:

```java
PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
pdf.saveAs("wikipedia-pdf.pdf");
```

#### Convert HTML File to PDF

To convert a stored HTML file into a PDF:

```java
PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
pdf.saveAs("invoice-pdf.pdf");
```

### Additional Resources

Explore further with code examples and detailed API documentation in the [Code Examples](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/) and the [API Reference](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html). Learn about ways to customize PDFs, extract content, compress files, and more through the [developer hub](https://ironpdf.com/java/).

Discover comprehensive guides and download Java source code from IronPDF's extensive library on GitHub or view detailed API documentation on the official IronPDF website.