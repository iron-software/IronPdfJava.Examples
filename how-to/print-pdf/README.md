# How to Print PDF Files in Java

> Full guide: [How to Print PDF Files in Java](https://ironpdf.com/how-to/print-pdf/)


In Java applications, automating the printing of PDF documents can enhance document management and integrate printing operations. Using IronPDF for Java, you have the capability to directly send PDF files to a physical printer with detailed control over printing options, including the number of copies and specified page ranges. This tutorial will demonstrate how to employ IronPDF’s capabilities to optimize printing procedures within your Java applications.

## Print PDF

Begin by loading the PDF you want to print. The `print` method initiates the standard printing dialog, which allows for the selection of printer, page range, and additional settings before executing the print command. Below is a typical example:

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

// Initialize IronPDF's license
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Convert HTML content into a PDF document
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>testing</h1>");

// Trigger printing of the PDF with an interactive print dialog
pdf.print();
```

An interactive print dialog will appear, prompting you to choose your preferred printing settings, as illustrated here.

![Print Dialog](https://ironpdf.com/static-assets/ironpdf-java/howto/print-pdf/print-dialog.webp)

---

## Print PDF without the Print Dialog

For scenarios requiring automation without user interaction, use the `printWithoutDialog` method. This function effectively skips the print dialog and sends your document directly to the default printer:

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

// Apply the IronPDF license key
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Create a PDF from HTML
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>testing</h1>");

// Print the PDF to the default printer without any dialog prompts
pdf.printWithoutDialog();
```

By adopting IronPDF for Java, you can manage direct PDF printing operations across different parts of your Java applications.