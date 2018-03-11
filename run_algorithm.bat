REM This script will run the genetic algorithm program with certain parameters.

SET filename=genetic_algorithm_output.csv

break > %filename%

REM Fitness Function #1
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 1 2 2 8 0.2 2 >> %filename%
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 1 8 2 16 0.5 2 >> %filename%

ECHO.>>%filename%

REM Fitness Function #2
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 2 2 1 5 0.2 2 >> %filename%

ECHO.>>%filename%

REM Fitness Function #3

ECHO.>>%filename%

REM Fitness Function #4

ECHO.>>%filename%

REM Fitness Function #5