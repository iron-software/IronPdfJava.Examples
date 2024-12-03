***Based on <https://ironpdf.com/examples/security-and-metadata/>***

IronPDF provides robust tools for adjusting PDF metadata and security parameters. It allows for setting PDF files as read-only, unprintable, password-protected, and encrypted. Additionally, developers can manipulate metadata by creating new properties or altering existing ones.

When utilizing IronPDF for Java to modify a PDF's metadata, a `MetadataManager` instance must be acquired first. This manager class facilitates easy and direct manipulation of metadata through its various methods. Developers can conveniently manage standard metadata attributes such as `Producer`, `CreationDate`, `Creator`, `Author`, `Keywords`, `Subject`, `Title`, and `ModifiedDate` using getters and setters named identically to these properties.

Here’s how to modify several attributes of a PDF using IronPDF:

- Use `setAuthor`, `setTitle`, `setKeywords`, and `setModifiedDate` methods to update the author, title, keywords, and modification date of the PDF document.

For properties not included in the standard list, the `getAnyMetadata` and `setAnyMetadata` methods can be used to access and set any metadata attribute by specifying its name.

Security modifications in a PDF are managed by accessing its `SecurityManager`. By invoking `getSecurity` on a `PdfDocument`, one can obtain this manager and apply various restrictions based on the document's intended usage.

Developers have the option to use a `SecurityOptions` object to finely tune the security settings of a PDF document.

For a more comprehensive understanding of IronPDF's functionalities across different development environments and further exploration, visit [IronPDF Documentation and Features](https://ironpdf.com/technology/html-to-pdf/). To explore more solutions from Iron Software, check out [Iron Software's Official Website](https://ironsoftware.com/).