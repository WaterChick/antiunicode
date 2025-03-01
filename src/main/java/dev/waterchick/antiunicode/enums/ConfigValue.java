package dev.waterchick.antiunicode.enums;

import java.util.Arrays;
import java.util.List;

public enum ConfigValue {
    MODE("ORAXEN"),
    LIST_CHARS(Arrays.asList("ꐙ", "ꐟ"));

    private String value;
    private List<String> valueList;

    ConfigValue(String value){
        this.value = value;
    }

    ConfigValue(List<String> valueList){
        this.valueList = valueList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }
}
