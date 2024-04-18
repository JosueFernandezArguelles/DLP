package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		try {
			if( str.length() > 1 ){
				if( str.charAt(1) == ('\\') ){
					if(str.charAt(2) == 'n'){
						return '\n';
					} else if (str.charAt(2) == 't') {
						return '\t';
					} else if (Character.isDigit(str.charAt(2))) {
						return (char) Integer.parseInt( str.substring(1, str.length() - 1) );
					}
				}
				return str.charAt(1);
			}
			return str.charAt(0);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		assert false: "Unknown pattern of char constant";
		return ' ';
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
	
}
