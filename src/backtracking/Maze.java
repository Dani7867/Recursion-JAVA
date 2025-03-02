package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        System.out.println(mazeCount(3,3));
        mazePath("",3,3);
        System.out.println(mazePathList("",3,3));

        System.out.println(mazeDiagonalPathList("",3,3));

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        pathRestrictions("", board, 0, 0);
    }

    private static int mazeCount(int r, int c) {
        if(r == 1 || c == 1){
            return 1;
        }
        int l = mazeCount(r-1,c);
        int rt = mazeCount(r,c-1);
        return  l + rt;
    }

    private static void mazePath(String p,int r, int c) {
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r>1) mazePath(p + 'D',r-1,c);
        if(c>1) mazePath(p + 'R',r,c-1);

    }

    private static List<String> mazePathList(String p, int r, int c) {
        if(r == 1 && c == 1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(r>1) list.addAll(mazePathList(p + 'D',r-1,c));
        if(c>1) list.addAll(mazePathList(p + 'R',r,c-1));

        return list;

    }

    private static List<String> mazeDiagonalPathList(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (r > 1 && c > 1) list.addAll(mazeDiagonalPathList(p + 'D', r - 1, c - 1));
        if (r > 1) list.addAll(mazeDiagonalPathList(p + 'V', r - 1, c));
        if (c > 1) list.addAll(mazeDiagonalPathList(p + 'H', r, c - 1));

        return list;
    }

        static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
            if (r == maze.length - 1 && c == maze[0].length - 1) {
                System.out.print(p + " ");
                return;
            }

            if (!maze[r][c]) {
                return;
            }

            if (r < maze.length - 1) {
                pathRestrictions(p + 'D', maze, r+1, c);
            }

            if (c < maze[0].length - 1) {
                pathRestrictions(p + 'R', maze, r, c+1);
            }
        }


    }

