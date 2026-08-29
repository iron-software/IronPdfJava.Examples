# IronPDF for Java - Create, Edit, and Read PDFs in Java Applications

> Docs: [IronPDF for Java documentation](https://ironpdf.com/java/docs/)


## Introduction to IronPDF for Java

IronPDF for Java by Iron Software is a library that aids Software Engineers in creating, editing, and extracting content from PDFs within Java 8+, Kotlin, and Scala projects.

`IronPDF for Java` extends the widespread recognition and capabilities of [IronPDF for .NET](https://ironpdf.com).

Communication with the `IronPdfEngine` in IronPDF for Java is facilitated through gRPC technology.

### Key Features of IronPDF 

- Creation of PDFs from various sources like HTML, URL, JavaScript, CSS, and various image formats.
- Capability to add headers, footers, digital signatures, attachments, and implement security measures like passwords.
- Optimized for performance with support for Full Multithreading and Asynchronous operations.
- Discover more at our website by checking all our code demos and a [comprehensive list of over 50 features](https://ironpdf.com/java/#page-home-section-columns-of-features).

## Implementing IronPDF in Java Projects

### Setting Up IronPDF as a Java Dependency

#### Dependency in pom.xml

Include IronPDF in your `pom.xml` as follows:

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

#### Manual JAR File Download

If preferred, the IronPDF JAR file can be [downloaded manually here](https://ironpdf.com/download-modal) for use without dependency management tools.

### Initial Setup and Execution

Upon your project's first run, `IronPdfEngine` binaries are provided automatically. The engine initiates as soon as any IronPDF method is invoked and terminates when the app closes or becomes idle.

### Installing IronPDF Engine as a Maven Dependency

For a quicker startup, installing the IronPDF Engine as a Maven dependency is recommended, allowing pre-download during dependency resolution:

Add the appropriate dependency to your **pom.xml** depending on your operating system:

#### Windows x64

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Windows x86

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x86</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Linux x64

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### macOS x64 (Intel)

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### macOS Arm (Apple Silicon)

```xml
<dependency>
    <groupId=com.ironsoftware</groupId>
    <artifactId=ironpdf-engine-macos-arm64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

### Writing Java Code with IronPDF

After setting up the dependency, begin by importing IronPDF in your Java code:

```java
// Importing IronPDF Java library
import com.ironsoftware.ironpdf.*;

// Input your license key here
License.setLicenseKey("YOUR-LICENSE-KEY");

// Setting up the logging path
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Convert HTML to PDF and store it in a PdfDocument object
PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");

// Saving the generated PDF document
myPdf.saveAs(Paths.get("html_saved.pdf"));
```

Here's another straightforward example that converts a URL to PDF:

```java
// Import IronPDF Java library
import com.ironsoftware.ironpdf.*;

// Apply your license key here
License.setLicenseKey("YOUR-LICENSE-KEY");

// Set the logging path
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Convert a URL to PDF and store it
PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");

// Save the PDF document to a file
myPdf.saveAs(Paths.get("url_saved.pdf"));
```

### Complete Main.java Example

```java
package org.example;

// Import IronPDF Java library
import com.ironsoftware.ironpdf.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        // Input your license key
        License.setLicenseKey("YOUR-LICENSE-KEY");

        // Specify the logging path
        Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

        // Convert HTML content to PDF
        PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");

        // Save the created PDF to a file
        myPdf.saveAs(Paths.get("html_saved.pdf"));

    }

}
```

### Important Configuration Notes

Remember, all settings, such as logging and licensing, must be set before employing any IronPDF methods.

#### Activating the License Key

To activate your license, insert the following at the top of your method:

```java
com.ironsoftware.ironpdf.License.setLicenseKey("YOUR-LICENSE-KEY");
```

#### Setting Up Logging

Use the [slf4j logger](https://www.slf4j.org/) to activate logging. Enable debugging like so:

```java
com.ironsoftware.ironpdf.Settings.setDebug(true);
```

To designate an `IronPdfEngine` log path, use:

```java
com.ironsoftware.ironpdf.Settings.setLogPath(Paths.get("C:/tmp/myIronPdfEngineLog.log"));
```

## Licensing & Support

To obtain a license for commercial use of IronPDF, please [purchase a license here](https://ironpdf.com/java/licensing/). A 30-day trial is also available for [trial users](https://ironpdf.com/trial-license).

For a full suite of code examples, tutorials, licensing details, and documentation, please visit: [IronPDF for Java resources](https://ironpdf.com/java/).

For further support and questions, you might [contact our support team directly](https://ironpdf.com/java/#live-chat-support).