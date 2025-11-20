package com.ironsoftware.ironpdfjava.examples.getStarted.aws;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            // Setting the working directory for IronPDF engine
            Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
    }
}
