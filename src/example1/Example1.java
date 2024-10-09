package example1;

public class Example1 {

	public static void main(String[] args) {
		
		/*
		 * List<Integer> intList=Arrays.asList(1,2,3,4,5);
		 * intList.stream().map(e->e*e).collect(Collectors.toList()).forEach(System.out:
		 * :println);
		 */
        
        RecordTest t=new RecordTest(1, 2);
		System.out.println(t);
	}

}
