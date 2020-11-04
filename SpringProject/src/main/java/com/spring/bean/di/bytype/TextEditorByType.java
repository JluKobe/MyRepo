package com.spring.bean.di.bytype;

public class TextEditorByType {
    private SpellCheckerByType spellCheckerByType;
    private String name;

    public void setSpellCheckerByType(SpellCheckerByType spellCheckerByType) {
        this.spellCheckerByType = spellCheckerByType;
    }

    public SpellCheckerByType getSpellCheckerByType() {
        return spellCheckerByType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void spellCheck() {
        spellCheckerByType.checkSpelling();
    }
}
