Software developers can leverage IronPDF to merge multiple images into a single PDF file.

The method `PdfDocument.fromImage` takes a collection of `Path` objects. Each `Path` corresponds to an image file located on the local file system. This flexibility allows developers to include images from various folders or those that meet certain naming or format conditions. In scenarios where all images are located in one folder (such as the scenario in the provided code example), developers can use `DirectoryStream` and other classes from `java.nio.file` to efficiently compile a list of all images in that folder.

`PdfDocument.fromImage` processes each specified image by creating a new page for it within the PDF.

If there is a requirement to create separate PDF files for each image rather than combining them, developers have a couple of options:

1. Repeatedly invoke `PdfDocument.fromImage` with single-item lists (for example, `PdfDocument.fromImage(new ArrayList<>().add(Paths.get("path/to/single/image.png"))`));
2. First combine all images into one PDF as detailed in the initial example, then distribute each PDF page into separate documents using the `PdfDocument.copyPage` method.