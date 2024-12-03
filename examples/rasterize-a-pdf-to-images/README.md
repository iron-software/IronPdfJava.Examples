***Based on <https://ironpdf.com/examples/rasterize-a-pdf-to-images/>***

After loading from a file, converting from various sources (such as webpages, URLs, HTML), or adjusting for things like margins, headers, and footers, IronPDF allows for the exporting of PDF document pages into image formats. These images can then be saved locally, stored in a database, or transmitted over networks, among other applications.

The method `toBufferedImages` produces a `List` of `BufferedImage` objects. Each `BufferedImage` holds the image data for an individual page of the `PdfDocument`. The list of `BufferedImage` objects is sorted by the page numbers in ascending order. By passing a `PageSelection` object to the method, developers can create an image list for a specific range of pages within the PDF.

In the provided code snippet, a `ToImageOptions` object is utilized to specify the desired dimensions of the output images after conversion. This class also allows for the adjustment of the image’s DPI through the `setDpi` method. By combining `ToImageOptions` with `PageSelection`, developers can fine-tune the conversion process in terms of scope, size, and resolution of the images derived from a PDF.

For further details on IronPDF and its capabilities, please visit the [IronPDF Documentation and Resources](https://ironpdf.com/).