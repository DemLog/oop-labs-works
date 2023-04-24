package site.dlsky.lab03;

public class Main {
    public static void main(String[] args) {
        char[][] map = {
                {'#', 's', '#', '#', '#'},
                {'#', '.', '.', '.', '#'},
                {'.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '#'},
                {'#', '#', '#', '.', 'f'}
        };

        Map mapObj = new Map(map);
        char[][] result = mapObj.findPath();

        for (char[] row : result) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
