package site.dlsky.lab03;

public class Map {
    private final char[][] map;

    public Map(char[][] map) {
        this.map = map;
    }

    public char[][] findPath() {
        int startRow = -1, startCol = -1;
        int endRow = -1, endCol = -1;

        // Находим начало и конец пути на карте
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 's') {
                    startRow = i;
                    startCol = j;
                } else if (map[i][j] == 'f') {
                    endRow = i;
                    endCol = j;
                }
            }
        }

        // Если начало или конец пути не найдены, возвращаем исходную карту
        if (startRow == -1 || startCol == -1 || endRow == -1 || endCol == -1) {
            return map;
        }

        // Создаем копию исходной карты, чтобы не менять ее
        char[][] result = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, result[i], 0, map[i].length);
        }

        // Прокладываем путь от начала до конца
        boolean[][] visited = new boolean[map.length][map[0].length];
        findPathRecursive(result, visited, startRow, startCol, endRow, endCol);

        return result;
    }

    private boolean findPathRecursive(char[][] result, boolean[][] visited, int row, int col, int endRow, int endCol) {
        if (row < 0 || row >= result.length || col < 0 || col >= result[row].length || visited[row][col] || result[row][col] == '#') {
            return false;
        }

        if (row == endRow && col == endCol) {
            if (result[row][col] != 's' && result[row][col] != 'f') {
                result[row][col] = '*';
            }
            return true;
        }

        visited[row][col] = true;

        if (findPathRecursive(result, visited, row + 1, col, endRow, endCol) ||
                findPathRecursive(result, visited, row - 1, col, endRow, endCol) ||
                findPathRecursive(result, visited, row, col + 1, endRow, endCol) ||
                findPathRecursive(result, visited, row, col - 1, endRow, endCol)) {
            if (result[row][col] != 's' && result[row][col] != 'f') {
                result[row][col] = '*';
            }
            return true;
        }

        visited[row][col] = false;

        if (result[row][col] != 's') {
            result[row][col] = '.';
        }

        return false;
    }
}