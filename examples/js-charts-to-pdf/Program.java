
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;
import com.ironsoftware.ironpdf.render.CssMediaType;
import java.io.IOException;
import java.nio.file.Paths;

String htmlWithJs = "var htmlWithJs = @\"<!DOCTYPE html>\n" +
        " <html>\n" +
        " <head>\n" +
        " <meta charset='utf-8' />\n" +
        " <title>C3 Bar Chart</title>\n" +
        " </head>\n" +
        " <body>\n" +
        " <div id='chart' style='width: 950px;'></div>\n" +
        " <script src='https://d3js.org/d3.v4.js'></script>\n" +
        " <!-- Load c3.css -->\n" +
        " <link href='https://cdnjs.cloudflare.com/ajax/libs/c3/0.5.4/c3.css' rel='stylesheet'>\n" +
        " <!-- Load d3.js and c3.js -->\n" +
        " <script src='https://cdnjs.cloudflare.com/ajax/libs/c3/0.5.4/c3.js'></script>\n" +
        " <script>\n" +
        " Function.prototype.bind = Function.prototype.bind || function (thisp) {\n" +
        " var fn = this;\n" +
        " return function() {\n" +
        " return fn.apply(thisp, arguments);\n" +
        " };\n" +
        " };\n" +
        " var chart = c3.generate({\n" +
        " bindto: '#chart',\n" +
        " data: {\n" +
        " columns: [\n" +
        " ['data1', 30, 200, 100, 400, 150, 250],\n" +
        " ['data2', 50, 20, 10, 40, 15, 25]\n" +
        " ]\n" +
        " }\n" +
        " });\n" +
        " </script>\n" +
        " </body>\n" +
        " </html>\"";

ChromePdfRenderOptions renderingOptions = new ChromePdfRenderOptions();
renderingOptions.setEnableJavaScript(true);
renderingOptions.setWaitFor(new WaitFor(1000));
renderingOptions.setCssMediaType(CssMediaType.PRINT);

PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlWithJs, renderingOptions);

// Save the PDF
try {
    pdf.saveAs(Paths.get("assets/js_chart.pdf"));
} catch(IOException exception) {
    exception.printStackTrace();
}