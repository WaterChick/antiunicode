package dev.waterchick.antiunicode.managers;

import dev.waterchick.antiunicode.enums.ConfigValue;

import java.util.List;

public class ListManager extends AbstractManager{

    @Override
    public List<String> load() {
        return ConfigValue.LIST_CHARS.getValueList();
    }
}
