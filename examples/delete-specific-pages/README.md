***Based on <https://ironpdf.com/examples/delete-specific-pages/>***

### PDF Page Removal Using IronPDF

IronPDF makes it straightforward to extract and discard specific pages from a PDF document.

The provided code snippet demonstrates how to employ the `removePages` method to alter a PDF document created for this example. This four-page document is modified in such a way that only the first and last pages are preserved, while the second and third pages are removed.

Utilizing the `PageSelection` class, developers can define which pages are to be excluded from a `PdfDocument`. If you need to remove pages sequentially, such as pages 4 through 18, you can use the static method `pageRange` to specify this range. In cases where you need to delete a non-sequential set of pages, simply pass a `List` containing the specific page indices to the `pageRange` method:

```csharp
// Create an instance of PdfDocument
PdfDocument document = PdfDocument.FromFile("path-to-your-document.pdf");

// Remove specific pages using the PageSelection class
PageSelection pagesToRemove = PageSelection.pageRange(2, 3); // Removes the second and third pages
document.removePages(pagesToRemove);

// Save the modified document
document.SaveAs("path-to-save-modified-document.pdf");
```

In this example, after deleting pages from the document, the modified version is saved back to the local storage. This allows for easy management and manipulation of PDF files using IronPDF in your .NET projects.