package com.yuyang.graph;

import java.util.*;

/**
 * @author : Yuyang Sun
 * @date: 3/24/2022, Thu
 **/
//743. Network Delay Time
// basic,use dijkstras find longest path in short path.
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //using map to build graph.
        Map<Integer, Map<Integer, Integer>> graph = build(times);

        //run di

        int max = 0;
        return max;
    }

    private int[] dijkstra(Map<Integer, Map<Integer, Integer>> graph,int n, int s ){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MIN_VALUE);//fill distance with max
        dist[s] = 0;//set start node dist is 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>();
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()){
            int[] cur  = pq.poll();
            int toNode = cur[0];
            int weight = cur[1];


        }



        return dist;
    }

    //method to build graph
    public Map<Integer,Map<Integer,Integer>> build(int[][] times) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] i : times) {

            int from = i[0];//edge from
            int to = i[1];//edge to
            int weight = i[2];
            map.putIfAbsent(from, new HashMap<Integer, Integer>());
            Map<Integer, Integer> values = map.get(from);
            values.put(to, weight);

        }

        return map;
    }
}