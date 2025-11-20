# Setting up IronPDF for Java in Google Cloud

***Based on <https://ironpdf.com/get-started/google-cloud/>***


<small>Note: Full compatibility with Google Cloud has not yet been established definitively. However, we can provide some <code>Required Settings</code> for experimental integration.</small>

## Essential: Required Configuration

* Utilizing Zip Deployment is nonviable with IronPDF as the operation requires binary executions.
* The standard Docker images provided by Cloud Functions are inadequate due to missing packages necessary for Chrome execution. For further details, refer to the [Google Cloud System Packages](https://cloud.google.com/functions/docs/reference/system-packages).
* A custom Dockerfile should be prepared with all necessary packages installed. Further guidance can be found in our [Linux Deployment Guide](https://ironpdf.com/how-to/linux/).

* Adding the `ironpdf-engine-linux-x64` dependency to your project is recommended (ensure version is latest):

  ```xml
  <dependency>
      <groupId>com.ironsoftware</groupId>
      <artifactId>ironpdf-engine-linux-x64</artifactId>
      <version>2022.xx.x</version>
  </dependency>
  ```

* Consider including this plugin if needed:

  ```xml
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>3.2.4</version>
      <executions>
          <execution>
              <phase>package</phase>
              <goals>
                  <goal>shade</goal>
              </goals>

              <configuration>
                  <transformers>
                      <transformer implementation="org.apache.maven.plugins.shade.resource.ServicesResourceTransformer"/>
                  </transformers>
              </configuration>
          </execution>
      </executions>
  </plugin>
  ```

* Adding these dependencies might be necessary:

  ```xml
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

* Increase `timeout` to `330 seconds` to accommodate potential slow boots.
* Allocate `memory size` of at least `2048 MB`.
* Ensure `Ephemeral Storage Size` of at least `1024 MB`.
* In certain environments, assigning an `IronPdfEngineWorkingDirectory` and setting appropriate execution rights might be necessary:

  ```java
  // Specify the IronPDF Engine's working directory
  Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
  ```

  ```docker
  # Set comprehensive read/write/execute permissions on the /tmp directory
  RUN chmod 777 /tmp/
  ```