import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProcessing {
    private static Map<Integer, User> AllUsersMap = new HashMap<>();

    public static Map<Integer, User> getAllUsersMap() {
        return AllUsersMap;
    }

    public List<User> getUsers(Sex inputSex) {
        List<User> resultList = new ArrayList<>();
        for (User user : AllUsersMap.values()) {
            if (user.getSex().equals(inputSex)) {
                resultList.add(user);
            }
        }
        return resultList;
    }

    public List<User> getUsers() {
        System.out.println(AllUsersMap.values());
        return new ArrayList<User>(AllUsersMap.values());
    }

    public int getUsersCount() {
        return AllUsersMap.size();
    }

    public int getUsersCount(Sex inputSex) {
        return getUsers(inputSex).size();
    }

    public double getUsersMiddleAge() {
        long ageSum = 0;
        for (User user : AllUsersMap.values())
            ageSum += user.getAge();

        return (double) ageSum / AllUsersMap.size();
    }

    public double getUsersMiddleAge(Sex inputSex) {
        long ageSum = 0;
        int counter = 0;
        for (User user : AllUsersMap.values()) {
            if (user.getSex().equals(inputSex)) {
                ageSum += user.getAge();
                counter++;
            }
        }
        return (double) ageSum / counter;
    }

    public boolean equals(User firstUser, User secondUser) {
        return firstUser.equals(secondUser);
    }
}
