# Deploying IronPDF for Java on Google Cloud

<small>Note: IronPDF's complete compatibility with Google Cloud hasn't been entirely validated, but here are essential configurations to help you get started.</small>

## Critical Settings Required

* Deployment using a ZIP is not feasible as IronPDF necessitates running binaries during execution.
* Default Docker images for Cloud Functions are unsuitable owing to their lack of necessary packages for optimal Chrome functionality. For a list of system packages, visit [here](https://cloud.google.com/functions/docs/reference/system-packages).
* It's advisable to utilize a custom Dockerfile for installing all necessary packages. Detailed instructions can be found [here](https://ironpdf.com/how-to/linux/).
* You should integrate the `ironpdf-engine-linux-x64` dependency in your project. Ensure you're using the most recent version:
  
    ```xml
    <dependency>
        <groupId>com.ironsoftware</groupId>
        <artifactId>ironpdf-engine-linux-x64</artifactId>
        <version>2022.xx.x</version>
    </dependency>
    ```

* You might find this plugin necessary:

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
                        <transformer
                                implementation="org.apache.maven.plugins.shade.resource.ServicesResourceTransformer"/>
                    </transformers>
                </configuration>
            </execution>
        </executions>
    </plugin>
    ```

* Consider adding these dependencies:

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

* Set the `timeout` to `330 seconds` to accommodate potential slow startups.
* Allocate at least `2048 MB` for `memory size`.
* Allocate a minimum of `1024 MB` for `EphemeralStorage Size`.
* In certain setups, you might need to specify an `IronPdfEngineWorkingDirectory` and assign appropriate execution rights:

    ```java
    Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
    ```

    ```Dockerfile
    RUN chmod 777 /tmp/
    ```