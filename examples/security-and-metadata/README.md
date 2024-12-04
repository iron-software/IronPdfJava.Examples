***Based on <https://ironpdf.com/examples/security-and-metadata/>***

IronPDF provides robust features for altering PDF metadata and security settings. This includes the capability to make PDF files read-only, non-printable, password-protected, and encrypted. Metadata modification allows for defining new properties and editing existing ones.

When working with PDF metadata in IronPDF for Java, the first step for a developer is to obtain a reference to the `MetadataManager` class. This class facilitates direct access and amendments to the PDF's metadata. With it, developers can effortlessly read and modify standard metadata properties using straightforward getters and setters.

Here are the metadata properties that can be managed directly:

- `Producer`
- `CreationDate`
- `Creator`
- `Author`
- `Keywords`
- `Subject`
- `Title`
- `ModifiedDate`

The following code snippet illustrates how to use methods like `setAuthor`, `setTitle`, `setKeywords`, and `setModifiedDate` to update the corresponding metadata fields in an active document.

For properties not listed above, the methods `getAnyMetadata` and `setAnyMetadata` enable interaction with any other desired property by specifying its name.

On the security front, adjustments must be handled through a `SecurityManager`, which can be accessed by executing `getSecurity` on a `PdfDocument`. This manager allows you to implement various restrictions on the PDF, according to your needs.

Java developers might utilize a `SecurityOptions` object to have finer control over the PDF's security configurations.

For additional insights and to uncover the full spectrum of IronPDF's functionalities across different development environments, consider visiting the [IronPDF Documentation and Features](https://ironpdf.com/technology/html-to-pdf/). To learn more about Iron Software's suite of products, visit [Iron Software's Official Website](https://ironsoftware.com/).