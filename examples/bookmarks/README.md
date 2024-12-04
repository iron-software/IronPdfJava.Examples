***Based on <https://ironpdf.com/examples/bookmarks/>***

Developers can leverage the `BookmarkManager` to insert bookmarks into a PDF file. To access `BookmarkManager`, invoke the `getBookmarks` method on a `PdfDocument`.

```java
BookmarkManager bookmarks = pdf.getBookmarks();
```

In our example, we use the `addBookmarkAtEnd` method to sequentially insert four top-level bookmarks into the active `PdfDocument` before committing the changes to the disk. When you open the PDF after running this code, the bookmarks will appear in this sequence:

- Author's Note
- Table of Content
- Summary
- References

Another method, `addBookmarkAtStart`, allows you to add a bookmark to the beginning, making it show up before any existing bookmarks. For instance, the following code snippet, if placed immediately after Line 16 in the code example, positions the "Foreword" bookmark at the very front of our previously mentioned list.

```java
bookmarks.addBookMarkAtStart("Foreword",1);
```

IronPDF is designed to recognize bookmarks that were inserted using different third-party applications. This capability significantly enhances the library's versatility for adding and adjusting bookmarks in PDFs that have already been generated, based on organizational needs.

For more comprehensive insights into bookmark management and additional PDF features, please visit the [IronPDF Overview Page on IronSoftware](https://ironpdf.com/) to discover more about the features and how to integrate them.