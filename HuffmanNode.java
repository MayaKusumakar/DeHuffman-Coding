public class HuffmanNode implements Comparable{
   char val;
   HuffmanNode left;
   HuffmanNode right;
   int count;
   
   public HuffmanNode(char v, HuffmanNode l, HuffmanNode r){
      val = v;
      left = l;
      right = r;
      count = 0;
   }
   
   public HuffmanNode(char v){
      val = v;
      left = null;
      right = null;
      count = 0;
   }
   
   public HuffmanNode(){
      left = null;
      right = null;
      count = 0;
      val = 0;
   }
   
   public HuffmanNode(char v, int c){
      val = v;
      count = c;
      left = null;
      right = null;
   }
   
   public HuffmanNode(int num, HuffmanNode l, HuffmanNode r){
      count = num;
      left = l;
      right = r;
      val = 0;
   }
   public int getCount(){
      return count;
   }
   
   public int compareTo(Object o){
      if(o instanceof HuffmanNode){
         HuffmanNode obj = (HuffmanNode)(o);
         if(this.count > obj.count){
            return 1;
         } else if(this.count == obj.count){
            return 0;
         }

      }
            
      return -1;
   }

   
   
   public boolean isLeaf(){
      if(this.left == null && this.right == null){
         return true;
      }
      
     return false;
   }
   
   public HuffmanNode getRight(){
      return right;
   }
   
   public HuffmanNode getLeft(){
      return left;
   }

   public char getVal(){
      return val;
   }

   public void setValue(Character v){
      val = v;
   }

   public void setLeft(HuffmanNode l){
      left = l;
   }

   public void setRight(HuffmanNode r){
      right = r;
   }

   public String toString(){     
      return "" + val + " " + count;  
   }

   
}