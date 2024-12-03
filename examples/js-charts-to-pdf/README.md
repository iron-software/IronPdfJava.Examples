***Based on <https://ironpdf.com/examples/js-charts-to-pdf/>***

IronPDF is capable of rendering web pages that include charts, graphs, and other complex visual elements crafted with contemporary JavaScript technologies.

IronPDF also integrates WebGL technology, enabling it to effectively handle elements constructed using web canvas through the hardware's graphical capabilities.

IronPDF is compatible with all notable third-party chart libraries, such as:

- C3.js
- D3.js
- Highcharts

Through the `ChromePdfRenderOptions` class, developers can use the `setEnableJavaScript` method to activate JavaScript processing. This is essential for executing internal or external JavaScript necessary for rendering visual content on web pages.

Additionally, the `setRenderDelay` method allows IronPDF to delay the interpretation of a web page’s JavaScript by a defined time in milliseconds post the loading of the DOM. This delay is crucial for capturing web content that only appears several seconds after the initial page load, particularly when dealing with asynchronous JavaScript.

For further reading and additional methods provided by the `ChromePdfRenderOptions`, check out the [JavaScript Charts to PDF Code Example](https://ironpdf.com/java/examples/js-charts-to-pdf/).