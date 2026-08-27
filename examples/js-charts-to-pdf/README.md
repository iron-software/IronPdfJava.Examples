> Full guide: [JS charts to PDF](https://ironpdf.com/examples/js-charts-to-pdf/)

IronPDF has the capability to convert web pages with interactive features such as charts and graphs, constructed using advanced JavaScript frameworks, into PDFs.

IronPDF includes support for WebGL, which allows it to handle elements created using web canvas with the aid of the computer's hardware graphical acceleration.

IronPDF is compatible with a variety of third-party chart libraries as listed below:

- C3.js
- D3.js
- Highcharts

The method `setEnableJavaScript` found on the `ChromePdfRenderOptions` allows developers to activate the handling of both internally and externally linked JavaScript within a webpage. This setting is essential and must be enabled to allow IronPDF to manage JavaScript that is necessary for depicting the charts and visuals on a webpage.

Additionally, the `setRenderDelay` method instructs IronPDF to delay its interpretation of a webpage's JavaScript for a set time period (measured in milliseconds) following the loading of its DOM. This capability ensures that the HTML-to-PDF conversion by IronPDF captures content that might become visible moments after the initial page load, which is crucial when dealing with asynchronous JavaScript operations that require extended execution times.

For more comprehensive details on the capabilities of the `ChromePdfRenderOptions` class, visit the [JavaScript Charts to PDF Code Example](https://ironpdf.com/java/examples/js-charts-to-pdf/).

---

### Converting JavaScript Charts to PDF

1. Integrate IronPDF into your Maven project.
2. Utilize `ChromePdfRenderOptions` to activate JavaScript and adjust the rendering delay/media type settings.
3. Convert HTML content (be it inline, from a file, or a URL) to PDF using `PdfDocument.renderHtmlAsPdf(...)`.
4. Store the generated PDF using `saveAs(...)`.

[Discover the method to Enable JavaScript for PDF Rendering](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html#setEnableJavaScript(boolean))