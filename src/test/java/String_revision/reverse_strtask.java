package String_revision;
//Today Task ://123ateb123ahpla reverse only the character

//alpha123beta123
	
		
public class reverse_strtask {
public static void main(String[] args) {
	String s ="alpha123beta123";
	String all = s.replaceAll("123"," ");
	System.out.println(all);
	StringBuffer sb=new StringBuffer(all);
	StringBuffer reverse = sb.reverse();
	System.err.println(reverse);
	String str = reverse.toString();
	String replace = str.replace(" ", "123");
	System.out.println(replace);
	
	
	
}
}
