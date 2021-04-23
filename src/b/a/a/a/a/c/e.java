package b.a.a.a.a.c;

class e {
  static long a(long paramLong) {
    return paramLong & 0xF000L;
  }
  
  static long a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte.length % 2 != 0)
      throw new UnsupportedOperationException(); 
    long l = 0L;
    byte b = 0;
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramArrayOfbyte.length);
    if (!paramBoolean) {
      byte b1 = 0;
      for (b = 0; b < arrayOfByte.length; b++) {
        b1 = arrayOfByte[b];
        arrayOfByte[b++] = arrayOfByte[b];
        arrayOfByte[b] = b1;
      } 
    } 
    l = (arrayOfByte[0] & 0xFF);
    for (b = 1; b < arrayOfByte.length; b++) {
      l <<= 8L;
      l |= (arrayOfByte[b] & 0xFF);
    } 
    return l;
  }
  
  static byte[] a(long paramLong, int paramInt, boolean paramBoolean) {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    long l = 0L;
    if (paramInt % 2 != 0 || paramInt < 2)
      throw new UnsupportedOperationException(); 
    l = paramLong;
    for (i = paramInt - 1; i >= 0; i--) {
      arrayOfByte[i] = (byte)(int)(l & 0xFFL);
      l >>= 8L;
    } 
    if (!paramBoolean) {
      byte b = 0;
      for (i = 0; i < paramInt; i++) {
        b = arrayOfByte[i];
        arrayOfByte[i++] = arrayOfByte[i];
        arrayOfByte[i] = b;
      } 
    } 
    return arrayOfByte;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/c/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */