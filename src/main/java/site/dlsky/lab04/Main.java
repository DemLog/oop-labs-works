package site.dlsky.lab04;


import site.dlsky.lab04.components.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("Login",
                new HorizontalLayout(
                        new VerticalLayout(
                                new Rectangle(new Text("User")),
                                new Rectangle(new Text("Password")),
                                new HorizontalLayout(
                                        new Rectangle(new Text("Ok")),
                                        new Rectangle(new Text("Cancel"))
                                )
                        ),
                        new Frame("Help",
                                new VerticalLayout(
                                        new Text("Please enter login"),
                                        new Text("  and password"),
                                        new Text("Then press Ok button")
                                )
                        )
                )
        );

        frame.calculate();

        char[][] result = new char[frame.getWidth()][frame.getHeight()];
        frame.draw(result);
        print(result);
    }

    private static void print(char[][] buffer) {
        for (int y = 0; y < buffer[0].length; y++) {
            for (char[] chars : buffer) {
                System.out.print(chars[y]);
            }
            System.out.println();
        }
    }
}
