import java.util.ArrayList;
import java.util.Arrays;

public class hw1 {
    public static void main(String[] args) {
        //  method1();
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        //  method2();
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "123e5"
        //  method3();
        //  Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 10

/*Integer [][] arr= {{123,12}, {123,12, 123}};
        System.out.println(sum2d(arr));
        arr=null;
        System.out.println(sum2d(arr));*/
        var first = new int[]{123, 5, 26};
        var second = new int[]{45, 10, 11};
        System.out.println(Arrays.toString(diffArrays(first, second)));
        var oneMassive = new Integer[]{123, 5, 25};
        var secondMassive = new Integer[]{23, 5, 0, 5};
        System.out.println(Arrays.toString(delArrays(oneMassive, secondMassive)));

    }

    // 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    public static void method1() {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

    public static void method2() {
        String letter = "123e5";
        int number = Integer.parseInt(letter);
        System.out.println(number);
    }

    public static void method3() {
        var arr = new int[10];
        arr[100] = 1;
    }

    // 2) Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//  Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "arr" is null
//  Exception in thread "main" java.lang.NumberFormatException: For input string: "1e2"
//  Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    public static int sum2d(Integer[][] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = arr[i][j];
                sum += val;
            }
        }
        return sum;
    }
//  3) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя

    public static int[] diffArrays(int[] first, int[] second) {
        if (first.length != second.length) {
            throw new RuntimeException("Lengths of massives are not similar");
        }
        var result = new int[first.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = first[i] - second[i];
        }
        return result;
    }

//   4) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше

    public static Integer[] delArrays(Integer[] first, Integer[] second) {
        if (first.length != second.length) {
            throw new RuntimeException("Lengths of massives are not similar");
        }
        var list = new ArrayList<Integer>();
        Integer[] result = new Integer[first.length];
        for (int i = 0; i < result.length; i++) {
            if (first[i] == null || second[i] == null) {
                list.add(i);
            }
            if (!list.isEmpty()) {
                throw new RuntimeException("Null elements have indexes:" + list);
            }
            if (second[i] != 0) {
                result[i] = first[i] / second[i];
            } else {
                throw new RuntimeException("We cant delete by zero");
            }
        }
        return result;
    }
}