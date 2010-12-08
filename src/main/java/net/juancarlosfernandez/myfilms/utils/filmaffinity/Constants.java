package net.juancarlosfernandez.myfilms.utils.filmaffinity;

import java.text.SimpleDateFormat;

public class Constants {
    public static final String dateFormatString = "yyyy-MM-dd";
    public static final String dateFormatLongString = dateFormatString + " HH:mm:ss";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
    public static final SimpleDateFormat dateFormatLong = new SimpleDateFormat(dateFormatLongString);
    
    public static final String UNKNOWN = "UNKNOWN";
}
