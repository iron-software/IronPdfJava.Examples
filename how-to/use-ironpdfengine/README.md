# Understanding IronPdfEngine in Detail

***Based on <https://ironpdf.com/how-to/use-ironpdfengine/>***


IronPdfEngine is a gRPC-based server that facilitates various IronPDF functionalities which include generation, modification, and parsing of PDF documents.

[Link to Download IronPDF for Java on ironpdf.com](https://ironpdf.com/java/)

## IronPdf for Java Dependency on IronPdfEngine

The IronPdf for Java library significantly relies on IronPdfEngine. In essence, the Java library serves as a client interface atop the IronPdfEngine gRPC setup. Any method invoked in IronPdf for Java leverages the functionalities housed in IronPdfEngine.

Typically, IronPdf for Java will manage the instantiation of IronPdfEngine as a subprocess, maintaining this subprocess throughout the lifespan of the application.

It’s imperative to note that each IronPdf for Java version is tightly coupled with a corresponding IronPdfEngine version, and inter-version compatibility is not maintained.

### Working with IronPdf for Java and Local IronPdfEngine

#### Approach 1: Runtime Download of IronPdfEngine

Upon the initial execution following the setup of IronPdf in your Java project, the library automatically recognizes your operating system (e.g., Windows x64) and fetches the appropriate IronPdfEngine binary from the web.

```xml
<dependency>
   <groupId>com.ironsoftware</groupId>
   <artifactId>ironpdf</artifactId>
   <version>20xx.xx.xx</version>
</dependency>
```

##### Advantages

* Minimizes the size of the application package.
* Enables deployment across various platforms.

##### Disadvantages

* Requires internet access initially.
* May experience delayed startup times.

#### Approach 2 (Recommended): Offline IronPdfEngine Integration as a Dependency

Installing IronPdfEngine as a direct dependency is another route you can take. This method integrates the IronPdfEngine into your project as a .zip file, which is then unpacked and utilized automatically.

It's crucial to ensure the version alignment between `ironpdf` and `ironpdf-engine-xxx-xxx` dependencies.

##### Specifying Versions for Platforms:

- **Windows x64**
  ```xml
  <dependency>
     <groupId>com.ironsoftware</groupId>
     <artifactId>ironpdf-engine-windows-x64</artifactId>
     <version>20xx.xx.xx</version>
  </dependency>
  ```

- **Windows x86**
  ```xml
  <dependency>
     <groupId>com.ironsoftware</groupId>
     <artifactId>ironpdf-engine-windows-x86</artifactId>
     <version>20xx.xx.xx</version>
  </dependency>
  ```

- **Linux x64**
  ```xml
  <dependency>
     <groupId>com.ironsoftware</groupId>
     <artifactId>ironpdf-engine-linux-x64</artifactId>
     <version>20xx.xx.xx</version>
  </dependency>
  ```

- **macOS x64**
  ```xml
  <dependency>
     <groupId>com.ironsoftware</groupId>
     <artifactId>ironpdf-engine-macos-x64</artifactId>
     <version>20xx.xx.xx</version>
  </dependency>
  ```

- **macOS arm**
  ```xml
  <dependency>
     <groupId>com.ironsoftware</groupId>
     <artifactId>ironpdf-engine-macos-arm64</artifactId>
     <version>20xx.xx.xx</version>
  </dependency>
  ```

##### Advantages

* Reduces startup time.
* Independent of internet access post-installation.

##### Disadvantages

* Increases the application package size.
* Requires specification of target platforms.

## Configuring IronPdf for Java with Remote IronPdfEngine

For remote operation, specific matching versions between IronPdf for Java and IronPdfEngine are necessary.

```java
String ironPdfEngineVersion = com.ironsoftware.ironpdf.Settings.getIronPdfEngineVersion();
```

### Establishing a Connection

Assuming IronPdfEngine is active remotely at `123.456.7.8:33350`:

[Detailed Instructions on Pulling and Running Remote IronPdfEngine](https://ironsoftware.com/how-to/pull-run-ironpdfengine/)

To integrate, configure the remote IronPdfEngine server details at the start of your application or right before invoking any IronPdf methods.
```java
com.ironsoftware.ironpdf.Settings.setIronPdfEngineHost("123.456.7.8");
com.ironsoftware.ironpdf.Settings.setIronPdfEnginePort(33350);
```
Once configured, your application will seamlessly interact with the remote IronPdfEngine instance, eliminating the need for a local dependency setup under the section [Option 2: Install IronPdfEngine as a Dependency](#option-2-recommended-install-ironpdfengine-as-a-dependency).