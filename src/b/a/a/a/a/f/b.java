package b.a.a.a.a.f;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class b extends InputStream {
  private boolean e = false;
  
  private CipherInputStream f = null;
  
  b(a parama, i parami, byte[] paramArrayOfbyte, InputStream paramInputStream) {}
  
  private CipherInputStream a() throws IOException {
    byte[] arrayOfByte3;
    if (this.e)
      return this.f; 
    int j = 0xFF & this.a.d[0];
    int k = j & 0x3F;
    int m = 0xFF & this.a.d[1];
    int n = (j >> 6 & 0x1) + (m & 0xF);
    int i1 = (j >> 7 & 0x1) + (m >> 4);
    if (2 + i1 + n > this.a.d.length)
      throw new IOException("Salt size + IV size too long"); 
    byte[] arrayOfByte1 = new byte[i1];
    System.arraycopy(this.a.d, 2, arrayOfByte1, 0, i1);
    byte[] arrayOfByte2 = new byte[16];
    System.arraycopy(this.a.d, 2 + i1, arrayOfByte2, 0, n);
    if (this.b == null)
      throw new IOException("Cannot read encrypted files without a password"); 
    if (k == 63) {
      arrayOfByte3 = new byte[32];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, i1);
      System.arraycopy(this.b, 0, arrayOfByte3, i1, Math.min(this.b.length, arrayOfByte3.length - i1));
    } else {
      MessageDigest messageDigest;
      try {
        messageDigest = MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        IOException iOException = new IOException("SHA-256 is unsupported by your Java implementation");
        iOException.initCause(noSuchAlgorithmException);
        throw iOException;
      } 
      byte[] arrayOfByte = new byte[8];
      long l;
      for (l = 0L; l < 1L << k; l++) {
        messageDigest.update(arrayOfByte1);
        messageDigest.update(this.b);
        messageDigest.update(arrayOfByte);
        for (byte b1 = 0; b1 < arrayOfByte.length; b1++) {
          arrayOfByte[b1] = (byte)(arrayOfByte[b1] + 1);
          if (arrayOfByte[b1] != 0)
            break; 
        } 
      } 
      arrayOfByte3 = messageDigest.digest();
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte3, "AES");
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      cipher.init(2, secretKeySpec, new IvParameterSpec(arrayOfByte2));
      this.f = new CipherInputStream(this.c, cipher);
      this.e = true;
      return this.f;
    } catch (GeneralSecurityException generalSecurityException) {
      IOException iOException = new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)");
      iOException.initCause(generalSecurityException);
      throw iOException;
    } 
  }
  
  public int read() throws IOException {
    return a().read();
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    return a().read(arrayOfByte, off, len);
  }
  
  public void close() {}
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */