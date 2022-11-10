import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AES {
	
    public static String encriptar(String clave, String iv, String texto) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec parametroIV = new IvParameterSpec(iv.getBytes("UTF-8"));

            SecretKeySpec claveSecreta = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, claveSecreta, parametroIV);

            byte[] encrypted = cipher.doFinal(texto.getBytes());
            String s = new String(Base64.getEncoder().encode(encrypted));
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String desencriptar(String clave, String iv, String textoCifrado) {
    	String textoDesencriptado = "";
    	try {
    		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    		
        	byte [] bytesClave = clave.getBytes("UTF-8");
        	byte [] bytesIV = iv.getBytes("UTF-8");
        	
        	SecretKey claveSecreta = new SecretKeySpec(bytesClave, "AES");
        	IvParameterSpec parametroIV = new IvParameterSpec(bytesIV);
        	
        	cipher.init(Cipher.DECRYPT_MODE, claveSecreta, parametroIV);
        	
        	byte [] texto = Base64.getDecoder().decode(textoCifrado);
        	
        	textoDesencriptado = new String(cipher.doFinal(texto));
    	}catch (Exception E){
    		System.err.println("ERROR: " + E.getMessage());
    	}
		return textoDesencriptado;
    }

    public static void main(String[] args) {
        String clave = "SeguridadInforma"; 
        String iv = "SeguridadInforma"; 
        String textoAEncriptar = "AESFuncionando";
        String textoADesencriptar = encriptar(clave, iv, textoAEncriptar);

        System.out.println(encriptar(clave, iv, textoAEncriptar));
        System.out.println(desencriptar(clave, iv, textoADesencriptar));
    }
}
