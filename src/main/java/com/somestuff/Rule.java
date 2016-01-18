package com.somestuff;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class Rule {
    String sourceState;
    char InputSymbol;
    String targetState;

    public Rule(String sourceState, char inputSymbol, String targetState) {
        this.sourceState = sourceState;
        InputSymbol = inputSymbol;
        this.targetState = targetState;
    }

}
