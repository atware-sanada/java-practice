public class IssueFactory {

    public static String create(String question, String answer) {
        String question1 = formatQuestion(question);
        String template = "%s%n%n### Answer%n%s";
        return String.format(template, question1, answer);
//        return "### Question\n" + question + "\n\n### Answer\n" + answer;
    }

    static String formatQuestion(String question) {
        String replaced = question.replace("\n", "\n> ");
        return "### Question\n> " + replaced;
    }

    public static void main(String args[]) {
        String question = args[0];
        String answer = args[1];
    }
}
