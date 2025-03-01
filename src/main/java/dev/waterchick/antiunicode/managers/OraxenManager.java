package dev.waterchick.antiunicode.managers;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.font.Glyph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OraxenManager extends AbstractManager{


    @Override
    public List<String> load() {
        List<String> listChars = new ArrayList<>();
        OraxenPlugin oraxenPlugin = OraxenPlugin.get();
        Collection<Glyph> glyphs = oraxenPlugin.getConfigsManager().parseGlyphConfigs();
        for(Glyph glyph : glyphs){
            if(!glyph.isEmoji()) listChars.add(glyph.getCharacter());
        }
        return listChars;
    }
}
