***Based on <https://ironpdf.com/examples/custom-pdf-paper-size/>***

IronPDF provides developers with the capability to create PDF documents in custom sizes beyond the traditional A4 format, which measures 8½ by 11 inches or 21.59 by 27.94 centimeters.

To produce PDF files with various paper sizes, developers can define the dimensions within a `ChromePdfRenderOptions` object using the `setPaperSize` method. Here, you can select from a predefined list of `PaperSizes`. Once set, generate the PDF from your source material (which can be an HTML string, a URL, or an HTML file) as you usually would.

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setPaperSize(PaperSize.B5); // Set to B5 size
PdfDocument.renderHtmlFileAsPdf("https://ironpdf.com/mycontent.html", renderOptions); // Render HTML to PDF
```

The `PaperSize` enumeration supports over 100 familiar print sizes, typically sufficient for most business applications. However, if you require a print size not available in the `PaperSize` enumeration, you can select `PaperSize.Custom`. This option allows you to manually specify the dimensions of the page width and height:

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setPaperSize(PaperSize.Custom);  // Use custom size
renderOptions.setCustomPaperWidth(11);        // Width in inches
renderOptions.setCustomPaperHeight(17);       // Height in inches
PdfDocument.renderHtmlAsStringAsPdf("<p>Custom Size Content</p>", renderOptions); // Example HTML string rendered as PDF
```

As demonstrated, the methods `setCustomPaperWidth` and `setCustomPaperHeight` are used to define dimensions in inches. For specifications in centimeters, the method `setCustomPaperSizeInCentimeters` should be utilized. Likewise, use `setCustomPaperSizeInMillimeters` for millimeters, and `setCustomPaperSizeInPixelsOrPoints` for pixel or point measurements.