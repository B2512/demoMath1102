import java.util.Scanner;

public class Game {
    Person person;      //用户类 --甲方
    Computer computer;  //电脑类 --乙方
    int count;          //对战次数
    int result;         //返回结果

    //初始化属性值，实例化甲方、乙方对方，对战次数为零
    public void initial() {
        person = new Person();      //用户类 --甲方
        computer = new Computer();  //电脑类 --乙方
        count = 0;                  //对战次数
        result = 0;                 //返回结果
    }

    //开始游戏方法
    public void startGame() {
        initial();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t********************");
        System.out.println("\t\t**\t 猜拳，开始\t  **");
        System.out.println("\t\t********************\n");
        System.out.println("出拳规则：1.剪刀  2.石头  3.布");
        System.out.print("请选择对方角色（1：刘备 2：孙权 3：曹操）：");
        //Character电脑角色变量
        int character = sc.nextInt();
        switch (character) {
            case 1:
                computer.name = "刘备";
                break;
            case 2:
                computer.name = "孙权";
                break;
            case 3:
                computer.name = "曹操";
                break;
        }
        System.out.print("请输入你的姓名：");
        //Person用户类的名字
        person.name = sc.next();
        System.out.println(person.name + " vs " + computer.name + " 对战\n");
        System.out.print("要开始吗？（y/n）:");
        String start = sc.next();
        System.out.println();
        while (start.equals("y")) {
            int per;
            int com;
            if (start.equals("y")) {
                per = person.showFist();
                com = computer.showFist();
                if ((per == 1 && com == 1) || (per == 2 && com == 2) || (per == 3 && com == 3)) {
                    System.out.println("结果说：-_-平局\n");
                } else if ((per == 1 && com == 2) || (per == 2 && com == 3) || (per == 3 && com == 1)) {   //记录用户输
                    System.out.println("结果说：^_^,你输了，真笨！\n");
                    computer.score++;
                } else if ((per == 1 && com == 3) || (per == 2 && com == 1) || (per == 3 && com == 2)) {   //记录用户赢
                    System.out.println("结果说：恭喜，你赢了\n");
                    person.score++;
                }
                count++;
            }
            System.out.print("是否开始下一轮（y/n）：");
            start = sc.next();
            System.out.println();
        }
        showResult();
    }

    //显示比赛结果的查找方法
    public void showResult() {
        System.out.println("----------------------------------------------");
        System.out.println(computer.name + " vs " + person.name);
        System.out.println("对战次数：" + count);
        System.out.println("\n姓名\t得分");
        System.out.println(person.name + "\t" + person.score);
        System.out.println(computer.name + "\t" + computer.score);
        System.out.println();
        calcResult();
        System.out.println("----------------------------------------------");
    }

    //计算比赛结果，返回一个整数，1：战平 2：用户赢 3：电脑赢
    public int calcResult() {
        if (person.score == computer.score) {
            result = 1;
        } else if (person.score > computer.score) {
            result = 2;
        } else if (person.score < computer.score) {
            result = 3;
        }
        switch (result) {
            case 1: System.out.println("结果：打成平手，下次再和你一份高下");break;
            case 2: System.out.println("结果：你赢了");break;
            case 3: System.out.println("结果：呵呵，你输了，下次加油！");break;
        }
        return result;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
