# Java Digital Clock

Digital Clock project based on Java and JavaFX.

## Usage

1. Launch the JAVA App (TBD) (see [Build And Run - Command Line](#build-and-run---command-line) below).
2. The Digitial Clock appears on-screen at a set size. Use the corner or edge "handles" to change the clock size.
3. Click the Digital Clock to set it to full screen mode.
4. While in full-screen mode, click or press "X" on the keyboard to restore the window size to previous.
5. Close the clock using the OS platform's Close buttons and/or key combinations.

_Note_: When resizing the Digital Clock, there might be some Width and Height ratios that make the readout difficult to interpret. The Digital Clock will try its best to be readable in most cases.

## Goals

- Explore developing Java apps for Linux.
- Display a full-screen clock on a Raspberry Pi (or other IoT-like Raspbian or similar device).

For the second goal, a 24-hour style clock is referenced by volunteers to timestamp events and activities during their deployment during support events.

## Project Status

- Is a JavaFX project.
- Can be built for Windows.
- Updates about once per second.
- Looks like a fairly inexpensive LED display.
- High contrast.
- Responsive screen design.
- Full-screen and "normal" window sizing supported.
- Click or press "X" key to exit full-screen mode.
- Better scale LED characters per screen size (some scalings make digits very difficult to interpret).

## Known Remaining Work

- Check-in with primary contact to get feedback and next-sprint goals.
- Build and run on Debian-derived Linux platform.

## Folder Structure

The workspace contains several folders by default, where:

- `src`: the folder to maintain sources
- JRE System Library (see Java Projects Extension for this view)
- Reference Libraries (see Java Projects Extension for this view)

Compiled output files will be generated and placed in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

Notes:

- JavaFX SDK can be downloaded separately and placed in a common folder where Java build can access its `lib` folder.
- Other dependencies might be elsewhere in the local filesystem (such as the Java JDK). Take a peek at `JAVA_HOME` env variable or VS Code Extensions for a clue about where JDK has been installed and what version.

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
1. Get path to JavaFX bin directory.
1. Get list of modules included in the Java project i.e. `javafx.fxml` etc.
1. Find `DigitalClock.App` (the source code, usually in `src`).
1. Execute `javac -d {GENERATED_CLASS_FILES_DIR} --module-path {JAVAFX_LIB_DIR} --add-modules {CSVLIST_OF_NAMED_JAVAFX_MODULES} --class-path .\src src\DigitalClock.java`

_Note_: No output is good screen output in this case.

Run:

1. Find the generated `.class` file and CHDIR to that directory for simplicity.
1. Execute `java --module-path {JAVAFX_BIN_DIR} --add-modules {LIST_OF_NAMED_JAVAFX_MODULES} DigitalClock`

## Publish and Deploy - Linux

Linux:

- Includes RaspberryPi OS Bookworm and other Debian derivatives.
- Support for ARCH platform but _not_ support ARM (this is a NetBeans limitation).

Steps:

1. Install Java JDK 17 (see [References](#references) for details).
1. Install SnapD: `sudo apt install snapd`, reboot, then `sudo snap install snapd`
1. Install Apache NetBeans: `sudo snap install netbeans --classic`
1. ...more TBD...

## References

- [JavaFX CSS Reference](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html)
- [Build and Run for Windows](https://stackoverflow.com/questions/16137713/how-do-i-run-a-java-program-from-the-command-line-on-windows)
- [Build and Run: Linux](https://askubuntu.com/questions/145748/how-to-compile-a-java-file-on-ubuntu)
- [Package a Java App](https://stackoverflow.com/questions/65851854/how-to-build-java-native-executable-files-for-linux)
- [Using GraalVM](https://www.graalvm.org/latest/reference-manual/native-image/guides/build-static-executables/)
- [Using GraalVM Containers](https://www.graalvm.org/latest/reference-manual/native-image/guides/containerise-native-executable-and-run-in-docker-container/)
- Adoptium.net [Instructions To Install Temurin to Linux](https://adoptium.net/installation/linux/) (a general prerequisite).
- How to [Install NetBeans](https://snapcraft.io/install/netbeans/raspbian) (requires Java JDK v.17 or newer, Adoptium recommended).
