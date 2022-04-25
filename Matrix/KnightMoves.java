package com.yuyang.leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther Yuyang Sun
 * @date 4/22/2022
 */
//leetcode mini knight moves
//bfs can find mini path, two d directions. decide right path.
public class KnightMoves {
    public int minKnightMoves(int x, int y){
        int steps=0, MAXN = 301;
        //2d array to store visited
        boolean[][] visited = new boolean[MAXN][MAXN];
        //init Q, use int[2] to repesent positions
        Queue<int[]> q = new LinkedList<>();
        // array to represent directions
        int[] dx = new int[]{-2, -1, 1, 2, 2, 1,-1,-2};
        int[] dy = new int[]{ 1,  2, 2, 1,-1, -2,-2,-1};

        //add start point to q, label as visited
        q.add(new int[]{0,0});
        visited[0][0] = true;

        //while loop untile q empty
        while(q.size()>0){
            int levelSize = q.size();//to record same level size
            for(int j = 0; j< levelSize; j++){
                //deque
                int[] poll = q.poll();
                //check poll positions
                if (poll[0] == x && poll[1] == y){
                    return steps;//find target position, return steps
                }

                //for every possible neighbors of v,
                for (int i = 0; i < 8; i++) {
                    //future move positions/neighbor
                    int moveX = poll[0] + dx[i];
                    int moveY = poll[1] + dy[i];
                    //check bounder
                    if (moveX < 0 || moveX > MAXN || moveY <0 || moveY>MAXN){
                        continue;//skip not possible positions
                    }
                    //if v not visited, enqueue
                    if (!visited[moveX][moveY]){
                        q.add(new int[]{moveX, moveY});
                        visited[moveX][moveY] = true;
                    }
                }
            }

            //System.out.println(poll[0] + "  " + poll[1] + "  steps: " +steps );
            steps++;//after same level loop, then steps ++;


        }


        return -1;//if not possible
    }
}
