package WeatherParsing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherInfo {

    private String name;
    private ArrayList<ArrayList<Float>> temp = new ArrayList<>();
    private ArrayList<String> main = new ArrayList<>();
    private Date date = new Date();
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ArrayList<Float>> getTemp() {
        return this.temp;
    }

    public void setTempe(ArrayList<Float> temp) {
        this.temp.add(temp);
    }

    public ArrayList<String> getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main.add(main);
    }

    public String getInfo(Integer days) {
        if (days == 2){
        return "Местоположение: " + name + "\n\n" +
                "Погода на сегодня (" + formatDate.format(date)+"): \n" +
                "Ночь - " + temp.get(0).get(0) + "\n" +
                "Утро - " + temp.get(0).get(1) + "\n" +
                "День - " + temp.get(0).get(2) + "\n" +
                "Вечер - " + temp.get(0).get(3) + "\n" +
                "Погода - " + main.get(0) +"\n" +
                "\n\nПогода на завтра: \n" +
                "Ночь - " + temp.get(1).get(0) + "\n" +
                "Утро - " + temp.get(1).get(1) + "\n" +
                "День - " + temp.get(1).get(2) + "\n" +
                "Вечер - " + temp.get(1).get(3) + "\n" +
                "Погода - " + main.get(1) +"\n";}
        else {
            return "Местоположение: " + name + "\n\n" +
                    "Погода на сегодня (" + formatDate.format(date)+"): \n" +
                    "Ночь - " + temp.get(0).get(0) + "\n" +
                    "Утро - " + temp.get(0).get(1) + "\n" +
                    "День - " + temp.get(0).get(2) + "\n" +
                    "Вечер - " + temp.get(0).get(3) + "\n" +
                    "Погода - " + main.get(0) +"\n";
        }



    }
}
