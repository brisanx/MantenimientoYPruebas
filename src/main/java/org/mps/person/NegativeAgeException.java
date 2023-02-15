package org.mps.person;

public class NegativeAgeException extends Throwable {
    public NegativeAgeException(String s) {
        super(s);
    }
}
