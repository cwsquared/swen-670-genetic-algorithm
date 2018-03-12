# SWEN 670 Genetic Algorithm with Methylation
## Master Branch

This repository acts as the starting Eclipse Project for the development of our Epigenetic Genetic Algorithm with Methylation.

To run the application, you will need to download and install the Eclipse Java IDE.

Once inside Eclipse Oxygen IDE, build the project by Opening the Ant Build Manager Window and Clicking Run As on the Genetic Algorithm task.

The Ant Build Manager will generate the necessary JAR file within a /build directory. This file is targeted by the run_algorithm.bat Batch file.

The run_algorithm.bat Batch file contains the arguments supplied to the application for setting fitness function, population size, number of generations, number of genes per indiviudal, mutation rate, and methylation coumt.

Next, in the root directory of the project, run the run_algorithm.bat Batch file. This will generate a Comma Separated Values (CSV) output of the Genetic Algorithm.

To view the results of the application, open the genetic_algorithm_output.csv file.