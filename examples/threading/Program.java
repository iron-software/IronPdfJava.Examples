package ironpdfjava.Threading;

import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            using System;
            using System.Collections.Generic;
            using System.Linq;
            using System.Threading.Tasks;
            using IronPdf;
            
            // Instantiate Renderer
            var Renderer = new IronPdf.ChromePdfRenderer();
            
            var htmls = new List<string>() { "<h1>Html#1</h1>", "<h1>Html#2</h1>", "<h1>Html#3</h1>" };
            
            Task<IronPdf.PdfDocument[]> task =
                Task.WhenAll(
                    htmls.Select(html => Renderer.RenderHtmlAsPdfAsync(html)));
            
            List<PdfDocument> pdfDocuments = task.Result.ToList();
            
            // Do something with the pdfDocuments
    }
}
