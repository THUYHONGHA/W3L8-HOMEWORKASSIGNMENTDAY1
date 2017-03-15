package problem1;

public class MyPersonList {
	private final int INITIAL_LENGTH = 4;
	private Person[] perArray; 
	private int size;
	
	public MyPersonList() {
		perArray = new Person[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(Person s){
		if(size == perArray.length) 
			resize();
		perArray[size++] = s;
	}
	
	public Person get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return perArray[i];
	}
	
	public boolean find(String lastName){
		for(Person test : perArray){
			if(test==null) return false;
			if(test.getLast().equals(lastName)) 
				return true;
		}
		return false;
	}
	
	public void insert(Person s, int pos){
		if(pos > size) return;
		if(pos >= perArray.length||size+1 > perArray.length) {
			resize();
		}
		Person[] temp = new Person[perArray.length+1];
		System.arraycopy(perArray,0,temp,0,pos);
		temp[pos] = s;
		
		System.arraycopy(perArray,pos,temp,pos+1, perArray.length - pos);
		perArray = temp;
		++size;
		
	}
	
	public boolean remove(Person s){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(perArray[i].equals(s)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		Person[] temp = new Person[perArray.length];
		System.arraycopy(perArray,0,temp,0,index);
		System.arraycopy(perArray,index+1,temp,index,perArray.length-(index+1));
		perArray = temp;
		--size;
		return true;
	}
	
	
	private void resize(){
		System.out.println("resizing");
		int len = perArray.length;
		int newlen = 2*len;
		Person[] temp = new Person[newlen];
		System.arraycopy(perArray,0,temp,0,len);
		perArray = temp;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(perArray[i]+", \n");
		}
		sb.append(perArray[size-1]+"]");
		
		return sb.toString();
	}
	public int size() {
		return size;
	}
	
	
		public static void main(String[] args) {
			MyPersonList l = new MyPersonList();
			l.add(new Person("AAA","Bob",18));
			l.add(new Person("BBB","Steve",21));
			l.add(new Person("CCC","Susan",17));
			l.add(new Person("DDD","Mark",21));
			l.add(new Person("EEE","Dave",19));
			System.out.println("The list of size "+l.size()+" is \n"+l);
			l.remove(new Person("DDD","Mark",21));
			l.remove(new Person("AAA","Bob",18));
			System.out.println("The list of size after remove "+l.size()+" is \n"+l);
			l.insert(new Person("ABC","Richard",19),3);
			System.out.println("The list of size "+l.size()+" after inserting Richard into pos 3 is \n"+l);
			l.insert(new Person("BCD","Tonya",20),0);
			System.out.println("The list of size "+l.size()+" after inserting Tonya into pos 0 is \n"+l);		
			System.out.println("Sorted set : ");
			System.out.println("The result for searching person with lastname DDD is "+l.find("DDD"));
			System.out.println("The result for searching person with lastname CCC is "+l.find("CCC"));
			
		}
	

}
