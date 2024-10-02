import java.util.*;
import java.util.stream.Collectors;

public class GetMinAgeUsersWithStreamAPI {
    public static class User {
        public String firstName;
        public String secondName;
        public Integer age;

        public User(String firstName, String secondName, Integer age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(age, user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, secondName, age);
        }
    }

// Есть список сотрудников, необходимо вывести на экран младшего сотрудника для каждого имени

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Igor", "Bruskov", 28));
        users.add(new User("Igor", "Vatnikov", 21));
        users.add(new User("Masha", "Ptachek", 34));
        users.add(new User("Masha", "Brusnikova", 25));
        users.add(new User("Masha", "Ptachek2", 33));
        users.add(new User("Petr", "Kashevich", 33));
        users.add(new User("Petr", "Aremov", 33));
        users.add(new User("Petr", "Urgel", 33));

        Map<String, User> map = new HashMap<>();

        for (User user : users) {
            if (!map.containsKey(user.firstName)) {
                map.put(user.firstName, user);
            } else {
                if (map.get(user.firstName).age > user.age) {
                    map.put(user.firstName, user);
                }
                if (map.get(user.firstName).secondName.compareTo(user.secondName) > 0) {
                    map.put(user.firstName, user);
                }
            }
        }
        System.out.println(map);

        users.stream()
                .collect(Collectors.groupingBy(
                        user -> user.firstName,
                        Collectors.minBy(
                                Comparator.comparingInt((User user) -> user.age)
                                        .thenComparing(user -> user.secondName)))
                )
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}


