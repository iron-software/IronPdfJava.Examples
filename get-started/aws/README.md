# Deploying IronPDF for Java on AWS Lambda

> Full guide: [Deploying IronPDF for Java on AWS Lambda](https://ironpdf.com/get-started/aws/)


## Essential Configuration Details

* **Compressed deployments via Zip are not supported** as IronPDF necessitates binary execution at runtime.
* The `PackageType` must be set to `Image` to enable Docker deployment for IronPDF for Java.
* Utilize an `AmazonLinux2` Docker base image.
* Configure the IronPdfEngineWorkingDirectory as shown:

```java
import com.ironsoftware.ironpdf.Settings;
import java.nio.file.Paths;

// Setting IronPDF engine's working directory
Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
```

**Note:** This setup is mandatory due to AWS enforced execution environment constraints.

* Expand the `/tmp` storage size to a minimum of 1024 MB from its default 512 MB.
* Incorporate `ironpdf-engine-linux-x64` into your project:

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>2022.xx.x</version>
</dependency>
```

* Adjust the Lambda timeout setting to 330 seconds to compensate for initialization delays.
* Increase the Lambda memory allocation to a minimum of 1024 MB.

## Initial Setup using AWS Toolkit for IntelliJ IDEA (AWS SAM)

1. **Installation prerequisites:**
    * Download IntelliJ IDEA from [here](https://www.jetbrains.com/idea/download/).
    * Set up the AWS Toolkit as described [here](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/setup-toolkit.html).
    * Install the SAM CLI following these [instructions](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html).
    * Download Docker Community Edition [here](https://hub.docker.com/search/?type=edition&offering=community).

    **For local testing purposes:**
    * Java SE Development Kit 8 is available [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
    * Installation instructions for Maven can be found [here](https://maven.apache.org/install.html).

2. **Project Creation:** Navigate via `File` -> `New` -> `Project...`.

![AWS Lambda Project Creation](https://ironpdf.com/static-assets/ironpdf-java/howto/aws1.webp)

3. **Configure the Project:**
    * Set Package Type to `Image`.
    * Choose runtime as either `java8` or `java11`.
    * Opt for a `Maven` SAM Template.

![AWS Lambda Configuration Setup](https://ironpdf.com/static-assets/ironpdf-java/howto/aws2.webp)

4. **Insert these dependencies into your `pom.xml`:**

```xml
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

5. **Update the `handleRequest` method in `App.java` to:**

```java
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.Settings;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// A function in AWS Lambda to create a PDF from a URL using IronPDF.
public class App {
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        
        // Optionally enable debugging for IronPDF
        Settings.setDebug(true);
        
        // Define the required IronPDF engine working directory
        Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
        
        try {
            context.getLogger().log("START PDF RENDERING");
            
            // Generate the PDF from a URL
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.google.com");
            
            context.getLogger().log("PDF RENDERING COMPLETED");
            
            // Save the PDF locally
            pdf.saveAs("/tmp/my-first-pdf.pdf");
            
            // Prepare HTTP response headers
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("X-Custom-Header", "application/json");
            
            // Sending the response with success status
            return response
                    .withHeaders(headers)
                    .withStatusCode(200)
                    .withBody("PDF GENERATION SUCCESSFUL");
                    
        } catch (Exception e) {
            // Handle exceptions by sending error response
            return response
                    .withBody("ERROR: " + e.getMessage())
                    .withStatusCode(500);
        }
    }
}
```

6. **Adjust Lambda settings in the `template.yaml`:**

```yaml
Globals:
  Function:
    Timeout: 400
    MemorySize: 2048
    EphemeralStorage:
      Size: 1024
# Preserve other configuration as is

```

7. **Revise the Dockerfile:**
* Note: For Java 8, it is recommended to use `java8.al2` images to leverage `AmazonLinux2`.

```dockerfile
FROM public.ecr.aws/sam/build-java8.al2:latest as build-image
WORKDIR "/task"
COPY src/ src/
COPY pom.xml ./
RUN mvn -q clean install
RUN mvn dependency:copy-dependencies -DincludeScope=compile

FROM public.ecr.aws/lambda/java:8.al2
RUN yum update -y
RUN yum install -y necessary libraries and tools including pango, libXcomposite, etc (names have been shortened for brevity).
RUN chmod 777 /tmp/
COPY --from=build-image /task/target/classes /var/task/
COPY --from=build-image /task/target/dependency /var/task/lib

# This command can be modified according to requirements in the template.

CMD ["helloworld.App::handleRequest"]
```

8. **Construct the project with SAM:**

```bash
sam build -u
```

9. **Promptly deploy your project:**

```bash
sam deploy --guided
```

10. **Delight in your functional IronPDF in AWS Lambda!** Your live function can be accessed at: [AWS Lambda Console](https://console.aws.amazon.com/lambda/home)