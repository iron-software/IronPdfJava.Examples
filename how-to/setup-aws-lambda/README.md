# Deploying IronPDF for Java on AWS Lambda

***Based on <https://ironpdf.com/how-to/setup-aws-lambda/>***


## Essential Configuration Settings

- **Zip Deployment**: Not supported because IronPDF requires dynamic execution of binaries.
- **Package Type**: Must be set to `Image` as IronPDF for Java demands Docker for deployment.
- **Base Docker Image**: Use the `AmazonLinux2` base image.
- **PDF Engine Working Directory**: Specify the IronPDF engine working directory to a writable temp directory:

```java
Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
```

This is necessary as `/tmp/` is the only write-permitted path in the AWS Lambda execution environment.

- **Temporary Storage Space**: Increase the default `/tmp` directory size from 512 MB to at least 1024 MB.
- **Dependency Addition**: Ensure the inclusion of IronPDF's engine dependency in your project:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>2022.xx.x</version>
</dependency>
```

- **Lambda Execution Time**: Set the Lambda function timeout to 330 seconds to accommodate initialization delays.
- **Lambda Memory Allocation**: Allocate a minimum of 1024 MB of memory to the Lambda function.

## Initializing Projects with the AWS Toolkit for IntelliJ IDEA

### Installation Prerequisites:

1. Download and install IntelliJ IDEA from [IntelliJ IDEA Official Page](https://www.jetbrains.com/idea/download/).
2. Set up the AWS Toolkit for JetBrains as per the instructions [here](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/setup-toolkit.html).
3. Install the SAM CLI for managing serverless applications by following these [guidelines](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html).
4. Install Docker Community Edition from [Docker Hub](https://hub.docker.com/search/?type=edition&offering=community).
5. For local development, download Java SE Development Kit 8 from [Oracle's JDK8 Downloads](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and follow [Maven Installation Guidelines](https://maven.apache.org/install.html).

### Project Setup and Configuration:

1. Start a new project via `File` -> `New` -> `Project...`.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws1.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws1.webp" alt="How to Run IronPDF for Java in AWS Lambda - Figure 1" class="img-responsive add-shadow"></a>
        <p class="content__image-caption"></p>
	</div>
</div>

2. Configure the following settings for your AWS Lambda:
    * **Package Type**: `Image`
    * **Runtime**: Either `java8` or `java11`
    * **Project Template**: `Maven`

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws2.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws2.webp" alt="How to Run IronPDF for Java in AWS Lambda - Figure 2" class="img-responsive add-shadow"></a>
        <p class="content__image-caption"></p>
	</div>
</div>

3. Extend your Maven `pom.xml` file to include these necessary dependencies:

```xml
<!-- Various dependencies ranging from logging to network protocols to augment IronPDF's functionality -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.3</version>
</dependency>
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

4. Modify your request handling `handleRequest` method in Java to render and manage PDFs effectively:

```java
import com.ironsoftware.ironpdf.*;
public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Settings.setDebug(true); // Optionally enable detailed logging
        try {
            context.getLogger().log("Starting PDF rendering.");
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.example.com");
            context.getLogger().log("PDF rendering successful.");
            pdf.saveAs("/tmp/output.pdf");
            // After saving you might wish to perform further actions, e.g., uploading the PDF to AWS S3.
            return generateSuccessResponse("PDF processing completed successfully.");
        } catch (Exception e) {
            return generateErrorResponse(e.getMessage());
        }
    }

private APIGatewayProxyResponseEvent generateSuccessResponse(String message) {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    return new APIGatewayProxyResponseEvent()
            .withHeaders(headers)
            .withStatusCode(200)
            .withBody(message);
}

private APIGatewayProxyResponseEvent generateErrorResponse(String errorMessage) {
    return new APIGatewayProxyResponseEvent()
            .withBody("{ Error: " + errorMessage + " }")
            .withStatusCode(500);
}
```

5. Configure global settings in your `template.yaml`:

```yaml
Globals:
  Function:
    Timeout: 400
    MemorySize: 2048
    EphemeralStorage:
      Size: 1024
# Maintain these settings to ensure optimal function performance.

***Based on <https://ironpdf.com/how-to/setup-aws-lambda/>***

```

6. Update your Dockerfile to ensure compatibility with AWS environments, focused on supporting graphical operations in AWS Lambda:

```Dockerfile
FROM public.ecr.aws/sam/build-java8.al2:latest as build-layer
# Setup work environment and install necessary packages for IronPDF and Java operation.

***Based on <https://ironpdf.com/how-to/setup-aws-lambda/>***

# (Detailed Dockerfile content continues...)

***Based on <https://ironpdf.com/how-to/setup-aws-lambda/>***

```

7. Build your SAM application using:

```bash
sam build -u
```

8. Deploy the application with a guided process:

```bash
sam deploy --guided
```

9. Congratulations! Your IronPDF integration into AWS Lambda is now operational. Verify its functionality at [Access AWS Lambda Console](https://console.aws.amazon.com/lambda/home).