package com.somestuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class RulesLoader {

    private static final Pattern PATTERN =
            Pattern.compile("(\\w+)\\s+\\+\\s+(\\w)\\s=\\s(\\w+)");
    private final String rulesPath;


    public RulesLoader(String rulesPath) {
        this.rulesPath = rulesPath;
    }

    public List<Rule> load() {
        final File rules = new File(this.rulesPath);
        final List<Rule> result = new ArrayList<Rule>();

        try {
            final Scanner text = new Scanner(rules);
            while(text.hasNextLine()){
                final String line = text.nextLine();
                final Matcher matcher = PATTERN.matcher(line);
                if(matcher.matches()){
                    final Rule rule = new Rule(matcher.group(1),
                            matcher.group(2).charAt(0), matcher.group(3));
                    result.add(rule);
                }
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
