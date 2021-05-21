import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception1 {
        Calculate calculate = new Calculate();
    }
}

class Calculate {
    private String a;
    private String symbol;
    private String b;

    private int num1;
    private int num2;

    private Translate translate;
    private Scanner scan;
    Calculate() throws Exception1 {
        scan = new Scanner(System.in);
        this.a = scan.next();
        this.symbol = scan.next();
        this.b = scan.next();
        answer(a, symbol, b);
    }
    public void answer(String a, String symbol, String b) throws Exception1 {
        translate = new Translate();
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        translate.setVal1(a);
        translate.setVal2(b);
        num1 = translate.getVal1();
        num2 = translate.getVal2();
        if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10) {
            if (isValue1Number(a) && isValue2Number(b)) {
                switch (symbol) {
                    case "+":
                        System.out.println(sum(num1, num2));
                        break;
                    case "-":
                        System.out.println(subtract(num1, num2));
                        break;
                    case "*":
                        System.out.println(multiply(num1, num2));
                        break;
                    case "/":
                        
                            System.out.println(divide(num1, num2));
                        break;
                }
            } else if (isValue1Number(a) || isValue2Number(b)) {
                throw new Exception1("Arabic or roman decide already...");
            } else {
                switch (symbol) {
                    case "+":
                        System.out.println(translate.translateNumber(num1 + num2));
                        break;
                    case "-":
                        if(num1 < num2)
                        System.out.println("-" + translate.translateNumber(Math.abs(num1 - num2)));
                        else
                            System.out.println( translate.translateNumber(num1 - num2));
                        break;
                    case "*":
                        System.out.println(translate.translateNumber(num1 * num2));
                        break;
                    case "/":
                        
                            System.out.println(translate.translateNumber(num1 / num2));
                        break;
                }
            }
        } else {
            throw new Exception1("Oh no, your input is too big or small...");
        }
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isValue1Number(String a) {
        int value1;
        try {
            value1 = Integer.parseInt(a);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isValue2Number(String b) {
        int value2;
        try {
            value2 = Integer.parseInt(b);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }
}

class Translate {
    private int num1;
    private int num2;

    Translate() {
    }

    public String translateNumber(int a) {
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String ans = "";
        if (a <= 10) {
            return rim[a - 1];
        } else if (a == 100) {
            return ans = "C";
        } else {
            int b = a / 10;
            int b2 = a % 10;
            switch (b) {
                case 10:
                    ans += "C";
                    break;
                case 5:
                    ans += "L";
                    break;
                case 2:
                    ans += "XX";
                    break;
                case 4:
                    ans += "XL";
                    break;
                case 6:
                    ans += "LX";
                    break;
                case 9:
                    ans += "XC";
                    break;
                case 3:
                    ans += "XXX";
                    break;
                case 7:
                    ans += "LXX";
                    break;
                case 8:
                    ans += "LXXX";
                    break;
            }
            ans += rim[b2 - 1];
        }
        return ans;
    }

    public void setVal1(String a) {
        switch (a) {
            case "I":
                num1 = 1;
                break;
            case "II":
                num1 = 2;
                break;
            case "III":
                num1 = 3;
                break;
            case "IV":
                num1 = 4;
                break;
            case "V":
                num1 = 5;
                break;
            case "VI":
                num1 = 6;
                break;
            case "VII":
                num1 = 7;
                break;
            case "VIII":
                num1 = 8;
                break;
            case "IX":
                num1 = 9;
                break;
            case "X":
                num1 = 10;
                break;
            default:
                num1 = Integer.parseInt(a);
                break;
        }
    }

    public void setVal2(String b) {
        switch (b) {
            case "I":
                num2 = 1;
                break;
            case "II":
                num2 = 2;
                break;
            case "III":
                num2 = 3;
                break;
            case "IV":
                num2 = 4;
                break;
            case "V":
                num2 = 5;
                break;
            case "VI":
                num2 = 6;
                break;
            case "VII":
                num2 = 7;
                break;
            case "VIII":
                num2 = 8;
                break;
            case "IX":
                num2 = 9;
                break;
            case "X":
                num2 = 10;
                break;
            default:
                num2 = Integer.parseInt(b);
                break;
        }
    }

    public int getVal1() {
        return num1;
    }

    public int getVal2() {
        return num2;
    }
}

class Exception1 extends Exception {
    Exception1(String m) {
        super(m);
    }
}




