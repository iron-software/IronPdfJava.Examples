***Based on <https://ironpdf.com/examples/custom-pdf-paper-size/>***

IronPDF affords developers the flexibility to create PDF documents in various sizes beyond the traditional A4 dimension (8½ by 11 inches, or 21.59 by 27.94 centimeters).

To render PDFs in assorted paper sizes, you can specify the desired dimensions using a `ChromePdfRenderOptions` object and the `setPaperSize` method. Simply assign a preset `PaperSizes` value as the method argument. Then, proceed to generate the PDF document from your source content, which could be an HTML string, a URL, or an HTML file.

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setPaperSize(PaperSize.B5);
PdfDocument.renderHtmlFileAsPdf("mycontent.html", renderOptions);
```

The `PaperSize` enum supports a comprehensive range of over 100 standard industry print sizes, adequately addressing the majority of common business requirements. If you need a size that is not predefined in the `PaperSize` enum, select `PaperSize.Custom`. Subsequently, specify the exact page width and height:

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setPaperSize(PaperSize.Custom);
renderOptions.setCustomPaperWidth(11);   // Width in inches
renderOptions.setCustomPaperHeight(17);  // Height in inches
```

The methods `setCustomPaperWidth` and `setCustomPaperHeight` are used to define custom dimensions in inches. For dimensions in other units, such as centimeters, millimeters, or pixels/points, use `setCustomPaperSizeInCentimeters`, `setCustomPaperSizeInMillimeters`, and `setCustomPaperSizeInPixelsOrPoints` respectively.