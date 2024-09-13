# Implementing IronPDF for Java in AWS Lambda

## Crucial Configuration Settings

- Deployment via Zip is not feasible as IronPDF necessitates running executables during runtime.
- Set `PackageType` to `Image` to accommodate IronPDF for Java's Docker-only deployment requirement.
- Utilize the `AmazonLinux2` Docker image for consistency.
- Define the IronPDF working directory with a specific setting:

```java
Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
```

This setting is mandatory because AWS only permits execution within the `/tmp` path.

- Expand the `/tmp` storage space from its standard 512 MB to at least 1024 MB.
- Integrate the `ironpdf-engine-linux-x64` package into your project:

```xml
 <dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>2022.xx.x</version>
</dependency>
```

- Extend the Lambda function timeout to 330 seconds to account for potential delays in startup.
- Enhance the Lambda memory allocation to a minimum of 1024 MB.

## Setting Up with AWS Toolkit for IntelliJ IDEA (AWS SAM)

1. Download Necessary Tools:
    * IntelliJ IDEA - [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
    * AWS Toolkit - [AWS Toolkit Setup Guide](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/setup-toolkit.html)
    * SAM CLI - [Install SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)
    * Docker - [Download Docker Community Edition](https://hub.docker.com/search/?type=edition&offering=community)

    Additional requirements for local testing include:
    * Java8 - [Download Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * Maven - [Download Maven](https://maven.apache.org/install.html)

2. Initiate Project:
   Navigate in IntelliJ IDEA via `File` -> `New` -> `Project...`

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws1.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws1.webp" alt="How to Run IronPDF for Java in AWS Lambda - Figure 1" class="img-responsive add-shadow"></a>
	</div>
</div>

3. Configuration Setup:
    * Package Type : `Image`
    * Runtime : `java8` or `java11`
    * SAM Template : `Maven`

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws2.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws2.webp" alt="Implementation in AWS Lambda - Figure 2" class="img-responsive add-shadow"></a>
	</div>
</div>

4. Add the following Maven dependencies in your `pom.xml`:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.3</version>
</dependency>

<!-- Repeat IronPDF dependency and other critical libraries -->
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>2022.11.1</version>
</dependency>

<dependency>
    <groupId>io.perfmark</groupId>
    <artifactId>perfmark-api</artifactId>
    <version>0.26.0</version>
</dependency>

<dependency>
    <groupId>io.grpc</groupId>
    <artifactId>grpc-okhttp</artifactId>
    <version>1.50.2</version>
</dependency>

<dependency>
    <groupId>io.grpc</groupId>
    <artifactId>grpc-netty-shaded</artifactId>
    <version>1.50.2</version>
</dependency>
```

5. Modify the `handleRequest` method in `App.java` as shown:

```java
import com.ironsoftware.ironpdf.*;
public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
    Settings.setDebug(true); // Optional for debugging
    Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/")); // Mandatory setting
    try {
        context.getLogger().log("STARTING PDF RENDERING");
        PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.google.com");
        context.getLogger().log("PDF RENDERING COMPLETED");
        pdf.saveAs("/tmp/my-first-pdf.pdf");
        // PDF processing completed, ready for further actions like S3 upload.
        
        // Configure response headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        
        response.setHeaders(headers);
        response.setStatusCode(200);
        return response.withBody("PDF RENDER SUCCESS");
    } catch (Exception e) {
        response.setStatusCode(500);
        return response.withBody("ERROR: " + e.getMessage());
    }
}
```

6. Update your `template.yaml` configurations under Globals for function-specific settings:

```yaml
Globals:
  Function:
    Timeout: 400
    MemorySize: 2048
    EphemeralStorage:
      Size: 1024
# Keep other configurations unchanged    
```

7. Modify your Dockerfile accordingly:

- Note: Use `java8.al2` image for Java8 as it requires `AmazonLinux2`. `java8` uses older Amazon Linux version.

```Dockerfile
FROM public.ecr.aws/sam/build-java8.al2:latest as build-image
# Define work directory, add source and configuration files
```

8. Build using the following command:

```bash
sam build -u
```

9. Deploy your application with:

```bash
sam deploy --guided
```

10. Final Step: Enjoy the functionality of IronPDF on AWS Lambda! Visit your function at: [AWS Lambda Console](https://console.aws.amazon.com/lambda/home)