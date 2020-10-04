package ch.virt.stringgenerator.style;

import com.google.gson.Gson;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleStorage {
    public static String toJSON(Style style){
        return new Gson().toJson(style);
    }

    public static Style fromJSON(String string){
        return new Gson().fromJson(string, Style.class);
    }
}
