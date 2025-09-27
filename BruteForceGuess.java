public class BruteForceGuess {

    static final String CHARSET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String secret = "code";  // the string we want to guess
        bruteForce(secret);
    }

    static void bruteForce(String secret) {
        char[] chars = CHARSET.toCharArray();

        for (char c1 : chars) {
            for (char c2 : chars) {
                for (char c3 : chars) {
                    for (char c4 : chars) {
                        String guess = "" + c1 + c2 + c3 + c4;
                        if (guess.equals(secret)) {
                            System.out.println("Found it: " + guess);
                            return; // stop searching
                        }
                    }
                }
            }
        }
        System.out.println("Not found");
    }
}

