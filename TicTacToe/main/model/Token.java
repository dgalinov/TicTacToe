package model;

public enum Token {
    X,
    H,
    O;

    public static Token valueOf(int token) {
        for (Token t : Token.values()) {
            if (t.ordinal() == token-1){
                return t;
            }
        }
        return null;
    }
}
