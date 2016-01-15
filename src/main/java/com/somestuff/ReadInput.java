package com.somestuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jellojunkie on 1/15/16.
 */
public class ReadInput {
    public static String readInput(String[] args) {
        String result = "";
        if(args.length > 0) {
            try {
                Scanner input = new Scanner(new File(args[0]));
                result = input.nextLine();
            } catch (FileNotFoundException e) {
                result = "The input file does not exist.";
            }
        } else {
            System.out.println("No name for input file has been specified, aborting.");
            System.exit(1);
        }
        return(result);
    }
}
