package com.wy.dataStructure.binaryTree.huffmanCode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        ArrayList<Node> list = creatList(bytes);
        StringBuilder stringBuilder = new StringBuilder();

        // 创建赫夫曼树
        System.out.println("赫夫曼树");
        Node res = creatHuffmanTree(list);
        System.out.println("前序遍历");
        res.preOrder();

        // 测试赫夫曼编码
        getCodes(res);
        System.out.println("生成的赫夫曼编码表" + huffmanCodes);

        // 测试字符串转化为赫夫曼编码
        byte[] code = zip(bytes, huffmanCodes);
        for(byte i : code){
            System.out.print(i+", ");
        }



    }


    /**
     * 完成数据的解压
     * 思路
     * 1.将【-88, -65, -56, -65, -56, -65, -50, -31, -57, 4, -24, -78, -117, -4, -57, 112, 28】
     * 重写为二进制
     * 2、赫夫曼编码对应的二进制的字符串
     */




    /**
     * 将一个byte转成一个二进制的字符串, 最后一个字节无序转高位
     * @param flag
     * @param b
     * @return
     */
    public static String byteToBitString(boolean flag, byte b){
        int temp = b;
        if(flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }



    /**
     * 编写一个方法，返回一个字符串的赫夫曼编码
     */
    /**
     *
     * @param bytes 字符串对应的byte[]
     * @param huffmanCodes huffmanCodes生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     * 举例： String str = "I like like like java do you like a java";
     * 返回：
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < bytes.length; i++){
            res.append(huffmanCodes.get(bytes[i]));
        }
        String str = res.toString();
        System.out.println("赫夫曼编码为："+str);
        int len = (str.length()+7) / 8;
        byte[] ret = new byte[len];
        int index = 0;
        for(int i = 0; i < str.length(); i += 8){
            if(i + 8 > str.length()){
                ret[index++] = (byte) Integer.parseInt(str.substring(i), 2);
            }else {
                ret[index++] = (byte) Integer.parseInt(str.substring(i, i + 8), 2);
            }
        }
        return ret;
    }



    /**
     * 生成赫夫曼树对应的赫夫曼编码
     * 1.将赫夫曼编码存放在Map<Byte,String>形式
     * 生成的赫夫曼编码表{32=01, 97=101, 100=10011, 101=1101, 73=10010, 105=1110, 106=0010,
     * 107=1111, 108=000, 111=0011, 117=11000, 118=1000, 121=11001}
     * 2、在生成赫夫曼编码时，需要去拼接路径，定义StringBuilder存储叶子结点的路径
     */
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();


    private static Map<Byte, String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     * 功能：将传入的node结点的所有节点的赫夫曼编码得到，并放入到HuffmanCodes集合当中
     * @param node 传入节点
     * @param code 路径：左子结点是0，右子结点1
     * @param stringBuilder 拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到StringBuilder2
        stringBuilder2.append(code);
        if(node != null){
            // 判断当前的node是否为叶子结点
            if(node.data == null){//非叶子结点
                // 递归处理
                // 向左
                getCodes(node.left, "0", stringBuilder2);
                // 向右
                getCodes(node.right, "1", stringBuilder2);

            }else {// 说明是叶子结点
                // 就表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }



    /**
     * 遍历
     * @param root
     */
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("......");
        }
    }



    /**
     * 创建哈夫曼树
     * @param nodes
     * @return
     */
    public static Node creatHuffmanTree(ArrayList<Node> nodes){
        // 第一步为了操作方便
        // 1、遍历arr数组
        // 2、将arr的每一个元素构成一个Node
        // 3、将Node放入到ArrayList中

        while(nodes.size() > 1){
            // 排序 从小到大
            Collections.sort(nodes);
            /*System.out.println("nodes = " + nodes);*/

            // 取出根结点权值最小的两颗二叉树
            // 1、取出权值最小的节点
            Node leftNode = nodes.get(0);
            // 2、取出次小
            Node rightNode = nodes.get(1);
            // 3、构建新树
            Node parent = new Node(leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4、从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5、将parent加入到nodes
            nodes.add(parent);
        }
        // 返回赫夫曼树
        return nodes.get(0);

    }

    public static ArrayList<Node> creatList(byte[] bytes){
        ArrayList<Node> list = new ArrayList<>();
        byte[] asc = new byte[128];
        for(int i = 0; i < bytes.length; i++){
            asc[bytes[i]]++;
        }
        for(int i = 0; i < 128; i++){
            if(asc[i] != 0){
                list.add(new Node((byte)i, asc[i]));
            }
        }
        return list;
    }
}


// 创建Node，存放数据和权值
class Node implements Comparable<Node>{
    Byte data; // 存放数据本身
    int weight; // 权重
    Node left;
    Node right;
    public Node(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }
    public Node(int weight){
        this.weight = weight;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}