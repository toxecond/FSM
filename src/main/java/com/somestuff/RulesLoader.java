package com.somestuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class RulesLoader {

    static File rules;
    static List<Rule> result = new ArrayList<Rule>();

    public RulesLoader(String rulesPath) {
        this.rules = new File(rulesPath);
    }

    public static List<Rule> load() {
        try {
            Scanner text = new Scanner(rules);
            while(text.hasNextLine()){
                String line = text.nextLine();
                String[] splitLine = line.split("\\+");
                String sourceState = splitLine[0].trim();
                splitLine = splitLine[1].split("=");
                char InputSymbol = splitLine[0].charAt(1);
                String targetState = splitLine[1].trim();
                Rule rule = new Rule(sourceState, InputSymbol, targetState);
                result.add(rule);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
