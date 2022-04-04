package com.robot.util;

public class Constant {

    private Constant(){}
    public static final String SPILITTER_COMMA = ",";
    public static final String SQL_SURVIVOR_LIST = "SELECT id,name,age,gender,last_latitude as LASTLATITUDE, last_longitude as LASTLONGITUDE, is_infected as ISINFECTED FROM survivor;";
    public static final String SQL_SURVIVOR_INFECTED_LIST = "SELECT id,name,age,gender,last_latitude as LASTLATITUDE, last_longitude as LASTLONGITUDE, is_infected as ISINFECTED from survivor WHERE is_infected = 'Y';";
    public static final String SQL_SURVIVOR_NON_INFECTED_LIST = "SELECT id,name,age,gender,last_latitude as LASTLATITUDE, last_longitude as LASTLONGITUDE, is_infected as ISINFECTED from survivor WHERE is_infected = 'N';";
    public static final String S_PERCENTAGE = "0 %";
    public static final String S_INFECTED = "Y";
    public static final String S_NON_INFECTED = "N";

}
