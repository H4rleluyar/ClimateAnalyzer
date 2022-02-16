package ClimateChange;

import java.util.*;
import java.io.*;

public class ClimateAnalyzer extends WeatherIO implements IClimateAnalyzer{

    private ArrayList<ITemperature> list;

    public ClimateAnalyzer(ArrayList<ITemperature> list) {
        this.list = list;
    }

    //use to add ITemperature object into a array
    public void add(ITemperature t) {
        list.add(t);
    }

    // TASK A-1
    // for all data that matches the specified month, get the lowest temperature reading
    public ITemperature getLowestTemp(String country, int month) {

        writeSubjectHeaderInFile("taskA-1_climate_info.csv", "Task A-1: lowest temperature for " + country + " in month " + month); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(); // use to get array that will be written in csv file
        ITemperature lowestTemp = null;
        double lowest = Double.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) { // this loop is for adding specific information to the empty array;
            ITemperature data = list.get(i);
            int m = 0;
            if(data.getMonth().equalsIgnoreCase("jan")) { //coversion for the month
                m = 1;
            }
            else if(data.getMonth().equalsIgnoreCase("feb")) {
                m = 2;
            }
            else if(data.getMonth().equalsIgnoreCase("mar")) {
                m = 3;
            }
            else if(data.getMonth().equalsIgnoreCase("apr")) {
                m = 4;
            }
            else if(data.getMonth().equalsIgnoreCase("may")) {
                m = 5;
            }
            else if(data.getMonth().equalsIgnoreCase("jun")) {
                m = 6;
            }
            else if(data.getMonth().equalsIgnoreCase("jul")) {
                m = 7;
            }
            else if(data.getMonth().equalsIgnoreCase("aug")) {
                m = 8;
            }
            else if(data.getMonth().equalsIgnoreCase("sep")) {
                m = 9;
            }
            else if(data.getMonth().equalsIgnoreCase("oct")) {
                m = 10;
            }
            else if(data.getMonth().equalsIgnoreCase("nov")) {
                m = 11;
            }
            else if(data.getMonth().equalsIgnoreCase("dec")) {
                m = 12;
            }

            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && month == m && data.getTemperature(false) <= lowest) {
                lowestTemp = data;
                lowest = lowestTemp.getTemperature(false);

            }
        }
        theWeatherList.add(lowestTemp);
        writeDataToFile("taskA-1_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return lowestTemp; // return ITemperature with fahrenheit as the temperature
    }

    // TASK A-1
    // for all data that matches the specified month, get the highest temperature reading
    public ITemperature getHighestTemp(String country, int month) {

        writeSubjectHeaderInFile("taskA-1_climate_info.csv", "Task A-1: highest temperature for " + country + " in month " + month); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(); // use to get array that will be written in csv file
        ITemperature highestTemp = null;
        double highest = Double.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) { // this loop is for adding specific information to the empty array;
            ITemperature data = list.get(i);
            int m = 0;
            if(data.getMonth().equalsIgnoreCase("jan")) { //coversion for the month
                m = 1;
            }
            else if(data.getMonth().equalsIgnoreCase("feb")) {
                m = 2;
            }
            else if(data.getMonth().equalsIgnoreCase("mar")) {
                m = 3;
            }
            else if(data.getMonth().equalsIgnoreCase("apr")) {
                m = 4;
            }
            else if(data.getMonth().equalsIgnoreCase("may")) {
                m = 5;
            }
            else if(data.getMonth().equalsIgnoreCase("jun")) {
                m = 6;
            }
            else if(data.getMonth().equalsIgnoreCase("jul")) {
                m = 7;
            }
            else if(data.getMonth().equalsIgnoreCase("aug")) {
                m = 8;
            }
            else if(data.getMonth().equalsIgnoreCase("sep")) {
                m = 9;
            }
            else if(data.getMonth().equalsIgnoreCase("oct")) {
                m = 10;
            }
            else if(data.getMonth().equalsIgnoreCase("nov")) {
                m = 11;
            }
            else if(data.getMonth().equalsIgnoreCase("dec")) {
                m = 12;
            }

            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && month == m && data.getTemperature(false) >= highest) {
                highestTemp = data;
                highest = highestTemp.getTemperature(false);

            }
        }

        theWeatherList.add(highestTemp);
        writeDataToFile("taskA-1_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return highestTemp; //ITemperature with fahrenheit as the temperature
    }

    // TASK A-2
    // for all data that matches the specified month and year, get the lowest temperature reading
    public ITemperature getLowestTempByYear(String country, int year) {
        writeSubjectHeaderInFile("taskA-2_climate_info.csv", "Task A-2: lowest temperature for " + country + " in year " + year); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(); // use to get array that will be written in csv file
        ITemperature lowestTemp = null;
        double lowest = Double.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) { // this loop is for adding specific information to the empty array;
            ITemperature data = list.get(i);
            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && data.getYear() == year && data.getTemperature(false) <= lowest) {
                lowestTemp = data;
                lowest = lowestTemp.getTemperature(false);

            }
        }

        theWeatherList.add(lowestTemp);
        writeDataToFile("taskA-2_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return lowestTemp; // return ITemperature with fahrenheit as the temperature
    }

    // TASK A-2
    // for all data that matches the specified month and year, get the highest temperature reading
    public ITemperature getHighestTempByYear(String country, int year) {
        writeSubjectHeaderInFile("taskA-2_climate_info.csv", "Task A-2: highest temperature for " + country + " in year " + year); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(); // use to get array that will be written in csv file
        ITemperature highestTemp = null;
        double highest = Double.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) { // this loop is for adding specific information to the empty array;
            ITemperature data = list.get(i);
            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && data.getYear() == year && data.getTemperature(false) >= highest) {
                highestTemp = data;
                highest = highestTemp.getTemperature(false);

            }
        }

        theWeatherList.add(highestTemp);
        writeDataToFile("taskA-2_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return highestTemp; //ITemperature with fahrenheit as the temperature
    }

    // TASK A-3
    // get all temperature data that fall within the given temperature range
    // the set is sorted from lowest to highest temperature
    // input parameter values are in Celsius
    public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp){
        writeSubjectHeaderInFile("taskA-3_climate_info.csv", "Task A-3: Get all temperature data that fall within the given " + rangeLowTemp +
                " low range and " + rangeHighTemp + " high temperature range for " + country); // Write information about what the task is
        TreeSet<ITemperature> sortedSet = new TreeSet<ITemperature>();
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(sortedSet);
        list = readDataFromFile("world_temp_2000-2016.csv");
        for(int i = 0; i <list.size(); i++) {
            ITemperature data = list.get(i);
            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && data.getTemperature(false) >= rangeLowTemp && data.getTemperature(false) <= rangeHighTemp) {
                sortedSet.add(data);
            }
        }
        theWeatherList.addAll(sortedSet);
        writeDataToFile("taskA-3_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return sortedSet; //TreeSet with fahrenheit as the temperature in the array printed


    }

    // TASK A-4
    // 1. get the lowest temperature reading amongst all data for that country
    public ITemperature getLowestTempYearByCountry(String country) {

        writeSubjectHeaderInFile("taskA-4_climate_info.csv", "Task A-4: lowest temperature for " + country); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(); // use to get array that will be written in csv file
        ITemperature lowestTemp = null;
        double lowest = Double.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) { // this loop is for adding specific information to the empty array;
            ITemperature data = list.get(i);

            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && data.getTemperature(false) <= lowest) {
                lowestTemp = data;
                lowest = lowestTemp.getTemperature(false);

            }
        }
        theWeatherList.add(lowestTemp);
        writeDataToFile("taskA-4_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return lowestTemp; // return ITemperature with fahrenheit as the temperature
    }

    // TASK A-4
    // 1. get the highest temperature reading amongst all data for that country
    public ITemperature getHighestTempYearByCountry(String country) {

        writeSubjectHeaderInFile("taskA-4_climate_info.csv", "Task A-4: highest temperature for " + country); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>(); // use to get array that will be written in csv file
        ITemperature highestTemp = null;
        double highest = Double.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) { // this loop is for adding specific information to the empty array;
            ITemperature data = list.get(i);

            if(data.getCountry().toLowerCase().contains(country.toLowerCase()) && data.getTemperature(false) >= highest) {
                highestTemp = data;
                highest = highestTemp.getTemperature(false);

            }
        }
        theWeatherList.add(highestTemp);
        writeDataToFile("taskA-4_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return highestTemp; //ITemperature with fahrenheit as the temperature
    }

    // TASK B-1
    // 1. the return list is sorted from lowest to highest temperature
    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month){
        writeSubjectHeaderInFile("taskB-1_climate_info.csv", "Task B-1: top 10 lowest temperature during month " + month); // Write information about what the task is
        Set<ITemperature> list = new TreeSet<ITemperature>(readDataFromFile("world_temp_2000-2016.csv")); // read csv file that contains all data and sort them
        ArrayList<ITemperature> sortedSet = new ArrayList<ITemperature>(list); // use to get tree sort data and add to list
        ArrayList<ITemperature> sortedSetM = new ArrayList<ITemperature>(); // sorted set with correct months
        ArrayList<String> sameName = new ArrayList<String>(); // array list contain country string which is already used in so no duplciates
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>();

        for(int i = 0; i < sortedSet.size(); i++) {
            ITemperature data = sortedSet.get(i);
            int m = 0;
            if(data.getMonth().equalsIgnoreCase("jan")) { //coversion for the month
                m = 1;
            }
            else if(data.getMonth().equalsIgnoreCase("feb")) {
                m = 2;
            }
            else if(data.getMonth().equalsIgnoreCase("mar")) {
                m = 3;
            }
            else if(data.getMonth().equalsIgnoreCase("apr")) {
                m = 4;
            }
            else if(data.getMonth().equalsIgnoreCase("may")) {
                m = 5;
            }
            else if(data.getMonth().equalsIgnoreCase("jun")) {
                m = 6;
            }
            else if(data.getMonth().equalsIgnoreCase("jul")) {
                m = 7;
            }
            else if(data.getMonth().equalsIgnoreCase("aug")) {
                m = 8;
            }
            else if(data.getMonth().equalsIgnoreCase("sep")) {
                m = 9;
            }
            else if(data.getMonth().equalsIgnoreCase("oct")) {
                m = 10;
            }
            else if(data.getMonth().equalsIgnoreCase("nov")) {
                m = 11;
            }
            else if(data.getMonth().equalsIgnoreCase("dec")) {
                m = 12;
            }

            if(month == m) {
                sortedSetM.add(data); // add specify mon to arraylist
                for(ITemperature t: sortedSetM) {
                    if(!sameName.contains(t.getCountry())) { // check to see duplicates
                        if(theWeatherList.size() < 10) {
                            theWeatherList.add(t);
                            sameName.add(t.getCountry()); // add to this so there's no duplicates
                        }
                    }
                }
            }
        }
        writeDataToFile("taskB-1_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return theWeatherList; //return ArrayList with fahrenheit as the temperature
    }

    // TASK B-1
    // 1. the return list is sorted from lowest to highest temperature
    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month){
        writeSubjectHeaderInFile("taskB-1_climate_info.csv", "Task B-1: top 10 highest temperature during month " + month); // Write information about what the task is
        TreeSet<ITemperature> list = new TreeSet<ITemperature>(readDataFromFile("world_temp_2000-2016.csv")); // read csv file that contains all data and sort them
        ArrayList<ITemperature> sortedSet = new ArrayList<ITemperature>(list.descendingSet()); // use to get tree sort data and add to list from high to low temp
        ArrayList<ITemperature> sortedSetM = new ArrayList<ITemperature>(); // sorted set with correct months
        ArrayList<String> sameName = new ArrayList<String>(); // array list contain country string which is already used in so no duplciates
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>();

        for(int i = 0; i < sortedSet.size(); i++) {
            ITemperature data = sortedSet.get(i);
            int m = 0;
            if(data.getMonth().equalsIgnoreCase("jan")) { //coversion for the month
                m = 1;
            }
            else if(data.getMonth().equalsIgnoreCase("feb")) {
                m = 2;
            }
            else if(data.getMonth().equalsIgnoreCase("mar")) {
                m = 3;
            }
            else if(data.getMonth().equalsIgnoreCase("apr")) {
                m = 4;
            }
            else if(data.getMonth().equalsIgnoreCase("may")) {
                m = 5;
            }
            else if(data.getMonth().equalsIgnoreCase("jun")) {
                m = 6;
            }
            else if(data.getMonth().equalsIgnoreCase("jul")) {
                m = 7;
            }
            else if(data.getMonth().equalsIgnoreCase("aug")) {
                m = 8;
            }
            else if(data.getMonth().equalsIgnoreCase("sep")) {
                m = 9;
            }
            else if(data.getMonth().equalsIgnoreCase("oct")) {
                m = 10;
            }
            else if(data.getMonth().equalsIgnoreCase("nov")) {
                m = 11;
            }
            else if(data.getMonth().equalsIgnoreCase("dec")) {
                m = 12;
            }

            if(month == m) {
                sortedSetM.add(data); // add specify month to array list
                for(ITemperature t: sortedSetM) {
                    if(!sameName.contains(t.getCountry())) {
                        if(theWeatherList.size() < 10) {
                            theWeatherList.add(t);
                            sameName.add(t.getCountry()); // add to this so there's no duplicates
                        }
                    }
                }
            }
        }
        TreeSet<ITemperature> rightOrder = new TreeSet<ITemperature>(theWeatherList); // readd completed array back to treeset to sort from lowest to highest
        ArrayList<ITemperature> theWeatherListV2 = new ArrayList<ITemperature>(rightOrder); // add treeset to arraylist again to return everything in order
        writeDataToFile("taskB-1_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherListV2);
        return theWeatherListV2; //return ArrayList with fahrenheit as the temperature
    }

    // TASK B-2
    // 1. the return list is sorted from lowest to highest temperature
    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(){
        writeSubjectHeaderInFile("taskB-2_climate_info.csv", "Task B-2: top 10 lowest temperature "); // Write information about what the task is
        Set<ITemperature> list = new TreeSet<ITemperature>(readDataFromFile("world_temp_2000-2016.csv")); // read csv file that contains all data and sort them
        ArrayList<ITemperature> sortedSet = new ArrayList<ITemperature>(list); // use to get tree sort data and add to list
        ArrayList<String> sameName = new ArrayList<String>(); // array list contain country string which is already used in so no duplciates
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>();

        for(ITemperature t: sortedSet) {
            if(!sameName.contains(t.getCountry())) {
                if(theWeatherList.size() < 10) {
                    theWeatherList.add(t);
                    sameName.add(t.getCountry()); // add to this so there's no duplicates
                }
            }
        }
        writeDataToFile("taskB-2_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return theWeatherList; //return ArrayList with fahrenheit as the temperature
    }

    // TASK B-2
    // 1. the return list is sorted from lowest to highest temperature
    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(){

        writeSubjectHeaderInFile("taskB-2_climate_info.csv", "Task B-2: top 10 highest temperature "); // Write information about what the task is
        TreeSet<ITemperature> list = new TreeSet<ITemperature>(readDataFromFile("world_temp_2000-2016.csv")); // read csv file that contains all data and sort them
        ArrayList<ITemperature> sortedSet = new ArrayList<ITemperature>(list.descendingSet()); // use to get tree sort data and add to list from high to low temp
        ArrayList<String> sameName = new ArrayList<String>(); // array list contain country string which is already used in so no duplciates
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>();

        for(ITemperature t: sortedSet) {
            if(!sameName.contains(t.getCountry())) {
                if(theWeatherList.size() < 10) {
                    theWeatherList.add(t);
                    sameName.add(t.getCountry()); // add to this so there's no duplicates
                }
            }
        }
        TreeSet<ITemperature> rightOrder = new TreeSet<ITemperature>(theWeatherList); // readd completed array back to treeset to sort from lowest to highest
        ArrayList<ITemperature> theWeatherListV2 = new ArrayList<ITemperature>(rightOrder); // add treeset to arraylist again to return everything in order
        writeDataToFile("taskB-2_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherListV2);
        return theWeatherListV2; //return ArrayList with fahrenheit as the temperature
    }

    // TASK B-3
    // 1. the return list is sorted from lowest to highest temperature
    public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp,double highRangeTemp){
        writeSubjectHeaderInFile("taskB-3_climate_info.csv", "Task B-3: all Countries within low temperature range " + lowRangeTemp + " and high temperature range " + highRangeTemp); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        Set<ITemperature> sortedSet = new TreeSet<ITemperature>(); // use to sort all data
        ArrayList<ITemperature> sortedSet2 = new ArrayList<ITemperature>(sortedSet);
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>();
        for(int i = 0; i < list.size(); i++) {
            ITemperature data = list.get(i);
            if(data.getTemperature(false) >= lowRangeTemp && data.getTemperature(false) <= highRangeTemp) {
                sortedSet.add(data);
            }
        }
        theWeatherList.addAll(sortedSet);
        writeDataToFile("taskB-3_climate_info.csv","Temperature, Year, Month_Avg, Country, Country_Code", theWeatherList);
        return theWeatherList;
    }

    // TASK C-1
    // 1. the countries with the largest temperature differences (absolute value)
    // 2. the return list is sorted from lowest to highest temperature delta
    public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2){
        writeSubjectHeaderInFile("taskC-1_climate_info.csv", "Task C-1: top 10 largest temperature difference"); // Write information about what the task is
        list = readDataFromFile("world_temp_2000-2016.csv"); // read csv file that contains all data
        ArrayList<ITemperature> sortedSet = new ArrayList<ITemperature>(); // sort data of month and year1 and add to list
        ArrayList<ITemperature> sortedSet2 = new ArrayList<ITemperature>(); // sort data of month and year2 and add to list
        ArrayList<ITemperature> sortedSet3 = new ArrayList<ITemperature>(); // sort data delta differents
        double tempDelta = 0;
        int yearDelta = 0;
        ITemperature newT = new Temperature (tempDelta, yearDelta, "", "", ""); // new object for the deltaTemp and deltaYear
        ArrayList<ITemperature> theWeatherList = new ArrayList<ITemperature>();

        for(int i = 0; i < list.size(); i++) {
            ITemperature data = list.get(i);
            int m = 0;
            if(data.getMonth().equalsIgnoreCase("jan")) { //coversion for the month
                m = 1;
            }
            else if(data.getMonth().equalsIgnoreCase("feb")) {
                m = 2;
            }
            else if(data.getMonth().equalsIgnoreCase("mar")) {
                m = 3;
            }
            else if(data.getMonth().equalsIgnoreCase("apr")) {
                m = 4;
            }
            else if(data.getMonth().equalsIgnoreCase("may")) {
                m = 5;
            }
            else if(data.getMonth().equalsIgnoreCase("jun")) {
                m = 6;
            }
            else if(data.getMonth().equalsIgnoreCase("jul")) {
                m = 7;
            }
            else if(data.getMonth().equalsIgnoreCase("aug")) {
                m = 8;
            }
            else if(data.getMonth().equalsIgnoreCase("sep")) {
                m = 9;
            }
            else if(data.getMonth().equalsIgnoreCase("oct")) {
                m = 10;
            }
            else if(data.getMonth().equalsIgnoreCase("nov")) {
                m = 11;
            }
            else if(data.getMonth().equalsIgnoreCase("dec")) {
                m = 12;
            }
            if(month == m && data.getYear() == year1) {   // add specify mon to the list
                sortedSet.add(data);
            }
            else if(month == m && data.getYear() == year2) {   // add specify mon to the list
                sortedSet2.add(data);
                for(int j = 0; j < sortedSet2.size(); j++) {
                    tempDelta = sortedSet2.get(j).getTemperature(false) - sortedSet.get(j).getTemperature(false);
                    yearDelta = sortedSet2.get(j).getYear() - sortedSet.get(j).getYear();
                    newT = new Temperature (Math.abs(tempDelta), yearDelta, sortedSet.get(j).getMonth(), sortedSet.get(j).getCountry(), sortedSet.get(j).getCountry3LetterCode());
                    if(!sortedSet3.contains(newT)) { // make sure list has no dupilcates
                        sortedSet3.add(newT);
                        for(int k = 0; k < sortedSet3.size(); k++) {   // two more loop to arrange the arraylist from highest to lowest temperature
                            for(int l = sortedSet3.size() -1; l > k; l--) {
                                ITemperature temp1= sortedSet3.get(k);
                                ITemperature temp2= sortedSet3.get(l);

                                if(temp1.getTemperature(false) < temp2.getTemperature(false)){ // put the highest on top
                                    sortedSet3.set(k, temp2);
                                    sortedSet3.set(l, temp1);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int j = 0; j < sortedSet3.size(); j++ ) {
            if(theWeatherList.size() < 10) { // only add the top 10 highest
                theWeatherList.add(sortedSet3.get(j));
                for(int k = 0; k < theWeatherList.size(); k++) {   // two more loop to arrange the arraylist from lowest to highest temperature
                    for(int l = theWeatherList.size() -1; l > k; l--) {
                        ITemperature temp1= theWeatherList.get(k);
                        ITemperature temp2= theWeatherList.get(l);

                        if(temp1.getTemperature(false) > temp2.getTemperature(false)){ // put the lowest on top
                            theWeatherList.set(k, temp2);
                            theWeatherList.set(l, temp1);
                        }
                    }
                }
            }
        }
        writeDataToFile("taskC-1_climate_info.csv","Temperature Delta, Year Delta, Month_Avg, Country, Country_Code", theWeatherList);
        return theWeatherList;

    }

    // 1. This method starts the climate-change task activities
    // 2. The ClimateChange methods must be called in the order as listed in the [description section], (first with the Task A
    // methods, second are the Task B methods, and third are the Task C methods)
    // 3. For each of the ClimateChange methods that require input parameters, this method must ask the user to
    // enter the required information for each of the tasks.
    // 4. Each ClimateAnalyzer method returns data, so the data results must be written to data files
    public void runClimateAnalyzer() {
        System.out.println("Enter what is prompted to run the program, be mindful of spaces and spelling errors. Enter the month from 1-12 only! Enter the year from 2000-2016 only!");
        ArrayList<ITemperature> list = new ArrayList<ITemperature>();
        ClimateAnalyzer ca = new ClimateAnalyzer(list);
        Scanner in = new Scanner(System.in);
        ca.readDataFromFile("world_temp_2000-2016.csv");
        System.out.println("Task A-1: Get the lowest temperature for the given country and month");

        System.out.println("Enter country:");

        String country = in.next();
        country += in.nextLine();


        System.out.println("Enter a month ranging from 1-12");
        int month = in.nextInt();

        if(month <= 12 && month >= 1) {
            getLowestTemp(country, month);
        }
        else {
            System.out.println("Task A-1 for getting lowest temperature has failed because of invalid input so please enter correct input next time!");
        }
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task A-1: Get the highest temperature for the given country and month");

        System.out.println("Enter country:");
        String country1 = in.next();
        country1 += in.nextLine();

        System.out.println("Enter a month ranging from 1-12:");
        int month1 = in.nextInt();

        if(month1 <= 12 && month1 >= 1) {
            getHighestTemp(country1, month1);
        }
        else {
            System.out.println("Task A-1 for getting highest temperature has failed because of invalid input so please enter correct input next time!");
        }
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task A-2: Get the lowest temperature for the given country and year");

        System.out.println("Enter country:");
        String country2 = in.next();
        country2 += in.nextLine();

        System.out.println("Enter a year ranging from 2001 - 2016:");
        int year = in.nextInt();
        if(year <= 2016 && year >= 2000) {
            getLowestTempByYear(country2, year);
        }
        else {
            System.out.println("Task A-2 for getting lowest temperature has failed because of invalid input so please enter correct input next time!");
        }

//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task A-2: Get the highest temperature for the given country and year");

        System.out.println("Enter country:");
        String country3 = in.next();
        country3 += in.nextLine();

        System.out.println("Enter a year ranging from 2001 - 2016:");
        int year1 = in.nextInt();
        if(year1 <= 2016 && year1 >= 2000) {
            getHighestTempByYear(country3, year1);
        }
        else {
            System.out.println("Task A-2 for getting highest temperature has failed because of invalid input so please enter correct input next time!");
        }
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task A-3: Get the temperature within the specify lowest and highest temperature range for the given country");

        System.out.println("Enter country:");
        String country4 = in.next();
        country4 += in.nextLine();

        System.out.println("Enter the lowest range limit:");
        double rangeLowTemp = in.nextDouble();

        System.out.println("Enter the highest range limit:");
        double rangeHighTemp= in.nextDouble();

        getTempWithinRange(country4, rangeLowTemp, rangeHighTemp);
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task A-4: Get the lowest temperature for the given country");

        System.out.println("Enter country:");
        String country5 = in.next();
        country5 += in.nextLine();

        getLowestTempYearByCountry(country5);
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task A-4: Get the highest temperature for the given country");

        System.out.println("Enter country:");
        String country6 = in.next();
        country5 += in.nextLine();

        getHighestTempYearByCountry(country6);
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task B-1: Get the top 10 lowest temperature for the given month");

        System.out.println("Enter a month ranging from 1-12:");

        int month2 = in.nextInt();
        if(month2 <= 12 && month2 >= 1) {
            allCountriesGetTop10LowestTemp(month2);
        }
        else {
            System.out.println("Task B-1 for getting top 10 lowest temperature has failed because of invalid input so please enter correct input next!");
        }

//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task B-1: Get the top 10 highest temperature for the given month");

        System.out.println("Enter a month ranging from 1-12:");
        int month3 = in.nextInt();
        if(month3 <= 12 && month3 >= 1) {
            allCountriesGetTop10HighestTemp(month3);
        }
        else {
            System.out.println("Task B-1 for getting top 10 highest temperature has failed because of invalid input so please enter correct input next time!");
        }

//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task B-2: Get the top 10 lowest temperature for all countries");

        System.out.println("This task is auto completed");
        allCountriesGetTop10LowestTemp();
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task B-2: Get the top 10 highest temperature for all countries");

        System.out.println("This task is auto completed");
        allCountriesGetTop10HighestTemp();
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task B-3: Get the top countries within the lowest and highest range");

        System.out.println("Enter the lowest range limit:");
        double lowRangeTemp = in.nextDouble();

        System.out.println("Enter the highest range limit:");
        double highRangeTemp = in.nextDouble();

        allCountriesGetAllDataWithinTempRange(lowRangeTemp,highRangeTemp);
//-------------------------------------------------------------------------------------------------------------------------- Separate by task
        System.out.println("Task C-1: Get the top countries with the largest temperature differences base on the year comparison");

        System.out.println("Enter a month ranging from 1-12:");
        int month4 = in.nextInt();

        System.out.println("Enter a the frist year ranging from 2001 - 2016:");
        int year2 = in.nextInt();

        System.out.println("Enter a the second year ranging from 2001 - 2016:");
        int year3 = in.nextInt();

        if(month4 <= 12 && month4 >= 1 && year2 >= 2001 && year2 <= 2016 && year3 >= 2001 && year3 <=2016) {
            allCountriesTop10TempDelta(month4, year2, year3);
        }
        else {
            System.out.println("Task C-1 has failed because of invalid input so please enter correct input next time!");
        }

//-------------------------------------------------------------------------------------------------------------------------- Separate by task

        System.out.println("Great you have enter all the information! To see the collect data, refresh the data folder. If any task has failed then user input is invalid, delete all csv task file and restart program!");

    }
}
