***Based on <https://ironpdf.com/examples/split-pdfs/>***

This coding illustration demonstrates how Java developers can take advantage of IronPDF's PDF modification capabilities to divide a single PDF document into multiple smaller files.

The `copyPages` function allows developers to swiftly create a new PDF file containing specific pages from the original document.

In the example provided, this method is employed to generate two separate PDF files. The first file contains only the first page, while the second file comprises the second and third pages of an initially rendered PDF. This method maintains the original document's content and structure while distributing certain parts into new files, essentially "splitting" the document as needed while keeping the original file intact for archival purposes.

An alternative way to split PDF files (where the original document is not retained) involves using `copyPages` together with `removePages`.

# How to Split PDF Files in Java

1. Install the IronPDF Java library to begin splitting PDF documents.
2. Load an existing PDF or create a new PDF in Java.
3. Use the `copyPages` method to duplicate selected pages into a different `PdfDocument`.
4. Output the new `PdfDocument` using the `saveAs` method.
5. Complete step 3 with a single line of Java code.

For further details on leveraging the comprehensive PDF manipulation tools offered by IronPDF, refer to the [IronPDF PDF Library for Java Documentation](https://ironpdf.com/java/getting-started/).