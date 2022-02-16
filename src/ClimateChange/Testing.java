package ClimateChange;

import java.io.*;
import java.util.*;

public class Testing {

    //use for testing code and checking if each method work correctly.
    public static void main (String[] args) {
        ArrayList<ITemperature> list = new ArrayList<ITemperature>();
        ClimateAnalyzer read = new ClimateAnalyzer(list);
        read.readDataFromFile("world_temp_2000-2016.csv");
        //System.out.println(read.getLowestTemp("United States", 4));
        //System.out.println(read.getHighestTemp("United States", 11));
        //System.out.println(read.getLowestTempYearByCountry("United States"));
        //System.out.println(read.getHighestTempYearByCountry("United States"));
        //System.out.println(read.getLowestTempByYear("United States", 2012));
        //System.out.println(read.getHighestTempByYear("United States", 2001));
        //System.out.println(read.getTempWithinRange("United States", -1, 16.23));
        //System.out.println(read.allCountriesGetTop10LowestTemp(2));
        //System.out.println(read.allCountriesGetAllDataWithinTempRange(2,6));
        //System.out.println(read.allCountriesGetTop10LowestTemp());
        //System.out.println(read.allCountriesGetTop10HighestTemp(5));
        //System.out.println(read.allCountriesGetTop10HighestTemp());
        //System.out.println(read.allCountriesTop10TempDelta(8, 2000, 2016));

    }
}
