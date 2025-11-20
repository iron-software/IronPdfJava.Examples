***Based on <https://ironpdf.com/examples/rasterize-a-pdf-to-images/>***

After being loaded from various sources like files, webpages, or URLs, or after undergoing modifications such as adding margins or custom headers and footers, IronPDF offers the capability to transform PDF document pages into images. These images can subsequently be stored in a file system, saved in a database, or transmitted across networks, among other potential applications.

The method `toBufferedImages` produces a `List` of `BufferedImage` instances, where each `BufferedImage` represents the visual content of an individual page from the `PdfDocument`. This collection is sorted in the order of the pages in the document. Developers have the option to pass a `PageSelection` argument when calling this method to generate images for a specific range of pages.

In the provided code example, a `ToImageOptions` class is utilized to specify the desired dimensions for the resulting images after conversion. Additionally, this class allows for adjusting the DPI (dots per inch) of the output image through the `setDpi` method. By using the `ToImageOptions` and `PageSelection` classes together, developers can fine-tune the dimensions, scope, and clarity of the conversion process from PDF to image.

For more details on IronPDF and its comprehensive features, feel free to check out the [IronPDF Documentation and Resources](https://ironpdf.com/java/docs/).

You can find further insights about the `toBufferedImages` method [here](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#toBufferedImages()).