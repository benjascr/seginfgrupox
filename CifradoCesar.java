import java.util.Scanner;

public class CifradoCesar {
	
	public static final String ALFABETOmin = "abcdefghijklmnopqrstuvwxyz";
	public static final String ALFABETOmay = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
	public static String cifrar(String textoEntrada, int desplazamiento) {
		String textoCifrado = "";
		for(int i=0; i<textoEntrada.length(); i++) {
			if((int)textoEntrada.charAt(i) < 97) {
				if((int)textoEntrada.charAt(i) == 32) {
					textoCifrado += ' ';
				}else {
					int caracterACifrar = ALFABETOmay.indexOf(textoEntrada.charAt(i));
					int pos = (caracterACifrar + desplazamiento) % 26;
					char caracterCifrado = ALFABETOmay.charAt(pos);
					textoCifrado += caracterCifrado;
				}
			}else {
				int caracterACifrar = ALFABETOmin.indexOf(textoEntrada.charAt(i));
				int pos = (caracterACifrar + desplazamiento) % 26;
				char caracterCifrado = ALFABETOmin.charAt(pos);
				textoCifrado += caracterCifrado;
			}
		}
		return textoCifrado;
	}
	
	public static String descifrar(String textoCifrado, int desplazamiento) {
		String textoDescifrado = "";
		for(int i=0; i<textoCifrado.length(); i++) {	
			if((int)textoCifrado.charAt(i) < 97) { 
				if((int)textoCifrado.charAt(i) == 32) {
					textoDescifrado += ' ';
				}else {
					int caracterADescifrar = ALFABETOmay.indexOf(textoCifrado.charAt(i));
					int pos = (caracterADescifrar + desplazamiento) % 26;
					char caracterDescifrado = ALFABETOmay.charAt(pos);
					textoDescifrado += caracterDescifrado;
				}
			}else{ 
				int caracterADescifrar = ALFABETOmin.indexOf(textoCifrado.charAt(i));
				int pos = (caracterADescifrar + desplazamiento) % 26;
				char caracterDescifrado = ALFABETOmin.charAt(pos);
				textoDescifrado += caracterDescifrado;
			}
		}
		return textoDescifrado;
	}
	
	public static void mostrarResultados() {
		for(int i=0; i<26; i++) {
			String resultado = descifrar("KqnzilwKmaizKwzzmkbw", i);
			System.out.println("Desplazamiento " + i + ": " + resultado);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Para cifrar ingresa 'c', para descifrar ingresa 'd': ");
		Scanner sc = new Scanner(System.in);
		char letra;
		do {
			letra = sc.next().charAt(0);
			if (letra == 'c') {
				System.out.println("\nIngresa el desplazamiento deseado: ");
				int despl = sc.nextInt();
				sc.nextLine();
				System.out.println("Ingresa el texto a cifrar: ");
				String texto = sc.nextLine();
				System.out.println("Cifrando texto <<" + texto + ">> con desplazamiento " + despl);
				String cifrado = cifrar(texto, despl);
				System.out.println("El texto cifrado es: " + cifrado);
				break;
			}else if(letra == 'd') {
				System.out.println("\nDescifrando el texto <<KqnzilwKmaizKwzzmkbw>>\n");
				mostrarResultados();
				break;
			}else {
				System.out.println("Caracter incorrecto, para cifrar ingresa 'c', para descifrar ingresa 'd': ");
			}
		}while(letra != 'c' || letra != 'd');
		sc.close();
	}
}