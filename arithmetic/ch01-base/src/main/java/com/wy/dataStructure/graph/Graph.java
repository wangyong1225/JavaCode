package com.wy.dataStructure.graph;

import java.util.ArrayList;

public class Graph {
    public ArrayList<String> vertexList; // 存储顶点集合
    public int[][] edges; // 存储图对应的邻结矩阵
    public int numOfEdges; // 表示边的数目
    public boolean[] isVisited;

    public static void main(String[] args){
        // 测试
        int n = 5; // 节点的个数
        String vertexes[] = {"A", "B", "C", "D", "E"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 循环添加顶点
        for(String vertex : vertexes){
            graph.insertVertex(vertex);
        }
        // 添加边
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        // 显示图的矩阵
        graph.showGraph();

        // 测试dfs
        System.out.println("dfs");
        graph.dfs();


    }

    // 构造器
    public Graph(int n) {
        // 初始化矩阵
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
        numOfEdges = 0;
    }
    // 得到第一个邻接结点的下标w

    /**
     *
     * @param index
     * @return 如果存在返回对应下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    // 根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }
    // 深度优先遍历算法
    // i 第一次就是0
    private void dfs(boolean[] isVisited, int i) {
        // 首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if(!isVisited[w]){
                dfs(isVisited, w);
            }
            // 如果w结点已经访问
            w = getNextNeighbor(i, w);
        }

    }
    // 对dfs  进行一个重载， 遍历所有的结点，并进行dfs
    public void dfs() {
        for(int i = 0; i < getNumOfVertex(); i++){
            if(!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    // 对一个结点进行广度优先遍历(Broad First Search, BFT)
    public void bft(boolean[] isVisited, int i){
        // 首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        
    }


    // 插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    // 图中常用的方法
    // 返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }
    // 返回边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }
    // 返回节点i（下标）对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    // 返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }
    // 显示图对应的矩阵
    public void showGraph(){
        for(int[] link : edges){
            for(int num : link){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    // 添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }


}
