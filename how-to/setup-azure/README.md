# Deploying IronPDF for Java on Azure Functions Using Docker

***Based on <https://ironpdf.com/how-to/setup-azure/>***


<small>
   <ul>
      <li>IronPDF for Java is only supported when deployed through Docker.</li>
      <li>Zip deployment isn't supported due to IronPDF's runtime binary execution requirements.</li>
   </ul>
</small>

1. Start by following the [Microsoft's Comprehensive Guide for Setting Up Functions on Linux with a Custom Image](https://learn.microsoft.com/en-us/azure/azure-functions/functions-create-function-linux-custom-image)
    * When selecting a programming language, choose `Java`
    * Continue with the guide to make sure your application is operational.
2. Incorporate the IronPDF dependency:
   * Insert the following into your project's pom file, making sure to replace `<version>` with the latest version:

    ```xml
    <dependencies>
        <dependency>
                <groupId>com.ironsoftware</groupId>
                <artifactId>ironpdf</artifactId>
                <version>2022.xx.x</version>
            </dependency>
            <dependency>
                <groupId>com.ironsoftware</groupId>
                <artifactId>ironpdf-engine-linux-x64</artifactId>
                <version>2022.xx.x</version>
            </dependency>
        </dependencies>
    ```

   * Note: It is essential to have `ironpdf-engine-linux` for running IronPDF within Docker.
3. Create a `RenderPdf` function:
   * Add this new function inside your `Function.java` file
   * This function will take a URL input and output a PDF.

    ```java
    public class Function {
    
    //...
    @FunctionName("RenderPdf")
    public HttpResponseMessage renderPdf(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Processing Java HTTP trigger. (RenderPdf)");
        // Fetch query parameter
        final String url = request.getQueryParameters().get("url");
        if (url == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("URL parameter is required on the query string").build();
        } else {
            context.getLogger().info("Attempting to render URL with IronPDF: " + url);
            PdfDocument pdfDocument = com.ironsoftware.ironpdf.PdfDocument.renderUrlAsPdf(url);
            byte [] content = pdfDocument.getBinaryData();
            return request.createResponseBuilder(HttpStatus.OK)
                    .body(content)
                    .header("Content-Disposition", "attachment; filename=result_with_ironpdf.pdf")
                    .build();
        }
    }
    }
    ```

4. Modify the Dockerfile:
   * Install necessary IronPDF Linux packages. Start with the base Docker image `mcr.microsoft.com/azure-functions/java:4-java$JAVA_VERSION-build` which is based on `Debian 11`.
   Incorporate these packages into your Docker configuration:

   ```dockerfile
   RUN apt update \
   && apt install -y libgdiplus libxkbcommon-x11-0 libc6 libc6-dev libgtk2.0-0 libnss3 libatk-bridge2.0-0 libx11-xcb1 libxcb-dri3-0 libdrm-common libgbm1 libasound2 libxrender1 libfontconfig1 libxshmfence1
   RUN apt-get install -y xvfb libva-dev libgdiplus
   ```

   * For guidance on other Linux variants, refer to the [IronPDF Linux Setup Manual](https://ironpdf.com/how-to/linux/)
5. Redeploy your function to Azure:
   1. Compile and package with `mvn clean package`
   2. Create a Docker image: `docker build --tag <DOCKER_ID>/azurefunctionsimage:v1.0.0 .`
   3. Upload your Docker image with: `docker push <DOCKER_ID>/azurefunctionsimage:v1.0.0`
   4. Update your Azure function configuration: `az functionapp create --name <APP_NAME> --storage-account <STORAGE_NAME> --resource-group AzureFunctionsContainers-rg --plan myPremiumPlan --deployment-container-image-name <DOCKER_ID>/azurefunctionsimage:v1.0.0`
6. Utilize IronPDF:
   * Access the function via: `https://<APP_NAME>.azurewebsites.net/api/RenderPdf?url=https://www.google.com`
   * Note: Initial operations might slow down or fail as the setup stabilizes, but subsequent uses should run smoothly.