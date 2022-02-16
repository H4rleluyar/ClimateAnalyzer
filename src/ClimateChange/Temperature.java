package ClimateChange;

import java.util.*;
import java.io.*;

public class Temperature implements ITemperature, Comparable<Temperature> {

    private double temperature;
    private int year;
    private String month;
    private String country;
    private String country3Code;

    public Temperature(double temperature, int year, String month, String country, String country3Code) {

        this.temperature = temperature;
        this.year = year;
        this.month = month;
        this.country = country;
        this.country3Code = country3Code;
    }

    //custom toString Method that print data in ArrayFormat
    public String toString() {
        return "[" + temperature + ", " + year + ", " + month + ", "
                + country + ", " + country3Code + "]";
    }

    // get the name of the country
    public String getCountry() {
        return country;
    }

    // get the 3-letter code of the country
    public String getCountry3LetterCode() {
        return country3Code;
    }

    // get the month
    public String getMonth() {
        return month;
    }

    // get the year
    public int getYear() {
        return year;
    }

    // get temperature; input parameter of false = return Celsius value)
    public double getTemperature(boolean getFahrenheit) {

        if(getFahrenheit == false) {
            return temperature;
        }

        //convert to celsius to fahrenheit
        else if(getFahrenheit == true) {
            temperature = temperature * (9f / 5) + 32;
        }

        return temperature;

    }

    //testing change to Temperature later
    public int compareTo(Temperature that) {
        int countryInteger = this.country.compareTo(that.getCountry()); //int version of country
        int monthInteger = this.month.compareTo(that.getMonth()); // int version of month

        if(this.temperature < that.getTemperature(false)) { // first compare temperature
            return -1;
        }
        else if(this.temperature > that.getTemperature(false)) {
            return 1;
        }
        else if(this.temperature == that.getTemperature(false)) { // if temp same, then compare country
            if(countryInteger != 0) {
                return countryInteger;
            }
            else if(countryInteger == 0) {       // if country same, compare year
                if(this.year < that.getYear()) {
                    return -1;
                }
                else if (this.year > that.getYear()) {
                    return 1;
                }
                else if(this.year == that.getYear()) {  /// if  year same, compare month
                    if(monthInteger != 0) {
                        return monthInteger;
                    }
                }
            }
        }
        return 0;
    }

    //need for the compareTo method to for comparison
    public boolean equals(Object x)
    {
        Temperature that = (Temperature) x;
        return this.compareTo(that) == 0;
    }


}
