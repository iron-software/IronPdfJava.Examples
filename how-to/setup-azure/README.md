# Deploying IronPDF for Java in an Azure Function

<small>
    <ul>
        <li>IronPDF for Java is tailored for Docker deployments.</li>
        <li>Zip Deployment is not compatible, as <strong>IronPDF needs to run binaries during execution.</strong></li>
    </ul>
</small>

1. Begin by consulting this Microsoft Official tutorial:
    * [https://learn.microsoft.com/en-us/azure/azure-functions/functions-create-function-linux-custom-image](https://learn.microsoft.com/en-us/azure/azure-functions/functions-create-function-linux-custom-image)
    * Choose `Java` for the programming language.
    * Proceed with the steps until your application is fully operational.
2. Include the IronPDF dependency in your project:
   * Insert the following entries in your `pom.xml` file, updating the `<version>` to the latest:

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

    * Important: The `ironpdf-engine-linux` library is **essential** for running IronPDF on Docker.
3. Implement a `RenderPdf` function:
   * Create a new method in `Function.java` that will process a URL and deliver a PDF document.

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
        context.getLogger().info("Java HTTP trigger processed a request for PDF rendering.");
        // Retrieve the URL parameter
        final String url = request.getQueryParameters().get("url");
        if (url == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("URL parameter is missing in the query string.").build();
        } else {
            context.getLogger().info("IronPDF is attempting to render the URL: " + url);
            PdfDocument pdfDocument = com.ironsoftware.ironpdf.PdfDocument.renderUrlAsPdf(url);
            byte [] content = pdfDocument.getBinaryData();
            return request.createResponseBuilder(HttpStatus.OK)
                    .body(content)
                    .header("Content-Disposition", "attachment; filename=generated_pdf.pdf")
                    .build();
        }
    }
    }
    ```

4. Modify the Dockerfile:
   * Include necessary packages for IronPDF in Linux, targeting `Debian 11` which is used in the base Docker image `mcr.microsoft.com/azure-functions/java:4-java$JAVA_VERSION-build`.

   ```dockerfile
   RUN apt update \
   && apt install -y libgdiplus libxkbcommon-x11-0 libc6 libc6-dev libgtk2.0-0 libnss3 libatk-bridge2.0-0 libx11-xcb1 libxcb-dri3-0 libdrm-common libgbm1 libasound2 libxrender1 libfontconfig1 libxshmfence1
   RUN apt-get install -y xvfb libva-dev libgdiplus
   ```

   * For instructions on other Linux distributions, visit [https://ironpdf.com/how-to/linux/](https://ironpdf.com/how-to/linux/)
5. Redeploy your Azure function:
   1. Compile and package your function: `mvn clean package`
   2. Build the Docker image: `docker build --tag <DOCKER_ID>/azurefunctionsimage:v1.0.0 .`
   3. Upload the Docker image: `docker push <DOCKER_ID>/azurefunctionsimage:v1.0.0`
   4. Launch the Azure function: `az functionapp create --name <APP_NAME> --storage-account <STORAGE_NAME> --resource-group AzureFunctionsContainers-rg --plan myPremiumPlan --deployment-container-image-name <DOCKER_ID>/azurefunctionsimage:v1.0.0`
6. Utilize IronPDF:
   * Invoke the function via: `https://<APP_NAME>.azurewebsites.net/api/RenderPdf?url=https://www.google.com`
   * Note: The initial function invocation may be slow or falter as it stabilizes, but subsequent uses should operate smoothly.