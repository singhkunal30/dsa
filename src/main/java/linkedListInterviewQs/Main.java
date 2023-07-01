package linkedListInterviewQs;

public class Main {
	
	public static LinkedList sumLists(LinkedList l1, LinkedList l2){
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        String s1 = "";
        String s2 = "";
        while(temp1 != null){
            s1 += temp1.value;
            s2 += temp2.value;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
//        System.out.println(s1+"\n"+ s2);
        String s3 = new StringBuffer(s1).reverse().toString();
        String s4 = new StringBuffer(s2).reverse().toString();
        String s5 = String.valueOf(Integer.parseInt(s3)+Integer.parseInt(s4));
//        System.out.println(s5);
        LinkedList newl = new LinkedList();
        for(int i=s5.length()-1; i>=0; i--){
            int x = s5.charAt(i) - '0';
            if(i == s5.length()-1) newl.create(x);
            else newl.insertNode(x);
        }
        return newl;
    }
	
	public static void main(String[] args) {
//		LinkedList l1 = new LinkedList();
//		l1.create(5);
//		l1.insertNode(3);
//		l1.insertNode(1);
//		LinkedList l2 = new LinkedList();
//		l2.create(4);
//		l2.insertNode(1);
//		l2.insertNode(1);
//		sumLists(l1,l2).traverse();

		
	}
	
}
