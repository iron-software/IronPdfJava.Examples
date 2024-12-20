# Java PDF to Image Conversion

***Based on <https://ironpdf.com/how-to/java-pdf-to-image-tutorial/>***


## 1. Introduction

Transforming PDF pages or entire documents into image formats like JPEG, PNG, or TIFF holds substantial utility in the software development field. There are scenarios where you might require an image capture of specific PDF pages for further use. For instances where direct image snapshots from a page are impractical, conversion functions are essential. In this guide, we introduce how to utilize [IronPDF for Java](https://ironpdf.com/java/) for such purposes in a Java project setting.

## 2. IronPDF for Java

[IronPDF for Java](https://ironpdf.com/java/) provides a robust toolkit allowing developers to construct, edit, and manage PDF files efficiently. It's favored for its comprehensive PDF manipulation capabilities, enabling developers to create, read, and modify PDFs seamlessly without Adobe Acrobat. Enhanced features in IronPDF for Java include asynchronous handling, multithreading, custom headers/footers, digital signing, and comprehensive security settings. Compatible with Maven, IronPDF for Java integrates smoothly into development workflows.

Next, we'll explain how to convert PDF pages into various image formats using Java.

## 3. Prerequisites

To proceed with this tutorial, ensure the following requirements are met:

1. Java must be installed on your machine and properly configured in the environment variables. If you need guidance, see this [Java Installation Help](https://www.java.com/en/download/help/download_options.html#windows).
2. A robust Java IDE like Eclipse or IntelliJ should be installed. For Eclipse, visit [Eclipse Downloads](https://www.eclipse.org/downloads/), or for IntelliJ, go to [IntelliJ Downloads](https://www.jetbrains.com/idea/download/#section=windows).
3. Confirm Maven is set up within your IDE before starting. For details, refer to this guide on [Installing Maven](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-maven/installing-maven/).

## 4. Installation of IronPDF for Java

Following the prerequisites, the next step is the straightforward setup of IronPDF for Java, even for beginners. Here's how:

Start IntelliJ IDEA and create a new Maven project.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-1.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-1.webp" alt="Java PDF to Image - Figure 1: Create new Maven Project" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">Create a new Maven Project</p>
	</div>
</div>

Name the project and finalize its creation.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-2.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/java-pdf-to-image/java-pdf-to-image-2.webp" alt="Java PDF to Image - Figure 2: New Project Name" class="img-responsive add-shadow"></a>
    <p class="content__image-caption">New Project Name</p>
	</div>
</div>

The project setup initializes, and you should add IronPDF for Java dependencies in the `pom.xml` or alternatively, download the JAR from [Maven Repository for IronPDF](https://search.maven.org/artifact/com.ironsoftware/ironpdf/2022.11.0/jar).

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>2022.11.0</version>
</dependency>
```

After adding the dependencies, initiate the installation by clicking the icon that appears, ensuring all modules are properly integrated.

## 5. Converting PDF File to Images with IronPDF for Java

IronPDF for Java enables the conversion of PDF documents into image files like JPEG with minimal code. It outputs a stream of images from a PDF document using the `toBufferedImages` method which returns a list of `BufferedImage` objects ordered by page.

### 5.1. PDF to Image Conversion

To convert an entire PDF document into images, use the following code:

```java
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
    public static void main(String [] args) throws IOException {
        PdfDocument doc = PdfDocument.fromFile(Paths.get("./business-plan.pdf"));
        ToImageOptions options = new ToImageOptions();
        options.setImageMaxHeight(800);
        options.setImageMaxWidth(500);

        List<BufferedImage> images = doc.toBufferedImages(options, PageSelection.allPages());
        for (int pageIndex = 1; pageIndex <= images.size(); pageIndex++) {
            File output = new File("./assets/images/page-" + pageIndex + ".png");
            ImageIO.write(images.get(pageIndex - 1), "PNG", output);
        }
    }
}
```

### 5.2. Converting Web Content to PDF then to Images

IronPDF simplifies conversion from HTML to PDF and subsequently to images. Below, we adapt content from Amazon into PDF and images:

```java
public class Main {
    public static void main(String[] args) throws IOException {
        PdfDocument webPdf = PdfDocument.renderUrlAsPdf("https://www.amazon.com/");
        ToImageOptions options = new ToImageOptions();
        options.setImageMaxHeight(800);
        options.setImageMaxWidth(500);
        
        List<BufferedImage> images = webPdf.toBufferedImages(options, PageSelection.allPages());
        for (int index = 1; index <= images.size(); index++) {
            ImageIO.write(images.get(index - 1), "PNG", new File("./assets/images/web-" + index + ".png"));
        }
    }
}
```

## 6. Conclusion

This guide demonstrated how IronPDF for Java efficiently converts PDF files into image formats. The examples show both document-based and URL-to-image conversions, illustrating the versatility of IronPDF. For deeper insights, refer to the [IronPDF Java Documentation](https://ironpdf.com/java/docs/) and for rasterization specifics, explore [IronPDF PDF to Images Example](https://ironpdf.com/java/examples/rasterize-a-pdf-to-images/).

IronPDF is free for developmental use but requires a purchase for commercial applications. For licensing information, visit [IronPDF Java Licensing](https://ironpdf.com/java/licensing/).