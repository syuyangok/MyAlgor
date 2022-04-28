package com.yuyang.leetcode.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @auther Yuyang Sun
 * @date 4/28/2022
 */
//380. Insert Delete GetRandom O(1)
// Implement the RandomizedSet class
public class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> valToIndex;
    Random rand = new Random();

    public RandomizedSet(){
        list = new ArrayList<>();
        valToIndex = new HashMap<>();//key is item, value is index of item.
    }

    public boolean insert(int val){
        //safe check
        if (valToIndex.containsKey(val)) return false;

        //insert item to end of list
        int index = list.size();
        list.add(val);
        valToIndex.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        //safe check
        if (!valToIndex.containsKey(val)) return false;

        //remove target,
        // first find index of target.
        int index = valToIndex.get(val);
        //if target is not the last one, swap target with last item.
        if (index != list.size()-1){
            swap(index, list.size()-1);
            valToIndex.put(list.get(index), index);
        }

        //remove target
        list.remove(list.size()-1);
        //update map
        valToIndex.remove(val);

        return true;
    }

    private void swap(int index, int i) {
        int temp = list.get(index);
        list.set(index, list.get(i));
        list.set(i, temp);
    }

    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }


}
