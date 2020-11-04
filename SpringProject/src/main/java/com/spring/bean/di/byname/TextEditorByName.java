package com.spring.bean.di.byname;

public class TextEditorByName {
    private SpellCheckerByName spellCheckerByName;
    private String name;

    public void setSpellCheckerByName(SpellCheckerByName spellCheckerByName) {
        this.spellCheckerByName = spellCheckerByName;
    }

    public SpellCheckerByName getSpellCheckerByName123() {
        return spellCheckerByName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void spellCheck() {
        spellCheckerByName.checkSpelling();
    }
}
