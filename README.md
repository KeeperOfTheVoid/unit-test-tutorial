# unit-test-tutorial

Quick Tutorial for using JUnit to create unit tests. This is a template project built by Matthew Lalmansingh. It has
some base configurations built in to make it easier to start writing useful code.

# Open in an IDE

If you are using IntelliJ IDEA < 13.1, skip to the instructions below.

1 Open command prompt/terminal and navigate to root folder of the project
2 Run the command 'gradlew idea'
3 After you see 'BUILD SUCCESSFUL' you can open the project in your IDE

## IntelliJ 13.1

More recent versions of IntelliJ IDEA have better support for importing Gradle projects. Simply use the `Import Project` menu option in IntelliJ and you will be good to go.

## The Gradle Wrapper

The [Gradle wrapper](gradle.org/docs/current/userguide/gradle_wrapper.html) is the recommended method for running a Gradle build. A Gradle wrapper script (`gradlew.bat/sh`) is already included in your project. See the docs for info about upgrading the Gradle version that your project uses.

You can also install [Gradle](gradle.org) on your machine for use outside of your project.

## Run Instructions in IntelliJ

To run it inside IntelliJ IDEA:

1 Edit your Run Configurations
2 Add a `Application`
3 Supply a name, like `Run`
4 Point the `Main Application` to your project or Main Java class
5 Run it!

## Technologies

- JUnit 1.4.10 (http://junit.org/junit4/)
- Mockito 1.4.10 (http://mockito.org/)
- EasyMock 3.1 (http://easymock.org/)