package com.ironsoftware.ironpdfjava.examples.howTo.setupAwsLambda;

import com.ironsoftware.ironpdf.*;
import com.ironsoftware.ironpdf.*;

public class Section2 {
    public static void run() {
            public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
                    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
                    Settings.setDebug(true); //optional
                    Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/")); //requried!
                    try {
                        context.getLogger().log("RENDER PDF");
                        PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.google.com");
                        context.getLogger().log("RENDER PDF SUCCESS");
                        pdf.saveAs("/tmp/my-first-pdf.pdf");
                        //Done! Now you can do anything with the pdf such as upload this pdf to S3.
                        //return something..
                        Map<String, String> headers = new HashMap<>();
                        headers.put("Content-Type", "application/json");
                        headers.put("X-Custom-Header", "application/json");
                        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                                .withHeaders(headers);
                        return response
                                .withStatusCode(200)
                                .withBody("ENJOY IRON-PDF!");
                    } catch (Exception e) {
                        return response
                                .withBody("{" + e.getMessage() + "}")
                                .withStatusCode(500);
                    }
                }
    }
}
