> Full guide: [Security and metadata](https://ironpdf.com/examples/security-and-metadata/)

IronPDF facilitates modifications to both PDF metadata and security settings. It has features to set PDFs as read-only, unprintable, password-protected, or encrypted. Moreover, users have the capability to add or edit metadata properties.

For Java developers, handling a PDF's metadata with IronPDF requires obtaining a reference to the `MetadataManager`. This component allows for the direct manipulation and retrieval of a PDF's metadata. Developers can easily access and modify common metadata properties via provided getter and setter methods.

Here is a comprehensive list of metadata properties accessible with straightforward getter and setter methods:

- `Producer`
- `CreationDate`
- `Creator`
- `Author`
- `Keywords`
- `Subject`
- `Title`
- `ModifiedDate`

For instance, the methods `setAuthor`, `setTitle`, `setKeywords`, and `setModifiedDate` can be used to customize the author, title, keywords, and modification date of a PDF document respectively.

To manipulate metadata properties beyond those listed, `getAnyMetadata` and `setAnyMetadata` methods can be employed, specifying the desired property name.

Adjusting security features of a PDF involves the `SecurityManager`. By invoking `getSecurity` on a `PdfDocument`, a `SecurityManager` instance is obtained, enabling the application of necessary security restrictions depending on the intended use of the document.

Java developers can further refine security settings by using a `SecurityOptions` object, which offers more detailed control over the security aspects of a PDF.

For an in-depth understanding of the MetadataManager in IronPDF for Java, refer to the following documentation:
[Explore MetadataManager API for Java PDF Management](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/metadata/MetadataManager.html)