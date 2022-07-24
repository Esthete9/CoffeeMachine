import java.util.Locale;
import java.util.Scanner;

class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int gbenns = 120;
    private int cups = 9;

    private int money = 550;

    public int getMoney() {
        return money;
    }
    public int getCups() {
        return cups;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getGbenns() {
        return gbenns;
    }

    public void setGbenns(int gbenns) {
        this.gbenns = gbenns;
    }

    public int getValueOfWater(int cups) {
        water = cups * 200;
        return water;
    }

    public int getValueOfMilk(int cups) {
        milk = cups * 50;
        return milk;
    }

    public int getValueOfGbenns(int cups) {
        gbenns = cups * 15;
        return gbenns;
    }
    public int calcNumberOfCups() {
        int WaterForCup = water;
        int MilkForCup = milk;
        int BeansForCup = gbenns;
        int ValueOfCups = 0;

        while (WaterForCup - 200 >= 0 && MilkForCup - 50 >= 0 && BeansForCup - 15 >= 0) {
            WaterForCup -= 200;
            MilkForCup -= 50;
            BeansForCup -= 15;
            ++ValueOfCups;
        }
        return ValueOfCups;
    }
    public void answerByNumberOfCups () {
        int moreCups = calcNumberOfCups() - cups;
        if(calcNumberOfCups() > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + moreCups + " more than that)");
        } else if (calcNumberOfCups() == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (calcNumberOfCups() < cups) {
            System.out.println("No, I can make only " + calcNumberOfCups() + " cup(s) of coffee");
        }
    }

    public void addCoffe () {
        System.out.println("Write how many ml of water you want to add: ");
        Scanner in = new Scanner(System.in);
        int add = in.nextInt();
        water += add;
        System.out.println("Write how many ml of milk you want to add: ");
        add = in.nextInt();
        milk += add;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        add = in.nextInt();
        gbenns += add;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        add = in.nextInt();
        cups += add;
    }
    public void chooseCofee (String choose) {
        switch (choose) {
            case "1":
                if (water - 250 < 0 || gbenns - 16 < 0 || cups - 1 < 0) {
                    if (water - 250 < 0) {
                        System.out.println("Sorry, not enough water!");
                    } else if (gbenns -16 < 0) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cups - 1 < 0) {
                        System.out.println("Sorry, not enough cups!");
                    }
                    break;
                } else {
                    water -= 250;
                    gbenns -= 16;
                    money += 4;
                    cups -= 1;
                    break;
                }
            case "2":
                if (water - 350 < 0 || milk - 75 < 0 || gbenns - 20 < 0 || cups - 1 < 0) {
                    if (water - 300 < 0) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk - 75 < 0) {
                        System.out.println("Sorry, not enough coffee milk!");
                    } else if (gbenns - 20 < 0) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cups - 1 < 0) {
                        System.out.println("Sorry, not enough cups!");
                    }
                    break;
                } else {
                    water -= 350;
                    milk -= 75;
                    gbenns -= 20;
                    money += 7;
                    cups -= 1;
                    break;
                }
            case "3":
                if (water - 200 < 0 || milk - 100 < 0 || gbenns - 12 < 0 || cups - 1 < 0) {
                    if (water - 200 < 0) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk - 100 < 0) {
                        System.out.println("Sorry, not enough coffee milk!");
                    } else if (gbenns - 12 < 0) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cups - 1 < 0) {
                        System.out.println("Sorry, not enough cups!");
                    }
                    break;
                } else {
                    water -= 200;
                    milk -= 100;
                    gbenns -= 12;
                    money += 6;
                    cups -= 1;
                    break;
                }
            case "back":
                showMenu ();
                break;
        }
    }

    public void showMenu () {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
    public void showRemaining () {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(gbenns + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println(money + " of money");
    }
    public void menuInput () {
        showMenu ();
        Scanner in = new Scanner(System.in);
        String val = "";
        while (!val.equals("exit")) {
            val = in.next();
            switch (val) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    chooseCofee(in.next());
                    break;
                case "fill":
                    addCoffe();
                    break;
                case "take":
                    take();
                    break;
                case "exit":
                    break;
                case "remaining":
                    showRemaining();
                    break;
            }
        }
    }
    public void take () {
        System.out.println("I gave you " + money);
        money = 0;
    }
}

public class Test {

    public static void main(String[] args) {
        CoffeeMachine coffe = new CoffeeMachine();
        coffe.menuInput();
    }
 }
