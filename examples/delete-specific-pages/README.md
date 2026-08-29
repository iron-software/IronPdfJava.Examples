> Full guide: [Delete specific pages](https://ironpdf.com/java/examples/delete-specific-pages/?utm_source=github)

### Managing PDF Pages with IronPDF

With IronPDF, extracting specific pages from a PDF document is straightforward and efficient.

This example demonstrates the utilization of the `removePages` method, which allows you to manipulate a PDF file by removing selected pages. In this instance, a four-page PDF is altered to retain only the first and last pages, thus removing the second and third pages.

Using the `PageSelection` class, the subject pages are chosen for the `removePages` method to excise from the given `PdfDocument`. The `pageRange` method of `PageSelection` facilitates the removal of contiguous page ranges (for example, pages 4 through 18 of a document). Alternatively, for removing non-sequential pages, one can input a `List` of individual page indexes into `pageRange`.

#### Guide to Deleting PDF Pages Using Java

1. [Install the IronPDF Java Library](https://ironpdf.com/download-modal?utm_source=github)
2. Load an existing PDF or create a new one in Java
3. Apply the `removePages` method to remove specified pages
4. Use the `PageSelection` class to choose which pages to delete
5. Store the altered PDF as a new file

Below is a Java code snippet that illustrates these steps:

This method of page removal assures that PDF documents can be tailored to meet precise requirements with minimal effort.

[Discover more about the PdfDocument.removePages Method](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html?utm_source=github#removePages(com.ironsoftware.ironpdf.edit.PageSelection))