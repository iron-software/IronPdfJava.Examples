***Based on <https://ironpdf.com/examples/image-to-pdf/>***

Developers can leverage IronPDF to merge multiple images into a single PDF file.

The method `PdfDocument.fromImage` is designed to take an array of `Path` objects, each pointing to an image file on the local file system. This flexibility allows developers to tailor the list of images, including those from varied directories or meeting specific naming or file type criteria. For images located in the same directory, as shown in the prior example, developers might use a `DirectoryStream` among other `java.nio.file` classes to swiftly aggregate a list of all images in that directory.

The `PdfDocument.fromImage` method will display each image from the list on its own page within the created PDF.

Should there be a requirement to create multiple PDF files from different images rather than merging them into one, developers can:

1. Repeatedly invoke `PdfDocument.fromImage` with lists that each contain only a single `Path` object (for instance, `PdfDocument.fromImage(new ArrayList<>().add(Paths.get("path/to/single/image.png")))`);
2. Merge all images into one PDF as illustrated earlier, then separate each page into individual PDF files using the `PdfDocument.copyPage` method.

For further guidance on managing PDF documents with IronPDF, explore the [IronPDF Developer Documentation](https://ironpdf.com/docs/).