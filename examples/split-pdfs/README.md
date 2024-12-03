***Based on <https://ironpdf.com/examples/split-pdfs/>***

This code snippet illustrates how Java developers can utilize IronPDF's PDF editing capabilities to perform a common task: dividing a PDF into several smaller ones.

By employing the `copyPages` method, developers can efficiently create a new PDF document that includes a specified set of pages from an original document.

The example showcased here uses this method to create two new PDF documents; the first containing the initial page, and the second holding the second and third pages, from a newly-generated PDF. This method ensures the original content and structure remains intact, while selectively replicating parts of it into new files—essentially "splitting" the document. This technique is particularly useful where there is a need to preserve the original document for archival purposes.

Another variation of splitting a PDF (which involves altering the original file) involves using the `copyPages` method together with the `removePages` method.

# Steps to Split PDF Files in Java

1. Install the IronPDF Java library to enable PDF document splitting.
2. Load an existing PDF or generate a new PDF in Java.
3. Use the `copyPages` method to duplicate selected pages into a new `PdfDocument` object.
4. Save the new `PdfDocument` using the `saveAs` method.
5. Execute step 3 with just a single line of Java code.

For additional details on leveraging the comprehensive PDF manipulation capabilities of IronPDF, please refer to the [IronPDF PDF Library for Java Documentation](https://ironpdf.com/java/getting-started/).