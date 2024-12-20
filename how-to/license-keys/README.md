# Applying Licenses to Projects in IronPDF for Java

***Based on <https://ironpdf.com/how-to/license-keys/>***


## Obtaining a License Key

Securing an IronPDF license key enables you to launch your projects live without any restrictions or watermark impositions.

You have the option to [purchase an IronPDF license](https://ironpdf.com/java/licensing/) or register for a [free 30-day trial license](#trial-license).

## Step 1: Integrating IronPDF as a Java Dependency

### Option 1: pom.xml Dependency

To incorporate IronPDF as a dependency, insert the following into your `pom.xml`:

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

### Option 2: Download the jar file

Alternatively, [download the IronPDF Java .jar file](https://ironpdf.com/java/downloadPackage) manually.

## Step 2: Applying Your License Key

### Option 1: Entering license key in Java code

Embed this code at the beginning of your application, before employing IronPDF. This strategy ensures ease and universal applicability.

```java
import com.ironsoftware.ironpdf.*;

// Inserting the license key
License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

// Initialize IronPDF!
```

### Option 2: Configuring license in config.properties file

Include the next line in your `config.properties` file:
```
IRONPDF_LICENSE_KEY=IRONPDF-MYLICENSE-KEY-1EF01
```

## Step 3: Verifying Your License Installation

```java
// Validate the inserted license key.
License.IsValidLicense(String licenseKey);
```

*Note:* Ensure to cleanse and republish your application post-license application to circumvent deployment errors.

## Step 4: Launching Your Project

Proceed by following our guide on [Getting Started with IronPDF for Java Projects](https://ironpdf.com/java/docs/).

## Have Questions?

`IronPDF for Java` can be evaluated freely in development environments albeit with an IronPDF watermark.

For operational deployments and the removal of watermarks, [obtain a live project license](https://ironpdf.com/java/licensing/). A 30-day trial period is also available [for trial purposes](#trial-license).

Explore our complete suite of code samples, tutorials, licensing details, and documentation at: [IronPDF Java Documentation](https://ironpdf.com/java/).

For additional support and queries, please [reach out to our support team](#live-chat-support).