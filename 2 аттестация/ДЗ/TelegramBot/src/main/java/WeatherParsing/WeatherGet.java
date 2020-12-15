package WeatherParsing;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherGet {

    public static String getWeather(Float lat, Float lon,Integer days) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+lat +"&lon="+lon+"&exclude=minutely,hourly&appid=7803ce9a0155591b3f5a32e4c5bbe980&lang=ru&&units=metric");
        Scanner data = new Scanner((InputStream) url.getContent());
        String weather = "";
        while (data.hasNext()) {
            weather += data.nextLine();
        }

        JSONObject result = new JSONObject(weather);
        WeatherInfo info = new WeatherInfo();
        info.setName(result.getString("timezone"));
        JSONArray dailyArray = result.getJSONArray("daily");
        for (int i = 0; i < 2; i++){
            JSONObject day = dailyArray.getJSONObject(i);
            ArrayList<Float> temp = new ArrayList<>();
            JSONObject temp_info = day.getJSONObject("temp");
            temp.add((float) temp_info.getDouble("night"));
            temp.add((float) temp_info.getDouble("morn"));
            temp.add((float) temp_info.getDouble("day"));
            temp.add((float) temp_info.getDouble("eve"));
            info.setTempe(temp);
            info.setMain(day.getJSONArray("weather").getJSONObject(0).getString("description"));

            }
        return info.getInfo(days);
        }

}

