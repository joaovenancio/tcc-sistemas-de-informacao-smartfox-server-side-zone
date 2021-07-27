package br.ufsc.inf.leb;

public enum ServerSetupVariables {
    //Enums:
    MIN_PLAYERS_TO_START("3"),
    MAX_PLAYERS_IN_ROOM("5");

    //Atributes:
    private String value;

    //Constructor:
    ServerSetupVariables(String value) {
        this.value = value;
    }

    //Methods:
    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return Integer.parseInt(value);
    }


}
