package com.somestuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jellojunkie on 1/15/16.
 */
public class ReadRules {
    public static String readRules(String[] args) {
        String result = "";
        if(args.length > 1 && args[1] != null && !args[1].isEmpty()) try {
            Scanner rules = new Scanner(new File(args[1]));
            while (rules.hasNextLine()) {
                result = result.concat("\n");
                result = result.concat(rules.nextLine());
            }
        } catch (FileNotFoundException e) {
            result = "The input file does not exist.";
        }
        else {
            System.out.println("No name of rules file has been specified, aborting.");
            System.exit(1);
        }
        return(result);
    }
}
