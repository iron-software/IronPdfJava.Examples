# Utilizing the IronPdfEngine

> Full guide: [Utilizing the IronPdfEngine](https://ironpdf.com/java/get-started/use-ironpdfengine/)


The IronPdfEngine operates as a gRPC server handling multiple operations for IronPDF, such as creation, modification, and reading of PDFs.

[Download IronPDF for Java at ironsoftware.com](https://ironpdf.com/java/)

## Integration of IronPdf with Java through IronPdfEngine

The operation of IronPdf for Java is dependent on IronPdfEngine. Java implementations act as a facade for the IronPdfEngine gRPC, where invoking Java methods processes the commands within IronPdfEngine.

IronPdf for Java automatically initiates IronPdfEngine as a subprocess and maintains this interaction throughout the runtime of the application.

Compatibility across different versions of IronPdf for Java and IronPdfEngine is not supported, requiring matching versions for functionality.

### Local Setup of IronPdfEngine for Java

**Option 1: Runtime Download of IronPdfEngine**

On installation within a Java project, IronPdf identifies the platform (e.g., Windows x64) and downloads the necessary IronPdfEngine binaries upon initial execution.

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf</artifactId>
    <version>20xx.xx.xx</version>
</dependency>
```

**Advantages**

- Reduced size of the application package.
- Deployable across various platforms.

**Drawbacks**

- Requires internet connection during initial runs.
- Increased time during startup.

**Option 2 (recommended): Pre-installing IronPdfEngine as a Dependency**

Configure your project to include IronPdfEngine directly by embedding the engine within a .zip file that automatically extracts during runtime. These dependencies should have matching versions with the `ironpdf` to ensure compatibility.

#### Configuration for Windows x64

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Configuration for Windows x86

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x86</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Configuration for Linux x64

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Configuration for macOS x64

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

#### Configuration for macOS arm64

```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-arm64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

Avoid installing all dependencies due to their substantial size.

**Advantages**

- Quicker to start.
- No internet required after installation.

**Drawbacks**

- Increased application package size.
- Platform targeting needed.

## Remote IronPdfEngine Setup for Java

A matching version of IronPdfEngine is required for remote utilization. Use the following method to verify compatibility:

```java
// Determine the required IronPdfEngine version for your Java setup
String ironPdfEngineVersion = com.ironsoftware.ironpdf.Settings.getIronPdfEngineVersion();
```

### Connection Setup

If IronPdfEngine is hosted remotely, say at `123.456.7.8:33350`, ensure compatibility by setting up the connection properly.

[Read detailed instructions on setting up and activating IronPdfEngine remotely](https://ironpdf.com/how-to/pull-run-ironpdfengine/)

Add the following at the start-up of your application or prior to any IronPdf method use:

```java
// Configure the network settings for IronPdfEngine connection
com.ironsoftware.ironpdf.Settings.setIronPdfEngineHost("123.456.7.8");
com.ironsoftware.ironpdf.Settings.setIronPdfEnginePort(33350);
```

This code snippet seamlessly integrates your application with the remote IronPdfEngine, negating the need to embed IronPdfEngine as a local dependency.