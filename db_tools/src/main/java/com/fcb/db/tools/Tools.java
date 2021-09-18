package com.fcb.db.tools;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;


/**
 * @author yemenggard
 */
public class Tools {
    public static void main(String[] args) {
       /* if (args.length < 2) {
            System.out.println("-jar db-encryptor.jar hdb_dev M9l5INHEjhqc4B6kslTP");
            return;
        }*/
        String iuserName = "1";
        String ipassword = "1";
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        standardPBEStringEncryptor.setPassword("KJFDSAFJ34882JF");
        String name = standardPBEStringEncryptor.encrypt(iuserName);
        String password = standardPBEStringEncryptor.encrypt(ipassword);
        //System.out.println("encode name:" + name);
        //System.out.println("encode password:" + password);
        //System.out.println("decode:" + standardPBEStringEncryptor.decrypt(name));
        //System.out.println("decode:" + standardPBEStringEncryptor.decrypt(password));
        Decrypt(null,null);
    }

    public static   void Decrypt(String privateKey,String encryptStr){
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 解密的算法，需同加密算法相同
        config.setAlgorithm("PBEWithMD5AndDES");
        //解密的密钥，需同加密密钥相同
        config.setPassword("KJFDSAFJ34882JF");
        standardPBEStringEncryptor.setConfig(config);
        String plainText0 =standardPBEStringEncryptor.decrypt("C6Tg9IdBhYJoWDmHpAH7rq4NirVHTaup");
        String plainText1 =standardPBEStringEncryptor.decrypt("srI8WLWoOxOlUPSHNpZfUjhnPYYpvIYiELKubwa9NK4=");
        System.out.println(plainText1);
        System.out.println(plainText0);

    }
}

