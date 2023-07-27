public class FizzBuzz {
    static String execute(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 5 == 0){
            return "Buzz";
        } else if (i % 3 == 0){
            return "Fizz";
        } else {
            return String.valueOf(i);
        }
    }

    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        System.out.println(FizzBuzz.execute(input));
    }
}
