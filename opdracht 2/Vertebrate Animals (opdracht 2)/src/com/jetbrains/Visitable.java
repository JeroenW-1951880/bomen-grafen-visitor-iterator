package com.jetbrains;

public interface Visitable {
    public void accept(Visitor v);
}
