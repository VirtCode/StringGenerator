package code.generation;

import code.learning.StyleData;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Generator {

    StyleUtilizer utilizer;
    StyleData data;

    public Generator(StyleData style){
        this.data = style;
        this.utilizer = new StyleUtilizer(data);


    }

}
