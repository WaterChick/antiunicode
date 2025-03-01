package dev.waterchick.antiunicode.managers;


import com.nexomc.nexo.NexoPlugin;
import com.nexomc.nexo.fonts.Glyph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NexoManager extends AbstractManager{

    @Override
    public List<String> load() {
        List<String> listChars = new ArrayList<>();
        NexoPlugin nexoPlugin = NexoPlugin.instance();
        Collection<Glyph> glyphs = nexoPlugin.configsManager().parseGlyphConfigs();
        for(Glyph glyph : glyphs){
            if(!glyph.isEmoji()) listChars.add(glyph.character());
        }
        return listChars;
    }
}
