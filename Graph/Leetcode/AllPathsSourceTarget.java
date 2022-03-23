package com.yuyang.leetcode.graph;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

/**
 * @auther Yuyang Sun
 * @date 3/22/2022
 */
//leetcode 797 797. All Paths From Source to Target
// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
// find all possible paths from node 0 to node n - 1
public class AllPathsSourceTarget {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //path to use in recursive
        List<Integer> path = new LinkedList<>();

        traverse(graph, 0, path);
        return result;
    }

    private void traverse(int[][] graph, int s, List<Integer> path) {
        path.add(s);
        //base case,
        if (s == graph.length-1){
            result.add(new LinkedList<Integer>(path));//reach node n-1, add path to result.
            path.remove(path.size()-1);//remove last item. keep path clean.
            return;
        }
        //visit all neighbors of s.
        for (int i : graph[s]){
            traverse(graph, i, path);
        }
        path.remove(path.size()-1);//remove last item. keep path clean.


    }
}