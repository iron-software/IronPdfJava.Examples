# How to Create PDF Files in Java

***Based on <https://ironpdf.com/how-to/java-create-pdf-tutorial/>***


Creating PDFs programmatically via Java equips developers to automate their PDF document generation within applications, useful for crafting invoices, reports, or other dynamic documents.

This guide elucidates how IronPDF facilitates PDF creation in Java applications.

## IronPDF Java PDF Library

IronPDF stands out as a Java library capable of creating PDFs directly from HTML. It's engineered for simplicity and offers a plethora of functionalities for PDF creation and customization, such as:

1. Incorporating text, images, and more into documents
2. Customizing fonts, colors, and managing the overall document styling and layout

Originally based on the .NET Framework, IronPDF is versatile enough for use in both .NET and Java environments, which enhances its utility across different programming contexts.

Beyond simply generating PDFs, IronPDF supports converting between file formats, extracting content from existing PDFs, and enhancing PDF security via password protection.

## Steps for Creating a PDF Document in Java Applications

### Prerequisites

For incorporating IronPDF in a Maven project, ensure these prerequisites are installed:

1. **Java Development Kit (JDK):** Essential for Java application development, available from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. **Maven:** Necessary for managing project dependencies, downloadable from the [Apache Maven website](https://maven.apache.org/download.cgi).
3. **IronPDF Library:** Add this library to your project by including its Maven dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>LATEST_VERSION</version>
</dependency>
```

### Initial Setup

Begin by importing the IronPDF library into your project:

```java
import com.ironsoftware.ironpdf.*;
```

Then, initialize IronPDF with an active license key right in the `main` method:

```java
License.setLicenseKey("Your license key");
```

**Note**: Obtain a [license key](ironsoftware.com/java/licensing/) or a [Free Trial License Key](ironsoftware.com/java/licensing/#trial-license) to create non-watermarked PDFs. Without this, the documents will include a watermark.

## Creating a PDF from an HTML String in Java

To convert HTML content into a PDF, use the `renderHtmlAsPdf()` method:

```java
String htmlContent = "<h1>Hello World!</h1><p>This is an example HTML content.</p>";
PdfDocument document = PdfDocument.renderHtmlAsPdf(htmlContent);
document.saveAs(Paths.get("html.pdf"));
```

The above snippet generates a PDF named "html.pdf" from the provided HTML.

## Generating PDFs from HTML Files in Java

To create a PDF from a locally stored HTML file:

```java
PdfDocument documentFromFile = PdfDocument.renderHtmlFileAsPdf("localfile.html");
documentFromFile.saveAs(Paths.get("output_pdf_from_html.pdf"));
```

The `renderHtmlFileAsPdf` method processes the HTML file with all associated styling and scripts, similar to web browser rendering.

## Converting Web Pages to PDFs in Java

To convert a webpage into a PDF:

```java
PdfDocument webPageToPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
webPageToPdf.saveAs(Paths.get("webpage_output.pdf"));
```

For more details on web-to-PDF conversions, visit [Converting a URL to a PDF example](ironsoftware.com/java/examples/converting-a-url-to-a-pdf/).

## Customizing PDF Format

To customize PDF settings like orientation and margins, utilize the `ChromePdfRenderOptions`:

```java
ChromePdfRenderOptions options = new ChromePdfRenderOptions();
// Configuration settings here
```

Refer to [PDF Generation Settings](ironsoftware.com/java/examples/pdf-generation-settings/) for detailed usage.

## Securing PDF Files

To password-protect a PDF:

```java
SecurityOptions options = new SecurityOptions();
options.setUserPassword("securepassword");

SecurityManager securityManager = webPageToPdf.getSecurity();
securityManager.setSecurityOptions(options);
webPageToPdf.saveAs("secured_webpage.pdf");
```

View details on additional security settings at [Security and Metadata settings](ironsoftware.com/java/examples/security-and-metadata/).

## Complete Source Code

Below is the complete source code for this guide:

```java
// Import IronPDF classes
import com.ironsoftware.ironpdf.*;
import java.io.IOException;
import java.nio.file.Paths; 

public class CreatePDFApp 
{
    public static void main(String [] args) throws Exception
    {
        License.setLicenseKey("Your License Key");
        String htmlContent = "<h1>Hello World!</h1><p>This is sample HTML content.</p>";
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlContent);
        pdf.saveAs(Paths.get("example_output.pdf"));

        PdfDocument documentFromFile = PdfDocument.renderHtmlFileAsPdf("local_file.html");
        documentFromFile.saveAs(Paths.get("from_local_html.pdf"));

        PdfDocument urlPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
        urlPdf.saveAs(Paths.get("url_based_pdf.pdf"));

        SecurityOptions security = new SecurityOptions();
        security.setUserPassword("YourPassword");
        SecurityManager securityManager = urlPdf.getSecurity();
        securityManager.setSecurityOptions(security);
        urlPdf.saveAs(Paths.get("secured_output.pdf"));
    }
}
```

## Summary

This guide demonstrates how IronPDF provides Java developers robust tools to create and manipulate PDF documents from HTML sources or direct URLs, making PDF generation straightforward and efficient.

IronPDF is commercially licensed, and you can start with a [free trial](ironsoftware.com/java/how-to/java-create-pdf-tutorial/) to assess its capabilities in real-world scenarios.