# Java-based Entertainment Data Processor
----

This Java project accepts a year and a month from the user. It then reads from two CVS files, one is a list of NYT best
sellers and the other is a list of the Billboard Top 100. The best sellers and the number 1 song from the month/year
are then returned and saved in a JSON file, in the home directory.

## Usage

The first menu will prompt a user for a year, the second will prompt for a month. The customer can exit at any time by
entering any input other than the year/month and pressing enter.

## Features & Requirements
The program accepts user input;
Reads data from two sources;
Each source instantiates objects, which are limited to the user-defined parameters and added to a list;
These lists of objects then become components of a new object;
This last object is then converted to a JSON and saved to the home directory.

## Dependencies
commons-csv = This component from Apache helps with reading the CSV files.
gson = Google supplies this tool for converting objects to JSON and saving to a file.

----
-J. Nathan Allen
@nateonmission