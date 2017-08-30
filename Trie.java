package trie;

import java.util.ArrayList;

/**
 * Trie are used for efficiently searching for a pattern of items in a transaction in frequent
 * itemset mining algorithms. This represents the structure of a Trie.
 *
 */

public class Trie {
    private TrieNode rootNode;
    final int height;

    public Trie(int height) {
        rootNode = new TrieNode();
        this.height = height;
    }

    boolean add(ItemSet itemSet) {
        
        TrieNode root=this.rootNode;
        for(int i=0;i<height;i++){
            int key=itemSet.get(i);
            if(!root.containsKey(key)){ 
                TrieNode newNode=new TrieNode();
                root.put(key,newNode);
            }
            root=root.get(key);
        }
        if(root.isLeafNode()){return false;}
        root.setLeafNode(true);
        root.add(itemSet);
  
		return true;
    }

    boolean contains(ItemSet itemSet) {
      
        boolean contain=false;
        TrieNode root=this.rootNode;
        for(int i=0;i<itemSet.size();i++){
            int key=itemSet.get(i);
            if(!root.containsKey(key)){ 
                contain=false;
                return contain;
            }
            root=root.get(key);
        }

        if(root.isLeafNode()){
            contain=true;}
        return contain;
        

    }

    public TrieNode getRootNode() {
        return rootNode;
    }

    public void findItemSetsInRecurse(ArrayList<ItemSet> matchedItemSet, ArrayList<Integer> transaction,int height, int curHeight,ItemSet itemSet) {
        if(height==curHeight){
            if(this.contains(itemSet)){
                ItemSet newItemSet=new ItemSet(height);
                for(int e:itemSet){newItemSet.add(e);}
                matchedItemSet.add(newItemSet);
            }
        }
        else if(height>curHeight){
            for(int i=0;i<transaction.size();i++){
                int index=i;
                int key=transaction.get(index); 
                transaction.remove(index);
                itemSet.add(key);
                curHeight++;
                this.findItemSetsInRecurse(matchedItemSet, transaction,height,curHeight,itemSet);
                transaction.add(index,key);
                itemSet.remove(itemSet.size()-1);
                curHeight--;
        }

        }
    
    }
    public void findItemSets(ArrayList<ItemSet> matchedItemSet, ArrayList<Integer> transaction) { //itemset was list on piaza
        
        int curHeight=0;
        ItemSet itemSet=new ItemSet(height);
        findItemSetsInRecurse(matchedItemSet, transaction,height,curHeight,itemSet);

    }
}
