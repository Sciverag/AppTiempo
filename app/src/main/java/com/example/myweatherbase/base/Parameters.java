package com.example.myweatherbase.base;

public class Parameters {

    public final static String API = "b7672169f202d654046b8699bc383877";
    public final static String LANG = "es";
    public final static String UNITS = "metric";
    public final static String URL = "https://api.openweathermap.org/data/2.5/";
    public final static String URL_OPTIONS =   "forecast?appid=" + API + "&lang=" + LANG + "&units=" + UNITS;

    public final static String ICON_URL_PRE = "http://openweathermap.org/img/wn/";
    public static final String ICON_URL_POST = "@2x.png";

}
