package trie;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        

        ArrayList<ItemSet> matchedItemSet = new ArrayList<>();
        
        ItemSet itemSet1=new ItemSet(2);
        itemSet1.add(1);
        itemSet1.add(2);


        ItemSet itemSet2=new ItemSet(2);
        itemSet2.add(1);
        itemSet2.add(3);

        ItemSet itemSet3=new ItemSet(2);
        itemSet3.add(2);
        itemSet3.add(3);

        Trie trie=new Trie(2);
        trie.add(itemSet1);
        trie.add(itemSet2);
        trie.add(itemSet3);
        
        ArrayList<Integer> transaction=new ArrayList<>();
        transaction.add(1);
        transaction.add(2);
        transaction.add(3);
        transaction.add(4);
        transaction.add(5);
     
        trie.findItemSets(matchedItemSet, transaction);
        System.out.println(matchedItemSet);
       
        transaction.remove(0);
        matchedItemSet.clear();

        trie.findItemSets(matchedItemSet, transaction);
        System.out.println(matchedItemSet);


        transaction.remove(0);
        transaction.remove(0);
        matchedItemSet.clear();
        
        trie.findItemSets(matchedItemSet, transaction);
        
    

        System.out.println(matchedItemSet);
    }


}
