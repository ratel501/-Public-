import java.util.Scanner;

public class Calculator {
    private String[] operations = {"덧셈", "뺄셈", "곱셈", "나눗셈", "제곱", "제곱근", "종료"};

    public Calculator() {
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("에러: 0으로 나눌 수 없습니다.");
            return Double.NaN;
        }
        return a / b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double value) {
        if (value < 0) {
            System.out.println("에러: 음수의 제곱근을 계산할 수 없습니다.");
            return Double.NaN;
        }
        return Math.sqrt(value);
    }

    public void startCalculator() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 메뉴 표시
            System.out.println("원하는 연산을 선택하세요:");
            for (int i = 0; i < operations.length; i++) {
                System.out.println((i + 1) + ". " + operations[i]);
            }
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == operations.length) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            double a = 0, b = 0;
            if (choice >= 1 && choice <= 5) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                a = scanner.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                b = scanner.nextDouble();
            } else if (choice == 6) { // 제곱근은 하나의 입력만 필요
                System.out.print("제곱근을 구할 숫자를 입력하세요: ");
                a = scanner.nextDouble();
            } else {
                System.out.println("결과값이 이상합니다. 다시 시도하세요.");
                continue;
            }
            double result;
            switch (choice) {
                case 1:
                    result = add(a, b);
                    System.out.println("결과: " + result);
                    break;
                case 2:
                    result = subtract(a, b);
                    System.out.println("결과: " + result);
                    break;
                case 3:
                    result = multiply(a, b);
                    System.out.println("결과: " + result);
                    break;
                case 4:
                    result = divide(a, b);
                    System.out.println("결과: " + result);
                    break;
                case 5:
                    result = power(a, b);
                    System.out.println("결과: " + result);
                    break;
                case 6:
                    result = squareRoot(a);
                    System.out.println("결과: " + result);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
            System.out.println();
        }
        scanner.close();
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.startCalculator();
    }
}

