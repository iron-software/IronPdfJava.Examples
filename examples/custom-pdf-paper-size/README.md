> Full guide: [Custom PDF paper size](https://ironpdf.com/examples/custom-pdf-paper-size/)

IronPDF allows developers to create PDF documents in sizes beyond the standard A4 dimensions (8½ by 11 inches, or 21.59 by 27.94 centimeters).

To configure unique paper sizes, you can define your preferences within a `ChromePdfRenderOptions` object using the `setPaperSize` method. Simply select a built-in `PaperSize` from over 100 recognized industry sizes, which should cater to most business requirements.

If the preset sizes don’t meet your needs, you can opt for `PaperSize.Custom`. Here, you manually specify your desired dimensions:
- Use `setCustomPaperWidth` and `setCustomPaperHeight` for measurements in inches.
- For centimeters, employ `setCustomPaperSizeInCentimeters`.
- If you need to specify dimensions in millimeters, turn to `setCustomPaperSizeInMillimeters`.
- To apply dimensions in pixels or points, the method `setCustomPaperSizeInPixelsOrPoints` is available.

After setting the size, proceed to generate your PDF from the available source content like HTML strings, URLs, or HTML files as usually done.

For additional details on customizing PDF dimensions with IronPDF, explore further [here](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html#setPaperSize(com.ironsoftware.ironpdf.render.PaperSize)).