package algorithms.dp;

public class bitmask {
    public static void main(String[] args) {
        String[] subjects = { "Maths", "Physics", "Chemistry", "English", "ComputerScience" };

        int n = subjects.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("{ ");

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(subjects[i] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
