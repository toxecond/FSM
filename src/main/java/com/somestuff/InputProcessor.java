package com.somestuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class InputProcessor {
    String headState;
    String input;
    List<Rule> rules;

    public InputProcessor(String input, List<Rule> rules) {
        this.headState = "state1";
        this.input = input;
        this.rules = rules;
    }

    public void process() {
        Scanner input = null;
        try {
            input = new Scanner(new File(this.input));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        char[] input_text = input.nextLine().trim().toCharArray();
        System.out.println("Head in " + this.headState);
        for (char symbol : input_text) {

            System.out.println("Read symbol '" + symbol + "'");
            for (Rule rule : this.rules) {
                if (symbol == rule.InputSymbol && this.headState.equals(rule.sourceState)) {
                    this.headState = rule.targetState;
                    System.out.println("Head in " + this.headState);
                    break;
                }

            }


        }
    }
}
