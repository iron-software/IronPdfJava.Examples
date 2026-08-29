> Full guide: [Bookmarks](https://ironpdf.com/examples/bookmarks/)

Developers can use the `BookmarkManager` to insert bookmarks into a PDF file. This can be done by utilizing the `getBookmarks` method from a `PdfDocument`.

In the example provided, we demonstrate how to use the `addBookmarkAtEnd` method to sequentially insert four primary bookmarks into an active `PdfDocument` and then save these changes to the disk. Upon reopening this PDF, you will notice the bookmarks displayed in the following sequence:

- Author's Note
- Table of Content
- Summary
- References

To insert a bookmark at the beginning, hence making it show up before any predefined bookmarks, the `addBookmarkAtStart` method can be employed. By inserting the next line of code right after the one in the example, the bookmark "Foreword" would be positioned at the forefront of the list.

IronPDF excels in identifying bookmarks that are added through external software, so bookmarks can be reorganised in a document that was rendered elsewhere.

For an in-depth guide on managing bookmarks and exploring other PDF capabilities, you can visit the [IronPDF Overview Page on Iron Software](https://ironpdf.com/) which looks at a variety of features and methods for integration.

[Discover more about how to handle PDF bookmarks in Java](https://ironpdf.com/java/how-to/bookmarks/)