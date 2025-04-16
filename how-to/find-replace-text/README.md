# How to Modify Text in a PDF

***Based on <https://ironpdf.com/how-to/find-replace-text/>***


Modifying text within a PDF is a highly efficient way to edit documents quickly and with precision. It’s ideal for correcting errors, updating details, or customizing templates for specific applications. This functionality proves especially useful for documents requiring regular revisions or tailored adaptations.

IronPDF provides a robust text modification feature for PDFs, making it a vital resource for developers and professionals aiming to streamline or personalize PDF documents.

## Example of Text Replacement

The `replaceText` function allows for easy text substitution. This function requires three arguments: `PageSelection`, which indicates the desired page; a string for the old text; and a string for the new text. In this example, we utilize the `PageSelection.firstPage` method to select the document's initial page. Here, we will substitute all appearances of '.NET6' with '.NET7'.

An exception will be thrown during runtime if the text intended for replacement isn't found.
![alt text](https://ironpdf.com/static-assets/ironpdf-java/howto/find-replace-text/cannotfindtext.webp)

### Code

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;

import java.io.IOException;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Rendering HTML content to PDF
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>.NET6</h1>");

        String oldText = ".NET6";
        String newText = ".NET7";

        // Executing text replacement on the first page
        pdf.replaceText(PageSelection.firstPage(), oldText, newText);
        pdf.saveAs("updatedText.pdf");
    }
}
```

All page indexes utilize zero-based indexing.

### Output PDF

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/find-replace-text/replaceText.pdf" width="100%" height="400px"></iframe>

<hr>

## Modifying Text Across Several Pages

For text modifications across multiple pages, we employ the identical `replaceText` function. This round, the `pageRange` method from the **PageSelection** class is applied, specifying an integer array for the pages on which the changes should occur.

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        String html = "<p> .NET6 </p>" +
                      "<p> This is 1st Page </p>" +
                      "<div style = 'page-break-after: always;'></div>" +
                      "<p> This is 2nd Page</p>" +
                      "<div style = 'page-break-after: always;'></div>" +
                      "<p> .NET6 </p>" +
                      "<p> This is 3rd Page</p>";

        PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);

        String oldText = ".NET6";
        String newText = ".NET7";
        // Specifying pages for text replacement
        List<Integer> pages = Arrays.asList(0, 2);

        // Performing text replacement on specified pages
        pdf.replaceText(PageSelection.pageRange(pages), oldText, newText);
        pdf.saveAs("multiPageTextUpdate.pdf");
    }
}
```

### Ouput PDF

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/find-replace-text/replaceTextOnMultiplePages.pdf" width="100%" height="400px"></iframe>

<hr>

## Understanding the PageSelection Class

As demonstrated, the `PageSelection` method is invaluable for denoting specific pages for text replacement. Below is a detailed rundown of its parameters.

The **PageSelection** class is static, thus you do not need to instantiate a new object to utilize its functions.

Here’s a brief overview of the functionalities:

- **allPages**: Selects all pages in the PDF.
- **firstPage**: Targets the first page of the document.
- **lastPage**: Aims at the last page.
- **pageRange​(int startIndex, int endIndex)**: Defines a selection from `startIndex` to `endIndex`. For instance, setting `startIndex = 0` and `endIndex = 2` picks out the first three pages.
- **pageRange​(List<Integer> pageList)**: Determines specific pages using a list, as shown earlier where pages 1 and 3 are selected and page 2 is omitted.
- **singlePage​(int pageIndex)**: Focuses on a singular page based on the index provided.