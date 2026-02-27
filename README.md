
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
- Maven

## Setup

Clone the repository

```bash
git clone https://github.com/yourusername/pdf-page-cutter.git
cd pdf-page-cutter
```

## Build the project
```bash
mvn package
```
## Run code
```bash
java -jar target/pdf-page-cutter.jar
```
## Example Usage

### Example in the terminal
```
PDF Path: report.pdf
Pages to remove: 1, 4-7 2
New file name: cleaned_report
```
## Result:
cleaned_report.pdf
