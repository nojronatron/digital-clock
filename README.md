# Java Digital Clock

Digital Clock project based on Java and JavaFX.

## Usage

1. Launch the JAVA App (TBD).
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

## Build and Run

### Prerequisites

- Java Eclipse Adoptium JDK 21.
- JavaFX (ensure it is a supported version for Java JDK version).
- Extension Pack for Java (Microsoft).
- Language Support for Java(TM) by Red Hat
- JavaFX Support by Shrey Pandya (addresses a bug in Language Support for Java(TM) by Red Hat).
- A basic understanding of Gradle.

### VSCode - Windows

Build:

1. Meet the prerequisites listed above.
1. Open the Command Palette and type `Gradle: Refresh Gradle Projects View` and run the command. There should be no errors in the Output window.
1. Open the Command Palette and type `Gradle: Run a Gradle Build` and run the command. If the Gradle Build succeeds, it will output Java Archive files (a ZIP and a TAR).

Run:

1. Build the app as described above.
1. Open Run and Debug (Ctrl + Shift + D) and allow VSCode to generate build and run settings.
1. Click the Green play button to run the app.

### Command Line - Windows

Build:

1. Check that Java executable and version: `java --version`
1. Execute `gradlew build`.
1. View output files in the `distributions` directory.

Run:

1. Check that Java executable and version: `java --version`
1. Download the pre-built Java Archive file (or see the `distributions` directory if you followed the Build instructions above).
1. Extract the ZIP file contents to a new directory.
1. Traverse the directory to find `bin\app.bat` and execute it to launch the Digital Clock.

Under the covers this batch file executes `java.exe` with the `-classpath` arguments that point to all files in the extracted `lib` directory. So long as the prerequisites are met, the application should run.

## Publish and Deploy - Linux

Linux:

Includes RaspberryPi OS Bookworm and other Debian derivatives.

1. Read through steps provided by Java JDK 21.x source, for example [Adoptium Linux Install Instructions](https://adoptium.net/installation/linux)
1. Follow steps using `sudo` as necessary.
1. For the final step select temurin 21 jdk like: `sudo apt install temurin-21-jdk`
1. To verify Java Temurin 21 is installed type `java --version`

---

JAR:

1. Start in the directory where `javac` output the build files to.
1. Add necessary Library files. ???
1. Create JAR: `jar --create --file=DigitalClock.jar --main-class=DigitalClock.class *.class`
1. Execute the app: `java -jar DigitalClock.jar`

Note about NetBeans to package this project in other ways:

1. Install Java JDK 21 (see [References](#references) for details).
1. Install SnapD: `sudo apt install snapd`, reboot, then `sudo snap install snapd`
1. Install Apache NetBeans: `sudo snap install netbeans --classic`
1. Configure NetBeans Options including Libraries, SDK version, etc.

## References

- [JavaFX CSS Reference](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html)
- [Build and Run for Windows](https://stackoverflow.com/questions/16137713/how-do-i-run-a-java-program-from-the-command-line-on-windows)
- [Build and Run: Linux](https://askubuntu.com/questions/145748/how-to-compile-a-java-file-on-ubuntu)
- [Package a Java App](https://stackoverflow.com/questions/65851854/how-to-build-java-native-executable-files-for-linux)
- [Using GraalVM](https://www.graalvm.org/latest/reference-manual/native-image/guides/build-static-executables/)
- [Using GraalVM Containers](https://www.graalvm.org/latest/reference-manual/native-image/guides/containerise-native-executable-and-run-in-docker-container/)
- Adoptium.net [Instructions To Install Temurin to Linux](https://adoptium.net/installation/linux/) (a general prerequisite).
- How to [Install NetBeans](https://snapcraft.io/install/netbeans/raspbian) (requires Java JDK v.21 or newer, Adoptium recommended).
