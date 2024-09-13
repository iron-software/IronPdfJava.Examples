IronPDF gives developers the capability to incorporate images directly into PDFs by embedding them into HTML strings instead of using them as external resources:

- Image Files
- `System.Drawing.Image`
- `System.Drawing.Bitmap`

This method is beneficial as it eliminates the need to load external assets when converting HTML to PDF. This can enhance performance and facilitates the storage of entire rendering tasks in non-file system locations, such as strings or databases.