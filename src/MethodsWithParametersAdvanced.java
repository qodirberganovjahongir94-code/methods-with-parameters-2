public class MethodsWithParametersAdvanced {

    // Password strength checker
    static String checkPassword(String pw) {
        if (pw.length() < 8)                           return "Too short";
        boolean hasUpper  = pw.chars().anyMatch(Character::isUpperCase);
        boolean hasLower  = pw.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit  = pw.chars().anyMatch(Character::isDigit);
        boolean hasSymbol = pw.chars().anyMatch(c -> "!@#$%^&*".indexOf(c) >= 0);
        int score = (hasUpper?1:0) + (hasLower?1:0) + (hasDigit?1:0) + (hasSymbol?1:0);
        return switch (score) {
            case 4 -> "Strong";
            case 3 -> "Medium";
            case 2 -> "Weak";
            default -> "Very Weak";
        };
    }

    // Format currency with locale
    static String formatCurrency(double amount, String symbol) {
        return String.format("%s%,.2f", symbol, amount);
    }

    // Calculate distance between two points
    static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    // Generate initials from full name
    static String initials(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) if (!p.isEmpty()) sb.append(Character.toUpperCase(p.charAt(0))).append(".");
        return sb.toString();
    }

    // Count vowels in a string
    static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray())
            if ("aeiou".indexOf(c) >= 0) count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Password Strength ===");
        String[] passwords = {"abc", "password", "Pass1", "P@ss1word", "Tr0ub4dor&3"};
        for (String p : passwords)
            System.out.printf("%-15s → %s%n", p, checkPassword(p));

        System.out.println("\n=== Currency Formatting ===");
        System.out.println(formatCurrency(1234567.89, "$"));
        System.out.println(formatCurrency(9876543.21, "€"));

        System.out.println("\n=== Point Distances ===");
        System.out.printf("(0,0)→(3,4): %.4f%n", distance(0,0,3,4));
        System.out.printf("(1,1)→(4,5): %.4f%n", distance(1,1,4,5));

        System.out.println("\n=== Initials ===");
        String[] names = {"John Doe", "Mary Jane Watson", "Leonardo da Vinci"};
        for (String n : names) System.out.printf("%-25s → %s%n", n, initials(n));

        System.out.println("\n=== Vowel Count ===");
        String[] words = {"Hello", "Programming", "Java", "aeiou", "rhythm"};
        for (String w : words) System.out.printf("%-15s → %d vowels%n", w, countVowels(w));
    }
}
