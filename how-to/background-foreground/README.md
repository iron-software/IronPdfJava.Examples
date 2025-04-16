# Incorporating Backgrounds and Foreground Overlays in PDFs Using Java

***Based on <https://ironpdf.com/how-to/background-foreground/>***


Incorporating a background into a PDF introduces an image or another PDF document beneath the content of an existing PDF, enhancing the document with various design elements such as letterheads, watermarks, or other styles. Conversely, overlaying a foreground allows you to add supplementary content over the top of the PDF, such as annotations, stamps, or signatures.

IronPDF for Java offers straightforward methods for both adding backgrounds and overlaying foregrounds. It allows flexibility in using either rendered or existing PDFs as overlays and lets you apply these changes across all pages or to specific ones. This guide will explore the processes for adding both backgrounds and foreground overlays utilizing IronPDF in Java.

## Adding a Background to a PDF

To incorporate a background into an existing or newly rendered PDF, use the `addBackgroundPdf` method. The following example demonstrates how to import a PDF, render a background, and integrate it throughout the document.

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Load the existing PDF file
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Generate a PDF to use as a background
PdfDocument background = PdfDocument.renderHtmlAsPdf("<body style='background-color: cyan;'></body>");

// Implement the background across all pages
pdf.addBackgroundPdf(background);

// Save the updated PDF file
pdf.saveAs(Paths.get("addBackground.pdf"));
```

### Output PDF

View your output PDF file through:

<iframe src="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/addBackground.pdf" width="100%" height="400px">
    This browser does not support PDFs. Please download the PDF to view it:
    <a href="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/addBackground.pdf">Download PDF</a>.
</iframe>

## Applying Background to Specific Pages

To add a background to specific pages, use the `addBackgroundPdf` method. This is useful for designs like a unique cover page or special branding styles. The **PageSelection** class is needed here and offers methods like `allPages`, `singlePage`, `pageRange`, and more.

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;

// Load your main PDF document
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Load the background PDF
PdfDocument background = PdfDocument.fromFile(Paths.get("background.pdf"));

// Apply background to the first page of the PDF
pdf.addBackgroundPdf(background, 0, PageSelection.firstPage());

// Save the PDF with the new background
pdf.saveAs(Paths.get("addBackgroundToSpecificPage.pdf"));
```

The **backgroundPdfPageIndex** parameter determines which page from the background PDF is used, utilizing a zero-based index, defaulting at 0.

## Overlaying a Foreground over a PDF

Use the `addForegroundPdf` method to superimpose additional content on existing PDF pages, ideally for elements like watermarks. Below, we'll create a foreground and apply it throughout the PDF.

```java
import com.ironsoftware.ironpdf.*;

License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Open the target PDF file
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Construct a foreground PDF from HTML content
PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");

// Implement this foreground onto all the PDF pages
pdf.addForegroundPdf(foreground);

// Persist the new PDF
pdf.saveAs(Paths.get("overlayForeground.pdf"));
```

### Output

Access the resulting PDF file:

<iframe src="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/overlayForeground.pdf" width="100%" height="400px">
    This browser does not support PDFs. Please download the PDF to view it:
    <a href="https://ironpdf.com/static-assets/ironpdf-java/howto/background-foreground/overlayForeground.pdf">Download PDF</a>.
</iframe>

## Applying Foreground to Specific Pages

Apply a foreground overlay to a designated range of pages using the `PageSelection.pageRange` method, shown below for pages 2 through 8.

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;

// Load your main PDF
PdfDocument pdf = PdfDocument.fromFile(Paths.get("sample.pdf"));

// Create the foreground PDF from HTML content
PdfDocument foreground = PdfDocument.renderHtmlAsPdf("<h1 style='transform: rotate(-45deg); opacity: 0.5;'>Foreground Example</h1>");

// Apply the foreground to a select range of pages
pdf.addForegroundPdf(foreground, PageSelection.pageRange(2, 8));

// Save the PDF with updated foreground
pdf.saveAs(Paths.get("overlayForeground.pdf"));
```

## Exploring the PageSelection class

IronPDF's `PageSelection` class provides various methods for specifying the pages for your backgrounds and foregrounds, including:

- `firstPage()`: Applies changes to the first page.
- `lastPage()`: Adjusts the last page.
- `singlePage(int index)`: Affects a targeted single page based on its index.
- `pageRange(int startIndex, int endIndex)`: Targets a continuous range of pages.
- `pageRange(List<int> pageList)`: Allows for selective page modifications in a non-sequential order.