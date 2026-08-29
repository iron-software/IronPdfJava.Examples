# How to Replace Text in a PDF

> Full guide: [How to Replace Text in a PDF](https://ironpdf.com/how-to/find-replace-text/)


Replacing text within a PDF is highly useful for quickly and accurately making modifications. This functionality is ideal for correcting errors, updating details, or customizing templates for specific purposes. It proves to be especially beneficial for documents that require regular revision or a customized approach.

IronPDF provides a feature to replace text in PDFs, offering an essential tool for developers and professionals looking to automate or personalize PDF documents.

## Replace Text Example

To initiate text replacement, utilize the `replaceText` method. This method accepts three arguments: `PageSelection`, which denotes the page; a string that indicates the old text to be replaced; and the string to replace it with. In the example below, we utilize the `PageSelection.firstPage()` method to target the first page of the PDF, where we replace all occurrences of '.NET6' with '.NET7'. If the old text is not found, a runtime exception will occur.
![Alt text](https://ironpdf.com/static-assets/ironpdf-java/howto/find-replace-text/cannotfindtext.webp)

### Code

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;
import java.io.IOException;

/**
 * Demonstrates replacing text in a PDF
 */
public class App {

    public static void main(String[] args) throws IOException {

        // Activate the license key for IronPDF
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Convert HTML content to a PDF
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>.NET6</h1>");

        // Specify the text to be replaced and the new replacement text
        String oldText = ".NET6";
        String newText = ".NET7";

        // Execute the text replacement on the first page
        pdf.replaceText(PageSelection.firstPage(), oldText, newText);

        // Save the updated PDF
        pdf.saveAs("replaceText.pdf");
    }
}
```

### Output PDF

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/find-replace-text/replaceText.pdf" width="100%" height="400px"></iframe>

<hr>

## Replace Text on Multiple Pages

The `replaceText` method is also used for text replacements across multiple pages. Here, we use the `pageRange` method from the `PageSelection` class with a list of integers indicating the target pages - in this case, the first and third pages.

```java
import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.edit.PageSelection;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates replacing text on multiple pages of a PDF
 */
public class App {

    public static void main(String[] args) throws IOException {

        // Initialize IronPDF license key
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Generate a 3-page PDF from HTML content
        String html = "<p> .NET6 </p>" +
                      "<p> This is 1st Page </p>" +
                      "<div style='page-break-after: always;'></div>" +
                      "<p> This is 2nd Page</p>" +
                      "<div style='page-break-after: always;'></div>" +
                      "<p> .NET6 </p>" +
                      "<p> This is 3rd Page</p>";

        // Convert the HTML into a PDF
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);

        // Set the texts to be replaced and their replacements
        String oldText = ".NET6";
        String newText = ".NET7";

        // Specify the pages for text replacement (first and third)
        List<Integer> pages = Arrays.asList(0, 2);

        // Perform the text replacement on the specified pages
        pdf.replaceText(PageSelection.pageRange(pages), oldText, newText);

        // Save the modified PDF
        pdf.saveAs("replaceTextOnMultiplePages.pdf");
    }
}
```

### Output PDF

<iframe loading="lazy" src="https://ironpdf.com/static-assets/ironpdf-java/howto/find-replace-text/replaceTextOnMultiplePages.pdf" width="100%" height="400px"></iframe>

<hr>

## Explore PageSelection Class

The `PageSelection` class provides methods that enable developers to specify which PDF pages to target for text replacement. Here's an overview of the available methods:

- `allPages`: Selects every page in the PDF.
- `firstPage`: Targets the first page of the PDF.
- `lastPage`: Targets the last page of the PDF.
- `pageRange(int startIndex, int endIndex)`: Defines a range of pages for selection, e.g., from page 1 to page 3 when values are 0 and 2.
- `pageRange(List<Integer> pageList)`: Allows selection of specific pages using a list of page indices, like selecting only the first and third pages.
- `singlePage(int pageIndex)`: Targets a single specified page within the PDF.