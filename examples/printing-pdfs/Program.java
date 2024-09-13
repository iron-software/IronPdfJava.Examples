
import com.ironsoftware.ironpdf.PdfDocument;
import java.awt.print.PrinterException;

PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Created with IronPDF!</h1>");
try {
    pdf.print();
} catch(PrinterException exception) {
    System.out.println("Failed to print PDF");
    exception.printStackTrace();
}