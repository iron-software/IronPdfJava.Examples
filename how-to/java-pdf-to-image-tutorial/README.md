# Java PDF to Image File

***Based on <https://ironpdf.com/how-to/java-pdf-to-image-tutorial/>***


## 1. Introduction

There are various scenarios in the software industry where converting PDF documents to image formats like JPEG, PNG, or TIFF is essential. For instance, if you need an image from a specific page of a PDF for further use, the primary method might seem to be taking a screenshot. However, for a Java project that involves loading and converting PDF pages into image files for different purposes, using standard Java code alone won't suffice. Here, we introduce [IronPDF for Java](https://ironpdf.com/java/).

## 2. IronPDF for Java

[IronPDF for Java](https://ironpdf.com/java/) is a versatile library tailored for the creation, manipulation, and management of PDF documents. It’s favored by developers for its robust PDF document manipulation features, enabling them to read and modify PDFs seamlessly without Adobe Acrobat. The library supports an array of features including custom headers and footers, digital signatures, attachments, and security settings, alongside multithreading and asynchronous operations. IronPDF effortlessly integrates with Maven-based projects.

In the ensuing sections, we will cover the process of converting PDF pages to image formats such as JPEG, JPG, or PNG using Java.

## 3. Prerequisites

Before beginning, ensure the following prerequisites are met:

1. Java must be installed on your machine and properly configured in the Environment Variables. If needed, follow this [Java installation guide](https://www.java.com/en/download/help/download_options.html#windows) to install Java.
2. Install a suitable Java IDE. Eclipse can be downloaded [here](https://www.eclipse.org/downloads/), and IntelliJ IDEA can be downloaded [here](https://www.jetbrains.com/idea/download/#section=windows).
3. Ensure Maven is integrated with your IDE. Refer to this [Maven installation guide](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-maven/installing-maven/) for detailed instructions.

## 4. IronPDF for Java Installation

After ensuring all prerequisites are in place, installing IronPDF for Java is straightforward, even for novice developers.

Begin by launching JetBrains IntelliJ IDEA and initiate a new Maven project as follows:

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-1.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-1.webp" alt="Java PDF to Image - Figure 1: Create new Maven Project" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Create a new Maven Project</p>
	</div>
</div>

Name your project and finalize the setup.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-2.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-2.webp" alt="Java PDF to Image - Figure 2: New Project Name" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">New Project Name</p>
	</div>
</div>

Upon completion, the project will open displaying the `pom.xml` file, which is crucial as we need to add dependencies for IronPDF. Add the following dependencies to your `pom.xml` or download the API's JAR file from the [Maven Repository page for IronPDF](https://search.maven.org/artifact/com.ironsoftware/ironpdf/2022.11.0/jar).

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>latest_version</version>
</dependency>
```

After updating `pom.xml`, a small icon will appear in the top right of the window, indicating dependencies need to be installed.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-4.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-4.webp" alt="Java PDF to Image - Figure 4: Maven Dependencies" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Maven Dependencies</p>
	</div>
</div>

Click this icon to install the dependencies, which should only take a few minutes based on your network speed.

## 5. Convert PDF File to Images using IronPDF for Java

With IronPDF for Java, transforming PDFs into image formats such as JPEG involves only a few lines of code. The library converts the input PDF into a series of images represented as `BufferedImage` objects. You have the flexibility not only to convert PDF documents but also to generate images from URLs and HTML directly.

### 5.1. Converting PDF Document to Images

To convert an existing PDF into images, follow this example and execute the code in your Java program.

```java
// Import required libraries and classes
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;
import com.ironsoftware.ironpdf.image.ToImageOptions;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Load the PDF file
        PdfDocument document = PdfDocument.fromFile(Paths.get("business plan.pdf"));
        List<BufferedImage> originalImages = document.toBufferedImages();

        // Set images resolution options
        ToImageOptions options = new ToImageOptions();
        options.setImageMaxHeight(800);
        options.setImageMaxWidth(500);

        // Convert PDF to images with specified options
        List<BufferedImage> images = document.toBufferedImages(options, PageSelection.allPages());
        int pageIndex = 1;
        for (BufferedImage image : images) {
            String fileName = "assets/images/" + pageIndex++ + ".png";
            ImageIO.write(image, "PNG", new File(fileName));
        }
    }
}
```

### 5.2. Converting URL to PDF and PDF to Images

IronPDF extends its capabilities to convert a HTML page to a PDF and then to images.

Below is an example where the homepage of Amazon is converted into a PDF, which is then turned into images.

```java
// Import required_classes
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;
import com.ironsoftware.ironpdf.image.ToImageOptions;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static you