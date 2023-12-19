package main.java.fields;

public class CharField extends Field {
    private int maxLength;

    public CharField(String name, int maxLength) {
        super(name);
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
}