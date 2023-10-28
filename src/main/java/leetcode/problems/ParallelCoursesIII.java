package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ParallelCoursesIII {
    public static void main(String[] args) {
        ParallelCoursesIII courses = new ParallelCoursesIII();
//        int minimumTime = courses.minimumTime(1, new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}}, new int[]{1, 2, 3, 4, 5});
        int minimumTime = courses.minimumTime(3, new int[][]{{1, 3}, {2, 3}}, new int[]{3, 2, 5});
        System.out.println(minimumTime);
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        int max = 0;
        int timeIndex = 0;
        for (int i = 0; i < relations.length; i++) {

        }
        return max;
    }
}

class Tree {
    private Node node;

    public Tree() {
    }

    public void addParentChild(int parent, int child, int time) {
        if (node == null) {
            node = new Node(child, time);
        }
        node.addChild(parent, 0);
    }
}

class Node {

    private final List<Node> pathNodes = new ArrayList<>();

    private int label;
    private int time;

    public Node() {
    }

    public Node(int label) {
        this.label = label;
    }

    public Node(int label, int time) {
        this.label = label;
        this.time = time;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addChild(int label, int time) {
        this.pathNodes.add(new Node(label, time));
    }
}

