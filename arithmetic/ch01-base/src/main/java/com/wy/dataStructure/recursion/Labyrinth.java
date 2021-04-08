package com.wy.dataStructure.recursion;

public class Labyrinth {
    public static void main(String[] args) {
        Labyrinth main = new Labyrinth(7,8);
        for(int i = 0; i < main.maze.length; i++){
            main.maze[i][0]=1;
            main.maze[0][i]=1;
            main.maze[i][main.maze[0].length-1]=1;
            main.maze[main.maze.length-1][i]=1;
        }
        main.maze[2][5]=1;
        main.maze[3][5]=1;
        main.maze[3][6]=1;
        main.print();
        main.findPath(1,1);
        main.print();


    }

    int[][] maze;
    public Labyrinth(int row, int col){
        maze = new int[row][col];
    }
    public void print(){
        System.out.println("迷宫的构造为：");
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public boolean findPath(int x, int y){
        if(maze[5][6]==2){
            return true;
        }
        if(maze[x][y] == 0){
            maze[x][y] = 2;
            if(findPath(x,y+1)){
                return true;
            }else if(findPath(x+1,y)){
                return true;
            }else if(findPath(x,y-1)){
                return true;
            }else if(findPath(x-1,y)){
                return true;
            }
            maze[x][y]=3;
        }
        return false;
    }



}
