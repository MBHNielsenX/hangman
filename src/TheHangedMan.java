public class TheHangedMan {
//Ascii art taken from: https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c

    static void gallows() {
        String gallows = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "========='''";
        System.out.println(gallows);

    }
    static void head() {
        String head = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========''";
        System.out.println(head);
    }
    static void body() {
        String body = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "========='''";
        System.out.println(body);
    }
    static void leftArm() {
        String leftArm = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "========='''";
        System.out.println(leftArm);
    }
    static void rightArm() {
        String rightArm = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                "      |\n" +
                "      |\n" +
                "========='''";
        System.out.println(rightArm);
    }
    static void leftLeg() {
        String leftLeg = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "      |\n" +
                "========='''";
        System.out.println(leftLeg);
    }
    static void rightLeg() {
        String rightLeg = "'''\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "========='''";
        System.out.println(rightLeg);
    }
}
