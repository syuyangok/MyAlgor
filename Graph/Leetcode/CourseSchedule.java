package com.yuyang.leetcode.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//leetcode 207. Course Schedule
//leetcode 210. Course Schedule II, toposort
//finde cycle in a graph
/**
 * @auther Yuyang Sun
 * @date 3/23/2022
 */
public class CourseSchedule {
    boolean[] visited; //record node visited.
    boolean[] onPath; //record node on current path;
    boolean hasCycle = false;

    List<Integer> postOrder;//add node to list from small post# to large#, last one is source




    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        postOrder = new LinkedList<>();//for 210


        //build graph
        List<Integer>[] graph = buildGraph( numCourses, prerequisites);
        //traverse graph to find if has cycle
        for (int i = 0; i < numCourses; i++) {
            //set i as start node
            traverse(graph, i);//dfs traverse
        }
        Collections.reverse(postOrder);//for 210
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        //base case, only visit nodes on current path mean cycle
        if(onPath[i]){
            hasCycle = true;
            return;
        }

        if(visited[i]){
            return;
        }

        visited[i] = true;
        onPath[i] = true;//set node on the current path.
        for ( int w : graph[i]) {
            traverse(graph, w);
        }
        //before leave node, remove node from current path
        onPath[i] = false;
        postOrder.add(i);//add node to post order list
    }

    //build graph from input
    //array store every node. each node have a linkedlist to store edge.
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        //every course is a node. array to store every node
        List<Integer>[] graph = new LinkedList[numCourses];

        //add list to every node to prepare for edges
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge: prerequisites ) {
            //get pair nodes of a edge
            int from = edge[1];
            int to = edge[0];
            //add edge to start node's list
            graph[from].add(to);
        }
        return graph;
    }
}
