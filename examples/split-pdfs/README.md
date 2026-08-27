> Full guide: [Split PDFs](https://ironpdf.com/java/examples/split-pdfs/)

In this code tutorial, we explore how Java developers can utilize IronPDF to manage PDF files effectively, particularly how to divide a PDF into smaller segments.

Developers can utilize the `copyPages` method to efficiently generate a new PDF that encompasses a defined range of pages from the original document.

The example provided demonstrates the process of generating two distinct PDF files. The first file contains only the initial page, while the second file includes the second and third pages of the source PDF. This method ensures that the integrity and layout of the original document are maintained while selectively transferring content to new files, accomplishing a file split in practice. This technique proves beneficial for scenarios where the original document needs to be preserved untouched for archival reasons.

Alternatively, for cases where maintaining the original file is not essential, developers can merge the `copyPages` method with the `removePages` method to split the document.

## Steps for Splitting PDF Files in Java

1. Install the IronPDF Java library to enable PDF splitting functionality.
2. Load an existing PDF or generate a new one in Java.
3. Use the `copyPages` method to isolate and copy desired pages into a new `PdfDocument`.
4. Save the newly created `PdfDocument` using the `saveAs` method.
5. Streamline the above process in a single line of Java code.

[Discover more about the `copyPage` method in Java](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#copyPage(int)).