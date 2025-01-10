public class Main {

    public static void checkLengthArray(String[][] array) throws MyArrayExeption {
        if (array.length > 4 || array[0].length > 4) {
            throw new MyArrayExeption("Ой, он слишком большой!");
        }
    }

    public static void checkCharArray(String[][] array) throws MyArrayExeption {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j].matches(("-?\\d+")) == false) {
                    throw new MyArrayExeption("Ой, тут в ячейке: " + i + "-" + j + " не цыфра, а вон че - " + array[i][j]);
                }
            }
        }
    }

    public static String[][] fillArray(String[][] array) {
        int summ = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = "2";
            }
        }
        return array;
    }


    public static int sumArray(String[][] array) {
        int summ = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                summ = summ + Integer.parseInt(array[i][j]);
            }
        }
        return summ;
    }

    public static void main(String[] args) {
        String[][] array = new String[3][4];
        array = fillArray(array);
        array[1][3] = ".1";

        try {
            checkCharArray(array);
            checkLengthArray(array);
            System.out.println(sumArray(array));
        } catch (MyArrayExeption e) {
            System.out.println("Ошибочка: " + e.getMessage());
        }
    }
}