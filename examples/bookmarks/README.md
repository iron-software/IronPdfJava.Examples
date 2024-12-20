***Based on <https://ironpdf.com/examples/bookmarks/>***

Developers can utilize the `BookmarkManager` class to incorporate bookmarks into a PDF file. It's accessible by invoking the `getBookmarks` method on the `PdfDocument`.

```java
BookmarkManager bookmarks = pdf.getBookmarks();
```

In the provided code snippet, we employ the `addBookmarkAtEnd` method to insert four sequential top-level bookmarks into the active `PdfDocument` before committing those changes to disk. Once the PDF is opened after running this code, the bookmarks will be displayed in the following sequence:

- Author's Note
- Table of Content
- Summary
- References

Additionally, the `addBookmarkAtStart` method can be used to insert a bookmark at the beginning of the list, causing it to precede any existing bookmarks. For instance, the following line of code, if executed directly after Line 16 in the featured code example, would position the "Foreword" bookmark at the top of the previously mentioned list.

```java
bookmarks.addBookMarkAtStart("Foreword",1);
```

IronPDF is engineered to detect and integrate bookmarks that were previously placed in PDFs by other third-party applications. This capability enables significant flexibility in managing bookmarks within PDFs that have already been rendered, as might be demanded in various business scenarios.

For a comprehensive exploration of bookmark capabilities and other PDF features, check out the [IronPDF Overview Page on IronSoftware](https://ironpdf.com/) to learn more about the extensive features and integration options.