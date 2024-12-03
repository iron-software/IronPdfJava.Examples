# Running IronPDF for Java on AWS Lambda

***Based on <https://ironpdf.com/how-to/setup-aws-lambda/>***


## Essential Configuration Instructions

- Zip deployment is currently unsupported due to IronPDF's requirement for runtime binary execution.
- The `PackageType` should be set to `Image` to accommodate IronPDF for Java's need for Docker deployment.
- Utilize the `AmazonLinux2` Docker image.
- Specify IronPdfEngine's working directory as follows:

```java
Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
```

It's crucial as `/tmp/` is the sole permitted path for the execution environment on AWS.

- Increase the `/tmp` storage size; the default is 512 MB. Adjust it to a minimum of 1024 MB.
- Implement `ironpdf-engine-linux-x64` in your project dependencies with:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>2022.xx.x</version>
</dependency>
```

- Adjust the AWS Lambda timeout setting to 330 seconds as startup times can be slow.
- The Lambda function should have a memory allocation of at least 1024 MB.

## Getting Started with AWS Toolkit for IntelliJ IDEA (AWS SAM)

1. **Installation of Required Tools:**
   
   - IntelliJ IDEA - [Download from here](https://www.jetbrains.com/idea/download/)
   - AWS Toolkit - [Configure AWS Toolkit for JetBrains](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/setup-toolkit.html)
   - SAM CLI - [Get the SAM CLI for Serverless](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)
   - Docker - [Download Docker Community Edition](https://hub.docker.com/search/?type=edition&offering=community)

    For local testing, you might need:
    - Java SDK 8 - [Download Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    - Maven - [Maven Installation Guidelines](https://maven.apache.org/install.html)

2. **Create a New Project:**
   Navigate through `File` -> `New` -> `Project...`.

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws1.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws1.webp" alt="Running IronPDF for Java in AWS Lambda - Figure 1" class="img-responsive add-shadow"></a>
	</div>
</div>

3. **Configuration Steps:**
   - Package Type: `Image`
   - Runtime: Use either `java8` or `java11`
   - Project Template: `Maven`

<div class="content-img-align-center">
	<div class="center-image-wrapper">
		<a rel="nofollow" href="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws2.webp" target="_blank"><img src="https://ironpdf.com/static-assets/ironpdf-java/howto/aws-lamda/aws2.webp" alt="Running IronPDF for Java in AWS Lambda - Figure 2" class="img-responsive add-shadow"></a>
	</div>
</div>

4. **Include Necessary Dependencies in Your `pom.xml`:**

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.3</version>
</dependency>
```
(A series of other dependencies, including IronPDF's, should be added here per the original provided listing.)

5. **Adjust the `handleRequest` Method in `App.java`:**

```java
import com.ironsoftware.ironpdf.*;
public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
    Settings.setDebug(true); // Optional but helpful for debugging
    Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/")); // Required
    try {
        context.getLogger().log("STARTING PDF RENDERING");
        PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.example.com");
        context.getLogger().log("PDF RENDERING SUCCESSFUL");
        pdf.saveAs("/tmp/your-first-pdf.pdf");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return response
                .withHeaders(headers)
                .withStatusCode(200)
                .withBody("SUCCESS WITH IRONPDF!");
    } catch (Exception e) {
        return response
                .withBody("ERROR: " + e.getMessage())
                .withStatusCode(500);
    }
}
```

6. **Lambda Configuration in `template.yaml`:**

```yaml
Globals:
  Function:
    Timeout: 400
    MemorySize: 2048
    EphemeralStorage:
      Size: 1024
#keep existing config settings    
```

7. **Update Your Dockerfile for Java 8 (AmazonLinux2 Image):**
(The original steps for modifying the Dockerfile remain unchanged.)

8. **Build the Application:**

```bash
sam build --use-container
```

9. **Deploy the Project:**

```bash
sam deploy --guided
```

10. **Enjoy Deploying IronPDF on AWS Lambda!**
   Check out your function at: [AWS Lambda Console](https://console.aws.amazon.com/lambda/home)