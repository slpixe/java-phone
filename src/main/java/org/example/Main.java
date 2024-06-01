package org.example;

/**
 * This is the main class of the program.
 * It contains the entry point of the application.
 *
 * @author Dean
 * @version 1.0
 * @since 2024-06-01
 */
public class Main {

    /**
     * Construct.
     */
    Main(){}

    /**
     * The main method is the entry point of the application.
     * It is called when the program starts.
     *
     * @param args Command line arguments. Not used in this example.
     */
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}