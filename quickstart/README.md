# IronPDF for Java - Comprehensive PDF Manipulation for Java Developers

***Based on <https://ironpdf.com/docs/docs/>***


## Introduction to IronPDF for Java

IronPDF for Java, crafted by Iron Software, aids developers in creating, editing, and extracting content from PDFs in environments such as Java 8+, Kotlin, and Scala. This product is an extension of the well-received [IronPDF for .NET](https://ironpdf.com).

The integration between IronPDF for Java and the `IronPdfEngine` is managed through gRPC technology.

### Capabilities of IronPDF

IronPDF is known for:
- Creating PDFs from HTML, URLs, JavaScript, CSS, and various image formats.
- Enhancing PDFs with headers, footers, digital signatures, attachments, and robust security features.
- Optimizing performance through full support for Multithreading and Asynchronous operations.
- Explore over 50 unique features and numerous code examples on our [features page](https://ironpdf.com/java/#page-home-section-columns-of-features).

## Getting Started with IronPDF for Java

### Setting up IronPDF in your Java Project

#### Maven Configuration
Add the following dependencies to your `pom.xml` to integrate IronPDF into your project:

```xml
<dependencies>
    <dependency>
        <groupId>com.ironsoftware</groupId>
        <artifactId>ironpdf</artifactId>
        <version>20xx.xx.xxxx</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.3</version>
    </dependency>
</dependencies>
```

#### Manual Setup
For direct inclusion in your project, you may [download the IronPDF JAR file](https://ironpdf.com/java/#download-modal) manually.

### Initial Project Execution

The `IronPdfEngine` binaries are automatically fetched upon initial run. The engine activates with the first IronPDF function call and deactivates upon application closure or during idle periods.

### Incorporating IronPDF Engine via Maven

Pre-loading IronPDF Engine binaries as a Maven dependency can streamline application starts and suit deployment environments with strict external access rules:

#### For Windows x64
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Additional Platforms
Include dependencies in your `pom.xml` for other operating systems as needed, such as Windows x86, Linux, macOS (Intel or Apple Silicon).

### Coding with IronPDF

Begin by importing the necessary packages and initial settings:

```java
// IronPDF Java imports
import com.ironsoftware.ironpdf.*;

// Enter your license key
License.setLicenseKey("YOUR-LICENSE-KEY");

// Set logging path
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Example: Convert HTML to PDF
PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");

// Save the resulting PDF
myPdf.saveAs(Paths.get("html_saved.pdf"));
```

Here's another straightforward example for converting a URL to PDF:

```java
// Setup for IronPDF Java
import com.ironsoftware.ironpdf.*;

// Licensing and logging
License.setLicenseKey("YOUR-LICENSE-KEY");
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Convert a URL to PDF
PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");

// Output the PDF file
myPdf.saveAs(Paths.get("url_saved.pdf"));
```

### Comprehensive Example: Main.java

```java
package org.example;

// Standard IronPDF Java imports
import com.ironsoftware.ironpdf.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String [] args) throws IOException {
        // Apply license
        License.setLicenseKey("YOUR-LICENSE-KEY");

        // Set up logging
        Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

        // Create and save a PDF from HTML
        PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");
        myPdf.saveAs(Paths.get("html_saved.pdf"));
    }
}
```

### Configuration and Pre-Execution Settings

#### License Application
To activate your license, integrate the following line at the start of your code execution:

```java
com.ironsoftware.ironpdf.License.setLicenseKey("YOUR-LICENSE-KEY");
```

#### Logging Configuration
Utilize the [slf4j logger](https://www.slf4j.org/) for debugging purposes:

```java
com.ironsoftware.ironpdf.Settings.setDebug(true);
com.ironsoftware.ironpdf.Settings.setLogPath(Paths.get("C:/tmp/myIronPdfEngineLog.log"));
```

## Licensing and Customer Support

Acquire a full license for IronPDF by visiting the [licensing page](https://ironpdf.com/java/licensing/). Evaluate using a 30-day trial license [available here](https://ironpdf.com/java/licensing/#trial-license).

For a broad selection of code samples and tutorials or additional support, refer to [IronPDF resources](https://ironpdf.com/java/) or [contact our support team](https://ironpdf.com/java/#live-chat-support).