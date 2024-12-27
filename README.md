# Digital Clock

Digital Clock application. Displays the current time to a large proportion of any screen size.

## Overview

## Approach

## Build and Run

Requirements:

1. Target plaform must have an appropriate, compatible JRE (Java Runtime Environment) installed.
1. (there may be more, tbd)

Targeting Linux or Windows:

1. Compile Java source file: `javac {entrypoint}.java`. Verify this worked by running `java {entrypoint}`
1. Create file `MANIFEST.MF` with content e.g.: `Main-Class: {entrypoint}`, where {entrypoint} is the compiled Java file from step 1.
1. Package the App into a JAR file: `jar cfm {projectName} MANIFEST.MF {entrypoint}.class`
1. Verify the package functions: `java -jar {projectName}.jar`

## Notes

All steps listed in this README are subject to change until this statement is removed.

## References
