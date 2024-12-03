***Based on <https://ironpdf.com/examples/delete-specific-pages/>***

### Extracting Specific Pages from PDFs using IronPDF

IronPDF simplifies the task of extracting certain pages from a PDF document.

In the code snippet provided, the `removePages` method is employed to alter a demo PDF document containing four pages. After application of the method, the modified document preserved in the local storage contains just the first and last pages – the second and third pages have been successfully removed as intended.

The `PageSelection` class plays a crucial role here; it determines which pages the `removePages` function will exclude from the `PdfDocument` object in question. Developers can make use of the static `pageRange` function demonstrated previously, which allows for the exclusion of a consecutive sequence of pages (for example, pages 4 through 18 in a hypothetical document). For non-sequential page removal, one should pass a `List` of individual page indexes to the `pageRange` method: