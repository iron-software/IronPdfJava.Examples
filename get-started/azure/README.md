# Implementing IronPDF for Java in an Azure Function with Docker Deployment

> Full guide: [Implementing IronPDF for Java in an Azure Function with Docker Deployment](https://ironpdf.com/get-started/azure/)


## Key Considerations
- **Docker Deployment**: IronPDF for Java is compatible exclusively with Docker-based deployments.
- **Unsupported Zip Deployment**: As IronPDF necessitates the execution of runtime binaries, Zip deployment methods are not feasible.

## Step-by-Step Guide

1. **Set Up Azure Function**
   Begin by consulting the [Official Microsoft Guide for Setting Up a Function on Linux with Custom Images](https://learn.microsoft.com/en-us/azure/azure-functions/functions-create-function-linux-custom-image):
    - Select `Java` as your programming language.
    - Complete the guide to ensure your application is operational.

2. **Incorporate IronPDF Dependency**
   Update your project’s `pom.xml` with the following dependencies using the most recent `<version>`:

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

   Note: The dependency `ironpdf-engine-linux-x64` is mandatory to facilitate IronPDF functionality within Docker environments.

3. **Develop a `RenderPdf` Function**
   Insert a new function in your `Function.java` to process a URL and produce a PDF:

    ```java
    import com.microsoft.azure.functions.*;
    import com.ironsoftware.ironpdf.PdfDocument;
    import java.util.Optional;

    public class Function {

        /**
         * Azure function to convert a URL into a PDF and return it as an HTTP response.
         * Triggered by an HTTP request, accepts a URL passed as a query parameter.
         */
        @FunctionName("RenderPdf")
        public HttpResponseMessage renderPdf(
                @HttpTrigger(
                        name = "req",
                        methods = {HttpMethod.GET, HttpMethod.POST},
                        authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
                final ExecutionContext context) {
            context.getLogger().info("Java HTTP trigger processed a request. (RenderPdf)");

            // Extract URL from query parameter
            final String url = request.getQueryParameters().get("url");

            // Validate the presence of URL
            if (url == null) {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                        .body("Please include a url on the query string")
                        .build();
            } else {
                try {
                    context.getLogger().info("IronPDF is preparing to process the URL: " + url);

                    // Convert URL to PDF
                    PdfDocument pdfDocument = PdfDocument.renderUrlAsPdf(url);

                    // Retrieve PDF data
                    byte[] content = pdfDocument.getBinaryData();

                    // Send PDF in response
                    return request.createResponseBuilder(HttpStatus.OK)
                            .body(content)
                            .header("Content-Disposition", "attachment; filename='document.pdf'")
                            .build();
                } catch (Exception e) {
                    context.getLogger().severe("PDF rendering failed: " + e.getMessage());
                    return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Failed to generate the PDF from URL.")
                            .build();
                }
            }
        }
    }
    ```

4. **Refine Dockerfile**
   Augment your Dockerfile to include the needed IronPDF Linux packages. For instance, using the base Docker image from `Debian 11`:

   ```dockerfile
   RUN apt update \
   && apt install -y libgdiplus libxkbcommon-x11-0 libc6 libc6-dev libgtk2.0-0 libnss3 \
                     libatk-bridge2.0-0 libx11-xcb1 libxcb-dri3-0 libdrm-common libgbm1 \
                     libasound2 libxrender1 libfontconfig1 libxshmfence1
   RUN apt-get install -y xvfb libva-dev libgdiplus
   ```

   For additional Linux configurations, consult the [IronPDF Linux Installation Guide](https://ironpdf.com/how-to/linux/).

5. **Redeploy to Azure**
   Proceed with the following sequence:
   - Build and package: `mvn clean package`
   - Construct Docker image: `docker build --tag <DOCKER_ID>/azurefunctionsimage:v1.0.0 .`
   - Publish Docker image: `docker push <DOCKER_ID>/azurefunctionsimage:v1.0.0`
   - Apply updates to the Azure function: 
      ```bash
      az functionapp create --name <APP_NAME> --storage-account <STORAGE_NAME> \
                            --resource-group AzureFunctionsContainers-rg --plan myPremiumPlan \
                            --deployment-container-image-name <DOCKER_ID>/azurefunctionsimage:v1.0.0
      ```

6. **Utilize IronPDF**
   - Activate the function here: `https://<APP_NAME>.azurewebsites.net/api/RenderPdf?url=https://www.google.com`
   - Initial requests may experience delays or issues during initialization; subsequent uses will stabilize in performance.