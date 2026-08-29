# Applying Custom Watermarks to PDF Documents

> Full guide: [Applying Custom Watermarks to PDF Documents](https://ironpdf.com/how-to/custom-watermark/?utm_source=github)


Custom watermarks are an excellent method for safeguarding PDF documents, indicating proprietary information, or showcasing certain statuses such as labeling them "Confidential" or embedding a corporation's logo. IronPDF offers the capability to design unique watermarks using HTML strings, which provide full CSS styling options allowing for extensive customization to include the wide range of styles that HTML and CSS support.

This tutorial will explore various watermark types including text, images, and demonstrate how to adjust watermark properties like location, opacity, and rotation using tools such as [`TextStamper`](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/stamp/TextStamper.html?utm_source=github) and [`ImageStamper`](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/stamp/ImageStamper.html?utm_source=github).

## Applying a Text Watermark

To insert a text-based watermark into a PDF document, utilize the `applyWatermark` method. This function lets you enter text stylized with HTML and CSS. The following example adds a 'Confidential' watermark in red.

```java
import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize the IronPDF license
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Open an existing PDF file
        PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

        // HTML code for the watermark
        String watermarkHtml = "<h1 style='color:red;'>Confidential</h1>";

        // Apply the text watermark onto the PDF
        pdf.applyWatermark(watermarkHtml);

        // Save the modified PDF
        pdf.saveAs("text_watermark.pdf");
    }
}
```

### Output

The modified document, named **'text_watermark.pdf,'** will display the 'Confidential' watermark in a bold red font across all its pages.

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/custom-watermark/text_watermark.pdf" width="100%" height="500px"></iframe>

---

## Adding an Image Watermark

Similar to the text watermark, images can also be added as watermarks using HTML templates, supporting formats like PNG, JPEG, and SVG. Images can be stylishly positioned with CSS.

```java
import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

public class Main {
    public static void main(String[] args) throws IOException {
        // Input IronPDF license key
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Import an existing PDF document
        PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

        // Define HTML image tag for watermark
        String watermarkHtml = "<img src='logo.png' style='width:100px;'/>";

        // Attach image watermark
        pdf.applyWatermark(watermarkHtml);

        // Save the watermarked PDF
        pdf.saveAs("image_watermark.pdf");
    }
}
```

### Output

The processed PDF file, **'image_watermark.pdf,'** embeds the 'logo.png' image as a watermark across all pages.

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/custom-watermark/image_watermark.pdf" width="100%" height="500px"></iframe>

---

## Adjustments for Watermark Opacity and Rotation

Enhance watermark customization by altering its opacity and rotation. These properties can be specified using the `applyWatermark` method.

```java
import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.stamp.HorizontalAlignment;
import com.ironsoftware.ironpdf.stamp.VerticalAlignment;

public class Main {
    public static void main(String[] args) throws IOException {
        // Activate IronPDF license
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Load a PDF from file
        PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

        // HTML for the watermark
        String watermarkHtml = "<h1 style='color:blue;'>Confidential</h1>";

        // Implement watermark with controlled opacity and alignment
        pdf.applyWatermark(watermarkHtml, 30, VerticalAlignment.TOP, HorizontalAlignment.LEFT);

        // Store the altered PDF
        pdf.saveAs("watermark_opacity_rotation.pdf");
    }
}
```

### Output

The resultant PDF, **'watermark_opacity_rotation.pdf,'** will prominently feature the watermark with 'Confidential' written in blue. The text will be placed with 30% opacity in the top-left corner of each page.

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/custom-watermark/watermark_opacity_rotation.pdf" width="100%" height="400px"></iframe>

**Applying the Watermark**: Besides altering the opacity, the `applyWatermark` method can specify vertical and horizontal placement within the PDF, allowing for customized positioning.