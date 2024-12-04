package ironpdfjava.MergePdfs;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            String htmlA = "<p> [PDF_A] </p>"
                    + "<p> [PDF_A] 1st Page </p>"
                    + "<div style = 'page-break-after: always;' ></div>"
                    + "<p> [PDF_A] 2nd Page</p>";
            String htmlB = "<p> [PDF_B] </p>"
                    + "<p> [PDF_B] 1st Page </p>"
                    + "<div style = 'page-break-after: always;' ></div>"
                    + "<p> [PDF_B] 2nd Page</p>";
            
            PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
            PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
            PdfDocument merged = PdfDocument.merge(pdfA, pdfB);
            
            merged.saveAs(Paths.get("assets/merged.pdf"));
    }
}
