public class test1 {

	public static void main(String[] args) {
		String s = null;
		String ss = testme(s);
		System.out.println(ss);		
	}
	public static String testme(String s) {
		try {
			return s.substring(0,1);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return "hello";
	}
}

