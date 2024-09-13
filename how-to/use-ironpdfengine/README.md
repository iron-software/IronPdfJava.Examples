# Utilizing IronPdfEngine

IronPdfEngine is a gRPC server crafted to handle a variety of operations with IronPDF, such as the creation, modification, and reading of PDF documents.

## Integration of IronPdf for Java with IronPdfEngine

For IronPdf for Java to function, it necessitates the use of IronPdfEngine. Essentially, the Java interface serves as a wrapper over the IronPdfEngine gRPC. This means that every method invoked through IronPdf for Java essentially activates processes within IronPdfEngine.

By default, IronPdf for Java initializes IronPdfEngine as a subprocess which remains active until your application is terminated.

It's important to note that each version of IronPdf for Java synchronizes with a specific version of IronPdfEngine, and cross-version compatibility is not supported.

### Implementing IronPdf for Java with a Local IronPdfEngine

#### Option 1: Downloading IronPdfEngine at Runtime

When you integrate IronPdf into your Java application and run it for the first time, IronPdf is programmed to identify your computing environment (like Windows x64) and download the proper IronPdfEngine binaries automatically.

```xml
<dependency>
   <groupId>com.ironsoftware</groupId>
   <artifactId>ironpdf</artifactId>
   <version>20xx.xx.xx</version>
</dependency>
```

**Advantages:**
- Smaller initial application size.
- Capable of deployment across multiple platforms.

**Disadvantages:**
- Requires internet connection initially.
- Increased start-up time.

#### Option 2 (Highly Recommended): Install IronPdfEngine as a Packaged Dependency

With this method, IronPdf for Java lets you incorporate IronPdfEngine directly within your project via dependency management. These dependencies come in a `.zip` file, which is automatically extracted and used by your Java application.

Ensure that both the `ironpdf` and `ironpdf-engine-xxx-xxx` dependencies share the same version.

Here's how to specify IronPdfEngine for different platforms:

**For Windows x64**
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

**For Windows x86**
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-windows-x86</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

**For Linux x64**
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-linux-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

**For macOS x64**
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-x64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

**For macOS ARM**
```xml
<dependency>
    <groupId>com.ironsoftware</groupId>
    <artifactId>ironpdf-engine-macos-arm64</artifactId>
    <version>20xx.xx.xxxx</version>
</dependency>
```

It's generally not recommended to install all dependencies due to their substantial size.

**Advantages:**
- Enhanced startup speed.
- No need for internet once installed.

**Disadvantages:**
- Increases the size of your application package.
- Requires explicit platform targeting.

## Configuring IronPdf for Java with Remote IronPdfEngine

When setting up a remote IronPdfEngine, ensure that the versions of IronPdf for Java and IronPdfEngine are compatible. For instance, if IronPdf for Java is version `2024.2.2`, you should utilize IronPdfEngine version `2024.2.2` and avoid any other versions. To verify compatibility, use:

```java
String ironPdfEngineVersion = com.ironsoftware.ironpdf.Settings.getIronPdfEngineVersion();
```

### Establishing Connection

Suppose IronPdfEngine is already operational remotely at `123.456.7.8:33350`. First, ensure this server is accessible and not blocked by any firewalls.

To connect, include the following setup in the initial phase of your application or right before deploying any IronPdf methods:

```java
com.ironsoftware.ironpdf.Settings.setIronPdfEngineHost("123.456.7.8");
com.ironsoftware.ironpdf.Settings.setIronPdfEnginePort(33350);
```

This straightforward configuration enables your application to communicate with the remote IronPdfEngine.

For remote configurations, there's no need to follow the install details from "[Option 2 (recommended) install IronPdfEngine as a dependency](https://ironpdf.com/how-to/pull-run-ironpdfengine/#anchor-option-2-recommended-install-ironpdfengine-as-a-dependency)."