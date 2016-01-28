package com.somestuff;

/**
 * Created by jellojunkie on 1/28/16.
 */
public class RuleKey {
    private final String state;
    private final char aChar;

    public RuleKey(String state, char aChar) {
        this.state = state;
        this.aChar = aChar;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleKey ruleKey = (RuleKey) o;

        if (aChar != ruleKey.aChar) return false;
        return state != null ? state.equals(ruleKey.state) : ruleKey.state == null;

    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (int) aChar;
        return result;
    }
}
