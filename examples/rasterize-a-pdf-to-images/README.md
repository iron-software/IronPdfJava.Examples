***Based on <https://ironpdf.com/examples/rasterize-a-pdf-to-images/>***

After IronPDF loads a PDF from a file, external sources like webpages, or HTML content, and following any customizations such as adding margins, headers, and footers, it offers the capability to export individual PDF pages as images. These images can then be saved on a local file system, stored within a database, or transmitted across networks for various applications.

The method `toBufferedImages` provides a `List` of `BufferedImage` instances, where each `BufferedImage` encapsulates the byte content of each page from the `PdfDocument`. The list is sorted by the page number in ascending order. Developers have the option to pass a `PageSelection` object to this method to specify a range of pages for which images should be generated.

In the provided code example, a `ToImageOptions` object is initialized to define the desired dimensions of the output images post-conversion. Additionally, this class offers a method `setDpi` to adjust the DPI (dots per inch), allowing for precision control over the output image's resolution. By utilizing `ToImageOptions` and `PageSelection` together, developers have comprehensive control over the resolution, dimensions, and specific pages when converting PDFs to images.

For further details on the functionalities of IronPDF, refer to the [IronPDF Documentation and Resources](https://ironpdf.com).