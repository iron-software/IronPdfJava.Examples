***Based on <https://ironpdf.com/examples/custom-pdf-paper-size/>***

With IronPDF, developers have the flexibility to create PDF documents in various sizes beyond the typical A4 dimension (8½ x 11 inches or 21.59 x 27.94 centimeters).

To craft PDFs in varying paper sizes, define the required dimensions within a `ChromePdfRenderOptions` instance using the `setPaperSize` method. Specify the paper size directly in the method's parameter using one of the predefined values from the `PaperSizes` enumeration. Proceed by generating the PDF document from your desired source, whether it's an HTML string, a web URL, or an HTML file.

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
renderOptions.setPaperSize(PaperSize.B5);  
PdfDocument.renderHtmlFileAsPdf("mycontent.html", renderOptions);  // Renders a PDF using the B5 paper size
```

The enumeration `PaperSize` includes over 100 recognized print sizes, suitable for a wide range of business scenarios. If you need a print size that is not available in the `PaperSize` enumeration, select `PaperSize.Custom` and manually specify the desired page width and height:

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
renderOptions.setPaperSize(PaperSize.Custom);  
renderOptions.setCustomPaperWidth(11);   // Width in inches  
renderOptions.setCustomPaperHeight(17);  // Height in inches
PdfDocument.renderHtmlFileAsPdf("custom-size-content.html", renderOptions);  // Renders a PDF with custom dimensions
```

As demonstrated, the methods `setCustomPaperWidth` and `setCustomPaperHeight` take numerical values that represent the desired dimensions in inches. For dimensions in centimeters, employ `setCustomPaperSizeInCentimeters`. Use `setCustomPaperSizeInMillimeters` for millimeters, and utilize `setCustomPaperSizeInPixelsOrPoints` for specifying size in pixels or points.