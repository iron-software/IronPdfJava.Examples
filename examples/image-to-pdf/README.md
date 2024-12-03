***Based on <https://ironpdf.com/examples/image-to-pdf/>***

Developers have the capability to merge multiple images into a unified PDF using IronPDF.

The method `PdfDocument.fromImage` is engineered to receive a collection of `Path` objects. Each `Path` must point to an existing image file located on the local system. This arrangement offers developers substantial flexibility in defining the list of images - whether the images are dispersed across different directories, or if they need to adhere to certain naming conventions or file types. For images located within the same folder (as described in the given example), developers can employ `DirectoryStream` among other `java.nio.file` classes to efficiently assemble a list of all images in that directory.

Each image specified in the list will be rendered on an individual page within the created PDF document using `PdfDocument.fromImage`.

In scenarios where separate images are required to be in distinct PDF files (rather than combined into one), developers can accomplish this in one of two ways:

1. Repeatedly invoke `PdfDocument.fromImage` for single-item lists, for example, using `PdfDocument.fromImage(new ArrayList<>().add(Paths.get("path/to/single/image.png")))`;
2. Initially merge all images into a single PDF as demonstrated, then segregate each page into separate new PDFs using the `PdfDocument.copyPage` technique.

For comprehensive guidelines on manipulating PDF documents with IronPDF, refer to the [IronPDF Developer Documentation](https://ironpdf.com/docs/).