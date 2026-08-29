package com.ironsoftware.ironpdfjava.examples.gettingStarted.useIronpdfengine;

import com.ironsoftware.ironpdf.Settings;

public class Section2 {
    public static void run() {
            // Set the host and port for a remote IronPdfEngine connection
            com.ironsoftware.ironpdf.Settings.setIronPdfEngineHost("123.456.7.8");
            com.ironsoftware.ironpdf.Settings.setIronPdfEnginePort(33350);
    }
}
