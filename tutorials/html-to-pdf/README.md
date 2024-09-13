# HTML to PDF in Java

*This guide provides a comprehensive breakdown for Java developers on utilizing the IronPDF library to transform HTML content into flawless PDF documents.*

*IronPDF stands out as a complete solution for PDF conversion and processing, supporting both [.NET](https://ironpdf.com) and [Java](https://ironpdf.com/java/) environments. Specifically, this document focuses on leveraging the library for HTML to PDF transformations within Java applications. For similar functionalities in .NET, refer to the following [tutorial](https://ironpdf.com/tutorials/html-to-pdf/).*

<hr class="separator">

<p class="main-content__segment-title">Overview</p>




<hr style="clear: both;" class="separator">

<p class="main-content__segment-title">Getting Started</p>

## 1. Integrating the IronPDF PDF Library into Your Java Project

To integrate the IronPDF library into a Java application, developers have two primary options:

1. Configure IronPDF as a Maven project dependency.
2. Manually download and add the IronPDF JAR file into the project's classpath.

We'll explore both methods in the forthcoming sections.

### Option 1: Adding IronPDF via Maven Dependency

To incorporate IronPDF into your Java project with Maven, you'll need to insert specific artifacts into the `dependencies` section of your project's `pom.xml` file. Here's how you can do it: 

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>%s</version>
</dependency>
```

This code snippet adds the IronPDF library to your project, ensuring you're using the [most recent version](https://ironpdf.com/java/product-updates/changelog/) available.

Here's the paraphrased content for the section requested:

```shell
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>%s</version>
</dependency>
```

The initial `dependency` element references the [most recent release](https://ironpdf.com/java/product-updates/changelog/) of the IronPDF library. Subsequently, a dependency for an [SLF4J](https://www.slf4j.org/ "target=_blank") implementation is mentioned. This is crucial for empowering IronPDF's rendering capabilities to produce log outputs during its operation. Developers have the flexibility to replace this logging dependency with other alternatives like [Logback](https://logback.qos.ch/ "target=_blank") or [Log4J](https://logging.apache.org/log4j/2.x/ "target=_blank"), depending on their logging preferences, or even remove it entirely if logging is unnecessary for their application.

To incorporate these libraries into your project, execute the `mvn install` command in a command-line interface located at your Java project’s primary directory. This will pull the specified libraries into your environment.

### Option 2: Manually Adding IronPDF JAR

For those developers who opt out of using Maven or other dependency management systems, it's necessary to manually import the IronPDF library JAR file. You may also consider including an optional [SLF4J](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple) library if logging support is needed.

You can directly download the IronPDF JAR file from [this link](https://ironpdf.com/static-assets/ironpdf-java/packages/ironpdf-2022.12.0-fat-jar.jar) or locate it via the Maven Repository. Once downloaded, simply incorporate it into your project's classpath.

<hr class="separator">

<p class="main-content__segment-title">How-To Guide and Code Examples</p>

## 2. Converting HTML to PDF

This part of the guide highlights the powerful HTML-to-PDF conversion capabilities offered by IronPDF.

The central component of IronPDF's PDF generation and handling functionalities is the `PdfDocument` class. It provides a comprehensive suite of methods designed to facilitate the conversion of HTML to PDF. These capabilities cater to three primary scenarios: transforming HTML strings/markup into PDFs, converting HTML files directly into PDFs, and creating PDFs from webpage URLs. We will explore each of these scenarios briefly in this section, along with references to further resources for more detailed information.

### 2.1 Import the IronPDF Package

The entire suite of IronPDF's conversion and processing tools is housed within the `com.ironsoftware.ironpdf` package.

To access these functionalities within your Java application, insert the following import statement at the beginning of your Java source files that utilize IronPDF:

```java
// Necessary import to access IronPDF functionality
import com.ironsoftware.ironpdf.*;
```

Here is the paraphrased section of the article:

```java
// Java imports for IronPDF library
import com.ironsoftware.ironpdf.*;
```

### 2.2. Configure the License Key (optional)

While IronPDF for Java doesn't require a purchase to operate, it does apply a tiled background watermark to PDF documents created by users utilizing the free version.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-23.webp" target="_blank"><img src="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-23.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Obtain a license key at ironpdf.com/java/licensing/ to convert and manipulate PDF documents without watermarks.</p>
	</div>
</div>

To create PDF documents with IronPDF devoid of any watermarks, it is imperative to configure the library using a legitimate license key. The code snippet provided below demonstrates how to set up your license key with the library.

```java
// Set your license key
License.setLicenseKey("YOUR-LICENSE-KEY");
```

It is advisable to configure the license key prior to creating or modifying PDF files. For optimal usage, initiate the `setLicenseKey` method at the beginning of your code sequence.

Acquire a license key by visiting our [licensing page](https://ironpdf.com/java/licensing/), or get in touch with us to [receive a free trial license key](https://ironpdf.com#trial-license).

### 2.3 Configure the Log File Path (Optional)

Out of the box, if you have set up an SLF4J logger, IronPDF logs its activities to a default text file named *IronPdfEngine.log* in the root directory of your Java application.

If you prefer to log to a different file or directory, you can alter this setting with the `Settings.setLogPath` method, as demonstrated below:

```java
// Define a custom path for the log file
Settings.setLogPath(Paths.get("your-custom-log-path.log"));
```

Here's the paraphrased section where the original Java code and text have been modified for clarity and uniqueness:

```java
// Configure the log file location for IronPDF
Settings.setLogPath(Paths.get("IronPdfEngine.log"));
```

This code snippet configures the logging path for IronPDF operations, directing them to a file named `IronPdfEngine.log`.

***Important Reminder***: It is essential to invoke `Settings.setLogPath` prior to employing any methods for PDF conversion or manipulation.

### 2.4 Transforming HTML Strings into PDF Documents

The `PdfDocument.renderHtmlAsPdf` method enables the conversion of HTML strings into PDF files.

Consider this code snippet where a simple HTML headline is used to create a new PDF file:

```java
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
pdf.saveAs("htmlstring_to_pdf.pdf");
```

Here's the paraphrased section with resolved URL paths and adjusted code snippet, ensuring it still operates with related functionality:

```java
// Initialize a new PdfDocument by rendering HTML as a PDF
PdfDocument document = PdfDocument.renderHtmlAsPdf("<h1>Welcome to IronPDF!</h1>");
// Save the document as a PDF file
document.saveAs("example_html_to_pdf.pdf");
```

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-5.webp" target="_blank"><img src="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-5.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Convert HTML markup into PDF File using the <code>PdfDocument.renderHtmlAsPdf</code>. This method can generate PDF documents using all valid W3C-compliant HTML and CSS markup.</p>
	</div>
</div>

The `renderHtmlAsPdf` method handles all HTML, CSS, and JavaScript assets consistently with modern, standards-compliant web browsers. This functionality enables developers to generate PDFs that are an accurate reflection of how content is displayed in a browser.

The method is able to source external resources such as images, stylesheets, and scripts from directories either locally on the computer or across a network. Below is an example demonstrating the creation of a PDF from HTML that utilizes a CSS file and an image from an `assets` directory:

Below is the paraphrased section of your article, with the relative URL paths resolved to `ironpdf.com`.

```java
String htmlContent = "<html><head><title>Welcome</title><link rel='stylesheet' href='https://ironpdf.com/assets/style.css'></head><body><h1>Welcome to IronPDF!</h1><a href='https://ironpdf.com/java/'><img src='https://ironpdf.com/assets/logo.png'></a></body></html>";
PdfDocument document = PdfDocument.renderHtmlAsPdf(htmlContent);
document.saveAs("final_output.pdf");
```

The outcome of the previous code snippet is visually illustrated in the following image.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-24.webp" target="_blank"><img src="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-24.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption"><code>PdfDocument.renderHtmlAsPdf</code> can render all kinds of rich media elements. If it displays in Chrome, then <code>renderHtmlAsPdf</code> will render it!</p>
	</div>
</div>

Additionally, the `renderHtmlAsPdf` method supports an optional second parameter where developers can define a base path for web assets. This base path can either refer to a local directory or a URL.

For more details on utilizing the `renderHtmlAsPdf` method, explore [this code example](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/), or consult the [API Reference](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#renderHtmlAsPdf(java.lang.String)) documentation.

### 2.5. Generating a PDF from a Webpage URL

With IronPDF's `PdfDocument.renderUrlAsPdf` function, programmers can transform web pages into PDF files seamlessly.

Below is an illustration of converting a Wikipedia page into a PDF document.

```java
// Create a PDF from a URL
PdfDocument newPdf = PdfDocument.renderUrlAsPdf("https://en.wikipedia.org/wiki/PDF");
newPdf.saveAs("web_to_pdf_conversion.pdf");
```

The displayed PDF format resulting from the conversion is illustrated below.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-7.webp" target="_blank"><img src="/static-assets/ironpdf-java/tutorials/html-to-pdf/html-to-pdf-7.webp" alt="" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">The IronPDF java library can convert HTML content contained in web pages hosted online. Use the <code>PdfDocument.renderUrlAsPdf</code> method to make it happen.</p>
	</div>
</div>

Gain further insights into transforming web pages into PDF files by accessing the [code example](https://ironpdf.com/java/examples/converting-a-url-to-a-pdf/).

### 2.6. Generating a PDF from an HTML Document

IronPDF is capable of transforming locally stored HTML documents into their PDF counterparts effectively.

Below is a practical example utilizing [this example invoice](https://codepen.io/tjoen/pen/wvgvLX) to illustrate the proficiency of IronPDF in converting HTML files to PDF format.

For ease of reference, the HTML code for the invoice is presented below:

```html
<html>
<head>
    <meta charset="utf-8">
    <title>Invoice</title>
    <link rel="stylesheet" href="style.css">
    <link rel="license" href="https://www.opensource.org/licenses/mit-license/">
    <script src="script.js"></script>
</head>
<body>
<header>
    <h1>Invoice</h1>
    <address contenteditable>
        <p>Jonathan Neal</p>
        <p>101 E. Chapman Ave<br>Orange, CA 92866</p>
        <p>(800) 555-1234</p>
    </address>
    <span><img alt="" src="http://www.jonathantneal.com/examples/invoice/logo.png"><input type="file" accept="image/*"></span>
</header>
<article>
    <h1>Recipient</h1>
    <address contenteditable>
        <p>Some Company<br>c/o Some Guy</p>
    </address>
    <table class="meta">
        <tr>
            <th><span contenteditable>Invoice #</span></th>
            <td><span contenteditable>101138</span></td>
        </tr>
        <tr>
            <th><span contenteditable>Date</span></th>
            <td><span contenteditable>January 1, 2012</span></td>
        </tr>
        <tr>
            <th><span contenteditable>Amount Due</span></th>
            <td><span id="prefix" contenteditable>$</span><span>600.00</span></td>
        </tr>
    </table>
    <table class="inventory">
        <thead>
        <tr>
            <th><span contenteditable>Item</span></th>
            <th><span contenteditable>Description</span></th>
            <th><span contenteditable>Rate</span></th>
            <th><span contenteditable>Quantity</span></th>
            <th><span contenteditable>Price</span></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a class="cut">-</a><span contenteditable>Front End Consultation</span></td>
            <td><span contenteditable>Experience Review</span></td>
            <td><span data-prefix>$</span><span contenteditable>150.00</span></td>
            <td><span contenteditable>4</span></td>
            <td><span data-prefix>$</span><span>600.00</span></td>
        </tr>
        </tbody>
    </table>
    <a class="add">+</a>
    <table class="balance">
        <tr>
            <th><span contenteditable>Total</span></th>
            <td><span data-prefix>$</span><span>600.00</span></td>
        </tr>
        <tr>
            <th><span contenteditable>Amount Paid</span></th>
            <td><span data-prefix>$</span><span contenteditable>0.00</span></td>
        </tr>
        <tr>
            <th><span contenteditable>Balance Due</span></th>
            <td><span data-prefix>$</span><span>600.00</span></td>
        </tr>
    </table>
</article>
<aside>
    <h1><span contenteditable>Additional Notes</span></h1>
    <div contenteditable>
        <p>A finance charge of 1.5% will be made on unpaid balances after 30 days.</p>
    </div>
</aside>
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Invoice Document</title>
    <link rel="stylesheet" href="style.css">
    <link rel="license" href="https://www.opensource.org/licenses/mit-license/">
    <script src="script.js"></script>
</head>
<body>
<header>
    <h1>Invoice Details</h1>
    <address>
        <p>Jonathan Neal</p>
        <p>101 E. Chapman Ave<br>Orange, CA 92866</p>
        <p>(800) 555-1234</p>
    </address>
    <span><img alt="Company Logo" src="http://www.jonathantneal.com/examples/invoice/logo.png"><input type="file" accept="image/*"></span>
</header>
<main>
    <h1>For</h1>
    <address>
        <p>Some Company<br>c/o Some Guy</p>
    </address>
    <table class="information">
        <tr>
            <th>Invoice Number</th>
            <td>101138</td>
        </tr>
        <tr>
            <th>Date</th>
            <td>January 1, 2012</td>
        </tr>
        <tr>
            <th>Total Amount</th>
            <td>$600.00</td>
        </tr>
    </table>
    <table class="items">
        <thead>
        <tr>
            <th>Item</th>
            <th>Description</th>
            <th>Unit Price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Front End Consultation</td>
            <td>Experience Review</td>
            <td>$150.00</td>
            <td>4</td>
            <td>$600.00</td>
        </tr>
        </tbody>
    </table>
    <button>Add Item</button>
    <table class="summary">
        <tr>
            <th>Total</th>
            <td>$600.00</td>
        </tr>
        <tr>
            <th>Amount Paid</th>
            <td>$0.00</td>
        </tr>
        <tr>
            <th>Balance Due</th>
            <td>$600.00</td>
        </tr>
    </table>
</main>
<aside>
    <h1>Notes</h1>
    <p>A finance charge of 1.5% will be applied on unpaid balances after 30 days.</p>
</aside>
</body>
</html>
```

Assuming you've stored the HTML file along with its CSS and JavaScript files in a directory named `invoices`, you can effortlessly convert it to PDF using IronPDF with the procedure outlined below:

```java
// Create a PDF file from an HTML file located on the local disk
PdfDocument document = PdfDocument.renderHtmlFileAsPdf("C:/invoices/TestInvoice1.html");
// Save the rendered PDF document as 'htmlfile_to_pdf.pdf'
document.saveAs("htmlfile_to_pdf.pdf");
```

Similar to the examples converting HTML strings to PDFs, IronPDF adeptly adjusts any relative URLs in an HTML document to their absolute counterparts on the file system. Consequently, the resulting PDF file accurately replicates the visual effects that the linked stylesheets and scripts impact on a webpage.

## 3. Additional Resources

This introduction to IronPDF's capabilities to transform HTML into PDF is just the beginning. To deepen your expertise in utilizing the HTML to PDF converter for Java, explore the meticulously assembled code samples in our [Code Examples](https://ironpdf.com/java/examples/using-html-to-create-a-pdf/) segment.

1. Discover how to tailor the appearance of your PDF files during the conversion process with [this code example](https://ironpdf.com/java/examples/pdf-generation-settings/).
2. Create PDF documents featuring [custom headers and footers](https://ironpdf.com/java/examples/html-headers-and-footers/), [specific margin sizes](https://ironpdf.com/java/examples/ironpdf-set-custom-margins/), [custom page dimensions](https://ironpdf.com/java/examples/custom-pdf-paper-size/), [watermarks](https://ironpdf.com/java/examples/backgrounds-and-foregrounds/), and other elements.
3. Learn how to [extract text](https://ironpdf.com/java/examples/extract-text-from-pdf/) and [images](https://ironpdf.com/java/examples/extract-image-from-pdf/) from PDF documents, [reduce PDF file size](https://ironpdf.com/java/examples/pdf-compression/), and [print PDFs programmatically](https://ironpdf.com/java/examples/printing-pdfs/).

For a more comprehensive understanding and finer control over the PDF rendering process, consult the [IronPDF Java API Reference](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html) on the `PdfDocument` class.

```
## Video Tutorial: Converting HTML to PDF

Explore our video tutorial on converting HTML to PDF using the IronPDF library for Java. This step-by-step guide provides practical insights into each phase of the conversion process.

<a name="video"></a>

<hr class="separator">

<h4 class="tutorial-segment-title">Access Tutorial Video Quickly</h4>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img alt="" class="img-responsive add-shadow" src="https://ironpdf.com/img/platforms/cps-intellij.svg" style="width: 160px;">
      </div>
    </div>
    <div class="col-sm-8">
      <h3>Download the Java Source Code for the Tutorial</h3>
      <p>Get the complete Java source code for this tutorial as a zipped IntelliJ project, available for free download.</p>
      <a class="btn btn-white3" href="#">
        <i class="fa fa-cloud-download"></i> Download</a>
    </div>
  </div>
</div>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-8">
      <h3>Explore the Tutorial on GitHub</h3>
      <p>The source code of this tutorial is hosted on GitHub. Quickly clone the project and start experimenting in your environment. It is saved as an IntelliJ IDEA project and is easily compatible with other Java IDEs.</p>
      <a class="doc-link" href="#" target="_blank">Java HTML to PDF <i class="fa fa-chevron-right"></i></a>
    </div>
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img alt="" class="img-responsive add-shadow" src="https://ironpdf.com/img/svgs/github-icon.svg">
      </div>
    </div>
  </div>
</div>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img style="max-width: 110px; width: 100px; height: 140px;" alt="" class="img-responsive add-shadow" src="https://ironpdf.com/img/svgs/documentation.svg" width="100" height="140">
      </div>
    </div>
    <div class="col-sm-8">
      <h3>Consult the API Reference</h3>
      <p>Dive deeper into the extensive feature set of IronPDF by exploring the detailed API Reference. It includes comprehensive documentation of all namespaces, classes, methods, fields, and enums.</p>
      <a class="doc-link" href="https://ironpdf.com/java/object-reference/api/" target="_blank">View the API Reference <i class="fa fa-chevron-right"></i></a>
    </div>
  </div>
</div>
```
This revised section provides an engaging and informative overview, guiding users to valuable resources related to the HTML to PDF conversion process with IronPDF.

<a name ="video"></a>

<hr class="separator">

<h4 class="tutorial-segment-title">Tutorial Quick Access</h4>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img alt="" class="img-responsive add-shadow" src="/img/platforms/cps-intellij.svg" style="width: 160px;">
      </div>
    </div>
    <div class="col-sm-8">
      <h3>Download this Tutorial as Java Source Code</h3>
      <p>The full HTML to PDF Java Source Code for this tutorial is available to download for free as a zipped IntelliJ project.</p>
      <a class="btn btn-white3" href="#">
        <i class="fa fa-cloud-download"></i>Download</a>
    </div>
  </div>
</div>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-8">
      <h3>Explore this Tutorial on GitHub</h3>
      <p>The source code for this project is available on GitHub.</p>
      <p>Use this code as an easy way to get up and running in just a few minutes. The project is saved as an IntellJ IDEA project, but can be imported into other popular Java IDEs.</p>
      <a class="doc-link" href="#" target="_blank">Java HTML to PDF <i class="fa fa-chevron-right"></i></a>
    </div>
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img alt="" class="img-responsive add-shadow" src="/img/svgs/github-icon.svg">
      </div>
    </div>
  </div>
</div>

<div class="tutorial-section">
  <div class="row">
    <div class="col-sm-4">
      <div class="tutorial-image">
        <img style="max-width: 110px; width: 100px; height: 140px;" alt="" class="img-responsive add-shadow" src="/img/svgs/documentation.svg" width="100" height="140">
      </div>
    </div>
    <div class="col-sm-8">
      <h3>View the API Reference</h3>
      <p>Explore the API Reference for IronPDF, outlining the details of all of IronPDF’s features, namespaces, classes, methods fields and enums.</p>
      <a class="doc-link" href="/java/object-reference/api/" target="_blank">View the API Reference <i class="fa fa-chevron-right"></i></a>
    </div>
  </div>
</div>

