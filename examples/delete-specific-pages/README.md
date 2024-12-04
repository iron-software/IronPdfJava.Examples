***Based on <https://ironpdf.com/examples/delete-specific-pages/>***

### Extracting Specific PDF Pages Using IronPDF

IronPDF simplifies the process of extracting pages from a PDF document seamlessly.

In this example, the `removePages` function is utilized to manipulate a created-on-the-spot four-page PDF, demonstrating the action. After processing, the modified PDF, saved locally, retains only the first and fourth pages, with the intervening two pages removed as intended.

The `PageSelection` class plays a crucial role in this operation, dictating which pages the `removePages` function should remove from an existing `PdfDocument`. Developers can leverage the static `pageRange` method to specify a consecutive sequence of pages to remove (for instance, pages 4 through 18 in a hypothetical document). Alternatively, for non-consecutive pages, passing a `List` of specific page numbers to `pageRange` facilitates their removal: