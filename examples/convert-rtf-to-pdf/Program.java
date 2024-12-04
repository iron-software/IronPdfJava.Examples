package ironpdfjava.ConvertRtfToPdf;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Case 1: Generate a PDF from a string of Rich Text Content
            try {
                String content = "{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1033{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\n" +
                        "{\\*\\generator Riched20 10.0.22621}\\viewkind4\\uc1 \n" +
                        "\\pard\\sa200\\sl276\\slmult1\\b\\f0\\fs160\\lang9 Hello, world!\\par\n" +
                        "}\n" +
                        " ";
                PdfDocument pdf = PdfDocument.renderRtfAsPdf(content);
                pdf.saveAs(Paths.get("assets/rtf_to_pdf.pdf"));
            } catch(IOException exception) {
                exception.printStackTrace();
            }
            
            // Case 2: Generate a PDF from a RTF file located on a filesystem path
            try {
                PdfDocument pdf = PdfDocument.renderRtfFileAsPdf(Paths.get("assets/test.rtf"));
                pdf.saveAs(Paths.get("assets/rtf_to_pdf_2.pdf"));
            } catch(IOException exception) {
                exception.printStackTrace();
            }
    }
}
