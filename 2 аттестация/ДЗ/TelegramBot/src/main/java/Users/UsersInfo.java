package Users;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersInfo {
    Map<Long, Float[]> usersMap = new HashMap<>();

    public void addUser(Long id, Float lat, Float lon) {
        Float[] coord = new Float[]{lat, lon};
        usersMap.put(id, coord);
        saveDataJson();
    }

    public void saveDataJson() {
        try (FileWriter file = new FileWriter("./src/main/resources/users.json")) {
            JSONObject data = new JSONObject(usersMap);
            file.write(String.valueOf(data));
            file.flush();
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
