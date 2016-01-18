package com.somestuff;

import java.util.List;

/**
 * Created by jellojunkie on 1/15/16.
 */
public class FiniteStateMachine {
    public static void main(String[] args) {

        try {
            List<Rule> rules = new RulesLoader(args[1]).load();
            InputProcessor inProc = new InputProcessor(args[0], rules);
            inProc.process();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
