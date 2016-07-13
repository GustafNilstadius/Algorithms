import IntList.IntList;


/**
* @author 	Gustaf Nislstadius
* @version 	1.0
* @since	2015-01-21
*/
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IntList list = new IntList(3);
			for (int i = 1; i < 11; i++){
				list.add(i);
			}
			System.out.println("Added 1-10 : \t\t" + list.toString() + "\t\t current size: "+ list.size());
			
			list.add(3, 42);
			System.out.println("Added 42 to index 3 : \t" + list.toString() + "\t current size: "+ list.size());
			
			list.add(0, 13);
			System.out.println("Added 13 to index 0 : \t" + list.toString() + "\t current size: "+ list.size());
			
			list.remove(0);
			System.out.println("Removed index 0 : \t" + list.toString() + "\t current size: "+ list.size());
			
			System.out.println("Int at index 0 : " + list.get(0));
			
			list.set(0, 55);
			System.out.println("Set index 0 to 55 : \t" + list.toString() + "\t current size: "+ list.size());
			
			list.add(1, 77);
			System.out.println("Added 77 to index 1 : \t" + list.toString() + "\t current size: "+ list.size());
			
			list.add(4, 41);
			System.out.println("Added 41 to index 4 : \t" + list.toString() + "\t current size: "+ list.size());
			
			
			System.out.println("Idex of 6 is: " + list.indexOf(6));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		

	}

}
