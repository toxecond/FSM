package com.somestuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class InputProcessor {
    private String headState;
    private final String inputPath;
    private final List<Rule> rules;

    public InputProcessor(String inputPath, List<Rule> rules) {
        this.headState = "state1";
        this.inputPath = inputPath;
        this.rules = rules;
    }

    public void process() {
        final File input = new File(inputPath);

        try {
            final char[] inputText = new Scanner(input).nextLine().trim().toCharArray();
            System.out.println("Head in " + headState);
            for (char symbol : inputText){
                System.out.println("Read symbol '" + symbol + "'");
                for (Rule rule: rules) {
                    if (symbol == rule.getInputSymbol() && headState.equals(rule.getSourceState())) {
                        headState = rule.getTargetState();
                        System.out.println("Head in " + headState);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
