***Based on <https://ironpdf.com/examples/backgrounds-and-foregrounds/>***

IronPDF offers the unique capability to embellish PDF documents with distinctive backgrounds or foregrounds through the methods `addBackground` and `addForeground`. These functions allow developers to incorporate the contents of one PDF as either the base or the overlay layer of another document. This feature is incredibly beneficial for creating multiple PDFs that follow a unified design theme.

To utilize these methods, you need to work with `PdfDocument` objects, which can be obtained from existing files using the `fromFile` method or created from scratch with various PDF rendering techniques.

By default, the `addBackground` and `addForeground` methods apply the first page of a multi-page PDF document as the default background or foreground. To select a different page, simply provide the page index as the second parameter in your method invocation.

If you need to set a PDF as the background or foreground for specific pages of a target PDF, you should define the pages using a `PageSelection` object. The following example illustrates how to implement this for both individual pages and a sequence of pages in a document.

For tasks where you need to watermark PDFs, consider using the `addWatermark` method. This alternative provides enhanced control over the positioning and opacity of the background elements.

For comprehensive details on manipulating PDF files, view the documentation at [IronPDF's Features and Documentation](https://ironpdf.com).

To learn more about editing backgrounds and foregrounds in PDF documents using Java from IronPDF, visit [Learn to Edit PDF Backgrounds & Foregrounds in Java](https://ironpdf.com/java/how-to/background-foreground/).