# HTML to PDF in Java

***Based on <https://ironpdf.com/tutorials/generate-pdfs/>***


*This guide is designed for Java developers on how to utilize the IronPDF library to transform HTML content into high-quality PDF documents.*

*IronPDF is a comprehensive suite for PDF conversion and manipulation, available for both [.NET](https://ironpdf.com/) and [Java](https://ironpdf.com/java/) programming environments. This tutorial specifically focuses on employing the library to convert HTML to PDF within Java applications. For a guide to doing so in .NET, please refer to the [HTML to PDF for .NET Tutorial](https://ironpdf.com/tutorials/html-to-pdf/).*

<hr class="separator">

<p class="main-content__segment-title">Overview</p>

<hr style="clear: both;" class="separator">

<p class="main-content__segment-title">Getting Started</p>

## 1. Installing the IronPDF Library for Java

### 1.1. Install IronPDF with Maven

To incorporate IronPDF into your Java project as a Maven dependency, insert these artifacts into your project's pom.xml file:

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

The first dependency denotes the [most recent release of IronPDF](https://ironpdf.com/java/product-updates/changelog/), while the second is an implementation of [SL4J](https://www.slf4j.org/). These are vital for enabling the logging capabilities of IronPDF's rendering engine. You may choose to replace it with other logging frameworks like [Logback](https://logback.qos.ch/) or [Log4J](https://logging.apache.org/log4j/2.x/), or not use logging at all.

Execute `mvn install` in your terminal at the root directory of your Java project to install these libraries.

### 1.2. Manual Installation of the IronPDF JAR

For those not using Maven or similar systems, manually add the IronPDF library JAR and [SL4J](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple) to your project’s classpath by [downloading them](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2022.12.0-fat-jar.jar).

Retrieve the JAR directly from the [IronPDF Java JAR Download Page](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2024.9.1-fat-jar.jar).

### 1.3. Import the IronPDF Package

Include this import statement in your Java files to use IronPDF:

```java
// Importing IronPDF namespace for Java
import com.ironsoftware.ironpdf.*;
```

### 1.4. Licensing (optional)

Although IronPDF for Java is free, usage with no license key results in watermarked PDFs.

To create watermark-free PDFs, use a license key as shown:

```java
// Set your license key
License.setLicenseKey("YOUR-LICENSE-KEY");
```

It's best practice to configure the license before performing any PDF operations.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-23.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-23.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Secure a license key at ironpdf.com/java/licensing/ for watermark-free PDF manipulation.</p>
	</div>
</div>

[Purchase a License Key for IronPDF](https://ironpdf.com/java/licensing/) directly from our website, or get a [free trial license key](#trial-license).

### 1.5 Configuring Log File Path (optional)

By default, IronPDF logs to *IronPdfEngine.log* in the Java application's root. To change this:

```java
// Customize the log path
Settings.setLogPath(Paths.get("IronPdfEngine.log"));
```

***Important***: Invoke `Settings.setLogPath` before using PDF manipulation methods.

<hr class="separator">

<p class="main-content__segment-title">How-To Guide and Code Examples</p>

## 2. Converting HTML to PDF

This section delves into IronPDF's functionality of transforming HTML into PDFs.

The `PdfDocument` class provides a comprehensive approach for HTML-to-PDF conversion catering to three scenarios: directly from HTML strings, from HTML files, and from a URL. We will address each scenario briefly with reference to additional resources.

### 2.1. Generating PDF from HTML Content

`PdfDocument.renderHtmlAsPdf` takes HTML code and renders it into a PDF file.

Here’s an example using a simple heading to produce a PDF:

```java
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Welcome to IronPDF!</h1>");
pdf.saveAs("from_html_to_pdf.pdf");
```

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-5.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-5.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Use <code>PdfDocument.renderHtmlAsPdf</code> to convert HTML markup directly into a PDF document. This method faithfully reproduces web-compliant HTML and CSS within PDF format.</p>
	</div>
</div>

`renderHtmlAsPdf` recognizes both local and external web assets ensuring that PDF files appear precisely as they would in a web browser.

Below is an example using HTML that references local files:

```java
String html = "<html><head><title>Welcome Page</title></head><body><h1>Welcome to IronPDF!</h1><img src='logo.png'></body></html>";
PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
pdf.saveAs("local_html_to_pdf.pdf");
```

The above code, as depicted in the following image, perfectly maps the HTML file with its dependent assets into PDF format.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-24.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-24.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption"><code>PdfDocument.renderHtmlAsPdf</code> skillfully renders HTML with all associated multimedia content. It's like Chrome but for PDF!</p>
	</div>
</div>

You can learn more about using HTML directly for PDF creation through [this example](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/) and the detailed explanation in the [IronPDF API Reference](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#renderHtmlAsPdf(java.lang.String)).

### 2.2. PDF Creation from a URL

Convert web content directly into PDFs using `PdfDocument.renderUrlAsPdf`.

In the following sample, a Wikipedia page transforms into a PDF document:

```java
PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
pdf.saveAs("webpage_to_pdf.pdf");
```

The conversion result is displayed as follows:

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-7.webp" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-7.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Convert website content into PDFs effortlessly with the <code>PdfDocument.renderUrlAsPdf</code> method from IronPDF.</p>
	</div>
</div>

For more on converting URL content to PDF, check the [Converting a URL to a PDF Code Example](https://ironpdf.com/java/examples/converting-a-url-to-a-pdf/).

### 2.3. Converting an HTML File into a PDF

IronPDF can smoothly transform HTML files from your filesystem into PDFs.

Below is a code snippet utilizing a saved HTML invoice file for conversion:

```java
PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
pdf.saveAs("file_based_pdf.pdf");
```

IronPDF adeptly handles linked CSS and JavaScript ensuring that the resultant PDF accurately reflects the original HTML document styling and scripting.

## 3. Further Exploration

There's much more to explore with IronPDF's capabilities in converting HTML to PDF.

Enhance your Java applications by diving into our [HTML to PDF Java Code Examples](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/) or learn more about document customization and advanced features in:

1. [Spicing up PDF appearance](https://ironpdf.com/java/examples/pdf-generation-settings/)
2. [Adding personalized headers, footers, and dimensions](https://ironpdf.com/java/examples/html-headers-and-footers/)
3. Opt for [custom margins](https://ironpdf.com/java/examples/ironpdf-set-custom-margins/) and [page sizes](https://ironpdf.com/java/examples/custom-pdf-paper-size/), or incorporate [unique watermarks](https://ironpdf.com/java/examples/backgrounds-and-foregrounds/).

You can also [extract text](https://ironpdf.com/java/examples/extract-text-from-pdf/) or [images](https://ironpdf.com/java/examples/extract-image-from-pdf/) from PDFs, [compress file sizes](https://ironpdf.com/java/examples/pdf-compression/), and [programmatically print documents](https://ironpdf.com/java/examples/printing-pdfs/).

Discover more via the [IronPDF Java API Reference](https://ironpdf.com/java/object-reference/api/) for in-depth information on every method and class available.

<hr class="separator">

<h4 class="tutorial-segment-title">Quick Tutorial Access</h4>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img src="https://ironpdf.com/img/platforms/cps-intellij.svg" alt="" class="img-responsive add-shadow" style="width: 160px;">
      </div>
    </div>
    <div class="col-sm-8">
      <h3>Download this Tutorial as Java Source Code</h3>
      <p>The full HTML to PDF Java Source Code for this guide is available for free download as a zipped IntelliJ project.</p>
      <a class="btn btn-white3" href="#">
        <i class="fa fa-cloud-download"></i>Download</a>
    </div>
  </div>
</div>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-8">
      <h3>Explore this Tutorial on GitHub</h3>
      <p>The entire source for this tutorial is available on GitHub.</p>
      <p>This is presented as an IntelliJ IDEA project but is compatible with other Java IDEs for quick start-up.</p>
      <a class="doc-link" href="#" target="_blank">Java HTML to PDF <i class="fa fa-chevron-right"></i></a>
    </div>
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img src="https://ironpdf.com/img/svgs/github-icon.svg" alt="" class="img-responsive add-shadow">
      </div>
    </div>
  </div>
</div>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img alt="" class="img-responsive add-shadow" src="https://ironpdf.com/img/svgs/documentation.svg" style="max-width: 110px; width: 100%; height: auto;">
      </div>
    </div>
    <div class="col-sm-8">
      <h3>View the API Reference</h3>
      <p>Learn about all the features, namespaces, classes, methods fields, and enums available through IronPDF in our detailed API Reference.</p>
      <a class="doc-link" href="https://ironpdf.com/java/object-reference/api/" target="_blank">View the API Reference <i class="fa fa-chevron-right"></i></a>
    </div>
  </div>
</div>