# TallyPracticeClean

A clean Android starter project for a Tally practice application.

## Build

The GitHub Actions workflow uses Gradle 8.7 directly through
`gradle/actions/setup-gradle@v6`. It intentionally does not call `./gradlew`,
so the build does not depend on a missing Gradle Wrapper.

## APK

After a successful GitHub Actions run:

1. Open the workflow run.
2. Open the Artifacts section.
3. Download `TallyPractice-debug-apk`.
4. Extract the APK and install it on Android.

## Project

- Android Gradle Plugin: 8.6.1
- Gradle: 8.7
- Java: 17
- compileSdk: 35
- minSdk: 23
