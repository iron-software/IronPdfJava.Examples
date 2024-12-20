***Based on <https://ironpdf.com/examples/js-charts-to-pdf/>***

IronPDF is adept at converting web pages with various elements, including charts and graphs designed with cutting-edge JavaScript technologies.

It also has support for WebGL, which enhances IronPDF's ability to process elements created with web canvas using the device's hardware graphics acceleration.

IronPDF is compatible with every major third-party chart library, such as:

- C3.js
- D3.js
- Highcharts

The method `setEnableJavaScript` in the `ChromePdfRenderOptions` class allows developers to activate the processing of JavaScript, whether it's linked internally or externally on a webpage. To ensure IronPDF correctly renders charts and graphics on the page, this property must be set to `true`.

The `setRenderDelay` method delays the JavaScript processing of a web page in IronPDF for a defined time (measured in milliseconds) following the loading of its DOM. This delay is crucial for capturing content that appears on the webpage slightly after the browser has initially completed loading, particularly for asynchronous JavaScript that requires more time to execute.

For more detailed information on additional capabilities of the `ChromePdfRenderOptions` class, visit the [JavaScript Charts to PDF Code Example](https://ironpdf.com/java/examples/js-charts-to-pdf/).