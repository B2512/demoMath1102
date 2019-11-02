import java.util.Scanner;

public class Person {
    String name;
    int score;
    public int showFist() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请出拳：1.剪刀 2.石头 3.布（输入相对应数字）：");
        int number = sc.nextInt();
        switch (number) {
            case 1: System.out.println("你出拳：剪刀");break;
            case 2: System.out.println("你出拳：石头");break;
            case 3: System.out.println("你出拳：布");break;
        }
        return number;
    }
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.showFist());
    }
}
