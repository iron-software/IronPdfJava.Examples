***Based on <https://ironpdf.com/examples/backgrounds-and-foregrounds/>***

For incorporating specific background or foreground elements into your PDF documents, IronPDF offers the methods `addBackground` and `addForeground`. These functions allow developers to utilize the content from one PDF as the background or foreground of another. This feature is especially useful for creating series of PDFs that share a uniform design scheme.

```java
addBackground(PdfDocument backgroundDoc);
addForeground(PdfDocument foregroundDoc);
```

These functionalities require `PdfDocument` objects, which developers can obtain from existing PDFs using the `fromFile` method, or create new ones via various PDF rendering options.

The default behavior of `addBackground` and `addForeground` is to use the first page from multi-page PDF documents for the background or foreground. However, developers can specify a different page by passing the desired page index as the second argument to the method.

```java
// Utilize the third page of the background PDF for the background of each page in the active PDF
pdf.addBackground(backgroundPdf, 2);

// Apply the second page of the foreground PDF as the foreground for every page in the active PDF
pdf.addForeground(foregroundPdf, 1);
```

To apply a PDF as the background or foreground on specific pages of an active PDF, developers should specify the target pages using a `PageSelection` object. Below is an illustration of how to target specific pages, both for individual and a range of pages.

```java
// Set the background to specifically the sixth page of the active PDF 
pdf.addBackground(backgroundPdf, PageSelection.singlePage(6));

// Apply a distinct background from the seventh to sixteenth pages of the active PDF
pdf.addBackground(backgroundPdf, PageSelection.pageRange(6, 15));

// Set another background on just the first page of the active PDF
pdf.addBackground(backgroundPdf, PageSelection.firstPage());
```

For watermarking, an alternative method `addWatermark` is provided, which offers easier management of the background's positioning and transparency compared to `addBackground`.

For additional insights on PDF manipulation, head over to [IronPDF's Features and Documentation](https://www.ironpdf.com).