# IronPDF for Java - Create, Edit, and Read PDFs in Java Applications

## Introduction to IronPDF for Java

IronPDF for Java offers a robust library by Iron Software aimed at enabling Software Engineers to generate, modify, and extract content from PDFs using Java 8+, Kotlin, and Scala.

The solution `IronPDF for Java` extends the renowned capabilities of [IronPDF for .NET](https://ironpdf.com/).

Internally, IronPDF for Java leverages gRPC for interactions with the `IronPdfEngine`.

### Key Features of IronPDF

- Creation of PDFs using HTML, URLs, JavaScript, CSS, and various image formats
- Insertion of headers/footers, digital signatures, attachments, and implementation of security features like passwords
- Enhanced performance: Supports Full Multithreading and Asynchronous operations
- Discover more advantages! Explore our coding samples and see a [comprehensive feature list](https://ironpdf.com/java/#page-home-section-columns-of-features)*

## Implementing IronPDF in Java Applications

### Setting up IronPDF as a Java Dependency

#### Adding to `pom.xml`

Integrate IronPDF into your project by inserting the following snippets into your project's `pom.xml`:

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

#### Manual .jar Download

Alternatively, you can [download the .jar file](https://ironpdf.com/$downloadPackage) directly.

### Initial Setup and Execution

`IronPdfEngine` binaries are automatically fetched the first time you execute your project. This process starts upon the initial use of any IronPDF function and terminates when the app closes or goes idle.

### Configuring IronPDF Engine with Maven

For more efficient setup, include IronPdfEngine in your Maven dependencies to pre-download binaries:

This method fast-tracks the setup time since IronPdfEngine binaries get pre-downloaded, very useful for deployment environments that restrict external downloads.

Append these configurations to your **pom.xml** for respective platforms:

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

### Begin Crafting Java Code

After setting up dependencies, start by including `import com.ironsoftware.ironpdf.*` in your Java code. Below are examples to help you get started with HTML to PDF and URL to PDF conversions:

A basic HTML to PDF conversion sample:

```java
import com.ironsoftware.ironpdf.*;

License.setLicenseKey("YOUR-LICENSE-KEY");
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");
myPdf.saveAs(Paths.get("html_saved.pdf"));
```

Convert a web page URL to PDF:

```java
import com.ironsoftware.ironpdf.*;

License.setLicenseKey("YOUR-LICENSE-KEY");
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");
myPdf.saveAs(Paths.get("url_saved.pdf"));
```

### Comprehensive Example: Main.java

```java
package org.example;

import com.ironsoftware.ironpdf.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("YOUR-LICENSE-KEY");
        Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

        PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");
        myPdf.saveAs(Paths.get("html_saved.pdf"));
    }
}
```

### Further Configuration Details

Ensure that all settings, logging, and license configurations are completed prior to invoking any IronPDF methods.

#### License Application

Apply your license with:

```java
com.ironsoftware.ironpdf.License.setLicenseKey("YOUR-LICENSE-KEY");
```

#### Enabling Logging

Utilize the [slf4j](https://www.slf4j.org/) logging library by enabling debugging and setting the log path:

```java
com.ironsoftware.ironpdf.Settings.setDebug(true);
com.ironsoftware.ironpdf.Settings.setLogPath(Paths.get("C:/tmp/myIronPdfEngineLog.log"));
```

## Purchase Options and Support

[Acquire a license](https://ironpdf.com/java/licensing/) for using IronPdf in your projects. Try it risk-free with a 30-day trial license available <a class="js-modal-open" data-modal-id="trial-license" href="#trial-license">here</a>.

For additional examples, tutorials, and detailed documentation, check out [IronPDF for Java](https://ironpdf.com/java/).

For further assistance, feel free to [contact our support team](https://ironpdf.com/#live-chat-support).