# IronPDF for Java - Create, Edit, and Read PDFs in Java Applications

***Based on <https://ironpdf.com/docs/docs/>***


## About IronPDF for Java

IronPDF for Java is a robust library offered by Iron Software that enables Software Engineers to generate, modify, and extract content from PDF files using Java 8+, Kotlin, and Scala.

`IronPDF for Java` enhances the robust foundation of [IronPDF for .NET](https://ironpdf.com).

This library communicates with the `IronPdfEngine` through gRPC.

### IronPDF excels in

- Creating PDFs from HTML, URLs, JavaScript, CSS, and various image formats
- Incorporating headers/footers, signatures, attachments, as well as adding passwords and security measures
- Ensuring performance efficiency: Supports Fully Multithreaded Operations and Asynchronous Programming
- Explore more! Check out our programming examples and a [complete list of over 50 advanced features](https://ironpdf.com/java/#page-home-section-columns-of-features)

## Using IronPDF for Java

### Configure IronPDF as a Java Dependency

#### pom.xml Dependency

To integrate IronPDF as a dependency, you can add the below lines to your `pom.xml`:

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

#### Download JAR file Link

Optionally, [download the IronPDF JAR file manually](https://ironpdf.com/java/#download-modal) for use without project dependencies.

### Initial Build and Execution

Upon your first project run, the `IronPdfEngine` binaries will be automatically installed. This engine starts upon the initial invocation of an IronPdf method and will cease when the application closes or becomes idle.

### Incorporate IronPDF Engine via Maven Dependency

Incorporating IronPdfEngine as a Maven dependency allows for pre-download of binaries, facilitating quicker startup times and assists in environments that restrict external internet access.

Just add one or more of the following snippets to your **pom.xml** for multiplatform support:

#### For Windows x64
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### For Windows x86
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x86</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### For Linux x64
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### For macOS x64 (Intel)
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### For macOS Arm (Apple Silicon)
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-arm64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

### Start writing Java code

To begin, insert `import com.ironsoftware.ironpdf.*` at your Java code's beginning. Below is a simple HTML to PDF conversion sample:

```java
// Import IronPDF Java package
import com.ironsoftware.ironpdf.*;

// Activation of your license key
License.setLicenseKey("YOUR-LICENSE-KEY");

// Specify log path
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Convert HTML to PDF and store it in myPdf as type PdfDocument
PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1>Hello World</h1> Crafted with IronPDF!");

// Save the resulting PdfDocument to disk
myPdf.saveAs(Paths.get("html_saved.pdf"));
```

And an easy URL to PDF conversion example:

```java
// Import IronPDF Java libraries
import com.ironsoftware.ironpdf.*;

// Enter your license key
License.setLicenseKey("YOUR-LICENSE-KEY");

// Define log path
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Convert a URL to PDF and store in myPdf as PdfDocument type
PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");

// Save the PDF file
myPdf.saveAs(Paths.get("url_saved.pdf"));
```

### Fully Integrated Main.java Example

```java
package org.example;  

// Import IronPDF Java library  
import com.ironsoftware.ironpdf.*;  
import java.io.IOException;  
import java.nio.file.Paths;  
  
public class Main {  
  
    public static void main(String [] args) throws IOException {
        // Apply your license key
        License.setLicenseKey("YOUR-LICENSE-_KEY");  
  
        // Set the log path  
        Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));  
  
        // Convert HTML content to PDF
        PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1>Hello World</h1> Created with IronPDF!");  
  
        // Store the PDF document
        myPdf.saveAs(Paths.get("html_saved.pdf"));
        
    }  
    
}
```

### Additional Settings Information

Before invoking IronPDF methods, ensure to configure the settings and apply the license key as shown:

```java
com.ironsoftware.ironpdf.License.setLicenseKey("YOUR-LICENSE-KEY");
```

For logging with IronPDF Java, enable debugging:

```java
com.ironsoftware.ironpdf.Settings.setDebug(true);
```

And to designate the `IronPdfEngine` log path:

```java
com.ironsoftware.ironpdf.Settings.setLogPath(Paths.get("C:/tmp/myIronPdfEngineLog.log"));
```

## Licensing & Support Options

[Acquire a license for IronPDF](https://ironpdf.com/java/licensing/) for commercial projects. A 30-day trial is available [for evaluation](https://ironpdf.com/java/licensing/#trial-license).

For extensive code samples, tutorials, and more, visit: [IronPDF for Java resources](https://ironpdf.com/java/).

For additional support, [contact our expert team](https://ironpdf.com/java/#live-chat-support).