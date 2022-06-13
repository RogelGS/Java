/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author KSGAMER
 */
public class ControladorEncriptacion {

    private String key = "K3Y3NCR1PT10N";
    private String textoEncriptado;

    public String encriptar(String texto) {
        try {
            MessageDigest mensajeDigerido = MessageDigest.getInstance("MD5");
            byte[] contraseña = mensajeDigerido.digest(key.getBytes("utf-8"));
            byte[] bitsEncriptados = Arrays.copyOf(contraseña, 24);

            SecretKey llaveSecreata = new SecretKeySpec(bitsEncriptados, "DESede");
            Cipher cifrador = Cipher.getInstance("DESede");
            cifrador.init(Cipher.ENCRYPT_MODE, llaveSecreata);

            byte[] textoPlano = texto.getBytes("utf-8");
            byte[] renderizar = cifrador.doFinal(textoPlano);
            byte[] base64 = Base64.encodeBase64(renderizar);
            textoEncriptado = new String(base64);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(ControladorEncriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return textoEncriptado;
    }

    public String desencriptar(String texto) {
        try {
            byte[] mensaje = Base64.decodeBase64(texto.getBytes("utf-8"));
            MessageDigest mensajeDigerido = MessageDigest.getInstance("MD5");
            byte[] contraseñaDigerida = mensajeDigerido.digest(key.getBytes("utf-8"));
            byte[] llaveRenderizada = Arrays.copyOf(contraseñaDigerida, 24);
            SecretKey llave = new SecretKeySpec(llaveRenderizada, "DESede");
            
            Cipher descifrador = Cipher.getInstance("DESede");
            descifrador.init(Cipher.DECRYPT_MODE, llave);
            
            byte[] textoPlano = descifrador.doFinal(mensaje);
            
            textoEncriptado = new String(textoPlano, "UTF-8");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(ControladorEncriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return textoEncriptado;
    }
}
