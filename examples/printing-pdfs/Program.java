package ironpdfjava.PrintingPdfs;

import java.awt.print.PrinterException;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Created with IronPDF!</h1>");
            try {
                pdf.print();
            } catch(PrinterException exception) {
                System.out.println("Failed to print PDF");
                exception.printStackTrace();
            }
    }
}
