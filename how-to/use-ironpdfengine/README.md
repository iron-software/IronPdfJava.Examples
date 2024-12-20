# Harnessing IronPdfEngine's Capabilities

***Based on <https://ironpdf.com/how-to/use-ironpdfengine/>***


IronPdfEngine stands as a robust gRPC server designed to streamline and facilitate various IronPDF tasks such as creating, editing, writing, and reading PDF documents.

[Link to Download IronPDF for Java on ironpdf.com](https://ironpdf.com/java/)

## Integration of IronPdf for Java with IronPdfEngine

For IronPdf to function in Java, it relies on IronPdfEngine. Essentially, IronPdf for Java functions as a client, interfacing through API calls to IronPdfEngine. Whenever IronPdf methods are invoked in Java, IronPdfEngine executes the necessary operations behind the scenes.

Typically, IronPdf for Java initializes IronPdfEngine as a child process, which remains active throughout the lifecycle of your application.

It's important to note that each version of IronPdf for Java is tailored to operate with a corresponding version of IronPdfEngine, and mixing versions is not supported for compatibility reasons.

### Utilizing IronPdf with Local IronPdfEngine

#### Option 1: Dynamically Download IronPdfEngine

When you incorporate IronPdf into your Java project, it will automatically recognize your operating system (e.g., Windows x64) and download the appropriate IronPdfEngine binaries at the initial launch.

```xml
<dependency>
   <groupId>com.ironsoftware</groupId>
   <artifactId>ironpdf</artifactId>
   <version>20xx.xx.xx</version>
</dependency>
```

##### Advantages

- Minimal application size.
- Applicable across various platforms.

##### Disadvantages

- Requires internet connectivity initially.
- Delays during startup.

#### Option 2 (Recommended): Embedding IronPdfEngine as a Dependency

This method involves embedding IronPdfEngine into your project through dependencies. These dependencies pack IronPdfEngine into a `.zip` file which is then automatically extracted and utilized.

You should ensure that the versions of `ironpdf` and `ironpdf-engine-xxx-xxx` align. The dependency version does not indicate the actual version of IronPdfEngine used internally.

#### Specific Platform Installations:

- **Windows x64 Installation**

  ```xml
   <dependency>
      <groupId>com.ironsoftware</groupId>
      <artifactId>ironpdf-engine-windows-x64</artifactId>
      <version>20xx.xx.xxxx</version>
  </dependency>
  ```

- **Windows x86 Installation**

  ```xml
  <dependency>
      <groupId>com.ironsoftware</groupId>
      <artifactId>ironpdf-engine-windows-x86</artifactId>
      <version>20xx.xx.xxxx</version>
  </dependency>
  ```

- **Linux x64 Installation**

  ```xml
  <dependency>
      <groupId>com.ironsoftware</groupId>
      <artifactId>ironpdf-engine-linux-x64</artifactId>
      <version>20xx.xx.xxxx</version>
  </dependency>
  ```

- **macOS x64 Installation**

  ```xml
  <dependency>
      <groupId>com.ironsoftware</groupId>
      <artifactId>ironpdf-engine-macos-x64</artifactId>
      <version>20xx.xx.xxxx</version>
  </dependency>
  ```

- **macOS arm Installation**

  ```xml
  <dependency>
      <groupId>com.ironsoftware</groupId>
      <artifactId>ironpdf-engine-macos-arm64</artifactId>
      <version>20xx.xx.xxxx</version>
  </dependency>
  ```

Each package option significantly increases the size of your application, so installing all available options is generally not advised.

##### Advantages

- Improved startup speed.
- No need for internet access post-installation.

##### Disadvantages

- Increased size of the application package.
- Requires definition of target platforms.

## Remote Deployment with IronPdfEngine

For a remote deployment scenario, specific version alignment between IronPdf for Java and IronPdfEngine is crucial. For instance, IronPdf for Java version 2024.2.2 should correspond to IronPdfEngine version 2024.2.2.

```java
String ironPdfEngineVersion = com.ironsoftware.ironpdf.Settings.getIronPdfEngineVersion();
```

### Connection Setup

Assuming IronPdfEngine is active remotely at `123.456.7.8:33350`:

[View Steps to Set Up and Operate IronPdfEngine](https://ironpdf.com/how-to/pull-run-ironpdfengine/)

Initiate a connection by specifying the IronPdfEngine server's address and port at the start of your application:

```java
com.ironsoftware.ironpdf.Settings.setIronPdfEngineHost("123.456.7.8");
com.ironsoftware.ironpdf.Settings.setIronPdfEnginePort(33350);
```

This configuration will establish a connection between your Java application and the remote IronPdfEngine.

When using IronPdf remotely, there’s no need to embed IronPdfEngine as a built-in dependency.