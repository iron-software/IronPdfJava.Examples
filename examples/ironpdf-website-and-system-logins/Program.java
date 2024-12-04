package ironpdfjava.IronpdfWebsiteAndSystemLogins;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            String url = "http://localhost:51169/Invoice";
            
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
            renderOptions.setMarginTop(50);
            renderOptions.setMarginBottom(50);
            
            // Set Login Credentials to bypass basic authentication
            ChromeHttpLoginCredentials loginCredentials = new ChromeHttpLoginCredentials();
            loginCredentials.setNetworkUsername("testUser");
            loginCredentials.setNetworkPassword("testPassword");
            
            try {
                PdfDocument webpage = PdfDocument.renderUrlAsPdf(url, loginCredentials);
                TextHeaderFooter textHeader = new TextHeaderFooter();
                textHeader.setCenterText("{pdf-title");
                textHeader.setDrawDividerLine(true);
                textHeader.setFontSize(16);
                webpage.addTextHeader(textHeader);
            
                TextHeaderFooter textFooter = new TextHeaderFooter();
                textFooter.setLeftText("{date} {time}");
                textFooter.setRightText("Page {page} of {total-pages}");
                textFooter.setDrawDividerLine(true);
                textFooter.setFontSize(14);
                webpage.addTextFooter(textFooter);
                
                webpage.saveAs(Paths.get("assets/UrlToPdfExample.pdf"));
            } catch(IOException e) {
                e.printStackTrace();
            }
    }
}
