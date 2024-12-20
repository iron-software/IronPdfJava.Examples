***Based on <https://ironpdf.com/examples/security-and-metadata/>***

IronPDF offers robust features for editing PDF metadata and enhancing security measures. With respect to security, functionalities include setting PDFs to be read-only, non-printable, password-secured, and encrypted. As for metadata, it allows the creation of new properties and editing of existing ones.

To manipulate a PDF's metadata with IronPDF for Java, developers need to obtain a reference to its `MetadataManager`. This component enables direct management of the PDF’s metadata. Using this class, developers can efficiently access and modify the metadata of a PDF document via dedicated getters and setters.

Here are the metadata properties that can be easily managed through provided getters and setters:

- `Producer`
- `CreationDate`
- `Creator`
- `Author`
- `Keywords`
- `Subject`
- `Title`
- `ModifiedDate`

In the provided example, the code modifies a document's metadata by employing methods like `setAuthor`, `setTitle`, `setKeywords`, and `setModifiedDate`, adjusting the respective properties of the author, title, and keywords of the document.

For metadata properties not listed above, developers can use the `getAnyMetadata` and `setAnyMetadata` methods by specifying the property name they wish to modify.

When it comes to modifying security settings, this is accomplished via the `SecurityManager`, which is accessed by invoking `getSecurity` on a `PdfDocument`. This allows the developer to apply the necessary security restrictions to the PDF document.

For a more detailed approach to securing PDFs, Java developers can utilize a `SecurityOptions` object to fine-tune the PDF's security settings.

For additional information about leveraging IronPDF in various coding environments and to further explore its capabilities, check out the [IronPDF Documentation and Features](https://ironpdf.com/technology/html-to-pdf/) or explore more about Iron Software's offerings at [Iron Software's Official Website](https://ironsoftware.com/).