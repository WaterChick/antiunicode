package dev.waterchick.antiunicode;

public class Main {

    public static void main(String[] args){
        System.out.println(removeUnicode("jojoo §"));
    }

    public static String removeUnicode(String input) {
        if (input == null) {
            return null; // Pokud je vstup null, vrátíme null
        }
        // Použití regulárního výrazu pro ponechání pouze ASCII znaků
        return input.replaceAll("[^\\x00-\\x7FáčďéěíľĺňóôřšťúůýžÁČĎÉĚÍĽĹŇÓÔŘŠŤÚŮÝŽ§]", "");
    }
}
