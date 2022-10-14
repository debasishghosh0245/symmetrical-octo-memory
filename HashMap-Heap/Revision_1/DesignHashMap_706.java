import java.util.*;
public class DesignHashMap_706{

    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.remove(27);
        System.out.println(myHashMap.toString());
    }
}

class MyHashMap{
    static class Entry{
        int key;
        int val;
        Entry(int key,int val){
            this.key=key;
            this.val=val;
        }
        public String toString(){
            return this.key+" "+this.val;
        }
    }
    private static int INITIAL_CAPACITY=16;
    private float loadFactor=(float)0.6;
    private LinkedList<Entry>[] buckets=null;
    int bucketsSize=INITIAL_CAPACITY;
    int noOfElements=0;
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets=(LinkedList<Entry>[]) new LinkedList<?>[bucketsSize];
        for(int i=0;i<bucketsSize;i++){
            buckets[i]=new LinkedList<Entry>();
        }
    }
    @SuppressWarnings("unchecked")
    public void put(int key, int value) {
        int bucketsIdx=findbucketsIndex(key);
        System.out.println("bucketsIdx "+bucketsIdx);
        LinkedList<Entry> linkedList=buckets[bucketsIdx];
        boolean isExist=false;
        for(Entry entry: linkedList){
            if(entry.key==key){
                entry.val=value;
                isExist=true;
            }
        }
        if(!isExist){
            noOfElements++;
            linkedList.addLast(new Entry(key,value));
        }
        //check for re-hashing
        float currLoadFact=(float)noOfElements/(float)bucketsSize;
        System.out.println("Current load factor "+currLoadFact);
        if(loadFactor <= currLoadFact){
            rehash();
        }
    }

    public int get(int key) {
        int bucketsIdx=findbucketsIndex(key);
        LinkedList<Entry> linkedList=buckets[bucketsIdx];
        for(Entry entry: linkedList){
            if(entry.key==key){
                return entry.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int bucketsIdx=findbucketsIndex(key);
        int remove_idx=getKeyIndex(bucketsIdx,key);

        if(remove_idx!=-1){
            LinkedList<Entry> linkedList=buckets[bucketsIdx];
            linkedList.remove(remove_idx);
            noOfElements--;
        }
    }

    public int findbucketsIndex(Object key){
        return Math.abs(key.hashCode())%bucketsSize;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        System.out.println("buckets length >>"+buckets.length);
        for(LinkedList<Entry> linkedList: buckets){
            if(linkedList.size()==0){
                sb.append("[ ] ");
            }else{
                for(Entry entry:linkedList){
                    sb.append("[ "+entry+" ] ");
                }
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public void rehash(){
        this.noOfElements=0;
        LinkedList<Entry>[] oldbuckets=buckets;
        bucketsSize=2*bucketsSize;
        buckets=(LinkedList<Entry>[])new LinkedList<?>[bucketsSize];
        for(int i=0;i<bucketsSize;i++){
            buckets[i]=new LinkedList<Entry>();
        }
        for(int i=0;i<oldbuckets.length;i++){
            LinkedList<Entry> linkedList=oldbuckets[i];
            for(Entry entry: linkedList){
                put(entry.key,entry.val);
            }
        }
    }

    public int getKeyIndex(int bucketsIdx,int key){
		int idx=0;
		LinkedList<Entry> linkedList=buckets[bucketsIdx];
		for(Entry entry:linkedList){
			if(entry.key==key) return idx;
			idx++;
		}
		return -1;
	}
}
