IronPDF empowers developers to create PDF documents in various sizes beyond the conventional A4 dimensions (8½ x 11 inches or 21.59 x 27.94 cm).

To build PDFs with custom paper sizes, utilize the `ChromePdfRenderOptions` object and employ the `setPaperSize` method to define your desired size using a predefined `PaperSizes` value. Simply configure the paper size within the method parameters and produce the PDF from any source like an HTML string, URL, or HTML file.

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setPaperSize(PaperSize.B5);
PdfDocument.renderHtmlFileAsPdf("mycontent.html", renderOptions);
```

The `PaperSize` enumeration supports a wide variety of over 100 recognized printing sizes, catering to most business requirements. If you need a size that isn't offered in the `PaperSize` enumeration, select `PaperSize.Custom` and specify your desired page dimensions manually:

```java
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setPaperSize(PaperSize.Custom);
renderOptions.setCustomPaperWidth(11);  // width in inches
renderOptions.setCustomPaperHeight(17); // height in inches
```

In the examples shown above, methods like `setCustomPaperWidth` and `setCustomPaperHeight` accept numerical values denoting dimensions in inches. To specify dimensions in centimeters, you would use `setCustomPaperSizeInCentimeters`, for millimeters, `setCustomPaperSizeInMillimeters`, and for dimensions in pixels or points, use `setCustomPaperSizeInPixelsOrPoints`.