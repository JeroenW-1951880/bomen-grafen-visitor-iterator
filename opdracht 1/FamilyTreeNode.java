package com.jetbrains;

/**
 * class that represents a member of a family tree
 *
 * @author Jeroen Weltens
 */
public class FamilyTreeNode {
    private String m_name;
    private FamilyTreeNode[] m_parents;
    private FamilyTreeNode[] m_children;
    private FamilyTreeNode m_partner;

    /**
     * constructor of the family member
     * @param name the name of the member
     */
    public FamilyTreeNode(String name){ m_name = name; }

    /**
     * adds a child to the familymember
     * @param child the child to add
     * @post the parents of the child are set to this member and its partner(if it has one)
     * @post the child is added to the children array of this member and its partners
     */
    public void add_child(FamilyTreeNode child){
        child.m_parents[child.m_parents.length] = this;
        if(m_partner != null){
            child.m_parents[child.m_parents.length] = m_partner;
            m_partner.m_children[m_partner.m_children.length] = child;
        }
        m_children[m_children.length] = child;
    }

    /**
     * method to make someone the partner of this familymember
     * @param partner the partner to set
     * @post if this member had a partner before, that partners partner is set to null
     */
    public void marry(FamilyTreeNode partner){
        if(m_partner != null){
            m_partner.m_partner = null;
        }
        partner.m_partner = this;
        m_partner = partner;
    }

    public static void main(String[] args) {

    }
}
