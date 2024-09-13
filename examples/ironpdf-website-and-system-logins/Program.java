
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.headerfooter.TextHeaderFooter;
import com.ironsoftware.ironpdf.render.ChromeHttpLoginCredentials;
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;
import java.io.IOException;
import java.nio.file.Paths;

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