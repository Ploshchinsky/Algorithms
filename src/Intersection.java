import java.util.*;
import java.util.stream.Collectors;

public class Intersection {
    public static int[] array1 = {0, 15, 33, 2, 24, 25, 3, 33};
    public static int[] array2 = {11, 15, 34, 3, 25, 26, 0, 33, 33};
    public static List<Student> list1 = List.of(
            new Student("Anton"),
            new Student("Anton"),
            new Student("Valer"),
            new Student("Alexey"),
            new Student("Maria"),
            new Student("Maria"),
            new Student("Maria"),
            new Student("Alexandra")
    );
    public static List<Student> list2 = List.of(
            new Student("Alexey"),
            new Student("Alexandra"),
            new Student("Alexandra"),
            new Student("Alexandra")
    );


    public static void main(String[] args) {
        findIntersection(array1, array2);
        System.out.println("---");
        findIntersection(list1, list2);
    }

    private static void findIntersection(int[] array1, int[] array2) {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        Arrays.stream(array1).forEach(list1::add);
        Arrays.stream(array2).forEach(list2::add);

        List<Integer> intersection = list1.stream().filter(list2::contains).toList();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(intersection);
    }

    private static <T> void findIntersection(List<T> list1, List<T> list2) {
        System.out.println(list1);
        System.out.println(list2);
        List<T> intersection = list1.stream().distinct().filter(list2::contains).toList();
        System.out.println(intersection);
    }

}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
