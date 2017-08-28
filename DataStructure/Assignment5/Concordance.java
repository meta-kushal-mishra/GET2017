
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concordance {

	private HashMap<Character, List<Integer>> mapping;	
	private List<Integer> index;	
	
	public void getConcordance(StringBuffer concat) {
		char data;
		mapping = new HashMap<Character, List<Integer>>();
		
		for(int i=0; i < concat.length(); i++) {
			data = concat.charAt(i);
			
			if(!mapping.containsKey(data)) {
				index = new ArrayList<Integer>();
			} else {
				index = mapping.get(data);
			}
			
			index.add(i);
			mapping.put(data, index);
		}
	}

	public void display() {
		Object[] keys;
		
		keys = mapping.keySet().toArray();
		
		for(int i=0; i < keys.length; i++) {
			index = mapping.get(keys[i]);
			System.out.print(keys[i]+" - ");
			
			for(int j=0 ; j < index.size(); j++) {
				System.out.print(index.get(j)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Concordance cordanceString = new Concordance();
		StringBuffer concatenate = new StringBuffer();
	
		for(int i=0; i < args.length; i++) {
			concatenate.append(args[i]);
		}
		
		cordanceString.getConcordance(concatenate);
		cordanceString.display();
	}
}
