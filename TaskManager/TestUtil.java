package ProjectB94;

public class TestUtil
{
	
	public static boolean validateName(String str )
	{
		if(str==null ||str.trim().equals(""))
			return false;
		if(!(Character.isLetter(str.charAt(0))))
			return false;
		if(str.split(" ").length>1)
			return false;
		for (int i = 1; i < str.length(); i++)
		{
			char c=str.charAt(i);
			if(!(Character.isLetter(c)|| Character.isDigit(c)))
            return false;
		}
		
		return true;		
	}
	

}
