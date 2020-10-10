package ch.virt.stringgenerator.style;

import com.google.gson.Gson;

/**
 * This utility class is used to convert Styles into (different) formats
 * @author VirtCode
 * @version 1.0
 */
public class StyleStorage {
    /**
     * Converts a Style to a json string
     * @param style style to convert
     * @return json string
     */
    public static String toJSON(Style style){
        return new Gson().toJson(style);
    }

    /**
     * This converts a json string to a Style
     * @param string json String
     * @return created Style
     */
    public static Style fromJSON(String string){
        return new Gson().fromJson(string, Style.class);
    }
}
