# Implementing Licenses for IronPDF in Java Projects

> Full guide: [Implementing Licenses for IronPDF in Java Projects](https://ironpdf.com/get-started/license-keys/?utm_source=github)


## Acquiring a License Key

To run your project live without any limitations or watermarking, it's essential to integrate an IronPDF license key.

Purchase a valid [IronPDF license here](https://ironpdf.com/java/licensing/?utm_source=github) or opt for a free 30-day trial license.

## Step 1: Configure IronPDF as a Java Dependency

### Option 1: Add to `pom.xml`

Insert the following code snippet into your `pom.xml` to set IronPDF as a project dependency:

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

### Option 2: Jar File Installation

Alternatively, you can [manually download the IronPDF Java jar file](https://ironpdf.com/$downloadPackage?utm_source=github).

## Step 2: License Key Application

### Option 1: Implement within Java Code

Implement your license key early in your application to ensure all features are unlocked:

```java
import com.ironsoftware.ironpdf.License;

public class MyApplication {
    public static void main(String[] args) {
        // Set the license key
        License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");

        // Now IronPDF is ready to use
    }
}
```

### Option 2: Configure via `config.properties`

Incorporate your license key into your `config.properties` setting:

```txt
IRONPDF_LICENSE_KEY=IRONPDF-MYLICENSE-KEY-1EF01
```

## Step 3: Validating Your License Key

Verify the functionality of your license key utilizing the following Java method:

```java
import com.ironsoftware.ironpdf.License;

public class LicenseTest {
    public static void main(String[] args) {
        String licenseKey = "IRONPDF-MYLICENSE-KEY-1EF01";
        
        // Validate the license key
        boolean isValid = License.isValidLicense(licenseKey);
        
        if (isValid) {
            System.out.println("License key is valid.");
        } else {
            System.out.println("License key is invalid.");
        }
    }
}
```

*Reminder:* Always clean and republish your application after installing a new license to prevent deployment errors.

## Step 4: Launching Your Java Project

Learn how to begin using IronPDF in your Java projects with our [Get Started Guide](https://ironpdf.com/java/docs/?utm_source=github).

## Assistance Needed?

`IronPDF for Java` is readily available for development use with a default watermark. To utilize it for live deployments, [obtain a license](https://ironpdf.com/java/licensing/?utm_source=github), which is available alongside a 30-day trial for evaluation purposes.

Explore extensive [IronPDF Java resources](https://ironpdf.com/java/?utm_source=github) including examples, tutorials, and thorough documentation.

If further help is required, don't hesitate to reach out to our support.