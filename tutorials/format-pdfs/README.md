# HTML to PDF Conversion Using Java with IronPDF

***Based on <https://ironpdf.com/tutorials/format-pdfs/>***


*This guide provides instructions for Java developers on converting HTML content to high-quality PDF documents using the IronPDF library.*

*The IronPDF library is a comprehensive solution for converting and manipulating PDF documents. It is available for both [.NET](https://ironpdf.com) and [Java](https://ironpdf.com/java/) developers. In this guide, we focus on using IronPDF with Java to transform HTML content (files, markup, etc.) into PDFs. For .NET developers, refer to [the .NET HTML to PDF conversion guide](https://ironpdf.com/tutorials/html-to-pdf/).*

<hr class="separator">

## Overview

<hr style="clear: both;" class="separator">

## Getting Started

## 1. Installing the IronPDF Library for Java

### 1.1. Install IronPDF through Maven

To incorporate IronPDF into your Java project via Maven, insert the following dependencies into your project's `pom.xml` file:

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

The first dependency imports IronPDF, detailed in the [changelog for the IronPDF library](https://ironpdf.com/java/product-updates/changelog/). The second is an [SL4J](https://www.slf4j.org/) implementation essential for enabling IronPDF's rendering engine to create log messages. You may switch this with other logging frameworks such as [Logback](https://logback.qos.ch/) or [Log4J](https://logging.apache.org/log4j/2.x/), or exclude it if logging is not required.

Execute `mvn install` in the terminal at your project's root to download these libraries.

### 1.2. Manual Installation of the IronPDF JAR

If you prefer not using Maven or similar systems, you need to [download the IronPDF JAR file](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2022.12.0-fat-jar.jar) (and potentially the [SL4J implementation](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple)) and add these to your project's classpath manually.

Also, download the IronPDF JAR file from the [official IronPDF download page](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2024.9.1-fat-jar.jar).

### 1.3. Importing IronPDF

Incorporate IronPDF’s functionalities by importing its package at the beginning of your Java files:

```java
// Import IronPDF Java library
import com.ironsoftware.ironpdf.*;
```

### 1.4. Setting the License Key (Optional)

While IronPDF for Java is free, unlicensed use results in PDFs with a watermark. For unmarked PDFs, use a valid license key:

```java
// Configure the library with your license key
License.setLicenseKey("YOUR-LICENSE-KEY");
```

Set the license key prior to using any PDF generation or processing functionalities.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-23.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-23.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Secure a license key at ironpdf.com/java/licensing/ for watermark-free PDFs.</p>
	</div>
</div>

[Acquire a license key from the IronPDF licensing page](https://ironpdf.com/java/licensing/), or [request a free trial license](#trial-license).

### 1.5 Setting the Log File Path (Optional)

By default, IronPDF directs logs to *IronPdfEngine.log* in the Java project's root, if a SLF4J provider is installed. Adjust the log file's name and location using the `Settings.setLogPath` method:

```java
// Specify the log path
Settings.setLogPath(Paths.get("IronPdfEngine.log"));
```

It's important to invoke `Settings.setLogPath` before deploying PDF conversion or manipulation methods.

<hr class="separator">

## How-To Guide and Code Examples

## 2. HTML to PDF Conversion

Explore the core functionality of IronPDF for converting HTML to pixel-perfect PDF documents across the following scenarios: from HTML strings, from files, and from URLs. Below, we touch on each scenario briefly.

### 2.1. Creating PDFs from HTML Strings

The `PdfDocument.renderHtmlAsPdf` method transforms HTML strings into PDFs:

```java
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
pdf.saveAs("htmlstring_to_pdf.pdf");
```

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-5.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-5.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Convert HTML markup into PDFs easily using <code>PdfDocument.renderHtmlAsPdf</code>; it accepts standard HTML and CSS.</p>
	</div>
</div>

`RenderHtmlAsPdf` processes HTML, CSS, and JavaScript just like modern browsers, which ensures that the generated PDFs accurately reflect the online content. 

This method manages both local and online resources effectively, whether the HTML links to files on your disk or online assets:

```java
String html = "<html><head><title>Hello world!</title><style class='text/css' href='style.css'></style></head><body><div class=''><h1>Hello from IronPDF!</h1><a href='https://ironpdf.com/java/'><img src='logo.png' /></a></div></body></html>";
PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
pdf.saveAs("output.pdf");
```

In the example above, IronPDF accurately links the inline assets to ensure the PDF looks as intended.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-24.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-24.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption"><code>PdfDocument.renderHtmlAsPdf</code> supports a variety of complex HTML and multimedia elements.</p>
	</div>
</div>

Access additional details on the `renderHtmlAsPdf` method from [the code example illustrating HTML to PDF conversion](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/),