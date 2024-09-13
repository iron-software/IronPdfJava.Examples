IronPDF provides functionality for editing PDF metadata and security parameters. Security options include turning a PDF into a read-only file, making it unprintable, securing it with a password, and encrypting it. Regarding metadata, the library allows users to add new attributes or modify existing ones.

To manipulate PDF metadata using IronPDF for Java, developers need to first obtain a reference to the `MetadataManager`. This class offers methods that provide direct access and the ability to change the metadata of the PDF. Developers can conveniently read and modify frequently-used metadata properties using predefined getters and setters.

The comprehensive list of metadata properties that can be easily modified using getters and setters includes:

- `Producer`
- `CreationDate`
- `Creator`
- `Author`
- `Keywords`
- `Subject`
- `Title`
- `ModifiedDate`

Below is an example where the `setAuthor`, `setTitle`, `setKeywords`, and `setModifiedDate` methods are utilized to adjust the document's author, title, keywords, and modification date.

For properties not listed above, you can employ the `getAnyMetadata` and `setAnyMetadata` methods by specifying the name of the property you wish to handle.

Adjusting security settings on a PDF also involves specific steps. You need to use the `SecurityManager`, which can be accessed by calling `getSecurity` on a `PdfDocument`. With the `SecurityManager`, restrictions can be applied to the PDF as necessary.

For finer control over the security settings of a PDF, Java developers can use the `SecurityOptions` object. This tool allows for detailed customization of security measures depending on the needs of the application.