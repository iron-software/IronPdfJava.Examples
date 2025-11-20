# Adding Backgrounds and Overlays to PDFs with IronPDF in Java

***Based on <https://ironpdf.com/how-to/background-foreground/>***


Integrating a background into a PDF places an image or another PDF document behind the main content, enhancing the visual appeal with elements like watermarks, letterheads, or other design motifs. Overlays, on the other hand, allow you to apply additional details over the PDF content, such as stamps, annotations, or signatures.

IronPDF for Java offers straightforward functions for embedding both backgrounds and overlays. This guide illustrates how to utilize IronPDF to insert backgrounds and foregrounds into your PDFs using Java.

## Embedding a Background in a PDF

To embed a background in a new or existing PDF, you should employ the `addBackgroundPdf` method. This example demonstrates how to load a PDF, create a background, and integrate it into the PDF.

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

// Activate the license for IronPDF usage
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Open the primary PDF document
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Generate a PDF background from HTML
PdfDocument background = PdfDocument.renderHtmlAsPdf("<body style='background-color: cyan;'></body>");

// Insert the created background into every page of the primary PDF
pdf.addBackgroundPdf(background);

// Store the altered PDF under a new name
pdf.saveAs(Paths.get("addBackground.pdf"));
```

### Resulting PDF

The resulting PDF is displayed as follows:

<iframe src="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/addBackground.pdf" width="100%" height="400px">
    This browser does not support PDFs. Please download the PDF to view it: <a href="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/addBackground.pdf">Download PDF</a>.
</iframe>

## Embedding a Background on Selected Pages

You can also selectively apply backgrounds using the `addBackgroundPdf` method. This capability is particularly useful for adding distinctive designs to specific pages, like a cover or branded pages. You will need the **PageSelection** class which offers various options such as `allPages`, `singlePage`, `pageRange`, and others.

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;

// Open the primary PDF document
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Load the background PDF
PdfDocument background = PdfDocument.fromFile(Paths.get("background.pdf"));

// Apply the background from the first page of the background PDF to the first page of the primary PDF
pdf.addBackgroundPdf(background, 0, PageSelection.firstPage());

// Save the edited PDF under a new file name
pdf.saveAs(Paths.get("addBackgroundToSpecificPage.pdf"));
```

The **backgroundPdfPageIndex** parameter indicates the page from the background PDF to use. This is a zero-based index, with a default value of 0.

<hr>

## Adding a Foreground to a PDF

The `addForegroundPdf` method enables you to layer additional content over the existing pages of a PDF. This is perfect for adding watermarks or other visual markers. Similar to embedding backgrounds, we will create a foreground and apply it to the PDF.

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

// Activate the IronPDF license
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Open the target PDF file
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Generate the foreground content from HTML
PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");

// Embed the generated foreground into all pages of the PDF
pdf.addForegroundPdf(foreground);

// Store the PDF with the added foreground under a new name
pdf.saveAs(Paths.get("overlayForeground.pdf"));
```

### Output

The PDF with the added foreground appears as:

<iframe src="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/overlayForeground.pdf" width="100%" height="400px">
    This browser does not support PDFs. Please download the PDF to view it: <a href="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/overlayForeground.pdf">Download PDF</a>.
</iframe>

## Applying Foreground to Specific Pages

Foregrounds can be added to specific pages by using the `PageSelection.pageRange` method. Here is how to apply it to pages 2 through 8.

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;

// Load and open the primary PDF
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Create the foreground from HTML content
PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");

// Apply the foreground to a specified range of pages (from page 2 to page 8)
pdf.addForegroundPdf(foreground, PageSelection.pageRange(2, 8));

// Save the newly updated PDF under a different name
pdf.saveAs(Paths.get("overlayForeground.pdf"));
```

<hr>

## Understanding the PageSelection Class

The **PageSelection** class offers various methods to define the application of backgrounds and foregrounds on specific pages:
- `firstPage()`: Affects the first page of the PDF.
- `lastPage()`: Targets the last page of the PDF.
- `singlePage(int index)`: Applies to a particular page, determined by its index (starting from zero).
- `pageRange(int startIndex, int endIndex)`: Applies to a sequence of pages, from startIndex to endIndex.
- `pageRange(List<Integer> pageList)`: Allows for applying changes to a custom list of pages, facilitating non-consecutive page selections.