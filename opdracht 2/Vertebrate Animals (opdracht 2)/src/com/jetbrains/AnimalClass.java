package com.jetbrains;

import java.util.ArrayList;

public class AnimalClass implements ThreeNode, Visitable {
    private ThreeNode mParent;
    private ArrayList<ThreeNode> mChildren;
    private String mData;

    public AnimalClass(String data){
        mData = data;
        mChildren = new ArrayList<>();
        mParent = null;
    }

    @Override
    public void setParent(ThreeNode parent) {
        mParent = null;
    }

    @Override
    public void addChild(ThreeNode child) {
        mChildren.add((Animalfamily)child);
    }

    @Override
    public ThreeNode getParent() {
        return null;
    }

    @Override
    public ArrayList<ThreeNode> getChildren() {
        return mChildren;
    }

    @Override
    public void accept(Visitor v) {
        v.visitClass(this);
    }

    @Override
    public String getData() {
        return mData;
    }
}
