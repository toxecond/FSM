package com.somestuff;

/**
 * Created by jellojunkie on 1/15/16.
 */
public class FiniteStateMachine {
    public static void main(String[] args) {
        ReadInput readInput = new ReadInput();
        ReadRules readRules = new ReadRules();
        System.out.println(readInput.readInput(args));
        System.out.println(readRules.readRules(args));
    }
}
