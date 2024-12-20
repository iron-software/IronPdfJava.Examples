***Based on <https://ironpdf.com/examples/image-to-pdf/>***

Developers can leverage IronPDF to merge numerous images into one PDF document.

The method `PdfDocument.fromImage` can be used by feeding it a list of `Path` objects, where each `Path` leads to an image located on the local file system. This arrangement offers developers great flexibility to define the list dynamically, enabling the inclusion of images from varied directories or those adhering to certain naming or file type criteria. When all images come from a single directory, it’s straightforward to employ a `DirectoryStream` along with other classes from `java.nio.file` to swiftly compile a list of every image in the directory.

Each image in the list passed to `PdfDocument.fromImage` will be shown on a new page in the generated PDF file.

If there is a requirement to create individual PDFs for each image, rather than merging them into a single document, developers have a couple of options:

1. Repeatedly invoke `PdfDocument.fromImage` with lists that contain just one `Path` object (for example, `PdfDocument.fromImage(new ArrayList<>().add(Paths.get("path/to/single/image.png"))`));
2. Aggregate all images into one PDF as demonstrated previously, and subsequently use the `PdfDocument.copyPage` method to extract each image into separate PDF documents.

For additional insights into managing PDF documents using IronPDF, consult the [IronPDF Developer Documentation](https://ironpdf.com/docs/).