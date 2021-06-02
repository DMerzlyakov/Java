public class App {

    public static void main(String[] args) {

        UserProcessing userProcessing = new UserProcessing();

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);
        User user4 = new User(4, "Елизавета", 20, Sex.FEMALE);

        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);
        userProcessing.getAllUsersMap().put(user4.getId(), user4);

        for (User user : userProcessing.getUsers()) {
            System.out.println(user);
        }

    }
}
