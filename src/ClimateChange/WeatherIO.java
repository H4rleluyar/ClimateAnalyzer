package ClimateChange;

import java.io.*;
import java.util.*;

public class WeatherIO implements IWeatherIO{

    //custom method use to create ITemperature object
    private static ITemperature createTemperature(String[] data) {
        double temperature = Double.parseDouble(data[0]);
        int year = Integer.parseInt(data[1]);
        String month = data[2];
        String country = data[3];
        String country3Code = data[4];
        return new Temperature(temperature, year, month, country, country3Code);
    }

    // read all data from the weather csv file
    public ArrayList<ITemperature> readDataFromFile(String fileName){

        ArrayList<ITemperature> list = new ArrayList<ITemperature>();
        try {
            FileReader fr = new FileReader("./data/" + fileName); //look for csv file in the data folder
            BufferedReader br = new BufferedReader(fr);
            Scanner in = new Scanner(br);
            String line = in.nextLine(); // skip the first line in File
            line = in.nextLine(); // read the next Line with the data
            while(in.hasNext()) {
                String[] data = line.split(", ");
                //System.out.println(Arrays.toString(data)); // testing to print the data to make sure it works
                ITemperature t = createTemperature(data);
                list.add(t); // add to the object into the arraylist
                line = in.nextLine();
            }
            String[] data = line.split(", "); // last line of the csv file
            //System.out.println(Arrays.toString(data)); //testing to print the data to make sure it works
            ITemperature t = createTemperature(data);
            list.add(t);
            in.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    //write infomation in to filename, subject is the header for the specfic topic
    public void writeSubjectHeaderInFile(String filename, String subject) {
        File file = new File("./data/" + filename); //look for csv file
        try {
            FileWriter fw = new FileWriter(file, true); // set to true so data won't be overwritten
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(subject);
            pw.flush();
            pw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    //write data containing an ArrayList into the specify filename
    public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) {
        File file = new File("./data/" + filename); //look for csv file
        try {
            FileWriter fw = new FileWriter(file, true); // set to true so data won't be overwritten
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(topic);
            for(ITemperature t: theWeatherList) {
                String celsius = String.format("%.2f", t.getTemperature(false)); // format by 2 decimal only for celsius
                String fahrenheit = String.format("%.2f", t.getTemperature(true)); // format by 2 decimal only for fahrenheit
                pw.println(celsius + "(C) " + fahrenheit + "(F)" + ", " + t.getYear() + ", " + t.getMonth() + ", " +
                        t.getCountry() + ", " + t.getCountry3LetterCode());
            }
            pw.flush();
            pw.close();
        }
        catch(IOException e) {
            e.printStackTrace();

        }

    }

}
