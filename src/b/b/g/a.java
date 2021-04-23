package b.b.g;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class a {
  public static final int a = 0;
  
  public static final int b = 1;
  
  public static final int c = 0;
  
  public static final int d = 2;
  
  public static final int e = 4;
  
  public static final int f = 8;
  
  public static final int g = 16;
  
  public static final int h = 32;
  
  private static final int j = 76;
  
  private static final byte k = 61;
  
  private static final byte l = 10;
  
  private static final String m = "US-ASCII";
  
  private static final byte n = -5;
  
  private static final byte o = -1;
  
  private static final byte[] p;
  
  private static final byte[] q;
  
  private static final byte[] r;
  
  private static final byte[] s;
  
  private static final byte[] t;
  
  private static final byte[] u;
  
  private static final byte[] b(int paramInt) {
    return ((paramInt & 0x10) == 16) ? r : (((paramInt & 0x20) == 32) ? t : p);
  }
  
  private static final byte[] c(int paramInt) {
    return ((paramInt & 0x10) == 16) ? s : (((paramInt & 0x20) == 32) ? u : q);
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
    b(paramArrayOfbyte2, 0, paramInt1, paramArrayOfbyte1, 0, paramInt2);
    return paramArrayOfbyte1;
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
    byte[] arrayOfByte = b(paramInt4);
    int i = ((paramInt2 > 0) ? (paramArrayOfbyte1[paramInt1] << 24 >>> 8) : 0) | ((paramInt2 > 1) ? (paramArrayOfbyte1[paramInt1 + 1] << 24 >>> 16) : 0) | ((paramInt2 > 2) ? (paramArrayOfbyte1[paramInt1 + 2] << 24 >>> 24) : 0);
    switch (paramInt2) {
      case 3:
        paramArrayOfbyte2[paramInt3] = arrayOfByte[i >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[i >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = arrayOfByte[i >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = arrayOfByte[i & 0x3F];
        return paramArrayOfbyte2;
      case 2:
        paramArrayOfbyte2[paramInt3] = arrayOfByte[i >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[i >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = arrayOfByte[i >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = 61;
        return paramArrayOfbyte2;
      case 1:
        paramArrayOfbyte2[paramInt3] = arrayOfByte[i >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[i >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = 61;
        paramArrayOfbyte2[paramInt3 + 3] = 61;
        return paramArrayOfbyte2;
    } 
    return paramArrayOfbyte2;
  }
  
  public static void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2) {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (paramByteBuffer1.hasRemaining()) {
      int i = Math.min(3, paramByteBuffer1.remaining());
      paramByteBuffer1.get(arrayOfByte1, 0, i);
      b(arrayOfByte2, arrayOfByte1, i, 0);
      paramByteBuffer2.put(arrayOfByte2);
    } 
  }
  
  public static void a(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer) {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (paramByteBuffer.hasRemaining()) {
      int i = Math.min(3, paramByteBuffer.remaining());
      paramByteBuffer.get(arrayOfByte1, 0, i);
      b(arrayOfByte2, arrayOfByte1, i, 0);
      for (byte b = 0; b < 4; b++)
        paramCharBuffer.put((char)(arrayOfByte2[b] & 0xFF)); 
    } 
  }
  
  public static String a(Serializable paramSerializable) throws IOException {
    return a(paramSerializable, 0);
  }
  
  public static String a(Serializable paramSerializable, int paramInt) throws IOException {
    if (paramSerializable == null)
      throw new NullPointerException("Cannot serialize a null object."); 
    ByteArrayOutputStream byteArrayOutputStream = null;
    b b = null;
    GZIPOutputStream gZIPOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    try {
      byteArrayOutputStream = new ByteArrayOutputStream();
      b = new b(byteArrayOutputStream, 0x1 | paramInt);
      if ((paramInt & 0x2) != 0) {
        gZIPOutputStream = new GZIPOutputStream(b);
        objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
      } else {
        objectOutputStream = new ObjectOutputStream(b);
      } 
      objectOutputStream.writeObject(paramSerializable);
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        objectOutputStream.close();
      } catch (Exception exception) {}
      try {
        gZIPOutputStream.close();
      } catch (Exception exception) {}
      try {
        b.close();
      } catch (Exception exception) {}
      try {
        byteArrayOutputStream.close();
      } catch (Exception exception) {}
    } 
    try {
      return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return new String(byteArrayOutputStream.toByteArray());
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    String str = null;
    try {
      str = a(paramArrayOfbyte, 0, paramArrayOfbyte.length, 0);
    } catch (IOException iOException) {
      if (!i)
        throw new AssertionError(iOException.getMessage()); 
    } 
    if (!i && str == null)
      throw new AssertionError(); 
    return str;
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt) throws IOException {
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    String str = null;
    try {
      str = a(paramArrayOfbyte, paramInt1, paramInt2, 0);
    } catch (IOException iOException) {
      if (!i)
        throw new AssertionError(iOException.getMessage()); 
    } 
    if (!i && str == null)
      throw new AssertionError(); 
    return str;
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) throws IOException {
    byte[] arrayOfByte = b(paramArrayOfbyte, paramInt1, paramInt2, paramInt3);
    try {
      return new String(arrayOfByte, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return new String(arrayOfByte);
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = null;
    try {
      arrayOfByte = b(paramArrayOfbyte, 0, paramArrayOfbyte.length, 0);
    } catch (IOException iOException) {
      if (!i)
        throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + iOException.getMessage()); 
    } 
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) throws IOException {
    if (paramArrayOfbyte == null)
      throw new NullPointerException("Cannot serialize a null array."); 
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Cannot have negative offset: " + paramInt1); 
    if (paramInt2 < 0)
      throw new IllegalArgumentException("Cannot have length offset: " + paramInt2); 
    if (paramInt1 + paramInt2 > paramArrayOfbyte.length)
      throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfbyte.length) })); 
    if ((paramInt3 & 0x2) != 0) {
      ByteArrayOutputStream byteArrayOutputStream = null;
      GZIPOutputStream gZIPOutputStream = null;
      b b = null;
      try {
        byteArrayOutputStream = new ByteArrayOutputStream();
        b = new b(byteArrayOutputStream, 0x1 | paramInt3);
        gZIPOutputStream = new GZIPOutputStream(b);
        gZIPOutputStream.write(paramArrayOfbyte, paramInt1, paramInt2);
        gZIPOutputStream.close();
      } catch (IOException iOException) {
        throw iOException;
      } finally {
        try {
          gZIPOutputStream.close();
        } catch (Exception exception) {}
        try {
          b.close();
        } catch (Exception exception) {}
        try {
          byteArrayOutputStream.close();
        } catch (Exception exception) {}
      } 
      return byteArrayOutputStream.toByteArray();
    } 
    boolean bool = ((paramInt3 & 0x8) != 0) ? true : false;
    int i = paramInt2 / 3 * 4 + ((paramInt2 % 3 > 0) ? 4 : 0);
    if (bool)
      i += i / 76; 
    byte[] arrayOfByte = new byte[i];
    byte b1 = 0;
    byte b2 = 0;
    int j = paramInt2 - 2;
    byte b3 = 0;
    while (b1 < j) {
      b(paramArrayOfbyte, b1 + paramInt1, 3, arrayOfByte, b2, paramInt3);
      b3 += true;
      if (bool && b3 >= 76) {
        arrayOfByte[b2 + 4] = 10;
        b2++;
        b3 = 0;
      } 
      b1 += 3;
      b2 += 4;
    } 
    if (b1 < paramInt2) {
      b(paramArrayOfbyte, b1 + paramInt1, paramInt2 - b1, arrayOfByte, b2, paramInt3);
      b2 += 4;
    } 
    if (b2 <= arrayOfByte.length - 1) {
      byte[] arrayOfByte1 = new byte[b2];
      System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, b2);
      return arrayOfByte1;
    } 
    return arrayOfByte;
  }
  
  private static int b(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3) {
    if (paramArrayOfbyte1 == null)
      throw new NullPointerException("Source array was null."); 
    if (paramArrayOfbyte2 == null)
      throw new NullPointerException("Destination array was null."); 
    if (paramInt1 < 0 || paramInt1 + 3 >= paramArrayOfbyte1.length)
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte1.length), Integer.valueOf(paramInt1) })); 
    if (paramInt2 < 0 || paramInt2 + 2 >= paramArrayOfbyte2.length)
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte2.length), Integer.valueOf(paramInt2) })); 
    byte[] arrayOfByte = c(paramInt3);
    if (paramArrayOfbyte1[paramInt1 + 2] == 61) {
      int j = (arrayOfByte[paramArrayOfbyte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfbyte1[paramInt1 + 1]] & 0xFF) << 12;
      paramArrayOfbyte2[paramInt2] = (byte)(j >>> 16);
      return 1;
    } 
    if (paramArrayOfbyte1[paramInt1 + 3] == 61) {
      int j = (arrayOfByte[paramArrayOfbyte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfbyte1[paramInt1 + 1]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfbyte1[paramInt1 + 2]] & 0xFF) << 6;
      paramArrayOfbyte2[paramInt2] = (byte)(j >>> 16);
      paramArrayOfbyte2[paramInt2 + 1] = (byte)(j >>> 8);
      return 2;
    } 
    int i = (arrayOfByte[paramArrayOfbyte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfbyte1[paramInt1 + 1]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfbyte1[paramInt1 + 2]] & 0xFF) << 6 | arrayOfByte[paramArrayOfbyte1[paramInt1 + 3]] & 0xFF;
    paramArrayOfbyte2[paramInt2] = (byte)(i >> 16);
    paramArrayOfbyte2[paramInt2 + 1] = (byte)(i >> 8);
    paramArrayOfbyte2[paramInt2 + 2] = (byte)i;
    return 3;
  }
  
  public static byte[] c(byte[] paramArrayOfbyte) throws IOException {
    null = null;
    return c(paramArrayOfbyte, 0, paramArrayOfbyte.length, 0);
  }
  
  public static byte[] c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) throws IOException {
    if (paramArrayOfbyte == null)
      throw new NullPointerException("Cannot decode null source array."); 
    if (paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length)
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })); 
    if (paramInt2 == 0)
      return new byte[0]; 
    if (paramInt2 < 4)
      throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + paramInt2); 
    byte[] arrayOfByte1 = c(paramInt3);
    int i = paramInt2 * 3 / 4;
    byte[] arrayOfByte2 = new byte[i];
    int j = 0;
    byte[] arrayOfByte3 = new byte[4];
    byte b = 0;
    int k = 0;
    byte b1 = 0;
    for (k = paramInt1; k < paramInt1 + paramInt2; k++) {
      b1 = arrayOfByte1[paramArrayOfbyte[k] & 0xFF];
      if (b1 >= -5) {
        if (b1 >= -1) {
          arrayOfByte3[b++] = paramArrayOfbyte[k];
          if (b > 3) {
            j += b(arrayOfByte3, 0, arrayOfByte2, j, paramInt3);
            b = 0;
            if (paramArrayOfbyte[k] == 61)
              break; 
          } 
        } 
      } else {
        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[] { Integer.valueOf(paramArrayOfbyte[k] & 0xFF), Integer.valueOf(k) }));
      } 
    } 
    byte[] arrayOfByte4 = new byte[j];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, j);
    return arrayOfByte4;
  }
  
  public static byte[] a(String paramString) throws IOException {
    return a(paramString, 0);
  }
  
  public static byte[] a(String paramString, int paramInt) throws IOException {
    if (paramString == null)
      throw new NullPointerException("Input string was null."); 
    try {
      arrayOfByte = paramString.getBytes("US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      arrayOfByte = paramString.getBytes();
    } 
    byte[] arrayOfByte = c(arrayOfByte, 0, arrayOfByte.length, paramInt);
    boolean bool = ((paramInt & 0x4) != 0) ? true : false;
    if (arrayOfByte != null && arrayOfByte.length >= 4 && !bool) {
      int i = arrayOfByte[0] & 0xFF | arrayOfByte[1] << 8 & 0xFF00;
      if (35615 == i) {
        ByteArrayInputStream byteArrayInputStream = null;
        GZIPInputStream gZIPInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] arrayOfByte1 = new byte[2048];
        int j = 0;
        try {
          byteArrayOutputStream = new ByteArrayOutputStream();
          byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
          gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
          while ((j = gZIPInputStream.read(arrayOfByte1)) >= 0)
            byteArrayOutputStream.write(arrayOfByte1, 0, j); 
          arrayOfByte = byteArrayOutputStream.toByteArray();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } finally {
          try {
            byteArrayOutputStream.close();
          } catch (Exception exception) {}
          try {
            gZIPInputStream.close();
          } catch (Exception exception) {}
          try {
            byteArrayInputStream.close();
          } catch (Exception exception) {}
        } 
      } 
    } 
    return arrayOfByte;
  }
  
  public static Object b(String paramString) throws IOException, ClassNotFoundException {
    return a(paramString, 0, (ClassLoader)null);
  }
  
  public static Object a(String paramString, int paramInt, ClassLoader paramClassLoader) throws IOException, ClassNotFoundException {
    byte[] arrayOfByte = a(paramString, paramInt);
    ByteArrayInputStream byteArrayInputStream = null;
    ObjectInputStream objectInputStream = null;
    Object object = null;
    try {
      byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
      if (paramClassLoader == null) {
        objectInputStream = new ObjectInputStream(byteArrayInputStream);
      } else {
        objectInputStream = new b(byteArrayInputStream, paramClassLoader);
      } 
      object = objectInputStream.readObject();
    } catch (IOException iOException) {
      throw iOException;
    } catch (ClassNotFoundException classNotFoundException) {
      throw classNotFoundException;
    } finally {
      try {
        byteArrayInputStream.close();
      } catch (Exception exception) {}
      try {
        objectInputStream.close();
      } catch (Exception exception) {}
    } 
    return object;
  }
  
  public static void a(byte[] paramArrayOfbyte, String paramString) throws IOException {
    if (paramArrayOfbyte == null)
      throw new NullPointerException("Data to encode was null."); 
    b b = null;
    try {
      b = new b(new FileOutputStream(paramString), 1);
      b.write(paramArrayOfbyte);
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        b.close();
      } catch (Exception exception) {}
    } 
  }
  
  public static void a(String paramString1, String paramString2) throws IOException {
    b b = null;
    try {
      b = new b(new FileOutputStream(paramString2), 0);
      b.write(paramString1.getBytes("US-ASCII"));
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        b.close();
      } catch (Exception exception) {}
    } 
  }
  
  public static byte[] c(String paramString) throws IOException {
    byte[] arrayOfByte = null;
    a a1 = null;
    try {
      File file = new File(paramString);
      byte[] arrayOfByte1 = null;
      int i = 0;
      int j = 0;
      if (file.length() > 2147483647L)
        throw new IOException("File is too big for this convenience method (" + file.length() + " bytes)."); 
      arrayOfByte1 = new byte[(int)file.length()];
      a1 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
      while ((j = a1.read(arrayOfByte1, i, 4096)) >= 0)
        i += j; 
      arrayOfByte = new byte[i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte, 0, i);
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        a1.close();
      } catch (Exception exception) {}
    } 
    return arrayOfByte;
  }
  
  public static String d(String paramString) throws IOException {
    String str = null;
    a a1 = null;
    try {
      File file = new File(paramString);
      byte[] arrayOfByte = new byte[Math.max((int)(file.length() * 1.4D + 1.0D), 40)];
      int i = 0;
      int j = 0;
      a1 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
      while ((j = a1.read(arrayOfByte, i, 4096)) >= 0)
        i += j; 
      str = new String(arrayOfByte, 0, i, "US-ASCII");
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        a1.close();
      } catch (Exception exception) {}
    } 
    return str;
  }
  
  public static void b(String paramString1, String paramString2) throws IOException {
    String str = d(paramString1);
    BufferedOutputStream bufferedOutputStream = null;
    try {
      bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString2));
      bufferedOutputStream.write(str.getBytes("US-ASCII"));
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        bufferedOutputStream.close();
      } catch (Exception exception) {}
    } 
  }
  
  public static void c(String paramString1, String paramString2) throws IOException {
    byte[] arrayOfByte = c(paramString1);
    BufferedOutputStream bufferedOutputStream = null;
    try {
      bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString2));
      bufferedOutputStream.write(arrayOfByte);
    } catch (IOException iOException) {
      throw iOException;
    } finally {
      try {
        bufferedOutputStream.close();
      } catch (Exception exception) {}
    } 
  }
  
  static {
    p = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47 };
    q = new byte[] { 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9 };
    r = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95 };
    s = new byte[] { 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9 };
    t = new byte[] { 
        45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
        57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
        74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
        84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
        99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
        109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
        119, 120, 121, 122 };
    u = new byte[] { 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
        3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
        -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
        36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
        51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
        61, 62, 63, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9 };
  }
  
  public static class b extends FilterOutputStream {
    private boolean a;
    
    private int b;
    
    private byte[] c;
    
    private int d;
    
    private int e;
    
    private boolean f;
    
    private byte[] g;
    
    private boolean h;
    
    private int i;
    
    private byte[] j;
    
    public b(OutputStream param1OutputStream) {
      this(param1OutputStream, 1);
    }
    
    public b(OutputStream param1OutputStream, int param1Int) {
      super(param1OutputStream);
      this.f = ((param1Int & 0x8) != 0);
      this.a = ((param1Int & 0x1) != 0);
      this.d = this.a ? 3 : 4;
      this.c = new byte[this.d];
      this.b = 0;
      this.e = 0;
      this.h = false;
      this.g = new byte[4];
      this.i = param1Int;
      this.j = a.a(param1Int);
    }
    
    public void write(int theByte) throws IOException {
      if (this.h) {
        this.out.write(theByte);
        return;
      } 
      if (this.a) {
        this.c[this.b++] = (byte)theByte;
        if (this.b >= this.d) {
          this.out.write(a.a(this.g, this.c, this.d, this.i));
          this.e += 4;
          if (this.f && this.e >= 76) {
            this.out.write(10);
            this.e = 0;
          } 
          this.b = 0;
        } 
      } else if (this.j[theByte & 0x7F] > -5) {
        this.c[this.b++] = (byte)theByte;
        if (this.b >= this.d) {
          int i = a.a(this.c, 0, this.g, 0, this.i);
          this.out.write(this.g, 0, i);
          this.b = 0;
        } 
      } else if (this.j[theByte & 0x7F] != -5) {
        throw new IOException("Invalid character in Base64 data.");
      } 
    }
    
    public void write(byte[] theBytes, int off, int len) throws IOException {
      if (this.h) {
        this.out.write(theBytes, off, len);
        return;
      } 
      for (byte b1 = 0; b1 < len; b1++)
        write(theBytes[off + b1]); 
    }
    
    public void a() throws IOException {
      if (this.b > 0)
        if (this.a) {
          this.out.write(a.a(this.g, this.c, this.b, this.i));
          this.b = 0;
        } else {
          throw new IOException("Base64 input not properly padded.");
        }  
    }
    
    public void close() throws IOException {
      a();
      super.close();
      this.c = null;
      this.out = null;
    }
    
    public void b() throws IOException {
      a();
      this.h = true;
    }
    
    public void c() {
      this.h = false;
    }
  }
  
  public static class a extends FilterInputStream {
    private boolean a;
    
    private int b;
    
    private byte[] c;
    
    private int d;
    
    private int e;
    
    private int f;
    
    private boolean g;
    
    private int h;
    
    private byte[] i;
    
    public a(InputStream param1InputStream) {
      this(param1InputStream, 0);
    }
    
    public a(InputStream param1InputStream, int param1Int) {
      super(param1InputStream);
      this.h = param1Int;
      this.g = ((param1Int & 0x8) > 0);
      this.a = ((param1Int & 0x1) > 0);
      this.d = this.a ? 4 : 3;
      this.c = new byte[this.d];
      this.b = -1;
      this.f = 0;
      this.i = a.a(param1Int);
    }
    
    public int read() throws IOException {
      if (this.b < 0)
        if (this.a) {
          byte[] arrayOfByte = new byte[3];
          byte b1 = 0;
          byte b2 = 0;
          while (b2 < 3) {
            int i = this.in.read();
            if (i >= 0) {
              arrayOfByte[b2] = (byte)i;
              b1++;
              b2++;
            } 
          } 
          if (b1 > 0) {
            a.a(arrayOfByte, 0, b1, this.c, 0, this.h);
            this.b = 0;
            this.e = 4;
          } else {
            return -1;
          } 
        } else {
          byte[] arrayOfByte = new byte[4];
          byte b = 0;
          for (b = 0; b < 4; b++) {
            int i = 0;
            do {
              i = this.in.read();
            } while (i >= 0 && this.i[i & 0x7F] <= -5);
            if (i < 0)
              break; 
            arrayOfByte[b] = (byte)i;
          } 
          if (b == 4) {
            this.e = a.a(arrayOfByte, 0, this.c, 0, this.h);
            this.b = 0;
          } else {
            if (b == 0)
              return -1; 
            throw new IOException("Improperly padded Base64 input.");
          } 
        }  
      if (this.b >= 0) {
        if (this.b >= this.e)
          return -1; 
        if (this.a && this.g && this.f >= 76) {
          this.f = 0;
          return 10;
        } 
        this.f++;
        byte b = this.c[this.b++];
        if (this.b >= this.d)
          this.b = -1; 
        return b & 0xFF;
      } 
      throw new IOException("Error in Base64 code reading stream.");
    }
    
    public int read(byte[] dest, int off, int len) throws IOException {
      byte b;
      for (b = 0; b < len; b++) {
        int i = read();
        if (i >= 0) {
          dest[off + b] = (byte)i;
        } else {
          if (b == 0)
            return -1; 
          break;
        } 
      } 
      return b;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/g/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */