package selPractice;

public class TestDir {
	
	public static void main(String[] args) {
		
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		System.out.println(currentDir + "\\Screenshot" + "\\");
	}

}
