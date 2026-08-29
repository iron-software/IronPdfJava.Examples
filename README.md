# IronPdfJava.Examples

Runnable Java examples for [IronPDF for Java](https://ironpdf.com/java/?utm_source=github), a PDF library that converts HTML to PDF with a real Chromium renderer and generates, edits, and extracts PDF content.

## Install

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>2026.8.2</version>
</dependency>
```

## Quickstart

```java
import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
        License.setLicenseKey("YOUR-LICENSE-KEY");

        PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello, PDF!</h1>");
        pdf.saveAs(Paths.get("hello.pdf"));
    }
}
```

That produces a working PDF on the first run. To render from other sources, swap `renderHtmlAsPdf` for `renderUrlAsPdf(url)` or `renderHtmlFileAsPdf(path)`.

IronPDF for Java downloads and starts `IronPdfEngine` on the first API call, so the first run takes longer than the ones after it. `Settings.setLogPath(Paths.get("IronPdfEngine.log"))` puts the engine log somewhere you can read it, and `Settings.setDebug(true)` makes it verbose.

Without a license key, generated PDFs include a watermark.

## What's in this repo

Each folder contains a self-contained Maven project you can open and run:

- `examples/` — focused snippets demonstrating individual features
- `get-started/` — first projects covering license keys, AWS, Azure, Google Cloud, and remote `IronPdfEngine`
- `how-to/` — task-oriented guides for specific PDF operations
- `quickstart/` — an end-to-end project scaffold
- `tutorials/` — longer walkthroughs combining multiple features

## Common tasks covered

- HTML, HTML file, URL, RTF, and image to PDF conversion
- Merging, splitting, and deleting pages from existing PDFs
- Headers, footers, watermarks, backgrounds, and foregrounds
- Digital signatures and PDF security metadata
- Form creation, form filling, and form data extraction
- Text and image extraction, find-and-replace across pages
- Rasterizing pages to images, and printing to a physical printer
- Bookmarks, page orientation, custom paper sizes, and margins
- Compression, Google Fonts, JavaScript charts, and website logins
- Deploying to AWS Lambda, Azure, Google Cloud, and a remote `IronPdfEngine`

## Platform support

Java 8 and above, plus the other JVM languages — Kotlin and Scala. Windows, Linux, Docker, Azure, and AWS. Works in IntelliJ IDEA and Eclipse. See the [documentation](https://ironpdf.com/java/docs/?utm_source=github) for environment-specific notes.

## Documentation and support

- Full documentation: [ironpdf.com/java/docs](https://ironpdf.com/java/docs/?utm_source=github)
- API reference: [ironpdf.com/java/object-reference/api](https://ironpdf.com/java/object-reference/api/?utm_source=github)
- Issues with these examples: file directly on this repository
- Product support: [support@ironsoftware.com](mailto:support@ironsoftware.com)

## About

This repository is maintained by [Iron Software](https://ironsoftware.com/?utm_source=github). IronPDF for Java is a commercial library — see [licensing](https://ironpdf.com/java/licensing/?utm_source=github) for terms and trial details.
