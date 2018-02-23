/**
 * SWEN 670 - Research Team
 * Main Java Class
 * 
 * @author Chris Wright, Raj Patel, Al Ramsey, Charles Enwesi, Amanda Lee, Kingsley Usen
 */

package geneticalgorithm;

public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello SWEN Team Members!");
		
		// First argument passed in is a string
		if(args.length > 0 && !args[0].isEmpty()) {
			System.out.println("My name is... " + args[0]);
		}

	}

}
