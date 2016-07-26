package ServletPackages.Formulaires;

import BeanPackage.NumericConstant;

class Vernam implements NumericConstant {
	String plainBit, cipher, plain;

	public void setPlain(String plain) {
		StringBuffer sb = new StringBuffer();
		this.plain = plain;
		for (int i = 0; i < plain.length(); i++)
			sb.append(chrToBit(getPlain().charAt(i)));
		this.plainBit = sb.toString();
	}

	// public Vernam(String plain, String plainBit, String cipher, String key) {
	// super();
	// this.plain = plain;
	// this.plainBit = plainBit;
	// this.cipher = cipher;
	// this.key = key;
	// }

	public String getPlain() {
		return plain;
	}

	public Vernam(String plain) {
		setPlain(plain);
	}

	void setPlainBit(String plain) {
		this.plainBit = plain;
	}

	// String getPlain(){
	// return this.plain;
	// }

	String getPlainBit() {
		return this.plainBit;
	}

	String getCipher() {
		return this.cipher;
	}

	String chrToBit(int chr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 8; i++) {
			sb.append(chr % 2);
			chr = chr / 2;
		}
		sb.reverse();
		return sb.toString();
	}

	public String encry() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.plainBit.length(); i++) {
			int p = this.plainBit.charAt(i) == '1' ? 1 : 0;
			int k = KEYGEN.charAt(i) == '1' ? 1 : 0;
			sb.append(p ^ k);
		}
          
		return conversionBinaireTohex(sb.toString());
	}

	char bitToChr(String bit) {
		System.out.println(bit);
		System.out.println((char) Integer.parseInt(bit, 2) + " ");
		return (char) Integer.parseInt(bit, 2);
	}

	String bitKeStr() {
		StringBuffer sb = new StringBuffer();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < this.cipher.length(); i++) {
			tmp.append(this.cipher.charAt(i));
			if (tmp.length() == 8) {
				sb.append(bitToChr(tmp.toString()));
				tmp = new StringBuffer();
			}
		}
		return sb.toString();
	}

	public String conversionBinaireTohex(String binaire) {
		int binaryLength = binaire.length();
		String Hexa = "";
		String bit = "";
		String nombreHexadecimal = "";
		int k = binaryLength % 4;
		if (k != 0) {
			switch (k) {
			case 1: {
				binaire = "000".concat(binaire);
				binaryLength = binaryLength + 3;
			}
				break;
			case 2: {
				binaire = "00".concat(binaire);
				binaryLength = binaryLength + 2;
			}
				break;
			case 3: {
				binaire = "0".concat(binaire);
				binaryLength = binaryLength + 1;
			}
				break;
			}
		}
		int i = binaryLength;
		while (i > 0) {
			bit = binaire.substring(i - 4, i);
			Hexa = binValueToHex(bit);
			nombreHexadecimal = Hexa.concat(nombreHexadecimal);
			i = i - 4;
		}
		return nombreHexadecimal;
	}

	public String binValueToHex(String bin) {
		String hexadecimale = null;
		switch (bin) {
		case "0000":
			hexadecimale = "%k";
			break;
		case "0001":
			hexadecimale = "#H";
			break;
		case "0010":
			hexadecimale = "K";
			break;
		case "0011":
			hexadecimale = "5";
			break;
		case "0100":
			hexadecimale = "2G";
			break;
		case "0101":
			hexadecimale = "A8";
			break;
		case "0110":
			hexadecimale = "0";
			break;
		case "0111":
			hexadecimale = "l";
			break;
		case "1000":
			hexadecimale = "Q";
			break;
		case "1001":
			hexadecimale = "Z";
			break;
		case "1010":
			hexadecimale = "P";
			break;
		case "1011":
			hexadecimale = "K";
			break;
		case "1100":
			hexadecimale = "à";
			break;
		case "1101":
			hexadecimale = "R";
			break;
		case "1110":
			hexadecimale = "*";
		case "1111":
			hexadecimale = "µµ";
			break;

		}

		return hexadecimale;
	}
}