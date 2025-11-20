***Based on <https://ironpdf.com/examples/ironpdf-set-custom-margins/>***

IronPDF naturally creates PDF documents with default margins of 25 millimeters on all sides. Yet, it provides flexibility for developers to tailor these margins to meet specific layout requirements.

Developers have the capability to customize margins for new PDF documents utilizing the `ChromePdfRenderOptions`. The example provided demonstrates setting specific custom margin values: 20 millimeters for the left and right margins, and 40 millimeters for the top and bottom margins.

You can adjust the PDF margins to be optimal for different types of documents such as letters, posters, and postcards—or to accommodate borderless formats ideal for professional printing needs by setting all margins to zero. Employ `ChromePdfRenderOptions` with methods like `renderUrlAsPdf`, `renderHtmlAsPdf`, and `renderHtmlFileAsPdf` to integrate other printing options such as paper size, DPI, and headers and footers, beyond just margins. For more details on these customizations, consult the [`ChromePdfRenderOptions` API Reference](https://ironpdf.com/object-reference/api/IronPdf.ChromePdfRenderOptions.html).

The following code outlines the process:

- Initializing `ChromePdfRenderOptions` enables the setting of specific margin sizes, measured in millimeters.
- `ChromePdfRenderer`, a class from IronPDF, is then used to apply these defined rendering options.
- By invoking the `renderHtmlAsPdf` method with basic HTML content, it illustrates the process of generating a PDF with the custom margins.
- The PDF is subsequently saved as "output.pdf".

Further explore customization capabilities through the [ChromePdfRenderOptions API](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html).