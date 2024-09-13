# Implementing Licenses in IronPDF for Java Projects

## Obtaining a License Key

To deploy your project live with IronPDF for Java without any limitations or watermarks, you need to acquire a license key.

Purchase your license from [this link](https://ironpdf.com/java/licensing/) or obtain a [free 30-day trial key](#trial-license) by signing up.

## Step 1: Configuring IronPDF as a Dependency in Java

### Option 1: Using `pom.xml` Dependency

To utilize IronPDF in your Java project, insert the following dependency into your `pom.xml` file:

```xml  
<dependencies>
    <dependency>
        <groupId>com.ironsoftware</groupId>
        <artifactId>ironpdf</artifactId>
        <version>20xx.xx.xxxx</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.3</version>
    </dependency>
</dependencies>
```

### Option 2: Direct jar File Download

Alternatively, you can [manually download the jar file](https://ironpdf.com/$downloadPackage).

## Step 2: Activating Your License Key

### Option 1: Insert the License Key in Java Code

To activate your IronPDF license, insert the following code at the start of your application, prior to utilizing IronPDF functionalities.

```java
import com.ironsoftware.ironpdf.*;

// Activate the license
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Ready to use IronPDF
```

### Option 2: Applying the License in `config.properties` File

Include this line in your `config.properties` file:
```
IRONPDF_LICENSE_KEY=IRONPDF-MYLICENSE-KEY-1EF01
```

## Step 3: Verify License Key Implementation

Execute the code below to check whether the license key is valid.

```java
// Validate the license key input
License.IsValidLicense(String licenseKey);
```

**Note:** Always clean and republish your application after embedding the license to prevent deployment errors.

## Step 4: Launching Your Project

Learn how to start using IronPDF in your Java projects by following our [Getting Started tutorial](https://ironpdf.com/java/docs/).

## Have Questions?

`IronPDF for Java` is freely accessible for testing in development phases but displays a watermark. 

To operate in live environments sans watermark, [buy a full license](https://ironpdf.com/java/licensing/). Explore the option of a 30-day trial [here](#trial-license).

For extensive tutorials, sample code, licensing details, and further documentation, visit [IronPDF for Java home](https://ironpdf.com/java/).

For additional assistance, please [contact our team](#live-chat-support).