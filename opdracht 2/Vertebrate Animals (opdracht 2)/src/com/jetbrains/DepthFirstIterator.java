package com.jetbrains;


public class DepthFirstIterator implements Iterator {
    @Override
    public boolean HasNext(ThreeNode n) {
        if(n.getChildren() != null && n.getChildren().size() > 0){
            return true;
        } else {
            while(n.getParent() != null){
                ThreeNode parent = n.getParent();
                if(parent.getChildren().indexOf(n) + 1 < parent.getChildren().size()) {
                    return true;
                } else {
                    n = n.getParent();
                }
            }
            return false;
        }
    }

    @Override
    public ThreeNode GetNext(ThreeNode n) {
        if(n.getChildren() != null && n.getChildren().size() > 0){
            return n.getChildren().get(0);
        } else {
            while(n.getParent() != null){
                ThreeNode parent = n.getParent();
                if(parent.getChildren().indexOf(n) + 1 < parent.getChildren().size()) {
                    return parent.getChildren().get(parent.getChildren().indexOf(n) + 1);
                } else {
                    n = n.getParent();
                }
            }
            System.err.println("out of bounds");
            return null;
        }
    }
}
