package com.somestuff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class InputProcessor {
    private String headState;
    private final String inputPath;
    private HashMap<RuleKey, Rule> map = new HashMap<>();

    public InputProcessor(String inputPath, List<Rule> rules) {
        this.headState = "state1";
        this.inputPath = inputPath;
        for (Rule rule: rules) {
            map.put(new RuleKey(rule.getSourceState(), rule.getInputSymbol()), rule);
        }
    }

    public void process() {
        final File input = new File(inputPath);

        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("Head in {}", headState);

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(input),
                            Charset.forName("UTF-8")));
            int c;

            while((c = reader.read()) != -1) {
                char symbol = (char) c;
                if (symbol != ' ' && symbol != '\t' && symbol != '\n' && symbol != '\r') {
                    logger.info("Read symbol '{}'", symbol);
                    Rule rule = map.get(new RuleKey(headState, symbol));
                    headState = rule.getTargetState();
                    logger.info("Head in {}", headState);
                }
            }
        } catch (IOException e) {
            throw new FSMException("IOException: Cannot read symbols in input.txt.");
        }
    }
}
