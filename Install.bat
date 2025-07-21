@echo off
echo ==========================
echo   MakeMyTrip Automation
echo ==========================

:: Check Maven
mvn -version
IF %ERRORLEVEL% NEQ 0 (
    echo Maven not found. Please install Maven and try again.
    pause
    exit /b
)

:: Check Java
java -version
IF %ERRORLEVEL% NEQ 0 (
    echo Java not found. Please install Java and try again.
    pause
    exit /b
)

:: Clean and build
echo Running Maven clean install...
mvn clean install

:: Run tests
echo Running Tests...
mvn test

echo ==========================
echo   Execution Completed!
echo ==========================