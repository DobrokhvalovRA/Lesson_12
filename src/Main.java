public class Main {

    public static void checkLengthArray(String[][] array) throws MyArrayExeption {
        if (array.length > 4 || array[0].length > 4) {
            throw new MyArrayExeption("Ой, он слишком большой!");
        }
    }

    public static void checkCharArray(String[][] array) throws MyArrayExeption {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!array[i][j].matches(("-?\\d+"))) {
                    throw new MyArrayExeption("Ой, тут в ячейке: " + i + "-" + j + " не цыфра, а вон че - " + array[i][j]);
                }
            }
        }
    }

    public static void fillArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = "2";
            }
        }
    }


    public static int sumArray(String[][] array) {
        int summ = 0;

        for (String[] strings : array) {
            for (int j = 0; j < array[0].length; j++) {
                summ = summ + Integer.parseInt(strings[j]);
            }
        }
        return summ;
    }

    public static void main(String[] args) {
        String[][] array = new String[3][4];
        fillArray(array);
        array[1][3] = "3";

        try {
            checkCharArray(array);
            checkLengthArray(array);
            System.out.println(sumArray(array));
        } catch (MyArrayExeption e) {
            System.out.println("Ошибочка: " + e.getMessage());
        }
    }
}