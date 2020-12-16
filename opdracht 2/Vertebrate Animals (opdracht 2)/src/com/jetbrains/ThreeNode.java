package com.jetbrains;

import java.util.ArrayList;

public interface ThreeNode {
    public void setParent(ThreeNode parent);

    public void addChild(ThreeNode child);

    public ThreeNode getParent();

    public ArrayList<ThreeNode> getChildren();

    public String getData();
}
