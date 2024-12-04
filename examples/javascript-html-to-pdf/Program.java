package ironpdfjava.JavascriptHtmlToPdf;

import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            using IronPdf;
            
            var htmlWithJavaScript = @"
                    <h1>This is HTML</h1>
                    <script>
                        document.write('<h1>This is JavaScript</h1>');
                    </script>";
            
            // Instantiate Renderer
            var Renderer = new IronPdf.ChromePdfRenderer();
            
            // Enable JavaScript in our RenderingOptions
            Renderer.RenderingOptions.EnableJavaScript = true;
            Renderer.RenderingOptions.RenderDelay = 100;
            
            var pdfJavaScript = Renderer.RenderHtmlAsPdf(htmlWithJavaScript);
            
            // Export to a file or Stream
            pdfJavaScript.SaveAs("javascript-in-html.pdf");
    }
}
