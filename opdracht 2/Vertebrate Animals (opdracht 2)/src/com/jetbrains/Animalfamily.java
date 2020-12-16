package com.jetbrains;

import java.util.ArrayList;

public class Animalfamily implements ThreeNode, Visitable {
    private AnimalClass mParent;
    private ArrayList<ThreeNode> mChildren;
    private String mData;

    public Animalfamily(String data){
        mData = data;
        mParent = null;
        mChildren = new ArrayList<>();
    }

    @Override
    public void setParent(ThreeNode parent) {
        mParent = (AnimalClass)parent;
    }

    @Override
    public void addChild(ThreeNode child) {
        mChildren.add(child);
    }

    @Override
    public ThreeNode getParent() {
        return mParent;
    }

    @Override
    public ArrayList<ThreeNode> getChildren() {
        return mChildren;
    }

    @Override
    public String getData() {
        return mData;
    }

    @Override
    public void accept(Visitor v) {
        v.visitFamily(this);
    }
}
