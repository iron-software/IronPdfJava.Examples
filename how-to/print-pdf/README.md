# How to Print PDF Files in Java

***Based on <https://ironpdf.com/how-to/print-pdf/>***


Automating the printing of PDF documents within Java programs offers streamlined document management and integrated printing functionalities. Utilizing IronPDF for Java, these PDF files can be automatically sent to a printer, providing fine-tuned control over various print options including the number of copies and specific page ranges. This tutorial will show you how to effectively leverage IronPDF’s capabilities in your Java-based applications to enhance printing operations.

## Print PDF

Start by loading the PDF file you wish to print. Using the `print` method, a standard print dialog is launched where you can choose the printer, specify page ranges, and adjust other settings before the printing process commences. Consider the following example:

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Convert HTML to PDF
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Example</h1>");

// Initiate printing with user interaction
pdf.print();
```

This will open a print dialog where you can select your desired printer and configure additional options, as depicted below.

![Print Dialog](https://ironpdf.com/static-assets/ironpdf-java/howto/print-pdf/print-dialog.webp)

<hr>

## Print PDF without the Print Dialog

For workflows that require no user interaction, such as in automated systems, use the `printWithoutDialog` method. This method directly sends the PDF to the default printer, bypassing the print dialog altogether.

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Create PDF from HTML
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Example</h1>");

// Print directly to the default printer
pdf.printWithoutDialog();
```