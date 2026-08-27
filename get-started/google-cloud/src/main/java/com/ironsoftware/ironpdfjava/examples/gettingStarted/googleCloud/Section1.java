package com.ironsoftware.ironpdfjava.examples.gettingStarted.googleCloud;

import java.nio.file.Paths;

public class Section1 {
    public static void run() {
            // Set the working directory for the IronPDF Engine
              Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
    }
}
