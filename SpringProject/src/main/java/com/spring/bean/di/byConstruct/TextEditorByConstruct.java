package com.spring.bean.di.byConstruct;

public class TextEditorByConstruct {
    private SpellCheckByConstruct spellCheckByConstruct;

    private String name;

    public TextEditorByConstruct(SpellCheckByConstruct spellCheckByConstruct, String name) {
        this.spellCheckByConstruct = spellCheckByConstruct;
        this.name = name;
    }

    public SpellCheckByConstruct getSpellCheckByConstruct() {
        return spellCheckByConstruct;
    }

    public String getName() {
        return name;
    }

    public void spellCheck() {
        spellCheckByConstruct.checkSpelling();
    }
}
