package b.a.a.a.a.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMAInputStream;

class k {
  private static final Map<t, j> a = new l();
  
  static j a(t paramt) {
    return a.get(paramt);
  }
  
  static InputStream a(InputStream paramInputStream, long paramLong, i parami, byte[] paramArrayOfbyte) throws IOException {
    j j = a(t.a(parami.a));
    if (j == null)
      throw new IOException("Unsupported compression method " + Arrays.toString(parami.a)); 
    return j.a(paramInputStream, paramLong, parami, paramArrayOfbyte);
  }
  
  static OutputStream a(OutputStream paramOutputStream, t paramt, Object paramObject) throws IOException {
    j j = a(paramt);
    if (j == null)
      throw new IOException("Unsupported compression method " + paramt); 
    return j.a(paramOutputStream, paramObject);
  }
  
  private static class e extends FilterInputStream {
    private boolean a = true;
    
    private e(InputStream param1InputStream) {
      super(param1InputStream);
    }
    
    public int read() throws IOException {
      int i = super.read();
      if (i == -1 && this.a) {
        this.a = false;
        i = 0;
      } 
      return i;
    }
    
    public int read(byte[] b, int off, int len) throws IOException {
      int i = super.read(b, off, len);
      if (i == -1 && this.a) {
        this.a = false;
        b[off] = 0;
        return 1;
      } 
      return i;
    }
  }
  
  static class b extends j {
    b() {
      super(new Class[] { Number.class });
    }
    
    InputStream a(InputStream param1InputStream, long param1Long, i param1i, byte[] param1ArrayOfbyte) throws IOException {
      return (InputStream)new b.a.a.a.c.a.a(param1InputStream);
    }
    
    OutputStream a(OutputStream param1OutputStream, Object param1Object) throws IOException {
      int i = a(param1Object, 9);
      return (OutputStream)new b.a.a.a.c.a.b(param1OutputStream, i);
    }
  }
  
  static class d extends j {
    d() {
      super(new Class[] { Number.class });
    }
    
    InputStream a(InputStream param1InputStream, long param1Long, i param1i, byte[] param1ArrayOfbyte) throws IOException {
      return new InflaterInputStream(new k.e(param1InputStream, null), new Inflater(true));
    }
    
    OutputStream a(OutputStream param1OutputStream, Object param1Object) {
      int i = a(param1Object, 9);
      return new DeflaterOutputStream(param1OutputStream, new Deflater(i, true));
    }
  }
  
  static class a extends j {
    private final FilterOptions a;
    
    a(FilterOptions param1FilterOptions) {
      super(new Class[0]);
      this.a = param1FilterOptions;
    }
    
    InputStream a(InputStream param1InputStream, long param1Long, i param1i, byte[] param1ArrayOfbyte) throws IOException {
      try {
        return this.a.getInputStream(param1InputStream);
      } catch (AssertionError assertionError) {
        IOException iOException = new IOException("BCJ filter needs XZ for Java > 1.4 - see http://commons.apache.org/proper/commons-compress/limitations.html#7Z");
        iOException.initCause(assertionError);
        throw iOException;
      } 
    }
    
    OutputStream a(OutputStream param1OutputStream, Object param1Object) {
      FinishableOutputStream finishableOutputStream = this.a.getOutputStream((FinishableOutputStream)new FinishableWrapperOutputStream(param1OutputStream));
      return new m(this, (OutputStream)finishableOutputStream);
    }
  }
  
  static class f extends j {
    f() {
      super(new Class[0]);
    }
    
    InputStream a(InputStream param1InputStream, long param1Long, i param1i, byte[] param1ArrayOfbyte) throws IOException {
      byte b = param1i.d[0];
      long l = param1i.d[1];
      for (byte b1 = 1; b1 < 4; b1++)
        l |= (param1i.d[b1 + 1] & 0xFFL) << 8 * b1; 
      if (l > 2147483632L)
        throw new IOException("Dictionary larger than 4GiB maximum size"); 
      return (InputStream)new LZMAInputStream(param1InputStream, param1Long, b, (int)l);
    }
  }
  
  static class c extends j {
    c() {
      super(new Class[0]);
    }
    
    InputStream a(InputStream param1InputStream, long param1Long, i param1i, byte[] param1ArrayOfbyte) throws IOException {
      return param1InputStream;
    }
    
    OutputStream a(OutputStream param1OutputStream, Object param1Object) {
      return param1OutputStream;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */