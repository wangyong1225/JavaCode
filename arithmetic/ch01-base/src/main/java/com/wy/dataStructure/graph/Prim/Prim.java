package com.wy.dataStructure.graph.Prim;

import com.wy.dataStructure.graph.Graph;
import com.wy.exam.Lianxisan31.MainG;

public class Prim {
    public static void main(String[] args) {
        // 测试
        int n = 7; // 节点的个数
        String vertexes[] = {"A", "B", "C", "D", "E", "F", "G"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 循环添加顶点
        for(String vertex : vertexes){
            graph.insertVertex(vertex);
        }
        // 添加边
        // A-B A-F A-G B-C B-G C-D D-E D-G E-F E-G
        graph.insertEdge(0, 1, 5);
        graph.insertEdge(0, 5, 7);
        graph.insertEdge(0, 6, 2);
        graph.insertEdge(1, 2, 9);
        graph.insertEdge(1, 6, 3);
        graph.insertEdge(2, 3, 4);
        graph.insertEdge(3, 4, 5);
        graph.insertEdge(3, 6, 6);
        graph.insertEdge(4, 5, 8);
        graph.insertEdge(4, 6, 4);
        // 显示图的矩阵
        graph.showGraph();

        Graph T = prim(graph);
        System.out.println("普利姆算法处理后");
        T.showGraph();
    }

    public static Graph prim(Graph G){

        Graph T = new Graph(G.getNumOfVertex());
        int h1 = -1, h2 = -1;
        G.isVisited[0] = true;
        T.vertexList.add(G.vertexList.get(0));
        int min = Integer.MAX_VALUE;
        for(int k = 1; k < G.getNumOfVertex(); k++){
            for(int i = 0; i < G.getNumOfVertex(); i++){
                for(int j = 0; j < G.getNumOfVertex(); j++){
                    if(!G.isVisited[i]){
                        break;
                    }
                    if(!G.isVisited[j] && G.edges[i][j] != 0 && G.edges[i][j] < min){
                        h1 = i;
                        h2 = j;
                        min = G.edges[i][j];
                    }
                }
            }
            T.vertexList.add(G.vertexList.get(h2));
            T.edges[h1][h2] = min;
            T.edges[h2][h1] = min;
            min = Integer.MAX_VALUE;
            G.isVisited[h2] = true;
        }
        return T;
    }

}


