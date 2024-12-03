# Applying Licenses to Projects using IronPDF for Java

***Based on <https://ironpdf.com/how-to/license-keys/>***


## Obtaining a License Key

Implementing an IronPDF license key in your project allows you to launch your application commercially without any restrictions or watermarks.

You can [obtain an IronPDF license](https://ironpdf.com/java/licensing/) or opt for a [free 30-day trial license](#trial-license) by clicking here.

## Step 1: Defining IronPDF as a Dependency in Java

### Option 1: Using `pom.xml` Dependency

To incorporate IronPDF as a dependency in your project, insert the following code into your `pom.xml` file:

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

### Option 2: Manual .jar File Download

Alternatively, you can [download the IronPDF Java .jar file](https://ironpdf.com/downloadPackage) directly.

## Step 2: Implementing Your License Key

### Option 1: Coding the License Key into Java

Integrate this snippet at the beginning of your application to apply your license key efficiently:

```java
import com.ironsoftware.ironpdf.*;

// Insert your license key here
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// IronPDF is now ready for use!
```

### Option 2: Using a Configuration File

Incorporate the following line in your `config.properties` file:
```
IRONPDF_LICENSE_KEY=IRONPDF-MYLICENSE-KEY-1EF01
```

## Step 3: Verify License Key Installation

Utilize this code to confirm if your license key is correctly applied:

```java
// Verify the validity of your license key.
License.IsValidLicense(String licenseKey);
```

*Important:* Always ensure to clean and republish your application following the license application to prevent errors during deployment.

## Step 4: Commencing Your Project

Explore our tutorial on [Getting Started with IronPDF for Java Projects](https://ironpdf.com/java/docs/).

## Need Help?

`IronPDF for Java` can be tested in development environments with an IronPDF watermark.

To deploy in live environments and eliminate the watermark, [secure a commercial project license](https://ironpdf.com/java/licensing/). Trial licenses for 30 days are also accessible [for testing the setup](#trial-license).

For a comprehensive collection of code examples, tutorials, licensing details, and additional documentation, visit: [IronPDF Java Documentation](https://ironpdf.com/java/).

For further assistance and support, please [reach out to our support team](#live-chat-support).