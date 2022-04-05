package com.robot.util;

public class Constant {

    private Constant(){}
    public static final String SPILITTER_COMMA = ",";
    public static final String SQL_SURVIVOR_LIST = "SELECT id,name,age,gender,last_latitude AS LASTLATITUDE, last_longitude AS LASTLONGITUDE, is_infected AS ISINFECTED FROM survivor ";
    public static final String SQL_SURVIVOR_INFECTED_LIST = "SELECT id,name,age,gender,last_latitude AS LASTLATITUDE, last_longitude AS LASTLONGITUDE, is_infected AS ISINFECTED from survivor WHERE is_infected = 'Y'  ";
    public static final String SQL_SURVIVOR_NON_INFECTED_LIST = "SELECT id,name,age,gender,last_latitude AS LASTLATITUDE, last_longitude AS LASTLONGITUDE, is_infected AS ISINFECTED from survivor WHERE is_infected = 'N' ";
    public static final String S_PERCENTAGE = " %";
    public static final String SQL_SURVIVOR_INFECTED_PER = "WITH sur_icount AS (SELECT count(*) AS ic FROM survivor WHERE is_infected='Y') "
                                                            + " ,sur_count AS (SELECT count(*) AS tc FROM survivor) "
                                                            + " SELECT (i.ic/t.tc*100) AS per  FROM sur_icount i, sur_count t ";
    public static final String SQL_SURVIVOR_NON_INFECTED_PER = "WITH sur_nicount AS (SELECT count(*) AS nic FROM survivor WHERE is_infected='N') "
                                                            + " ,sur_count AS (SELECT count(*) AS tc FROM survivor) "
                                                            + " SELECT (ni.nic/t.tc*100) AS per  FROM sur_nicount ni, sur_count t ";

}
