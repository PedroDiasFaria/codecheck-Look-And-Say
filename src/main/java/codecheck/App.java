package codecheck;

/*
 *	More about the sequence explained:
 *	https://www.youtube.com/watch?v=ea7lJkEhytA
**/

public class App {

	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {
			//System.out.print(args[i] + " -> ");
			String result = lookAndSay(Integer.parseInt(args[i]));
			System.out.println(result);
		}
	}

	//Calculates nth term in Look and Say
	static String lookAndSay(int n){
	    
	    //Base cases
	    if (n == 1)      
	    	return "1";
	    if (n == 2)      
	    	return "11";

		String lookNsay = "1";
		String temp;

		//Calculate the nth term by calculating all terms from n to 1
		while(--n != 0){

			temp = "";
			int count = 1;
			//Easier to process as char[]
			char[] charArrayLnS = lookNsay.toCharArray();

			//All of them are calculated using the previous one
			char previous = charArrayLnS[0];

			//Process previous term to find the next 
			for(int i = 1; i < charArrayLnS.length; i++){

				//If current doesn't match
				if(charArrayLnS[i] != previous){
					//Append it to the temporary value and restart the counting
					temp = temp + count + previous;
					previous = charArrayLnS[i];
					count = 1;
				} 
				else
					count++;		//If matches, increment the counting

			}

			lookNsay = temp + count + previous;

			//Return only the 500 first digits of the result
			if(lookNsay.length() > 500){
				return lookNsay.substring(0, 500);
			}
		}
		return lookNsay;
	}
}