package Users;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class Subscribes {
    Map<Long, Float[]> subscribesMap = new HashMap<>();


    public Map<Long, Float[]> getSubscribesList() {
        return subscribesMap;
    }

    public void addSubscribe(Long id) {
        Float[] coord = getLatLonById(id);
        subscribesMap.put(id, coord);
        saveDataJson();
    }

    public Map<Long, Float[]> getData(){
        getDataJson();
        return subscribesMap;
    }
    public void removeSubscribe(Long id) {
        subscribesMap.remove(id);
        saveDataJson();
    }

    public void saveDataJson() {
        try (FileWriter file = new FileWriter("./src/main/resources/subscribe.json")) {
            JSONObject data = new JSONObject(subscribesMap);
            file.write(String.valueOf(data));
            file.flush();
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getDataJson() {
        try {

            ObjectMapper mapper = new ObjectMapper();

            Map<Long, Float[]> map = mapper.readValue(
                    new File("./src/main/resources/subscribe.json"),
                    new TypeReference<Map<Long, Float[]>>() {
                    });

            subscribesMap = map;

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Float[] getLatLonById(Long id){
        try {

            ObjectMapper mapper = new ObjectMapper();

            Map<Long, Float[]> map = mapper.readValue(
                    new File("./src/main/resources/users.json"),
                    new TypeReference<Map<Long, Float[]>>() {
                    });

            return map.get(id);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

