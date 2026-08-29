# HTML to PDF in Java

> Full guide: [HTML to PDF in Java](https://ironpdf.com/java/tutorials/format-pdfs/?utm_source=github)

*This guide provides a step-by-step approach for Java developers to convert HTML content into high-quality PDF documents using IronPDF.*

*IronPDF delivers a comprehensive solution for PDF conversion and processing. The library supports both [.NET](https://ironpdf.com/?utm_source=github) and [Java](https://ironpdf.com/java/?utm_source=github) developers. This specific guide focuses on utilizing IronPDF for Java to transform HTML sources into PDFs. You can find the tutorial specific to .NET in [this detailed guide on HTML to PDF conversion in .NET](https://ironpdf.com/tutorials/html-to-pdf/?utm_source=github).*

<hr class="separator">

<p class="main-content__segment-title">Overview</p>

<hr style="clear: both;" class="separator">

<p class="main-content__segment-title">Getting Started</p>

## 1. Setting Up IronPDF PDF Library for Java

### 1.1. Adding IronPDF as a Maven Dependency

For Java projects managed with Maven, integrate IronPDF by including the following dependencies in the `pom.xml` file:

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

The first dependency links to the [IronPDF library's latest version and changelog](https://ironpdf.com/java/product-updates/changelog/?utm_source=github), while the second is a [SL4J](https://www.slf4j.org/) simple implementation that aids in logging during the PDF rendering process. Alternatives to SL4J, such as [Logback](https://logback.qos.ch/) or [Log4J](https://logging.apache.org/log4j/2.x/), are also compatible.

Execute `mvn install` in the terminal within the root directory of your Java project to fetch the listed libraries.

### 1.2. Manual Installation of IronPDF JAR

For those not using Maven or similar systems, manually download and integrate the IronPDF library JAR files from the [official IronPDF download page](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2024.9.1-fat-jar.jar?utm_source=github).

### 1.3. Import IronPDF Package

The entire functionality of IronPDF is encapsulated within the `com.ironsoftware.ironpdf` package, which is made available as follows:

```java
// Include IronPDF library
import com.ironsoftware.ironpdf.*;
```

### 1.4. License Key Configuration (Optional)

IronPDF is usable for free but will imprint a watermark on generated PDFs. To create clean PDFs, configure the IronPDF library with a license key:

```java
// Configure IronPDF with a license key
License.setLicenseKey("YOUR-LICENSE-KEY");
```

Implement this configuration prior to any PDF generation activities for optimal results.

<div class="content-img-align-center">
<div class="center-image-wrapper">
<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-23.webp?utm_source=github" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-23.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Visit ironpdf.com/java/licensing/ to obtain a license key and enhance your PDF processing capabilities without watermarks.</p>
</div>
</div>

[Acquire a license from the IronPDF licensing page](https://ironpdf.com/java/licensing/?utm_source=github), or ask about [receiving a trial license](https://ironpdf.com/trial-license?utm_source=github).

### 1.5 Specify Log File Location (Optional)

If an SLF4J provider is installed, IronPDF by default logs to *IronPdfEngine.log* in the root directory of your application. To alter the log file's path and name:

```java
// Set the path for the log file
Settings.setLogPath(Paths.get("IronPdfEngine.log"));
```

*Important*: Call `Settings.setLogPath` before utilizing any PDF conversion methods.

<hr class="separator">

<p class="main-content__segment-title">How-To Guide and Code Examples</p>

## 2. Converting HTML to PDF

Explore IronPDF's capabilities to convert HTML content to PDF documents for three scenarios: HTML strings, HTML files, and URLs.

### 2.1. Producing a PDF from HTML String

Generate a PDF from a simple HTML string using the `PdfDocument.renderHtmlAsPdf` method:

```java
// Generating a PDF from an HTML string
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
// Save this PDF to a file
pdf.saveAs("example_from_string.pdf");
```

<div class="content-img-align-center">
<div class="center-image-wrapper">
<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-5.webp?utm_source=github" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-5.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Utilize the <code>PdfDocument.renderHtmlAsPdf</code> method to transform HTML markup directly into a PDF file, supporting any valid W3C HTML/CSS.</p>
</div>
</div>

The conversion engine respects all modern web standards and can include local or external web resources, such as stylesheets and images:

```java
// HTML content with local resource links
String htmlContent = "<html><head><title>Sample Title</title><link rel='stylesheet' href='style.css'></link></head><body><div><h1>Hello from IronPDF!</h1><img src='logo.png'></div></body></html>";
// Create a PDF from the HTML content
PdfDocument createdPdf = PdfDocument.renderHtmlAsPdf(htmlContent);
// Store the generated PDF
createdPdf.saveAs("complete_example.pdf");
```

<div class="content-img-align-center">
<div class="center-image-wrapper">
<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-24.webp?utm_source=github" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-24.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Rich media elements and complex web content can be flawlessly converted into PDFs, resembling their display in browsers like Chrome.</p>
</div>
</div>

`renderHtmlAsPdf` can optionally take a base path for resolving relative links—whether located locally or at a URL.

Learn more about creating PDFs from HTML strings from [our detailed code examples](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/?utm_source=github) and review the method in the [IronPDF Java API Reference](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html?utm_source=github#renderHtmlAsPdf(java.lang.String)).

### 2.2. Generating a PDF from a URL

For online content conversion:

```java
// Convert an online article to PDF
PdfDocument webPdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
// Save the produced PDF file
webPdf.saveAs("web_article.pdf");
```

<div class="content-img-align-center">
<div class="center-image-wrapper">
<a rel="nofollow" href="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-7.webp?utm_source=github" target="_blank"><img src="https://ironpdf.com/static-assets/pdf/java/tutorials/html-to-pdf/html-to-pdf-7.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Convert an entire web page into a PDF with the <code>PdfDocument.renderUrlAsPdf</code> method.</p>
</div>
</div>

Learn how to convert web pages into PDFs from our [practical examples](https://ironpdf.com/java/examples/converting-a-url-to-a-pdf/?utm_source=github).

### 2.3. Transforming an HTML File into a PDF

Convert files directly from the filesystem:

```java
// Create a PDF from a local HTML file
PdfDocument filePdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/example.html");
// Store the PDF
filePdf.saveAs("file_to_pdf.pdf");
```

Like the HTML-string method, this process respects all linked media, ensuring a fully rendered PDF output.

## 3. Further Reading

Expand your skills with IronPDF, exploring advanced scenarios and configurations.

1. Enhance your PDFs' appearance with configurable settings and elements like watermarks. Dive into customizations with our [feature guide](https://ironpdf.com/java/examples/pdf-generation-settings/?utm_source=github).
2. Read how to adjust margins, headers, footers, and page dimensions through our [comprehensive examples](https://ironpdf.com/java/examples/?utm_source=github).
3. For content extraction, PDF optimization, and programmatic printing, see our [in-depth tutorials](https://ironpdf.com/java/examples/printing-pdfs/?utm_source=github).

Access richer insights and controls with the [IronPDF Java API Reference](https://ironpdf.com/java/object-reference/api/?utm_source=github).

<hr class="separator">

<h4 class="tutorial-segment-title">Tutorial Quick Access</h4>

<div class="tutorial-section">
  <div class="row">
    <div clas