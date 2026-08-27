# How to Generate PDF Files Using Java

> Full guide: [How to Generate PDF Files Using Java](https://ironpdf.com/java/how-to/java-create-pdf-tutorial/)


*Automatically creating PDFs via Java programming greatly enhances the ability to produce documents dynamically, catering to needs such as generating invoices, reports, or other custom PDFs as required.*

*This guide details how to employ IronPDF for generating PDFs within Java-based software applications.*

## IronPDF Java PDF Library

IronPDF offers a Java-based solution for crafting PDFs from HTML. Its user-friendly approach includes capabilities such as:

1. Incorporating text, images, and diverse content types.
2. Selecting fonts and colors, and mastering document design and layout.

Beneficially, IronPDF integrates with the .NET Framework. This dual compatibility with .NET and Java expands its utility across different software environments.

Furthermore, IronPDF is not limited to PDF creation but also supports file conversions, text extraction from PDFs, and implementing password protections.

## Steps to Create a PDF Document in a Java Application

### Prerequisites

For using IronPDF within a Maven project, ensure the installation of:

1. **Java Development Kit (JDK):** Essential for Java application execution. Available for download on the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. **Maven:** Manages library dependencies, available from the [Apache Maven website](https://maven.apache.org/download.cgi).
3. **IronPDF Library:** Integrate IronPDF via Maven by adding the dependency below in your project's `pom.xml`:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Configuration

Begin by importing the IronPDF classes into your Java source file:

```java
import com.ironsoftware.ironpdf.*;
```

Next, activate IronPDF by inputting a valid license key in your `main` method:

```java
License.setLicenseKey("Your license key");
```

**Note**: *License keys are necessary for watermark-free PDF creation. [Purchase a License Key](https://ironpdf.com/java/licensing/) or [Obtain a Free Trial License Key](https://ironpdf.com/trial-license). Without a license key, PDFs will contain watermarks.*

## Creating a PDF from HTML Content

Convert HTML strings to PDFs using the `renderHtmlAsPdf()` method:

```java
// Sample HTML content
String htmlString = "<h1>Hello World!</h1><p>This is an example HTML string.</p>";

// Transform HTML to PDF
PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlString);

// Save the new PDF
pdf.saveAs(Paths.get("html.pdf"));
```

This generates a PDF named "html.pdf" from the provided HTML string content.

## Generating PDFs from HTML Files

To create a PDF from an HTML file:

```java
// Creating a PDF from an HTML file
PdfDocument myPdf = PdfDocument.renderHtmlFileAsPdf("example.html");

// Storing the PDF
myPdf.saveAs(Paths.get("html_file_saved.pdf"));
```

This method accurately renders the HTML and its associated styles.

## Creating PDFs from URLs

Convert web pages to PDFs using the `renderUrlAsPdf` method:

```java
// Convert web page to PDF
PdfDocument urlToPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");

// Save the resulting PDF
urlToPdf.saveAs(Paths.get("urlToPdf.pdf"));
```

Learn more about URL to PDF conversions on the [Converting a URL to a PDF Tutorial](https://ironpdf.com/java/examples/converting-a-url-to-a-pdf/) page.

## Customizing PDF Formatting

Adjust PDF formatting using the `ChromePdfRenderOptions`:

```java
// Settings for PDF generation
ChromePdfRenderOptions options = new ChromePdfRenderOptions();
// Custom settings can be applied here
```

Detailed instructions for using this class can be found in the [PDF Generation Settings Tutorial](https://ironpdf.com/java/examples/pdf-generation-settings/).

## Securing PDF Files

Create password-protected PDFs with the `SecurityOptions` class:

```java
// Setting up security options
SecurityOptions securityOptions = new SecurityOptions();
securityOptions.setUserPassword("shareable");

// Applying security to a PDF
SecurityManager securityManager = urlToPdf.getSecurity();
securityManager.setSecurityOptions(securityOptions);

// Saving the secure PDF
urlToPdf.saveAs("protected.pdf");
```

Protected PDFs will prompt for the password upon access:

![Java Create PDFs - Figure 1](https://ironpdf.com/static-assets/ironpdf-java/howto/java-create-pdf/java-create-pdf-1.webp)

![Java Create PDFs - Figure 2](https://ironpdf.com/static-assets/ironpdf-java/howto/java-create-pdf/java-create-pdf-2.webp)

For more on security and metadata, explore the [Security and Metadata Tutorial](https://ironpdf.com/java/examples/security-and-metadata/).

## Complete Source Code

Below is the full source code for this tutorial:

```java
import com.ironsoftware.ironpdf.*;
import java.io.IOException;  
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        // Insert license information
        License.setLicenseKey("Your License Key");

        // Create PDF from HTML string
        String htmlString = "<h1>Hello World!</h1><p>This is an example HTML string.</p>";
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlString);
        pdf.saveAs(Paths.get("html.pdf"));

        // Convert HTML file to PDF
        PdfDocument myPdf = PdfDocument.renderHtmlFileAsPdf("example.html");
        myPdf.saveAs(Paths.get("html_file_saved.pdf"));

        // Convert URL to PDF
        PdfDocument urlToPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
        urlToPdf.saveAs(Paths.get("urlToPdf.pdf"));

        // Apply password protection
        SecurityOptions securityOptions = new SecurityOptions();
        securityOptions.setUserPassword("shareable");
        SecurityManager securityManager = urlToPdf.getSecurity();
        securityManager.setSecurityOptions(securityOptions);
        urlToPdf.saveAs(Paths.get("protected.pdf"));
    }
}
```

IronPDF renders elements consistently with web standards, supporting interactive features within the PDF.

## Summary

This guide examined the process of generating PDFs using Java with IronPDF. IronPDF is robust, offering an easy-to-use API for creating PDFs from various kinds of content. Though it is a commercial product, you can start with a [Free Trial](https://ironpdf.com/trial-license).