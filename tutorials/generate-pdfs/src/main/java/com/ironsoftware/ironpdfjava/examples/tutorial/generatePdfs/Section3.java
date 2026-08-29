package com.ironsoftware.ironpdfjava.examples.tutorial.generatePdfs;

import com.ironsoftware.ironpdf.Settings;
import java.nio.file.Paths;

public class Section3 {
    public static void run() {
            // Set a log path
            Settings.setLogPath(Paths.get("IronPdfEngine.log"));
    }
}
