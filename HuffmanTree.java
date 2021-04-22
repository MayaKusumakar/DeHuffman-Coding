import java.io.*;
import java.util.*;
public class HuffmanTree{
   HuffmanNode root;
   
   public HuffmanTree(Scanner obj){
      Map<Character, String> map = new TreeMap<Character,String>();
      root = null;      
      int num = 1;
      while(obj.hasNext()){
         
         String firstLine = obj.nextLine();
         String path = obj.nextLine();
         
         int firstInt = Integer.parseInt(firstLine);
         
         char letter = (char)(firstInt);
         root = add(root,letter,path,0);
         map.put(letter, path);
         
         
      }
      
      
      
    }
     
   public HuffmanTree(Scanner file, Histogram hst){
      buildHistogram(file, hst);
      
      int[] array = hst.getCountArray();
      
      PriorityQueue<HuffmanNode> q = new PriorityQueue<>();    
      for(int i = 0; i < array.length; i++){
         HuffmanNode n = new HuffmanNode((char)(i+65),array[i]);
         q.add(n);
      }
      
      q.add(new HuffmanNode((char)(array.length), 1));
      
      while(q.size() != 1){
      HuffmanNode smallest = q.poll(); 
      HuffmanNode smallest2 = q.poll();
      
      int combinedScore = smallest.getCount() + smallest2.getCount();
      
      HuffmanNode parent = new HuffmanNode(combinedScore, smallest, smallest2);
      
      q.add(parent);
      
      }
      
      root = q.poll();
   }
   
   
   private void buildHistogram(Scanner f, Histogram h){
      while(f.hasNext()){
         String line = f.nextLine();
         char[] charArray = line.toCharArray();
         for(int i = 0; i<charArray.length; i++){
            h.add(charArray[i]);
         }
         
      }
   }
   
   private HuffmanNode add(HuffmanNode node, Character val, String code, int spot){
      if(spot!=code.length()){
         if(node == null){
            node = new HuffmanNode();
         }
         if(code.substring(spot, spot+1).equals("0")){
            node.setLeft(add(node.getLeft(), val, code, spot+1));
         }
         else{
            node.setRight(add(node.getRight(), val, code, spot+1));
         }

      }else{
         node = new HuffmanNode(val);
      }
      return node;

   }
   private void inOrder(HuffmanNode node){
      if(node != null){
         inOrder(node.getLeft());
         if(node.getLeft() == null && node.getRight() == null){
         System.out.print(node.getVal() + " ");
         }
         inOrder(node.getRight());   
      }
      
         }
    public void printTree(){
      inOrder(root);
    }
    
    public void decode(BitInputStream in, PrintStream out){
      while(true){
         int c = getOneChar(in);
         if(c == Integer.MAX_VALUE){
            return;
         }else{
            out.append((char)(c));
         }
      }
    }
    
    public void generateCodeFile(PrintStream out){
      String str = "";
      inOrderFile(root, str, out);
    }
    
    public void inOrderFile(HuffmanNode n, String str, PrintStream o){
      if(n!= null){
         inOrderFile(n.getLeft(), str+0, o);
         if(n.isLeaf()){
            o.println((int)n.getVal());
            o.println(str);
         }
         inOrderFile(n.getRight(), str+1, o);
      }
    }
    private int getOneChar(BitInputStream input){
      HuffmanNode n = root;
      while(true){
         int b = input.readBit();
         if(b==0){
            n = n.getLeft();
         } else if(b==1){
            n = n.getRight();
         }
         else if(b ==-1){
            return Integer.MAX_VALUE;
         }
         if(n.isLeaf()){
            return n.getVal();
         }
      }
    }
    
}

