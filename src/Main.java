public class Main {

    public static void checkArray(String[][] array) throws MyArraySizeExeption,MyArrayDataExeption {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeExeption("Ой, не тот размер!");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!array[i][j].matches(("-?\\d+"))) {
                    throw new MyArrayDataExeption("Ой, тут в ячейке: " + i + "-" + j + " не цыфра, а вон че - " + array[i][j]);
                }
            }
        }
    }

    /*/public static void checkCharArray(String[][] array) throws MyArrayDataExeption {
       for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!array[i][j].matches(("-?\\d+"))) {
                    throw new MyArrayDataExeption("Ой, тут в ячейке: " + i + "-" + j + " не цыфра, а вон че - " + array[i][j]);
                }
            }
        }
    }/*/

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
        String[][] array = new String[4][4];
        fillArray(array);
        array[1][1] = "3";

        try {
            //checkCharArray(array);
            //checkLengthArray(array);
            checkArray(array);
            System.out.println(sumArray(array));
        } catch (MyArraySizeExeption e) {
            System.out.println("Ошибочка: " + e.getMessage());
        } catch (MyArrayDataExeption e) {
            System.out.println("Ошибочка: " + e.getMessage());
        }
    }
}