# shapecalc

# Sprint 1 (10/22/24):
## Description:
Takes various types of shapes and performs various mathematical features with the given shape. 

### Members Present:
1. Henry Johnson
2. Caden Grover
3. Lucas Fabianek

## Functional Requirements:
| Functional Requirements  | Time Estimate |                                                               Description                                                                |
|:------------------------:|:-------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|
| Perimeter Calculation     | 30 Mins       |                       Uses the correct formula for the given shape to produce the the given perimeter of the shape                       |
| Area Calculation          | 30 Mins       |                           Uses the correct formula for the given shape to produce the given area of the shape                            |
| Compare Shapes | 15 Mins |                                 Takes the perimeter or the area to show which shape is bigger or smaller                                 |
| Volume Calculation | 30 Mins |                            Takes the given components for the shape and returns the the volume of that shape                             |
| Unit Conversion | 30 Mins | Be able to take various measurement types such as imperical and metric and be able to perform the correct calculations with those values |
| Multiple Shape Support | 45 Mins |                               Takes all sorts of shapes and uses the correct formulas for each shape type                                |
| Error Handeling | 30 Mins |                              Double checks the users inputs to make sure that the correct values are given                               |

## Non-Functional Requirements:
| Non-Functional Requirements | Time Estimate | Description |
| :-------------------------: | :-----------: | :---------: |
| Speed | 15 Mins | Able to perform the given function within a set amount of time | 
| Cloud Saving | 30 Mins | Has a backing data structure that saves the various shapes for possible later use and recall |
| Visual Display | 30 Mins | Creates a visual display of the shape and allws for the user to see the shape on their screen |
| Maintinabilty | 45 Mins | Proper coding that allows for future updates to be clean and efficient |


# Sprint 2 (10/29/24):
## Meeting Notes:
We created multiple issues for the various functional requirements listed above within the read 
-me and assigned them to the Product Backlog.

### Members Present: 
1. Henry Johnson
2. Mei-Ling Fullhart
3. Caden Grover
4. Lucas Fabianek


# Sprint 3 (11/05/24):
## Meeting Notes:
We used Apache Commons CLI to write code to parse command line arguments for our project.

### Members Present: 
1. Henry Johnson
2. Mei-Ling Fullhart

## Example of Apache Commmons
-- shapetype -- circle 
-- radius -- 2.5 -- centimeters
-- area 

print the output

-- shapetype -- rectangle 
-- length -- 4.5 -- centimeters -- width -- 4.0 -- centimeters
-- perimeter

print the output

-- shapetype -- right triangle 
-- base -- 2.5 -- centimeters -- height -- 3.0 -- centimeters
-- area

print the output

## Apache Common Breakdown
|        Type         |                                           Possible Arguments                                           |
|:-------------------:|:------------------------------------------------------------------------------------------------------:|
|      ShapeType      |                               Rectangle, Square, Circle, Right Triangle                                |
|     Calculation     |                               Area, Perimeter (Circumference if Circle)                                |
|       Values        | Length and width for rectangle or square; radius and diameter for circle; base and height for triangle |
| Unit of measurement |                      Centimeters, inches, meters, feet, yards, kilometers, miles                       |

# Sprint 4 (11/12/24)
## Meeting Notes:
Within this meeting we implemented Apache Commons into our code and began 
building out some basic functionality of our shapecalc program.

### Actual Time Spent: 2 Hours

### Members Present:
1. Henry Johnson
2. Mei-Ling Fullhart
3. Lucas Fabianek


# Sprint 5 (11/11)
## Meeting Notes:
Continued Apache Commons implementation and basic functional programming

### Members Present:
1. Henry Johnson
2. Mei-Ling Fullhart
3. Lucas Fabianek
4. Caden Grover

# Sprint 6 (11/26)
## Meeting Notes:
Added new tests utilizing J-Unit.
(Still need to continue fixing errors, was not able to fix everything)

### Members Present:
1. Henry Johnson
2. Mei-Ling Fullhart
3. Lucas Fabianek
4. Caden Grover

# Sprint 7 (12/2)
## Meeting Notes:
Added support for:
- Spanish
- French
- Italian
- German
- English

### Members Present:
1. Lucas Fabianek
2. Henry Johnson
3. Mei-Ling Fullhart
4. Caden Grover