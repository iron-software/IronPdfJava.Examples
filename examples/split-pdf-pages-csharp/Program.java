package ironpdfjava.SplitPdfPagesCsharp;

import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            using IronPdf;
            
            var html = @"<p> Hello Iron </p>
                            <p> This is 1st Page </p>
                            <div style = 'page-break-after: always;' ></div>
                            <p> This is 2nd Page</p>
                            <div style = 'page-break-after: always;' ></div>
                            <p> This is 3rd Page</p>";
            
            
            var Renderer = new IronPdf.ChromePdfRenderer();
            var pdfdoc = Renderer.RenderHtmlAsPdf(html);
            
            //take the first page
            var pdfdoc_page1 = pdfdoc.CopyPage(0);
            pdfdoc_page1.SaveAs("Spli1.pdf");
            
            //take the pages 2 & 3
            var pdfdoc_page2_3 = pdfdoc.CopyPages(1, 2);
            pdfdoc_page2_3.SaveAs("Spli2.pdf");
    }
}
