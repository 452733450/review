package com.jack.review.test.test;

import com.jack.review.exception.ServiceException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

/*import com.sun.crypto.provider.SunJCE;*/

/**
 * @author zhangzm
 * @date 2020/10/15
 */
public class DESSecurity {
    private static Logger log = LoggerFactory.getLogger(com.jack.review.test.test.DESSecurity.class);
    private static String strDefaultKey = "simu800";
    private static Cipher encryptCipher = null;
    private static Cipher decryptCipher = null;
    private static Base64 base64;

    public static String byteArr2HexStr(byte[] arrB) {
        int iLen = arrB.length;
        StringBuilder sb = new StringBuilder(iLen * 2);
        byte[] var3 = arrB;
        int var4 = arrB.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            int b = var3[var5];

            int intTmp;
            for (intTmp = b; intTmp < 0; intTmp += 256) {
            }

            if (intTmp < 16) {
                sb.append("0");
            }

            sb.append(Integer.toString(intTmp, 16));
        }

        return sb.toString();
    }

    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];

        for (int i = 0; i < iLen; i += 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }

        return arrOut;
    }

    public DESSecurity() throws Exception {
        this(strDefaultKey);
    }

    public DESSecurity(String strKey) throws Exception {
        /*Security.addProvider(new SunJCE());*/
        Security.addProvider(Security.getProvider("SunJCE"));
        Key key = getKey(strKey.getBytes());
        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(1, key);
        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(2, key);
    }

    public static byte[] encrypt(byte[] arrB) throws Exception {
        return encryptCipher.doFinal(arrB);
    }

    public static String encrypt(String strIn) {
        try {
            return byteArr2HexStr(encrypt(strIn.getBytes()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException("密码加密异常!");
        }
    }

    public static byte[] decrypt(byte[] arrB) throws Exception {
        return decryptCipher.doFinal(arrB);
    }

    public static String decrypt(String strIn) throws Exception {
        try {
            return new String(decrypt(hexStr2ByteArr(strIn)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    private static Key getKey(byte[] arrBTmp) throws Exception {
        byte[] arrB = new byte[8];

        for (int i = 0; i < arrBTmp.length && i < arrB.length; ++i) {
            arrB[i] = arrBTmp[i];
        }

        Key key = new SecretKeySpec(arrB, "DES");
        return key;
    }

    public static String sha1Encrypt(String data) {
        return DigestUtils.sha1Hex(data);
    }

    public static String base64Encode(String text) throws UnsupportedEncodingException {
        return base64.encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64Decode(String text) throws UnsupportedEncodingException {
        return new String(base64.decode(text), StandardCharsets.UTF_8);
    }



    public static String stringToMD5(String plainText) {
        byte[] secretBytes;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("没有这个md5算法！");
        }

        StringBuilder md5code = new StringBuilder((new BigInteger(1, secretBytes)).toString(16));
        int n = 32 - md5code.length();

        for (int i = 0; i < n; ++i) {
            md5code.insert(0, "0");
        }

        return md5code.toString();
    }

    public static String decodeWXInfo(String encryptedData, String iv, String session_key) throws Exception {
        byte[] aesIv = Base64.decodeBase64(iv);
        byte[] aesData = Base64.decodeBase64(encryptedData);
        byte[] aeskey = Base64.decodeBase64(session_key);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES");
        algorithmParameters.init(new IvParameterSpec(aesIv));
        Key sKeySpec = new SecretKeySpec(aeskey, "AES");
        cipher.init(2, sKeySpec, algorithmParameters);
        byte[] result = cipher.doFinal(aesData);
        String base64Str = new String(result);
        log.info("解密字符串：" + base64Str);
        return base64Str;
    }

    public static void main(String[] args) {
        try {
            System.out.println(decrypt("d9607ff288577938037345dcd476741c45d21093e7e3e820"));
            System.out.println(decrypt("5847e5495e95b74a8af38c8c4f6fbcc85bddf3294cdf86bac291e4db2ba9b6ee"));
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    static {
        try {
            /*Security.addProvider(new SunJCE());*/
            Security.addProvider(Security.getProvider("SunJCE"));
            Key key = getKey(strDefaultKey.getBytes());
            encryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(1, key);
            decryptCipher = Cipher.getInstance("DES");
            decryptCipher.init(2, key);
        } catch (Exception var1) {
            var1.printStackTrace();
        }

        base64 = new Base64(0, new byte[]{13, 10}, true);
    }
}
