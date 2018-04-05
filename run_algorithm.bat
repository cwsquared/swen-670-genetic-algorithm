ECHO OFF
REM This script will run the genetic algorithm program with certain parameters.
REM 	[0] = fitness function
REM		[1] = POP_SIZE
REM		[2] = NUM_OF_GENERATIONS
REM		[3] = NUM_GENES_PER_INDIVIDUAL
REM		[4] = MUTATION_RATE 
REM		[5] = METHYLATION_COUNT

SET filename=genetic_algorithm_output.csv

ECHO.
ECHO Output file is located at: 
ECHO.
ECHO %CD%\%filename%
ECHO. 
PAUSE

:: Clears out genetic_algorithm_output.csv
break > %filename%

ECHO.
:: Fitness Function #1
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 1 20 20 16 1.6 5 >> %filename%

::ECHO.>>%filename%

::ECHO.
::ECHO Fitness Function #2
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 2 20 20 16 1.6 5 >> %filename%

::ECHO.>>%filename%

::ECHO.
::ECHO Fitness Function #3
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 3 20 20 16 1.6 5 >> %filename%

::ECHO.>>%filename%

::ECHO.
::ECHO Fitness Function #4
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 4 20 20 16 1.6 5 >> %filename%

::ECHO.>>%filename%

::ECHO.
::ECHO Fitness Function #5
java -classpath ./build/GeneticAlgorithm.jar geneticalgorithm/ResearchGA 5 20 20 16 1.6 5 >> %filename%