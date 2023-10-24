# Quarkus envirnoment config example

> **IMPORTANT**: To start a new project using the supported Red Hat build of Quarkus go to: https://code.quarkus.redhat.com/

The **goal** of this project is to show **how to configure** the project via _environment variables_ and how to retrieve those variables via **javascript**.

Applications can defines their needs in terms of configuration using `@ConfigMapping` annotation in a simple Java interface:
[Config interface](src/main/java/org/acme/Config.java)

When you need the configuration values you have to inject the config class:

```java
    @Inject
    Config config;
```

Behind the scene Quarkus framework instanciates the config object taking the information from the following sources and priorities:

1. Java system properties
2. Environment variables
3. The environment file
4. K8s secrets
5. K8s config maps
6. Application properties

If you want to use that configuration on the client side you have to expose it via a REST endpoint: [EnvResource](src/main/java/org/acme/EnvResource.java).

Finally, you can retrieve the information via javascript: [index.html](src/main/resources/META-INF/resources/index.html)

Learn more about configuration at https://quarkus.io/guides/config-reference

## How to run the demo

1. Clone this project

2. Build the project:

   ```shell script
   ./mvnw package
   ```

3. Run the project: `java -jar target/quarkus-app/quarkus-run.jar`

4. See the configuration values in browser: [https://localhost:9080/]()

5. Stop java execution (CTRL-C)

6. Set the environment variable

   ```shell script
   export EXAMPLE_HOST=example.com
   ```

   > **NOTE**: for naming convention the `.` is translated in `_` when dealing with environment variable

7. Run again: `java -jar target/quarkus-app/quarkus-run.jar`

8. Reload the page [https://localhost:9080/]() and check that page shows the actual value: `example.com`

# Quarkus Basics

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

To start a new Quarkus project

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-env-config-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
