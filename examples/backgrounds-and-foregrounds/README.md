***Based on <https://ironpdf.com/examples/backgrounds-and-foregrounds/>***

IronPDF provides the methods `addBackground` and `addForeground` for injecting specific visual elements into your PDF documents. These functions allow developers to utilize the content from one PDF as either the background or foreground of another document. This capability is especially valuable for creating a series of PDFs that share a common design template.

```java
addBackground(PdfDocument backgroundPDF);
addForeground(PdfDocument foregroundPDF);
```

To utilize these methods, you must work with `PdfDocument` instances, which can be either loaded from existing files using the `fromFile` method or created freshly via various PDF rendering techniques.

By default, the `addBackground` and `addForeground` functions will apply the first page of any multi-page PDF document as the background or foreground. To use a different page, you need to specify the page index as the second parameter in these functions.

```java
// Assign the third page of the background PDF to every page in the target PDF
pdf.addBackground(backgroundPdf, 2);

// Set the second page of the foreground PDF as the foreground across all pages of the target PDF
pdf.addForeground(foregroundPdf, 1);
```

To apply a PDF layer as a background or foreground on selected pages of a target PDF, you can use a `PageSelection` object to define those pages. Below are examples of how to target a single page, as well as a range of pages, for this customization.

```java
// Apply the background to the fifth page of the target PDF
pdf.addBackground(backgroundPdf, PageSelection.singlePage(5));

// Set a specific background for pages seven through sixteen of the target PDF
pdf.addBackground(backgroundPdf, PageSelection.pageRange(7, 16));

// Overlay a background onto the very first page of the target PDF
pdf.addBackground(backgroundPdf, PageSelection.firstPage());
```

If you're looking to add watermarks to your PDFs, consider using the `addWatermark` method. It offers a straightforward approach for adjusting background configurations, including their positioning and opacity, compared to `addBackground`.

For comprehensive details on manipulating PDFs, make sure to explore [IronPDF's Features and Documentation](https://ironpdf.com).