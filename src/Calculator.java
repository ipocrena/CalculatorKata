import java.util.Scanner;

public class Calculator {
    static int x, y, result, resaultConverter;
    static Boolean expresionTest = true;
    static String[] signs = {"/", "*", "-", "+"};

    public static void ArabicCalc(String text) {
        expresionTest = false;
        text = text.replaceAll("[^1234567890+*/-]", "");
        try {
            if (text.length() > 7 || text.length() < 3) {
                throw new Exception("Недопустимое количество символов, либо пропущен знак");
            }
        } catch (
                Exception ex) {
            System.out.println(ex.getMessage());
            expresionTest = false;

        }
        int i;
        for (i = 0; i < text.length(); i++) {
            for (String sign : signs) {
                String testCharAt = text.charAt(i) + "";
                if (testCharAt.equals(sign)) {
                    String signString = text.charAt(i) + "";
                    String[] stringTexts = text.split("[*+/-]", 2);
                    try {
                        for (int j = 0; j < stringTexts.length; j++) {
                            if (stringTexts[j].startsWith("-")){
                                throw new Exception("Только положительные числа");

                            }
                        }

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        expresionTest = false;
                        break;
                    }
                    for (int k = 0; k < stringTexts.length; k++) {
                        stringTexts[k] = stringTexts[k].replaceAll("[^1234567890]", "");
                    }
                    x = Integer.parseInt(stringTexts[0]);
                    y = Integer.parseInt(stringTexts[1]);
                    try {
                        if ((x > 10)||(x<1)){
                            throw new Exception("числа только от 1 до 10");

                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        expresionTest = false;
                        break;
                    }
                    try {
                        if ((y > 10)||(x<1)){
                            throw new Exception("числа только от 1 до 10");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        expresionTest = false;
                        break;
                    }

                    switch (signString) {
                        case ("/"): {
                            result = x / y;
                            System.out.println("Результат: " + result);
                            break;
                        }
                        case ("*"): {
                            result = x * y;
                            System.out.println("Результат: " + result);
                            break;
                        }
                        case ("-"): {
                            result = x - y;
                            System.out.println("Результат: " + result);
                            break;
                        }
                        case ("+"): {
                            result = x + y;
                            System.out.println("Результат: " + result);
                            break;
                        }
                    }
                    expresionTest = true;
                    break;
                }
            }
        }

    }

    public static void RomanCalc(String text) {
        expresionTest = true;
        text = text.replaceAll("[^+*/ivIVxXlLcC-]", "");
        text = text.toUpperCase();
        try {
            if (text.length() > 9 || text.length() < 3) {
                throw new Exception("Недопустимое количество символов, либо пропущен знак");
            }
        } catch (
                Exception ex) {
            System.out.println(ex.getMessage());
            expresionTest = false;

        }
        int i;
        resaultConverter = 0;
        for (i = 0; i < text.length(); i++) {
            for (String sign : signs) {
                String testCharAt = text.charAt(i) + "";
                if (testCharAt.equals(sign)) {
                    String signString = text.charAt(i) + "";
                    String[] stringTexts = text.split("[*+/-]", 2);
                    try {
                        for (int j = 0; j < stringTexts.length; j++) {
                            if (stringTexts[j].startsWith("-")){
                                throw new Exception("Только положительные числа");

                            }
                        }

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        expresionTest = false;
                        break;
                    }
                    for (int k = 0; k < stringTexts.length; k++) {
                        stringTexts[k] = stringTexts[k].replaceAll("[^IVX]", "");
                    }
                    String romanLeft = stringTexts[0];
                    String romanRight = stringTexts[1];
                    String[] romanNums = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                    int[] converterArabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                    for (int k = 0; k < 10; k++) {
                        if (romanLeft.equals(romanNums[k])) {
                            x = converterArabic[k];
                        }
                    }
                    for (int m = 0; m < 10; m++) {
                        if (romanRight.startsWith(romanNums[m])) {
                            y = converterArabic[m];
                        }

                    }

                    try {
                        if ((x > 10) || (x <= 0)) {
                            throw new Exception("числа только от I до X");

                        }
                    } catch (Exception exc) {
                        System.out.println(exc.getMessage());
                        expresionTest = false;
                        break;
                    }
                    try {
                        if ((y > 10) || (y <= 0)) {
                            throw new Exception("числа только от I до X");
                        }
                    } catch (Exception exce) {
                        System.out.println(exce.getMessage());
                        expresionTest = false;
                        break;
                    }

                    switch (signString) {
                        case "/":
                            result = x / y;
                            System.out.print("Результат: ");
                            try {
                                if (result<1) {
                                    throw new Exception("Ответ может быть только больше ноля");
                                }
                            } catch (Exception exce) {
                                System.out.println(exce.getMessage());
                                expresionTest = false;
                                break;
                            }
                            decimalToRoman();
                            break;
                        case "*":
                            result = x * y;
                            System.out.print("Результат: ");
                            try {
                                if (result<1) {
                                    throw new Exception("Ответ может быть только больше ноля");
                                }
                            } catch (Exception exce) {
                                System.out.println(exce.getMessage());
                                expresionTest = false;
                                break;
                            }
                            decimalToRoman();
                            break;
                        case "-":
                            result = x - y;
                            System.out.print("Результат: ");
                            try {
                                if (result<1) {
                                    throw new Exception("Ответ может быть только больше ноля");
                                }
                            } catch (Exception exce) {
                                System.out.println(exce.getMessage());
                                expresionTest = false;
                                break;
                            }
                            decimalToRoman();
                            break;
                        case "+":
                            result = x + y;
                            System.out.print("Результат: ");
                            try {
                                if (result<1) {
                                    throw new Exception("Ответ может быть только больше ноля");
                                }
                            } catch (Exception exce) {
                                System.out.println(exce.getMessage());
                                expresionTest = false;
                                break;
                            }
                            decimalToRoman();
                            break;
                    }
                    break;
                }
            }
        }

    }


    public static void decimalToRoman() {
        RomanNumsEnum[] romanNumsEnums = RomanNumsEnum.values();
        System.out.println(romanNumsEnums[result - 1]);
    }

    public static void main(String[] args) {
        System.out.print("Введите пример: ");
        Scanner scanner = new Scanner(System.in);
        String scannerTest = scanner.nextLine();
        String scannerArabicTest = scannerTest.replaceAll("[1234567890+*/-]", "");
        boolean scannerBoolTest = scannerArabicTest.isEmpty();
        if (scannerBoolTest) {
            ArabicCalc(scannerTest);
        } else if (!scannerBoolTest) {
            RomanCalc(scannerTest);
        }
    }
}




