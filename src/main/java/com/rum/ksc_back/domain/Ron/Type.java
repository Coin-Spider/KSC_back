package com.rum.ksc_back.domain.Ron;

public class Type {
    private int typeId;
    private String typeContent;
    private int typeFather;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public int getTypeFather() {
        return typeFather;
    }

    public void setTypeFather(int typeFather) {
        this.typeFather = typeFather;
    }

    public Type(int typeId, String typeContent, int typeFather) {
        this.typeId = typeId;
        this.typeContent = typeContent;
        this.typeFather = typeFather;
    }
}
