# Java Digital Clock

Digital Clock project based on Java and JavaFX.

## Goals

- Explore developing Java apps for Linux.
- Display a full-screen clock on a Raspberry Pi (or other IoT-like Raspbian or similar device).

For the second goal, a 24-hour style clock is referenced by volunteers to timestamp events and activities during their deployment during support events.

## Known Issues

- [ ] When launching the Java Package using the "app" script, a Warning message appears in the console stating "...unsupported JavaFX configuration...", and the app works as advertised.

## Usage

1. Launch the JAVA App (TBD).
2. The Digitial Clock appears on-screen at a set size. Use the corner or edge "handles" to change the clock size.
3. Click the Digital Clock to set it to full screen mode.
4. While in full-screen mode, click or press "X" on the keyboard to restore the window size to previous.
5. Close the clock using the OS platform's Close buttons and/or key combinations.

_Note_: When resizing the Digital Clock, there might be some Width and Height ratios that make the readout difficult to interpret. The Digital Clock will try its best to be readable in most cases.

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

Build and Run tasks within VSCode are the same for Windows and Linux.

Executing from Explorer (Windows) or Shell (Linux) is slightly different in that the Batch/Shell script that is run from the Deployment package (a ZIP or TAR file).

### Prerequisites

- Java Eclipse Adoptium JDK 21.
- JavaFX (ensure it is a supported version for Java JDK version).
- Extension Pack for Java (Microsoft).
- Language Support for Java(TM) by Red Hat
- JavaFX Support by Shrey Pandya (addresses a bug in Language Support for Java(TM) by Red Hat).
- A basic understanding of Gradle.

### Build

Linux and Windows:

1. Meet the prerequisites listed above on the target platform (Linux or Windows).
1. Launch VSCode on the target platform. It will take a moment for Gradle to start-up and complete initialization tasks.
1. Open the Command Palette and type `Gradle: Refresh Gradle Projects View` and run the command. There should be no errors in the Output window.
1. Open `Gradle` tool on the Activity Bar and expand the `digitalclock` node, `build` node, and execute a `clean` task, then a `build` task.
1. Copy the output ZIP file from `.\app\build\distributions` to the location where you need it.

### Run - VSCode

1. Build the app using `Gradle` tool on the Activity Bar.
1. Expand `application` node to reveal the `run` task.
1. Click the play icon to run, or the bug icon to run in debug mode.

Alternative Run:

1. Open Run and Debug (Ctrl + Shift + D) and allow VSCode to generate build and run settings.
1. Click the Green play button to run the app.

### Run - PowerShell, Bash, etc

1. Execute a build (above) or acquire a built Package. Gradle output files are dumped in the `distributions` directory by default.
1. Check that Java executable and version: `java --version`
1. Extract the ZIP (or TAR) file contents to a new directory.
1. Traverse the directory to find and execute the script to launch the Digital Clock.

Windows script is `app.bat` and Linux script is `app`. Under the covers these batch file execute `java.exe` with the `-classpath` arguments that point to all files in the extracted `lib` directory. So long as the prerequisites are met, the application should run.

Note: In Linux you might have to mark the shell script as executable using `chmod +x {filename}` before it will work.

## Prepare Java and JavaFX

Linux:

Includes RaspberryPi Bookworm and other Debian derivatives.

1. Read through steps provided by Java JDK 21.x source, for example [Adoptium Linux Install Instructions](https://adoptium.net/installation/linux)
1. Follow steps using `sudo` as necessary.
1. For the final step select temurin 21 jdk like: `sudo apt install temurin-21-jdk`
1. To verify Java Temurin 21 is installed type `java --version`
1. To confirm JavaFX is accessible, launch VSCode and perform a Gradle Build task.

Windows:

1. Download and install Adoptium JDK 21.x
1. Launch VSCode and run a Gradle Build task.

JavaFX should be downloaded from the Maven Repo and the build should succeed without errors.

## References

- [JavaFX CSS Reference](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html)
- [Build and Run for Windows](https://stackoverflow.com/questions/16137713/how-do-i-run-a-java-program-from-the-command-line-on-windows)
- [Build and Run: Linux](https://askubuntu.com/questions/145748/how-to-compile-a-java-file-on-ubuntu)
- [Package a Java App](https://stackoverflow.com/questions/65851854/how-to-build-java-native-executable-files-for-linux)
- Adoptium.net [Instructions To Install Temurin to Linux](https://adoptium.net/installation/linux/) (a general prerequisite).
- How to [Install NetBeans](https://snapcraft.io/install/netbeans/raspbian) (requires Java JDK v.21 or newer, Adoptium recommended).
- StackOverflow discussion about [JavaFX Warning Unsupported JavaFX configuration](https://stackoverflow.com/questions/67854139/javafx-warning-unsupported-javafx-configuration-classes-were-loaded-from-unna)
