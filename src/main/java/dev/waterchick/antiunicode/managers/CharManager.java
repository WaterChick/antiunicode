package dev.waterchick.antiunicode.managers;

import dev.waterchick.antiunicode.enums.ConfigValue;
import dev.waterchick.antiunicode.enums.Mode;

import java.util.*;

public class CharManager {

    /*
    LIST OF ALL BLOCKED CHARS
     */
    private List<String> listChars;

    public CharManager(){
        this.listChars = new ArrayList<>();
    }

    public void reload(){
        this.load();
    }

    public void load(){
        Mode mode;
        this.listChars.clear();
        AbstractManager manager = null;
        try{
            mode = Mode.valueOf(ConfigValue.MODE.getValue());
        }catch (IllegalArgumentException e){
            mode = Mode.LIST;
        }
        switch (mode){
            case ORAXEN -> {
                manager = new OraxenManager();
            }
            case LIST -> {
                manager = new ListManager();
            }
            case NEXO -> {
                manager = new NexoManager();
            }
        }
        this.listChars = manager.load();
    }

    public String removeChars(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (!listChars.contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
