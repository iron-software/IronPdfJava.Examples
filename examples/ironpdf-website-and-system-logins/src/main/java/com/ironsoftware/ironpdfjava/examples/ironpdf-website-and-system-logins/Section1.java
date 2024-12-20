package com.ironsoftware.ironpdfjava.examples.ironpdfWebsiteAndSystemLogins;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            PdfDocument.renderUrlAsPdf(restrictedUrl, loginCredentials).saveAs(Paths.get("output.pdf"));
    }
}
