public class Main {
    public static int findDuplicatesInList(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}

