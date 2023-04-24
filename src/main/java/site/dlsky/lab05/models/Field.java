package site.dlsky.lab05.models;

import site.dlsky.lab05.service.BallColor;
import site.dlsky.lab05.service.Direction;

public class Field {
    private final Ball[][] field;
    private boolean isWhole = false;
    private final int width;
    private final int height;
    public Field() {
        this(3, 3);
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Ball[width][height];
    }

    public Ball getBall(int index1, int index2) {
        if (index1 < 0 || index1 >= width || index2 < 0 || index2 >= height) {
            throw new IndexOutOfBoundsException("Incorrect index of ball");
        }
        return this.field[index1][index2];
    }

    public void addBall(int index1, int index2, BallColor color) {
        addBall(index1, index2, new Ball(color));
    }

    public void addBall(int index1, int index2, Ball ball) {
        if (index1 < width && index1 >= 0 && index2 < height && index2 >= 0 && field[index1][index2] == null)
            this.field[index1][index2] = ball;
        else
            throw new IndexOutOfBoundsException("incorrect index");

        isWhole = true;
        for (int i = 0; i < width; i++)
            for (int j = 0; j<height; j++)
                if(this.field[i][j] == null)
                    isWhole = false;
    }

    public boolean isWhole(){
        return this.isWhole;
    }

    public void rotateField(Direction direction) throws Exception {
        int size = this.field.length;
        Ball[][] newBalls = new Ball[width][height];
        if (direction == Direction.Right) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    newBalls[i][j] = this.field[height - j - 1][i];
                }
            }
        } else if (direction == Direction.Left) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    newBalls[i][j] = this.field[j][width - i - 1];
                }
            }

        } else throw new Exception("incorrect direction");
        copyArrToArr(newBalls, this.field);
    }

    public int[] getSize() {
        return new int[] {this.width, this.height};
    }

    /**
     * copy value of array in next array if it's length is equal
     *
     * @param  arrToCopy  arr from which will be copy values
     * @param  arr arr to which will be copied values
     */
    private static<T> void copyArrToArr(T[][] arrToCopy, T[][] arr) throws Exception {
        if (arrToCopy.length == arr.length && arrToCopy[0].length == arr[0].length)
            for (int i = 0; i < arrToCopy.length; i++)
                for (int j = 0; j < arrToCopy[0].length; j++)
                    arr[i][j] = arrToCopy[i][j];
        else
            throw new Exception("incorrect arrs");
    }
}
