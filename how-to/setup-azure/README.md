# Deploying IronPDF for Java in an Azure Function

***Based on <https://ironpdf.com/how-to/setup-azure/>***


In this guide, we'll cover the steps to deploy IronPDF for Java in an Azure environment, particularly focusing on the use of Docker containers, as IronPDF for Java exclusively supports this deployment method.

<small>
<ul>
<li>Only Docker deployment is supported for IronPDF for Java.</li>
<li>Zip Deployment is not supported because **IronPDF necessitates the ability to run binaries during runtime.**</li>
</ul>
</small>

1. Begin by following the [Microsoft Official Guide for Creating Function on Linux Using Custom Image](https://learn.microsoft.com/en-us/azure/azure-functions/functions-create-function-linux-custom-image).
   - Choose `Java` as your programming language.
   - Continue with the guide until your application is operational.
2. Integrate IronPDF into your project
   - Incorporate the following dependencies into your `pom.xml` using the latest `<version>`:

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

    - **Note**: It's crucial to include `ironpdf-engine-linux` when deploying IronPDF with Docker.
3. Create a `RenderPdf` function
   - Add this function to `Function.java` to process incoming requests, converting a specified URL to a PDF.

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
            context.getLogger().info("Java HTTP trigger processed a request. (RenderPdf)");
            // Retrieve URL from query parameter
            final String url = request.getQueryParameters().get("url");
            if (url == null) {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please provide a url in the query string").build();
            } else {
                context.getLogger().info("IronPDF is rendering URL: " + url);
                PdfDocument pdfDocument = com.ironsoftware.ironpdf.PdfDocument.renderUrlAsPdf(url);
                byte[] content = pdfDocument.getBinaryData();
                return request.createResponseBuilder(HttpStatus.OK)
                        .body(content)
                        .header("Content-Disposition", "attachment; filename=result_pdf.pdf")
                        .build();
            }
        }
    }
    ```

4. Modify your Dockerfile
   - Ensure the installation of necessary packages for IronPDF on Linux. Here’s an update using `Debian 11` as the base image:

   ```dockerfile
   RUN apt update \
   && apt install -y libgdiplus libxkbcommon-x11-0 libc6 libc6-dev libgtk2.0-0 libnss3 libatk-bridge2.0-0 libx11-xcb1 libxcb-dri3-0 libdrm-common libgbm1 libasound2 libxrender1 libfontconfig1 libxshmfence1
   RUN apt-get install -y xvfb libva-dev libgdiplus
   ```

   - For other Linux distributions, please refer to the [IronPDF Linux Installation Guide](https://ironpdf.com/how-to/linux/).
5. Redeploy your Azure function
   1. Compile and package your application using `mvn clean package`.
   2. Construct your Docker image, for example, `docker build --tag <DOCKER_ID>/azurefunctionsimage:v1.0.0 .`.
   3. Upload your Docker image, for example, `docker push <DOCKER_ID>/azurefunctionsimage:v1.0.0`.
   4. Update your Azure function with `az functionapp create --name <APP_NAME> --storage-account <STORAGE_NAME> --resource-group AzureFunctionsContainers-rg --plan myPremiumPlan --deployment-container-image-name <DOCKER_ID>/azurefunctionsimage:v1.0.0`.
6. Using IronPDF
   - Trigger your function using the URL: `https://<APP_NAME>.azurewebsites.net/api/RenderPdf?url=https://www.google.com`
   - Note: The initial request might be slow or require a retry as the function initializes. Subsequent requests should perform better.