#g graph
#n, number of nodes
#s, the node of start

function dijkstra(g, n, s):
  #create a array to record vistied nodes
  visit[] = [false, false, false,....]; #size n
  #create a array to record shortest value to start node
  dist[] = [0, -1, -1, -1....];#size n
  
  pq; #create a priority queque   
  pq.insert((s,0));
  
  while(pq not empty){    
     (indexNode, miniValue) = pq.pop();
     visit[indexNode] = true; #lable as visited node
       
    for(each edge e: g[indexNode] ){
      
      # if neighbor nodealready visited, skip.
      if(visit[e.toNode] == true) continue;
      
      #if new value less than current value, update current value. and insert to pq.
      if (e.value + dist[indexNode] < dist[e.toNode]){
        dist[e.toNode] = e.value + dist[indexNode];
        pq.insert((e.toNode, dist[e.toNode]));
      }//#if end
    }
    
  }//#while end

  return dist;
  


  
 
