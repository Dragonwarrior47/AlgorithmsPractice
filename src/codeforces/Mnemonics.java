import java.util.*;

public class Mnemonics{

	public static List<String> phoneMnemonics(String phoneNumber){
		List<String> mnemonics = new ArrayList<String>();
		int n = phoneNumber.length();
		char [] partialMnemonic = new char[n];
		phoneMnemonicHelper(phoneNumber, 0, mnemonics, partialMnemonic);
		return mnemonics;
	}
	
	public static void phoneMnemonicHelper(String phoneNumber, int digit, List<String> mnemonics, char[] partialMnemonic){
		if(digit == phoneNumber.length()){
			mnemonics.add(new String(partialMnemonic));
		}
		else
		{
			for(int i =0; i<MAPPING[phoneNumber.charAt(digit)-'0'].length(); i++){
				partialMnemonic[digit] = MAPPING[phoneNumber.charAt(digit)-'0'].charAt(i);
				phoneMnemonicHelper(phoneNumber, digit+1, mnemonics, partialMnemonic);	
			}
		}
		
	}
	
	public static final String [] MAPPING = {"0", "1", "ABC", "DEF", "GHI",
						"JKL", "MNO","PQRS", "TUV", "WXYZ"};

	public static void main(String args[]){
	
		String phoneNumber = "78";
		
		List<String> ans = phoneMnemonics(phoneNumber);
		System.out.println(ans);
	}
}
