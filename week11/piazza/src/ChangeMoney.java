public class ChangeMoney {
    public static void main(String[] args) {
        int pay = 20000;
        int price = 15500;
        int change = pay - price;
        int[] bills = {50000, 10000, 5000, 1000};
        int[] coins = {500, 100, 50, 10};
        System.out.println("=== 거스름돈 ===");
        for (int bill : bills) {
            int num = change / bill;
            change %= bill;
            System.out.printf("%d원 지폐 %d개", bill, num);
        }
        for (int coin : coins) {
            int num = change / coin;
            change %= coin;
            System.out.printf("%d원 동전 %d개", coin, num);
        }
    }
}
