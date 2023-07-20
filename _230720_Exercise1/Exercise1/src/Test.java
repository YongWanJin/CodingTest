import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};

        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());

        System.out.println("Sorted arr[] : " + Arrays.toString(arr));
    }
}
