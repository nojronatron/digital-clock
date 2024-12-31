# Java Digital Clock

Digital Clock project based on Java and JavaFX.

The primary goal of this project is to explore developing Java apps for Linux.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Prerequisites

- Java Eclipse Adoptium JDK 17.0.6.10-hotspot.
- JavaFX r.17 (Sept 2021) LTS. Requires JDK 11 or newer.
- Extension Pack for Java (Microsoft).
- Language Support for Java(TM) by Red Hat
- JavaFX Support by Shrey Pandya (addresses a bug in Language Support for Java(TM) by Red Hat).
- Settings.json includes library references to JavaFX.
- Launch.json includes `vmArgs` to JavaFX Bin packages.

## Build and Run - VSCode

1. Install Java JDK.
1. Download JavaFX (ensure it is a supported version for Java JDK version).
1. Install VSCode Extension Packs.
1. Update VSCode settings and launch to ensure JavaFX libs are included.
1. In VSCode, select `App.java` and click the Run command or the `play` triangle.

## Build and Run - Command Line

Build:

1. Decide where to place generated class files
1. Get path to JavaFX lib directory.
1. Get list of modules included in the Java project i.e. `javafx.fxml` etc.
1. Find `DigitalClock.App` (the source code, usually in `src`).
1. Execute `javac -d {GENERATED_CLASS_FILES_DIR} --module-path {JAVAFX_LIB_DIR} --add-modules {LIST_OF_NAMED_JAVAFX_MODULES} src\DigitalClock.java`

Run:

1. Find the generated `.class` file and CHDIR to that directory for simplicity.
1. Execute `java --module-path {JAVAFX_LIB_DIR} --add-modules {LIST_OF_NAMED_JAVAFX_MODULES} DigitalClock`

## Publish and Deploy

Linux:

1. Steps are TBD.

References:

- [JavaFX CSS Reference](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html)
- [Build and Run for Windows](https://stackoverflow.com/questions/16137713/how-do-i-run-a-java-program-from-the-command-line-on-windows)
- [Build and Run: Linux](https://askubuntu.com/questions/145748/how-to-compile-a-java-file-on-ubuntu)
- [Package a Java App](https://stackoverflow.com/questions/65851854/how-to-build-java-native-executable-files-for-linux)
- [Using GraalVM](https://www.graalvm.org/latest/reference-manual/native-image/guides/build-static-executables/)
- [Using GraalVM Containers](https://www.graalvm.org/latest/reference-manual/native-image/guides/containerise-native-executable-and-run-in-docker-container/)
