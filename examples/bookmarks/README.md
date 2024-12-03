***Based on <https://ironpdf.com/examples/bookmarks/>***

Developers have the capability to integrate bookmarks into a PDF utilizing the `BookmarkManager`. This is achieved by invoking the `getBookmarks` method on the `PdfDocument`.

```java
BookmarkManager bookmarks = pdf.getBookmarks();
```

In this illustrated code snippet, the `addBookmarkAtEnd` method is employed to sequentially insert four top-level bookmarks into the active `PdfDocument`, prior to finalizing the changes by saving to the disk. When the updated PDF is opened following the execution of the previous code, the bookmarks will be displayed in the order noted:

- Author's Note
- Table of Content
- Summary
- References

Another method, `addBookmarkAtStart`, is available to insert a bookmark at the beginning, causing it to feature ahead of other previously set bookmarks. For instance, inserting the following code immediately after Line 16 from the initial example will position the "Foreword" bookmark at the very top of the previously mentioned list.

```java
bookmarks.addBookMarkAtStart("Foreword",1);
```

IronPDF is adept at detecting bookmarks that have been incorporated into the PDF through various third-party applications, enhancing its versatility in managing and updating bookmarks in post-production PDF files as business requirements dictate.

For a comprehensive exploration of bookmark functions and other PDF capabilities, head over to the [IronPDF Overview Page on IronSoftware](https://ironpdf.com) to discover a range of features and potential integrations.