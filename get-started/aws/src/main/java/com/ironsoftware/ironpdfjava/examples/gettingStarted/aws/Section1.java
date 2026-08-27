package com.ironsoftware.ironpdfjava.examples.gettingStarted.aws;

import java.io.IOException;

import com.ironsoftware.ironpdf.Settings;
import java.nio.file.Paths;

public class Section1 {
    public static void run() throws IOException {
            // Setting the working directory for IronPDF engine
            Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
    }
}
