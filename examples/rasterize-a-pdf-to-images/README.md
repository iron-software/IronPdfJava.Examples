***Based on <https://ironpdf.com/examples/rasterize-a-pdf-to-images/>***

Once you've loaded a PDF from a file, transformed it from a webpage, URL, or HTML, or customized it by adjusting margins or adding headers and footers, IronPDF offers the functionality to take any page of your PDF and convert it into image formats. These images can then be saved on a file system, stored in a database, or transmitted across network connections, serving a myriad of applications.

The method `toBufferedImages` yields a `List` of `BufferedImage` instances. Each `BufferedImage` encapsulates the image data of a single PDF page. These images are sorted in the `List` by the ascending order of their respective page numbers. Additionally, developers can pass a `PageSelection` object when calling this method to select a specific range of pages from the PDF for conversion.

In the provided code snippet, a `ToImageOptions` object is created for specifying the desired dimensions of the output images. This class also features a method, `setDpi`, for adjusting the resolution (DPI) of the resulting images. By combining `ToImageOptions` with `PageSelection`, developers can finely tune the conversion process, effectively managing the dimensions and resolution of the image outputs.

For further details on IronPDF and its array of features, please visit the [IronPDF Documentation and Resources](https://ironpdf.com/).