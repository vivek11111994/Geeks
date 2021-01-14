public class RentCalculator {
        public static void main (String[] args) {
                int initialRent = 10000000;
                int interest = 10;
                int sum = initialRent;

                for (int i = 1; i <= 14; i++) {
                        int interestAmmount = (initialRent * interest) / 100;
                        initialRent = initialRent + interestAmmount;

                        sum = sum + interestAmmount;
                }

                System.out.println (sum);
        }
}
