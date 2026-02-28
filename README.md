
# PDF Page Cutter (CLI)

Simple Java cli tool to remove pages from PDFs.  
I couldn't find a free PDF cutter that worked the way I wanted, so I made this.

## Features

- Remove specific pages from a PDF
- Supports single pages and ranges
- Mixed page input supported (e.g. `1, 4-7 2 10-12`)
- Pages are automatically processed in descending order to prevent index shifting
- Runs locally - no file uploads required

## Requirements

- Java 17+
- Maven (or IntelliJ IDEA with bundled Maven)

## Setup

Clone the repository

```bash
git clone https://github.com/farron65/pdf-cutter.git
cd pdf-cutter
```

### Option 1 — Maven (CLI)

```bash
mvn package
```

### Option 2 — IntelliJ IDE

1. Open the project in IntelliJ.
2. Right-click `pom.xml` -> **Add as Maven Project**.
3. Run the `package` lifecycle task from the Maven tool window
   or just run `Main.java`.

## Run the program

```bash
java -jar target/pdf-cutter.jar
```

## Example Usage

### Example in the terminal
```
PDF Path: "C:\Users\admin\Documents\report.pdf"
Pages to remove: 1, 4-7 2
New file name: cleaned_report
```
!Paths can be provided with or without quotation marks.

## Result:
A new file is created in the same directory as `report.pdf`
```
C:\Users\admin\Documents\cleaned_report.pdf
```
