public class Computer {
    String name;
    int score;

    public int showFist() {
        //电脑随机出拳 “1.剪刀  2 石头  3 布”
        int random = (int) (Math.random() * 3 + 1);
        switch (random) {
            case 1 : System.out.println(name + "出拳：剪刀"); break;
            case 2 : System.out.println(name + "出拳：石头"); break;
            case 3 : System.out.println(name + "出拳：布"); break;
        }
        return random;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.showFist());
    }
}
