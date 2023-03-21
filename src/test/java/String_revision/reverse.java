package String_revision;

public class reverse {
	public static void main(String[] args) {
		String input="alpha123beta123";
		int length = input.length();

		String temp="";
		String temp1="";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			try {
				
		Integer.parseInt(String.valueOf(c));
			if (input.length()==i) {
				System.err.println(input.length()-1==i);
				temp=temp1+c+temp;
				
			}else {
				temp1=c+temp;
				
			}
			
		} catch (Exception e) {
			if (temp1.length()>1) {
				temp=c+temp1+temp;
				temp1="";
				
			}else {
				temp=c+temp;
				
			}
		}
		
		}
		System.out.println(temp);  //alpha***beta&&&
	}

}
