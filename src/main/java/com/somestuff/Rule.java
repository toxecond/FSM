package com.somestuff;

/**
 * Created by jellojunkie on 1/18/16.
 */
public class Rule {
    private final String sourceState;
    private final char inputSymbol;
    private final String targetState;

    public Rule(String sourceState, char inputSymbol, String targetState) {
        this.sourceState = sourceState;
        this.inputSymbol = inputSymbol;
        this.targetState = targetState;
    }

    public String getSourceState() {
        return sourceState;
    }

    public char getInputSymbol() {
        return inputSymbol;
    }

    public String getTargetState() {
        return targetState;
    }

}
