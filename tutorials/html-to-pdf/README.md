# HTML to PDF in Java

> Full guide: [HTML to PDF in Java](https://ironpdf.com/tutorials/html-to-pdf/)

_This guide provides step-by-step instructions for Java developers on using the IronPDF library to convert HTML content into precise PDF documents._

_IronPDF offers a comprehensive set of tools for converting and processing PDF documents, and supports both Java and .NET platforms. This guide focuses specifically on utilizing IronPDF for converting HTML content (including files, markup, and more) in Java applications. For .NET developers, the corresponding guide can be found in the [HTML to PDF .NET tutorial](https://ironpdf.com/tutorials/html-to-pdf/)._

--------------------------------------------------------------------------------

### How to Convert HTML to PDF in Java

![How to Convert HTML to PDF in Java](https://ironpdf.com/static-assets/pdf/images/html-to-pdf-java.png)

1. Set up the Java library for HTML to PDF conversion
2. Convert HTML Strings to PDF documents using the `renderHtmlAsPdf` method
3. Create PDFs from website URLs in Java
4. Convert HTML files to PDF using the `renderHtmlFileAsPdf` method
5. Save the newly created PDF document

--------------------------------------------------------------------------------

## 1. Installing the IronPDF PDF Library for Java

There are two approaches to integrate IronPDF into a Java Project:

1. Include IronPDF as a Maven dependency in a Maven-managed Java project
2. Manually download the IronPDF JAR File and add it to the project's classpath.

Let’s explore both installation methods in the following sections.

### Option 1: Install IronPDF Using Maven

To add IronPDF to your Java project via Maven, insert the following dependencies into your pom.xml file's dependency section.

```xml
<dependencies>
    
    <dependency>
        <groupId>com.ironsoftware</groupId>
        <artifactId>ironpdf</artifactId>
        <version>[LATEST_VERSION]</version>
    </dependency>

    
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>[LATEST_VERSION]</version>
    </dependency>
</dependencies>
```

The first dependency incorporates the [newest IronPDF version](https://ironpdf.com/java/product-updates/changelog/), whereas the second involves an SLF4J library required for IronPDF’s rendering engine to log events during its execution. Developers have the option to choose alternative logging frameworks or skip incorporating a logger.

To fetch these dependencies, execute the `mvn install` command from your project's root directory in the terminal.

### Option 2: Manually Install IronPDF JAR

For those not using Maven or similar systems, [download the IronPDF JAR file](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2024.9.1-fat-jar.jar) and optionally the [SLF4J implementation](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple) to include in your project's class path manually.

Get the IronPDF JAR from [here](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2024.9.1-fat-jar.jar).

--------------------------------------------------------------------------------

## 2. Converting HTML to PDF

Here, we look at IronPDF's capabilities for converting HTML content to PDF.

The `PdfDocument` class serves as the gateway to all of IronPDF’s document rendering and manipulation operations. It offers powerful methods to convert HTML to PDF in three main scenarios: from HTML strings or markup, from HTML files, and from URLs. This section briefly explores these capabilities, providing links for further exploration.

### 2.1 Import the IronPDF Package

To utilize IronPDF’s features, include the following import statement in your Java source files:

```java
// Essential IronPDF import for Java
import com.ironsoftware.ironpdf.*;
```

### 2.2. Set the License Key (optional)

While IronPDF for Java is usable for free, it applies a watermark to PDFs when used without a license.

```java
// Activating your license key
License.setLicenseKey("YOUR-LICENSE-KEY");
```

It’s best to set your license key before employing any other functionalities. To acquire a license, visit the [IronPDF licensing page](https://ironpdf.com/java/licensing/), or get in touch to request a [free trial key](https://ironpdf.com/trial-license).

### 2.3 Specify the Log File Location (optional)

Assuming an SLF4J provider is installed, IronPDF routes log messages to _IronPdfEngine.log_ in your application’s root directory by default. Use `Settings.setLogPath` to change the log file properties:

```java
// Customize the log file path
Settings.setLogPath(Paths.get("IronPdfEngine.log"));
```

Call `Settings.setLogPath` early in your application setup.

### 2.4. Generate a PDF from HTML String

To turn HTML strings into PDFs, utilize `PdfDocument.renderHtmlAsPdf`.

```java
// Create a PDF document from an HTML string
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Welcome to IronPDF!</h1>");
// Store the resultant PDF
pdf.saveAs("html-to-pdf.pdf");
```

![Conversion from HTML string to PDF](https://ironpdf.com/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-5.webp)

This process precisely replicates the rendering behavior of modern browsers, ensuring that your PDF appears just like it would on a web page.

Consider the following example for incorporating external assets into your HTML:

```java
// HTML string referencing external assets
String html = "<html><head><title>Welcome</title><link rel='stylesheet' href='assets/style.css'></head><body><h1>Hello from IronPDF!</h1><a href='https://ironpdf.com/java/'><img src='assets/logo.png' /></a></body></html>";
// Convert the HTML to a PDF
PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
// Save the resultant PDF
pdf.saveAs("output_with_assets.pdf");
```

![Result of conversion with assets](https://ironpdf.com/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-24.webp)

Optionally, you can specify a directory or URL path for sourcing the assets. More about this is available in [this example on HTML to PDF conversion](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/).

### 2.5. Convert a URL to a PDF

Convert web pages to PDFs using `PdfDocument.renderUrlAsPdf`.

```java
// Generate a PDF from a web URL
PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
// Save the PDF file
pdf.saveAs("wiki-pdf.pdf");
```

![Result of URL to PDF conversion](https://ironpdf.com/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-7.webp)

Discover more about this process in [this URL to PDF conversion guide](https://ironpdf.com/java/examples/converting-a-url-to-a-pdf/).

### 2.6. Convert an HTML File to a PDF

IronPDF effectively translates HTML files directly into their PDF counterparts.

Assuming the necessary assets like CSS and JavaScript are placed appropriately, here’s how you could convert an HTML document:

```java
// Transform an HTML file into a PDF
PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
// Store the newly created PDF
pdf.saveAs("invoice-pdf.pdf");
```

IronPDF resolves all relative URLs, ensuring that the generated PDF perfectly represents the styled HTML page.

## 3. Further Resources

Dive deeper into the features of IronPDF for Java with these resources:

1. Explore [advanced PDF generation settings](https://ironpdf.com/java/examples/pdf-generation-settings/) for customizing the PDF look and feel.
2. Learn to create PDFs with [custom headers and footers](https://ironpdf.com/java/examples/html-headers-and-footers/), adjustable [margins](https://ironpdf.com/java/examples/ironpdf-set-custom-margins/), [custom page sizes](https://ironpdf.com/java/examples/custom-pdf-paper-size/), [watermarks](https://ironpdf.com/java/examples/backgrounds-and-foregrounds/), and more.
3. Discover how to [extract text](https://ironpdf.com/java/examples/extract-text-from-pdf/) and [images from PDFs](https://ironpdf.com/java/examples/extract-image-from-pdf/), [compress PDF files](https://ironpdf.com/java/examples/pdf-compression/), and [print PDFs programmatically](https://ironpdf.com/java/examples/printing-pdfs/).

For a comprehensive understanding, consult the [IronPDF Java API Reference on the PdfDocument class](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html).