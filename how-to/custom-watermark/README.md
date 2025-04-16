# How to Add Custom Watermarks to PDF Documents

***Based on <https://ironpdf.com/how-to/custom-watermark/>***


Watermarking is an effective strategy for securing PDF documents and establishing ownership or confidentiality by applying labels such as "Confidential" or adding corporate logos. 
IronPDF provides a robust solution for this by enabling developers to design custom watermarks using HTML and CSS. This flexibility allows for extensive design options through HTML and CSS capabilities.

This tutorial will cover how to implement various watermark styles including text and images, position watermarks on the page, and adjust their opacity and rotation. It includes demonstrations on utilizing advanced features through [TextStamper](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/stamp/TextStamper.html) and [ImageStamper](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/stamp/ImageStamper.html).

## Example of Adding a Text Watermark

To add a text watermark to a PDF, the `applyWatermark` method is used. This method allows for HTML and CSS to enhance text appearance. For instance, the following example demonstrates how to add the word 'Confidential' in red to a PDF document.

```java
import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

public class Main {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

        // Define HTML string for the watermark
        String watermarkHtml = "<h1 style='color:red;'>Confidential</h1>";

        // Adding the watermark
        pdf.applyWatermark(watermarkHtml);

        // Saving the PDF
        pdf.saveAs("text_watermark.pdf");
    }
}
```

### Output

The generated PDF file, **'text_watermark.pdf',** will display the watermark 'Confidential' in red, centrally positioned on each page.

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/custom-watermark/text_watermark.pdf" width="100%" height="500px"></iframe>

<hr>

## Example of Adding an Image Watermark

Similarly, images can also be employed as watermarks using the same method, supporting formats like PNG, JPEG, SVG, etc. The image can be customized and positioned using CSS within the HTML string.

```java
import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

public class Main {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

        // HTML string for the image watermark
        String watermarkHtml = "<img src='logo.png' style='width:100px;'>";

        // Applying the image watermark
        pdf.applyWatermark(watermarkHtml);

        // Saving the PDF
        pdf.saveAs("image_watermark.pdf");
    }
}
```

### Output

The PDF file **'image_watermark.pdf'** will display the image **'logo.png'** as a watermark on every page, scaled to a width of 100 pixels.

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/custom-watermark/image_watermark.pdf" width="100%" height="500px"></iframe>

<hr>

## Adjusting Watermark Opacity and Rotation

The appearance of the watermark can be tailored by adjusting its opacity and applying rotation. The `applyWatermark` method also allows specification of these attributes.

```java
import java.io.IOException;
import java.nio.file.Paths;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.stamp.HorizontalAlignment;
import com.ironsoftware.ironpdf.stamp.VerticalAlignment;

public class Main {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

        // HTML string for watermark
        String watermarkHtml = "<h1 style='color:blue;'>Confidential</h1>";

        // Applying HTML watermark with customization
        pdf.applyWatermark(watermarkHtml, 30, VerticalAlignment.TOP, HorizontalAlignment.LEFT);

        // Saving the PDF
        pdf.saveAs("watermark_opacity_rotation.pdf");
    }
}
```

### Output

The final PDF, **'watermark_opacity_rotation.pdf',** will include the watermark 'Confidential' in blue, positioned at the top-left corner of each page, with an opacity level of 30%.

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/custom-watermark/watermark_opacity_rotation.pdf" width="100%" height="400px"></iframe>

**Application Details**: The `applyWatermark` method integrates the HTML-based watermark across all pages, including settings for:
- **Opacity**: Applied at `30%`, rendering the watermark partially transparent.
- **Vertical Alignment**: Options include `TOP`, `MIDDLE`, and `BOTTOM`, with this example using `TOP`.
- **Horizontal Alignment**: Options include `LEFT`, `CENTER`, and `RIGHT`, with this example using `LEFT`.