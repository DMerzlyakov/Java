import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserProcessingTest {

    @Test
    public void getAllMaleUsers() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);

        List<User> actual = userProcessing.getUsers(Sex.MALE);

        List<User> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllFemaleUsers() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);

        List<User> actual = userProcessing.getUsers(Sex.FEMALE);

        List<User> expected = new ArrayList<>();
        expected.add(user3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllUsers() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);

        UserProcessing userProcessing = new UserProcessing();

        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);

        List<User> actual = userProcessing.getUsers();

        List<User> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAllUsersCount() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);

        int actual = userProcessing.getUsersCount();
        int expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaleUsersCount() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);

        int actual = userProcessing.getUsersCount(Sex.MALE);
        int expected = 3;

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getFemaleUsersCount() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);

        int actual = userProcessing.getUsersCount(Sex.FEMALE);
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAllUsersMiddleAge() {

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);
        User user4 = new User(4, "Елизавета", 20, Sex.FEMALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);
        userProcessing.getAllUsersMap().put(user4.getId(), user4);

        double actual = userProcessing.getUsersMiddleAge();
        double expected = 19.25;

        Assert.assertEquals(expected, actual, 0.0001);

    }

    @Test
    public void testMaleUsersMiddleAge() {
        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);
        User user4 = new User(4, "Елизавета", 20, Sex.FEMALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);
        userProcessing.getAllUsersMap().put(user4.getId(), user4);

        double actual = userProcessing.getUsersMiddleAge(Sex.MALE);
        double expected = 19;

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFemaleUsersMiddleAge() {
        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(2, "Давид", 18, Sex.MALE);
        User user3 = new User(3, "Александр", 19, Sex.MALE);
        User user4 = new User(4, "Елизавета", 20, Sex.FEMALE);

        UserProcessing userProcessing = new UserProcessing();
        userProcessing.getAllUsersMap().put(user1.getId(), user1);
        userProcessing.getAllUsersMap().put(user2.getId(), user2);
        userProcessing.getAllUsersMap().put(user3.getId(), user3);
        userProcessing.getAllUsersMap().put(user4.getId(), user4);

        double actual = userProcessing.getUsersMiddleAge(Sex.FEMALE);
        double expected = 22;
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testEqualsTrue() {

        UserProcessing userProcessing = new UserProcessing();

        User user1 = new User(1, "Данила", 20, Sex.MALE);
        User user2 = new User(1, "Данила", 20, Sex.MALE);

        boolean actual = userProcessing.equals(user1, user2);
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsFalse() {

        UserProcessing userProcessing = new UserProcessing();

        User user1 = new User(1, "Данила", 21, Sex.MALE);
        User user2 = new User(1, "Данила", 20, Sex.MALE);

        boolean actual = userProcessing.equals(user1, user2);
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
}