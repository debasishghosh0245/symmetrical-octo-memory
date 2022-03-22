public class KReverseInLinkedList{
    
    public static class LinkedList {
       
        private Node head;
        private Node tail;
        private int size;

		public void addFirst(int val) {
			Node temp=new Node(val);
			temp.next=this.head;
			tail=head;
			while(null!=tail && tail.next!=null){
				  tail=tail.next;
			}
			this.head=temp;
			size++;
		}
    
		public void addLast(int data) {
			tail=new Node(data);
			if(head==null){
			   head=tail;
			}else{
			   Node current=head;
			   while(current.next!=null){
					   current=current.next;
			   }
			   current.next=tail;
			  }
			 size++;
		}
   
		public void display(Node head){
				Node curr=head;
				while(curr!=null){
				   System.out.print(curr.data+" ");
				   curr=curr.next;
			}
			System.out.println(" ");
		}
    
		public Node removeFirst(){
			if(head==null){
				System.out.println("List is empty");
				
			}else if(head.next==null){
				head=tail=null;
				size--;
			}
			else{
				head=head.next;
				size--;
			}
			return head;
		}
    
		public int length(Node head){
			if(head.next==null) return 1;
			int length=length(head.next);
			return length+1;
		}
    
		public Node reverse(int k){
			Node tempHead=null;
			Node tempTail=null;
			Node orgHead=null;
			Node orgTail=null;
			Node curr=head;
			int cnt=k;        
			while(curr!=null && k <= length(curr)){
				tempHead=null;
				tempTail=null;
				cnt=k;
				while(cnt!=0 ){
					Node temp=curr.next;
					curr.next=tempHead;
					tempHead=curr;
					if(tempTail==null) {
						tempTail=tempHead;
					}
					curr=temp;
					cnt--;
				}
				if(orgHead==null) {
					orgHead=tempHead;
					orgTail=tempTail;
				}else {
					orgTail.next=tempHead;
					orgTail=tempTail;
				}
			}
			if(curr!=null){
				orgTail.next=curr;
				//orgTail=tempTail;  
			}
			return orgHead;
		}
}
   
		private static class Node {
		   public Node next;
		   public int data;
			
		   Node(int data){
			 this.data=data;
		   }
		   Node(Node next,int data){
			 this.data=data;
			 this.next=next;
		   }  
	   }

	   public static void main(String[] args) {
		   
			LinkedList list=new LinkedList();
			list.addLast(1);
			list.addLast(2);
			list.addLast(3);
			list.addLast(4);
			list.addLast(5);
			list.display(list.head);
			Node temp=list.reverse(2);
			list.display(temp);
	   }   
}