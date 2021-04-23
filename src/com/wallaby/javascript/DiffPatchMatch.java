package com.wallaby.javascript;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiffPatchMatch {
  public float a = 1.0F;
  
  public short b = 4;
  
  public float c = 0.5F;
  
  public int d = 1000;
  
  public float e = 0.5F;
  
  public short f = 4;
  
  private short h = 32;
  
  private Pattern i = Pattern.compile("\\n\\r?\\n\\Z", 32);
  
  private Pattern j = Pattern.compile("\\A\\r?\\n\\r?\\n", 32);
  
  private static String d(String paramString) {
    return paramString.replace("%21", "!").replace("%7E", "~").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%3B", ";").replace("%2F", "/").replace("%3F", "?").replace("%3A", ":").replace("%40", "@").replace("%26", "&").replace("%3D", "=").replace("%2B", "+").replace("%24", "$").replace("%2C", ",").replace("%23", "#");
  }
  
  public LinkedList<a> a(String paramString1, String paramString2) {
    return a(paramString1, paramString2, true);
  }
  
  public LinkedList<a> a(String paramString1, String paramString2, boolean paramBoolean) {
    long l;
    if (this.a <= 0.0F) {
      l = Long.MAX_VALUE;
    } else {
      l = System.currentTimeMillis() + (long)(this.a * 1000.0F);
    } 
    return a(paramString1, paramString2, paramBoolean, l);
  }
  
  private LinkedList<a> a(String paramString1, String paramString2, boolean paramBoolean, long paramLong) {
    if (paramString1 == null || paramString2 == null)
      throw new IllegalArgumentException("Null inputs. (diff_main)"); 
    if (paramString1.equals(paramString2)) {
      LinkedList<a> linkedList1 = new LinkedList();
      if (paramString1.length() != 0)
        linkedList1.add(new a(Operation.EQUAL, paramString1)); 
      return linkedList1;
    } 
    int i = d(paramString1, paramString2);
    String str1 = paramString1.substring(0, i);
    paramString1 = paramString1.substring(i);
    paramString2 = paramString2.substring(i);
    i = e(paramString1, paramString2);
    String str2 = paramString1.substring(paramString1.length() - i);
    paramString1 = paramString1.substring(0, paramString1.length() - i);
    paramString2 = paramString2.substring(0, paramString2.length() - i);
    LinkedList<a> linkedList = b(paramString1, paramString2, paramBoolean, paramLong);
    if (str1.length() != 0)
      linkedList.addFirst(new a(Operation.EQUAL, str1)); 
    if (str2.length() != 0)
      linkedList.addLast(new a(Operation.EQUAL, str2)); 
    d(linkedList);
    return linkedList;
  }
  
  private LinkedList<a> b(String paramString1, String paramString2, boolean paramBoolean, long paramLong) {
    LinkedList<a> linkedList = new LinkedList();
    if (paramString1.length() == 0) {
      linkedList.add(new a(Operation.INSERT, paramString2));
      return linkedList;
    } 
    if (paramString2.length() == 0) {
      linkedList.add(new a(Operation.DELETE, paramString1));
      return linkedList;
    } 
    String str1 = (paramString1.length() > paramString2.length()) ? paramString1 : paramString2;
    String str2 = (paramString1.length() > paramString2.length()) ? paramString2 : paramString1;
    int i = str1.indexOf(str2);
    if (i != -1) {
      Operation operation = (paramString1.length() > paramString2.length()) ? Operation.DELETE : Operation.INSERT;
      linkedList.add(new a(operation, str1.substring(0, i)));
      linkedList.add(new a(Operation.EQUAL, str2));
      linkedList.add(new a(operation, str1.substring(i + str2.length())));
      return linkedList;
    } 
    if (str2.length() == 1) {
      linkedList.add(new a(Operation.DELETE, paramString1));
      linkedList.add(new a(Operation.INSERT, paramString2));
      return linkedList;
    } 
    String[] arrayOfString = g(paramString1, paramString2);
    if (arrayOfString != null) {
      String str3 = arrayOfString[0];
      String str4 = arrayOfString[1];
      String str5 = arrayOfString[2];
      String str6 = arrayOfString[3];
      String str7 = arrayOfString[4];
      LinkedList<a> linkedList1 = a(str3, str5, paramBoolean, paramLong);
      LinkedList<a> linkedList2 = a(str4, str6, paramBoolean, paramLong);
      linkedList = linkedList1;
      linkedList.add(new a(Operation.EQUAL, str7));
      linkedList.addAll(linkedList2);
      return linkedList;
    } 
    return (paramBoolean && paramString1.length() > 100 && paramString2.length() > 100) ? b(paramString1, paramString2, paramLong) : a(paramString1, paramString2, paramLong);
  }
  
  private LinkedList<a> b(String paramString1, String paramString2, long paramLong) {
    b b = b(paramString1, paramString2);
    paramString1 = b.a;
    paramString2 = b.b;
    List<String> list = b.c;
    LinkedList<a> linkedList = a(paramString1, paramString2, false, paramLong);
    a(linkedList, list);
    a(linkedList);
    linkedList.add(new a(Operation.EQUAL, ""));
    byte b1 = 0;
    byte b2 = 0;
    String str1 = "";
    String str2 = "";
    ListIterator<a> listIterator = linkedList.listIterator();
    for (a a = listIterator.next(); a != null; a = listIterator.hasNext() ? listIterator.next() : null) {
      switch (a.a[a.a.ordinal()]) {
        case 1:
          b2++;
          str2 = str2 + a.b;
          break;
        case 2:
          b1++;
          str1 = str1 + a.b;
          break;
        case 3:
          if (b1 >= 1 && b2 >= 1) {
            listIterator.previous();
            for (byte b3 = 0; b3 < b1 + b2; b3++) {
              listIterator.previous();
              listIterator.remove();
            } 
            for (a a1 : a(str1, str2, false, paramLong))
              listIterator.add(a1); 
          } 
          b2 = 0;
          b1 = 0;
          str1 = "";
          str2 = "";
          break;
      } 
    } 
    linkedList.removeLast();
    return linkedList;
  }
  
  protected LinkedList<a> a(String paramString1, String paramString2, long paramLong) {
    int i = paramString1.length();
    int j = paramString2.length();
    int k = (i + j + 1) / 2;
    int m = k;
    int n = 2 * k;
    int[] arrayOfInt1 = new int[n];
    int[] arrayOfInt2 = new int[n];
    int i1;
    for (i1 = 0; i1 < n; i1++) {
      arrayOfInt1[i1] = -1;
      arrayOfInt2[i1] = -1;
    } 
    arrayOfInt1[m + 1] = 0;
    arrayOfInt2[m + 1] = 0;
    i1 = i - j;
    boolean bool = (i1 % 2 != 0) ? true : false;
    byte b1 = 0;
    byte b2 = 0;
    byte b3 = 0;
    byte b4 = 0;
    for (byte b5 = 0; b5 < k && System.currentTimeMillis() <= paramLong; b5++) {
      int i2;
      for (i2 = -b5 + b1; i2 <= b5 - b2; i2 += 2) {
        int i4;
        int i3 = m + i2;
        if (i2 == -b5 || (i2 != b5 && arrayOfInt1[i3 - 1] < arrayOfInt1[i3 + 1])) {
          i4 = arrayOfInt1[i3 + 1];
        } else {
          i4 = arrayOfInt1[i3 - 1] + 1;
        } 
        int i5;
        for (i5 = i4 - i2; i4 < i && i5 < j && paramString1.charAt(i4) == paramString2.charAt(i5); i5++)
          i4++; 
        arrayOfInt1[i3] = i4;
        if (i4 > i) {
          b2 += 2;
        } else if (i5 > j) {
          b1 += 2;
        } else if (bool) {
          int i6 = m + i1 - i2;
          if (i6 >= 0 && i6 < n && arrayOfInt2[i6] != -1) {
            int i7 = i - arrayOfInt2[i6];
            if (i4 >= i7)
              return a(paramString1, paramString2, i4, i5, paramLong); 
          } 
        } 
      } 
      for (i2 = -b5 + b3; i2 <= b5 - b4; i2 += 2) {
        int i4;
        int i3 = m + i2;
        if (i2 == -b5 || (i2 != b5 && arrayOfInt2[i3 - 1] < arrayOfInt2[i3 + 1])) {
          i4 = arrayOfInt2[i3 + 1];
        } else {
          i4 = arrayOfInt2[i3 - 1] + 1;
        } 
        int i5;
        for (i5 = i4 - i2; i4 < i && i5 < j && paramString1.charAt(i - i4 - 1) == paramString2.charAt(j - i5 - 1); i5++)
          i4++; 
        arrayOfInt2[i3] = i4;
        if (i4 > i) {
          b4 += 2;
        } else if (i5 > j) {
          b3 += 2;
        } else if (!bool) {
          int i6 = m + i1 - i2;
          if (i6 >= 0 && i6 < n && arrayOfInt1[i6] != -1) {
            int i7 = arrayOfInt1[i6];
            int i8 = m + i7 - i6;
            i4 = i - i4;
            if (i7 >= i4)
              return a(paramString1, paramString2, i7, i8, paramLong); 
          } 
        } 
      } 
    } 
    LinkedList<a> linkedList = new LinkedList();
    linkedList.add(new a(Operation.DELETE, paramString1));
    linkedList.add(new a(Operation.INSERT, paramString2));
    return linkedList;
  }
  
  private LinkedList<a> a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong) {
    String str1 = paramString1.substring(0, paramInt1);
    String str2 = paramString2.substring(0, paramInt2);
    String str3 = paramString1.substring(paramInt1);
    String str4 = paramString2.substring(paramInt2);
    LinkedList<a> linkedList1 = a(str1, str2, false, paramLong);
    LinkedList<a> linkedList2 = a(str3, str4, false, paramLong);
    linkedList1.addAll(linkedList2);
    return linkedList1;
  }
  
  protected b b(String paramString1, String paramString2) {
    ArrayList<String> arrayList = new ArrayList();
    HashMap<Object, Object> hashMap = new HashMap<>();
    arrayList.add("");
    String str1 = a(paramString1, arrayList, (Map)hashMap);
    String str2 = a(paramString2, arrayList, (Map)hashMap);
    return new b(str1, str2, arrayList);
  }
  
  private String a(String paramString, List<String> paramList, Map<String, Integer> paramMap) {
    int i = 0;
    int j = -1;
    StringBuilder stringBuilder = new StringBuilder();
    while (j < paramString.length() - 1) {
      j = paramString.indexOf('\n', i);
      if (j == -1)
        j = paramString.length() - 1; 
      String str = paramString.substring(i, j + 1);
      i = j + 1;
      if (paramMap.containsKey(str)) {
        stringBuilder.append((char)((Integer)paramMap.get(str)).intValue());
        continue;
      } 
      paramList.add(str);
      paramMap.put(str, Integer.valueOf(paramList.size() - 1));
      stringBuilder.append((char)(paramList.size() - 1));
    } 
    return stringBuilder.toString();
  }
  
  protected void a(LinkedList<a> paramLinkedList, List<String> paramList) {
    for (a a : paramLinkedList) {
      StringBuilder stringBuilder = new StringBuilder();
      for (byte b = 0; b < a.b.length(); b++)
        stringBuilder.append(paramList.get(a.b.charAt(b))); 
      a.b = stringBuilder.toString();
    } 
  }
  
  public LinkedList<a> c(String paramString1, String paramString2) {
    b b = j(paramString1, paramString2);
    String str1 = b.a;
    String str2 = b.b;
    List<String> list = b.c;
    LinkedList<a> linkedList = a(str1, str2, false);
    a(linkedList, list);
    return linkedList;
  }
  
  private b j(String paramString1, String paramString2) {
    ArrayList<String> arrayList = new ArrayList();
    HashMap<Object, Object> hashMap = new HashMap<>();
    arrayList.add("");
    String str1 = b(paramString1, arrayList, (Map)hashMap);
    String str2 = b(paramString2, arrayList, (Map)hashMap);
    return new b(str1, str2, arrayList);
  }
  
  private String b(String paramString, List<String> paramList, Map<String, Integer> paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : paramString.split("\\b")) {
      if (paramMap.containsKey(str)) {
        stringBuilder.append((char)((Integer)paramMap.get(str)).intValue());
      } else {
        paramList.add(str);
        paramMap.put(str, Integer.valueOf(paramList.size() - 1));
        stringBuilder.append((char)(paramList.size() - 1));
      } 
    } 
    return stringBuilder.toString();
  }
  
  public int d(String paramString1, String paramString2) {
    int i = Math.min(paramString1.length(), paramString2.length());
    for (byte b = 0; b < i; b++) {
      if (paramString1.charAt(b) != paramString2.charAt(b))
        return b; 
    } 
    return i;
  }
  
  public int e(String paramString1, String paramString2) {
    int i = paramString1.length();
    int j = paramString2.length();
    int k = Math.min(i, j);
    for (byte b = 1; b <= k; b++) {
      if (paramString1.charAt(i - b) != paramString2.charAt(j - b))
        return b - 1; 
    } 
    return k;
  }
  
  protected int f(String paramString1, String paramString2) {
    int i = paramString1.length();
    int j = paramString2.length();
    if (i == 0 || j == 0)
      return 0; 
    if (i > j) {
      paramString1 = paramString1.substring(i - j);
    } else if (i < j) {
      paramString2 = paramString2.substring(0, i);
    } 
    int k = Math.min(i, j);
    if (paramString1.equals(paramString2))
      return k; 
    int m = 0;
    int n = 1;
    while (true) {
      String str = paramString1.substring(k - n);
      int i1 = paramString2.indexOf(str);
      if (i1 == -1)
        return m; 
      n += i1;
      if (i1 == 0 || paramString1.substring(k - n).equals(paramString2.substring(0, n))) {
        m = n;
        n++;
      } 
    } 
  }
  
  protected String[] g(String paramString1, String paramString2) {
    String[] arrayOfString3;
    if (this.a <= 0.0F)
      return null; 
    String str1 = (paramString1.length() > paramString2.length()) ? paramString1 : paramString2;
    String str2 = (paramString1.length() > paramString2.length()) ? paramString2 : paramString1;
    if (str1.length() < 4 || str2.length() * 2 < str1.length())
      return null; 
    String[] arrayOfString1 = c(str1, str2, (str1.length() + 3) / 4);
    String[] arrayOfString2 = c(str1, str2, (str1.length() + 1) / 2);
    if (arrayOfString1 == null && arrayOfString2 == null)
      return null; 
    if (arrayOfString2 == null) {
      arrayOfString3 = arrayOfString1;
    } else if (arrayOfString1 == null) {
      arrayOfString3 = arrayOfString2;
    } else {
      arrayOfString3 = (arrayOfString1[4].length() > arrayOfString2[4].length()) ? arrayOfString1 : arrayOfString2;
    } 
    return (paramString1.length() > paramString2.length()) ? arrayOfString3 : new String[] { arrayOfString3[2], arrayOfString3[3], arrayOfString3[0], arrayOfString3[1], arrayOfString3[4] };
  }
  
  private String[] c(String paramString1, String paramString2, int paramInt) {
    String str1 = paramString1.substring(paramInt, paramInt + paramString1.length() / 4);
    int i = -1;
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    while ((i = paramString2.indexOf(str1, i + 1)) != -1) {
      int j = d(paramString1.substring(paramInt), paramString2.substring(i));
      int k = e(paramString1.substring(0, paramInt), paramString2.substring(0, i));
      if (str2.length() < k + j) {
        str2 = paramString2.substring(i - k, i) + paramString2.substring(i, i + j);
        str3 = paramString1.substring(0, paramInt - k);
        str4 = paramString1.substring(paramInt + j);
        str5 = paramString2.substring(0, i - k);
        str6 = paramString2.substring(i + j);
      } 
    } 
    return (str2.length() * 2 >= paramString1.length()) ? new String[] { str3, str4, str5, str6, str2 } : null;
  }
  
  public void a(LinkedList<a> paramLinkedList) {
    if (paramLinkedList.isEmpty())
      return; 
    boolean bool = false;
    Stack<a> stack = new Stack();
    String str = null;
    ListIterator<a> listIterator = paramLinkedList.listIterator();
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    a a1;
    for (a1 = listIterator.next(); a1 != null; a1 = listIterator.hasNext() ? listIterator.next() : null) {
      if (a1.a == Operation.EQUAL) {
        stack.push(a1);
        i = k;
        j = m;
        k = 0;
        m = 0;
        str = a1.b;
      } else {
        if (a1.a == Operation.INSERT) {
          k += a1.b.length();
        } else {
          m += a1.b.length();
        } 
        if (str != null && str.length() <= Math.max(i, j) && str.length() <= Math.max(k, m)) {
          while (a1 != stack.lastElement())
            a1 = listIterator.previous(); 
          listIterator.next();
          listIterator.set(new a(Operation.DELETE, str));
          listIterator.add(new a(Operation.INSERT, str));
          stack.pop();
          if (!stack.empty())
            stack.pop(); 
          if (stack.empty()) {
            while (listIterator.hasPrevious())
              listIterator.previous(); 
          } else {
            a1 = stack.lastElement();
            while (a1 != listIterator.previous());
          } 
          i = 0;
          k = 0;
          j = 0;
          m = 0;
          str = null;
          bool = true;
        } 
      } 
    } 
    if (bool)
      d(paramLinkedList); 
    b(paramLinkedList);
    listIterator = paramLinkedList.listIterator();
    a a2 = null;
    a1 = null;
    if (listIterator.hasNext()) {
      a2 = listIterator.next();
      if (listIterator.hasNext())
        a1 = listIterator.next(); 
    } 
    while (a1 != null) {
      if (a2.a == Operation.DELETE && a1.a == Operation.INSERT) {
        String str1 = a2.b;
        String str2 = a1.b;
        int n = f(str1, str2);
        int i1 = f(str2, str1);
        if (n >= i1) {
          if (n >= str1.length() / 2.0D || n >= str2.length() / 2.0D) {
            listIterator.previous();
            listIterator.add(new a(Operation.EQUAL, str2.substring(0, n)));
            a2.b = str1.substring(0, str1.length() - n);
            a1.b = str2.substring(n);
          } 
        } else if (i1 >= str1.length() / 2.0D || i1 >= str2.length() / 2.0D) {
          listIterator.previous();
          listIterator.add(new a(Operation.EQUAL, str1.substring(0, i1)));
          a2.a = Operation.INSERT;
          a2.b = str2.substring(0, str2.length() - i1);
          a1.a = Operation.DELETE;
          a1.b = str1.substring(i1);
        } 
        a1 = listIterator.hasNext() ? listIterator.next() : null;
      } 
      a2 = a1;
      a1 = listIterator.hasNext() ? listIterator.next() : null;
    } 
  }
  
  public void b(LinkedList<a> paramLinkedList) {
    ListIterator<a> listIterator = paramLinkedList.listIterator();
    a a1 = listIterator.hasNext() ? listIterator.next() : null;
    a a2 = listIterator.hasNext() ? listIterator.next() : null;
    for (a a3 = listIterator.hasNext() ? listIterator.next() : null; a3 != null; a3 = listIterator.hasNext() ? listIterator.next() : null) {
      if (a1.a == Operation.EQUAL && a3.a == Operation.EQUAL) {
        String str1 = a1.b;
        String str2 = a2.b;
        String str3 = a3.b;
        int i = e(str1, str2);
        if (i != 0) {
          String str = str2.substring(str2.length() - i);
          str1 = str1.substring(0, str1.length() - i);
          str2 = str + str2.substring(0, str2.length() - i);
          str3 = str + str3;
        } 
        String str4 = str1;
        String str5 = str2;
        String str6 = str3;
        int j = k(str1, str2) + k(str2, str3);
        while (str2.length() != 0 && str3.length() != 0 && str2.charAt(0) == str3.charAt(0)) {
          str1 = str1 + str2.charAt(0);
          str2 = str2.substring(1) + str3.charAt(0);
          str3 = str3.substring(1);
          int k = k(str1, str2) + k(str2, str3);
          if (k >= j) {
            j = k;
            str4 = str1;
            str5 = str2;
            str6 = str3;
          } 
        } 
        if (!a1.b.equals(str4)) {
          if (str4.length() != 0) {
            a1.b = str4;
          } else {
            listIterator.previous();
            listIterator.previous();
            listIterator.previous();
            listIterator.remove();
            listIterator.next();
            listIterator.next();
          } 
          a2.b = str5;
          if (str6.length() != 0) {
            a3.b = str6;
          } else {
            listIterator.remove();
            a3 = a2;
            a2 = a1;
          } 
        } 
      } 
      a1 = a2;
      a2 = a3;
    } 
  }
  
  private int k(String paramString1, String paramString2) {
    if (paramString1.length() == 0 || paramString2.length() == 0)
      return 6; 
    char c1 = paramString1.charAt(paramString1.length() - 1);
    char c2 = paramString2.charAt(0);
    boolean bool1 = !Character.isLetterOrDigit(c1) ? true : false;
    boolean bool2 = !Character.isLetterOrDigit(c2) ? true : false;
    boolean bool3 = (bool1 && Character.isWhitespace(c1)) ? true : false;
    boolean bool4 = (bool2 && Character.isWhitespace(c2)) ? true : false;
    boolean bool5 = (bool3 && Character.getType(c1) == 15) ? true : false;
    boolean bool6 = (bool4 && Character.getType(c2) == 15) ? true : false;
    boolean bool7 = (bool5 && this.i.matcher(paramString1).find()) ? true : false;
    boolean bool8 = (bool6 && this.j.matcher(paramString2).find()) ? true : false;
    return (bool7 || bool8) ? 5 : ((bool5 || bool6) ? 4 : ((bool1 && !bool3 && bool4) ? 3 : ((bool3 || bool4) ? 2 : ((bool1 || bool2) ? 1 : 0))));
  }
  
  public void c(LinkedList<a> paramLinkedList) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual isEmpty : ()Z
    //   4: ifeq -> 8
    //   7: return
    //   8: iconst_0
    //   9: istore_2
    //   10: new java/util/Stack
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore_3
    //   18: aconst_null
    //   19: astore #4
    //   21: aload_1
    //   22: invokevirtual listIterator : ()Ljava/util/ListIterator;
    //   25: astore #5
    //   27: iconst_0
    //   28: istore #6
    //   30: iconst_0
    //   31: istore #7
    //   33: iconst_0
    //   34: istore #8
    //   36: iconst_0
    //   37: istore #9
    //   39: aload #5
    //   41: invokeinterface next : ()Ljava/lang/Object;
    //   46: checkcast com/wallaby/javascript/DiffPatchMatch$a
    //   49: astore #10
    //   51: aload #10
    //   53: astore #11
    //   55: aload #10
    //   57: ifnull -> 442
    //   60: aload #10
    //   62: getfield a : Lcom/wallaby/javascript/DiffPatchMatch$Operation;
    //   65: getstatic com/wallaby/javascript/DiffPatchMatch$Operation.EQUAL : Lcom/wallaby/javascript/DiffPatchMatch$Operation;
    //   68: if_acmpne -> 141
    //   71: aload #10
    //   73: getfield b : Ljava/lang/String;
    //   76: invokevirtual length : ()I
    //   79: aload_0
    //   80: getfield b : S
    //   83: if_icmpge -> 121
    //   86: iload #8
    //   88: ifne -> 96
    //   91: iload #9
    //   93: ifeq -> 121
    //   96: aload_3
    //   97: aload #10
    //   99: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: iload #8
    //   105: istore #6
    //   107: iload #9
    //   109: istore #7
    //   111: aload #10
    //   113: getfield b : Ljava/lang/String;
    //   116: astore #4
    //   118: goto -> 132
    //   121: aload_3
    //   122: invokevirtual clear : ()V
    //   125: aconst_null
    //   126: astore #4
    //   128: aload #10
    //   130: astore #11
    //   132: iconst_0
    //   133: dup
    //   134: istore #9
    //   136: istore #8
    //   138: goto -> 413
    //   141: aload #10
    //   143: getfield a : Lcom/wallaby/javascript/DiffPatchMatch$Operation;
    //   146: getstatic com/wallaby/javascript/DiffPatchMatch$Operation.DELETE : Lcom/wallaby/javascript/DiffPatchMatch$Operation;
    //   149: if_acmpne -> 158
    //   152: iconst_1
    //   153: istore #9
    //   155: goto -> 161
    //   158: iconst_1
    //   159: istore #8
    //   161: aload #4
    //   163: ifnull -> 413
    //   166: iload #6
    //   168: ifeq -> 186
    //   171: iload #7
    //   173: ifeq -> 186
    //   176: iload #8
    //   178: ifeq -> 186
    //   181: iload #9
    //   183: ifne -> 247
    //   186: aload #4
    //   188: invokevirtual length : ()I
    //   191: aload_0
    //   192: getfield b : S
    //   195: iconst_2
    //   196: idiv
    //   197: if_icmpge -> 413
    //   200: iload #6
    //   202: ifeq -> 209
    //   205: iconst_1
    //   206: goto -> 210
    //   209: iconst_0
    //   210: iload #7
    //   212: ifeq -> 219
    //   215: iconst_1
    //   216: goto -> 220
    //   219: iconst_0
    //   220: iadd
    //   221: iload #8
    //   223: ifeq -> 230
    //   226: iconst_1
    //   227: goto -> 231
    //   230: iconst_0
    //   231: iadd
    //   232: iload #9
    //   234: ifeq -> 241
    //   237: iconst_1
    //   238: goto -> 242
    //   241: iconst_0
    //   242: iadd
    //   243: iconst_3
    //   244: if_icmpne -> 413
    //   247: aload #10
    //   249: aload_3
    //   250: invokevirtual lastElement : ()Ljava/lang/Object;
    //   253: if_acmpeq -> 271
    //   256: aload #5
    //   258: invokeinterface previous : ()Ljava/lang/Object;
    //   263: checkcast com/wallaby/javascript/DiffPatchMatch$a
    //   266: astore #10
    //   268: goto -> 247
    //   271: aload #5
    //   273: invokeinterface next : ()Ljava/lang/Object;
    //   278: pop
    //   279: aload #5
    //   281: new com/wallaby/javascript/DiffPatchMatch$a
    //   284: dup
    //   285: getstatic com/wallaby/javascript/DiffPatchMatch$Operation.DELETE : Lcom/wallaby/javascript/DiffPatchMatch$Operation;
    //   288: aload #4
    //   290: invokespecial <init> : (Lcom/wallaby/javascript/DiffPatchMatch$Operation;Ljava/lang/String;)V
    //   293: invokeinterface set : (Ljava/lang/Object;)V
    //   298: aload #5
    //   300: new com/wallaby/javascript/DiffPatchMatch$a
    //   303: dup
    //   304: getstatic com/wallaby/javascript/DiffPatchMatch$Operation.INSERT : Lcom/wallaby/javascript/DiffPatchMatch$Operation;
    //   307: aload #4
    //   309: invokespecial <init> : (Lcom/wallaby/javascript/DiffPatchMatch$Operation;Ljava/lang/String;)V
    //   312: dup
    //   313: astore #10
    //   315: invokeinterface add : (Ljava/lang/Object;)V
    //   320: aload_3
    //   321: invokevirtual pop : ()Ljava/lang/Object;
    //   324: pop
    //   325: aconst_null
    //   326: astore #4
    //   328: iload #6
    //   330: ifeq -> 355
    //   333: iload #7
    //   335: ifeq -> 355
    //   338: iconst_1
    //   339: dup
    //   340: istore #9
    //   342: istore #8
    //   344: aload_3
    //   345: invokevirtual clear : ()V
    //   348: aload #10
    //   350: astore #11
    //   352: goto -> 411
    //   355: aload_3
    //   356: invokevirtual empty : ()Z
    //   359: ifne -> 367
    //   362: aload_3
    //   363: invokevirtual pop : ()Ljava/lang/Object;
    //   366: pop
    //   367: aload_3
    //   368: invokevirtual empty : ()Z
    //   371: ifeq -> 381
    //   374: aload #11
    //   376: astore #10
    //   378: goto -> 390
    //   381: aload_3
    //   382: invokevirtual lastElement : ()Ljava/lang/Object;
    //   385: checkcast com/wallaby/javascript/DiffPatchMatch$a
    //   388: astore #10
    //   390: aload #10
    //   392: aload #5
    //   394: invokeinterface previous : ()Ljava/lang/Object;
    //   399: if_acmpeq -> 405
    //   402: goto -> 390
    //   405: iconst_0
    //   406: dup
    //   407: istore #9
    //   409: istore #8
    //   411: iconst_1
    //   412: istore_2
    //   413: aload #5
    //   415: invokeinterface hasNext : ()Z
    //   420: ifeq -> 436
    //   423: aload #5
    //   425: invokeinterface next : ()Ljava/lang/Object;
    //   430: checkcast com/wallaby/javascript/DiffPatchMatch$a
    //   433: goto -> 437
    //   436: aconst_null
    //   437: astore #10
    //   439: goto -> 55
    //   442: iload_2
    //   443: ifeq -> 451
    //   446: aload_0
    //   447: aload_1
    //   448: invokevirtual d : (Ljava/util/LinkedList;)V
    //   451: return
  }
  
  public void d(LinkedList<a> paramLinkedList) {
    paramLinkedList.add(new a(Operation.EQUAL, ""));
    ListIterator<a> listIterator = paramLinkedList.listIterator();
    byte b1 = 0;
    byte b2 = 0;
    String str1 = "";
    String str2 = "";
    a a1 = listIterator.next();
    a a2 = null;
    while (a1 != null) {
      switch (a.a[a1.a.ordinal()]) {
        case 1:
          b2++;
          str2 = str2 + a1.b;
          a2 = null;
          break;
        case 2:
          b1++;
          str1 = str1 + a1.b;
          a2 = null;
          break;
        case 3:
          if (b1 + b2 > 1) {
            boolean bool1 = (b1 != 0 && b2 != 0) ? true : false;
            listIterator.previous();
            while (b1-- > 0) {
              listIterator.previous();
              listIterator.remove();
            } 
            while (b2-- > 0) {
              listIterator.previous();
              listIterator.remove();
            } 
            if (bool1) {
              int i = d(str2, str1);
              if (i != 0) {
                if (listIterator.hasPrevious()) {
                  a1 = listIterator.previous();
                  if (!g && a1.a != Operation.EQUAL)
                    throw new AssertionError("Previous diff should have been an equality."); 
                  a1.b += str2.substring(0, i);
                  listIterator.next();
                } else {
                  listIterator.add(new a(Operation.EQUAL, str2.substring(0, i)));
                } 
                str2 = str2.substring(i);
                str1 = str1.substring(i);
              } 
              i = e(str2, str1);
              if (i != 0) {
                a1 = listIterator.next();
                a1.b = str2.substring(str2.length() - i) + a1.b;
                str2 = str2.substring(0, str2.length() - i);
                str1 = str1.substring(0, str1.length() - i);
                listIterator.previous();
              } 
            } 
            if (str1.length() != 0)
              listIterator.add(new a(Operation.DELETE, str1)); 
            if (str2.length() != 0)
              listIterator.add(new a(Operation.INSERT, str2)); 
            a1 = listIterator.hasNext() ? listIterator.next() : null;
          } else if (a2 != null) {
            a2.b += a1.b;
            listIterator.remove();
            a1 = listIterator.previous();
            listIterator.next();
          } 
          b2 = 0;
          b1 = 0;
          str1 = "";
          str2 = "";
          a2 = a1;
          break;
      } 
      a1 = listIterator.hasNext() ? listIterator.next() : null;
    } 
    if (((a)paramLinkedList.getLast()).b.length() == 0)
      paramLinkedList.removeLast(); 
    boolean bool = false;
    listIterator = paramLinkedList.listIterator();
    a a3 = listIterator.hasNext() ? listIterator.next() : null;
    a1 = listIterator.hasNext() ? listIterator.next() : null;
    for (a a4 = listIterator.hasNext() ? listIterator.next() : null; a4 != null; a4 = listIterator.hasNext() ? listIterator.next() : null) {
      if (a3.a == Operation.EQUAL && a4.a == Operation.EQUAL)
        if (a1.b.endsWith(a3.b)) {
          a3.b += a1.b.substring(0, a1.b.length() - a3.b.length());
          a3.b += a4.b;
          listIterator.previous();
          listIterator.previous();
          listIterator.previous();
          listIterator.remove();
          listIterator.next();
          a1 = listIterator.next();
          a4 = listIterator.hasNext() ? listIterator.next() : null;
          bool = true;
        } else if (a1.b.startsWith(a4.b)) {
          a3.b += a4.b;
          a1.b = a1.b.substring(a4.b.length()) + a4.b;
          listIterator.remove();
          a4 = listIterator.hasNext() ? listIterator.next() : null;
          bool = true;
        }  
      a3 = a1;
      a1 = a4;
    } 
    if (bool)
      d(paramLinkedList); 
  }
  
  public int a(LinkedList<a> paramLinkedList, int paramInt) {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    a a = null;
    for (a a1 : paramLinkedList) {
      if (a1.a != Operation.INSERT)
        i += a1.b.length(); 
      if (a1.a != Operation.DELETE)
        j += a1.b.length(); 
      if (i > paramInt) {
        a = a1;
        break;
      } 
      k = i;
      m = j;
    } 
    return (a != null && a.a == Operation.DELETE) ? m : (m + paramInt - k);
  }
  
  public String e(LinkedList<a> paramLinkedList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (a a : paramLinkedList) {
      String str = a.b.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "&para;<br>");
      switch (a.a[a.a.ordinal()]) {
        case 1:
          stringBuilder.append("<ins style=\"background:#e6ffe6;\">").append(str).append("</ins>");
        case 2:
          stringBuilder.append("<del style=\"background:#ffe6e6;\">").append(str).append("</del>");
        case 3:
          stringBuilder.append("<span>").append(str).append("</span>");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public String f(LinkedList<a> paramLinkedList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (a a : paramLinkedList) {
      if (a.a != Operation.INSERT)
        stringBuilder.append(a.b); 
    } 
    return stringBuilder.toString();
  }
  
  public String g(LinkedList<a> paramLinkedList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (a a : paramLinkedList) {
      if (a.a != Operation.DELETE)
        stringBuilder.append(a.b); 
    } 
    return stringBuilder.toString();
  }
  
  public int h(LinkedList<a> paramLinkedList) {
    int i = 0;
    int j = 0;
    int k = 0;
    for (a a : paramLinkedList) {
      switch (a.a[a.a.ordinal()]) {
        case 1:
          j += a.b.length();
        case 2:
          k += a.b.length();
        case 3:
          i += Math.max(j, k);
          j = 0;
          k = 0;
      } 
    } 
    i += Math.max(j, k);
    return i;
  }
  
  public String i(LinkedList<a> paramLinkedList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (a a : paramLinkedList) {
      switch (a.a[a.a.ordinal()]) {
        case 1:
          try {
            stringBuilder.append("+").append(URLEncoder.encode(a.b, "UTF-8").replace('+', ' ')).append("\t");
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new Error("This system does not support UTF-8.", unsupportedEncodingException);
          } 
        case 2:
          stringBuilder.append("-").append(a.b.length()).append("\t");
        case 3:
          stringBuilder.append("=").append(a.b.length()).append("\t");
      } 
    } 
    String str = stringBuilder.toString();
    if (str.length() != 0) {
      str = str.substring(0, str.length() - 1);
      str = d(str);
    } 
    return str;
  }
  
  public LinkedList<a> h(String paramString1, String paramString2) throws IllegalArgumentException {
    LinkedList<a> linkedList = new LinkedList();
    int i = 0;
    String[] arrayOfString = paramString2.split("\t");
    for (String str : arrayOfString) {
      if (str.length() != 0) {
        int j;
        String str2;
        String str1 = str.substring(1);
        switch (str.charAt(0)) {
          case '+':
            str1 = str1.replace("+", "%2B");
            try {
              str1 = URLDecoder.decode(str1, "UTF-8");
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
              throw new Error("This system does not support UTF-8.", unsupportedEncodingException);
            } catch (IllegalArgumentException illegalArgumentException) {
              throw new IllegalArgumentException("Illegal escape in diff_fromDelta: " + str1, illegalArgumentException);
            } 
            linkedList.add(new a(Operation.INSERT, str1));
            break;
          case '-':
          case '=':
            try {
              j = Integer.parseInt(str1);
            } catch (NumberFormatException numberFormatException) {
              throw new IllegalArgumentException("Invalid number in diff_fromDelta: " + str1, numberFormatException);
            } 
            if (j < 0)
              throw new IllegalArgumentException("Negative number in diff_fromDelta: " + str1); 
            try {
              str2 = paramString1.substring(i, i += j);
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
              throw new IllegalArgumentException("Delta length (" + i + ") larger than source text length (" + paramString1.length() + ").", stringIndexOutOfBoundsException);
            } 
            if (str.charAt(0) == '=') {
              linkedList.add(new a(Operation.EQUAL, str2));
              break;
            } 
            linkedList.add(new a(Operation.DELETE, str2));
            break;
          default:
            throw new IllegalArgumentException("Invalid diff operation in diff_fromDelta: " + str.charAt(0));
        } 
      } 
    } 
    if (i != paramString1.length())
      throw new IllegalArgumentException("Delta length (" + i + ") smaller than source text length (" + paramString1.length() + ")."); 
    return linkedList;
  }
  
  public int a(String paramString1, String paramString2, int paramInt) {
    if (paramString1 == null || paramString2 == null)
      throw new IllegalArgumentException("Null inputs. (match_main)"); 
    paramInt = Math.max(0, Math.min(paramInt, paramString1.length()));
    return paramString1.equals(paramString2) ? 0 : ((paramString1.length() == 0) ? -1 : ((paramInt + paramString2.length() <= paramString1.length() && paramString1.substring(paramInt, paramInt + paramString2.length()).equals(paramString2)) ? paramInt : b(paramString1, paramString2, paramInt)));
  }
  
  protected int b(String paramString1, String paramString2, int paramInt) {
    if (!g && this.h != 0 && paramString2.length() > this.h)
      throw new AssertionError("Pattern too long for this application."); 
    Map<Character, Integer> map = a(paramString2);
    double d = this.c;
    int i = paramString1.indexOf(paramString2, paramInt);
    if (i != -1) {
      d = Math.min(a(0, i, paramInt, paramString2), d);
      i = paramString1.lastIndexOf(paramString2, paramInt + paramString2.length());
      if (i != -1)
        d = Math.min(a(0, i, paramInt, paramString2), d); 
    } 
    int j = 1 << paramString2.length() - 1;
    i = -1;
    int k = paramString2.length() + paramString1.length();
    int[] arrayOfInt = new int[0];
    for (byte b = 0; b < paramString2.length(); b++) {
      int m = 0;
      int n;
      for (n = k; m < n; n = (k - m) / 2 + m) {
        if (a(b, paramInt + n, paramInt, paramString2) <= d) {
          m = n;
        } else {
          k = n;
        } 
      } 
      k = n;
      int i1 = Math.max(1, paramInt - n + 1);
      int i2 = Math.min(paramInt + n, paramString1.length()) + paramString2.length();
      int[] arrayOfInt1 = new int[i2 + 2];
      arrayOfInt1[i2 + 1] = (1 << b) - 1;
      for (int i3 = i2; i3 >= i1; i3--) {
        int i4;
        if (paramString1.length() <= i3 - 1 || !map.containsKey(Character.valueOf(paramString1.charAt(i3 - 1)))) {
          i4 = 0;
        } else {
          i4 = ((Integer)map.get(Character.valueOf(paramString1.charAt(i3 - 1)))).intValue();
        } 
        if (b == 0) {
          arrayOfInt1[i3] = (arrayOfInt1[i3 + 1] << 1 | 0x1) & i4;
        } else {
          arrayOfInt1[i3] = (arrayOfInt1[i3 + 1] << 1 | 0x1) & i4 | (arrayOfInt[i3 + 1] | arrayOfInt[i3]) << 1 | 0x1 | arrayOfInt[i3 + 1];
        } 
        if ((arrayOfInt1[i3] & j) != 0) {
          double d1 = a(b, i3 - 1, paramInt, paramString2);
          if (d1 <= d) {
            d = d1;
            i = i3 - 1;
            if (i > paramInt) {
              i1 = Math.max(1, 2 * paramInt - i);
            } else {
              break;
            } 
          } 
        } 
      } 
      if (a(b + 1, paramInt, paramInt, paramString2) > d)
        break; 
      arrayOfInt = arrayOfInt1;
    } 
    return i;
  }
  
  private double a(int paramInt1, int paramInt2, int paramInt3, String paramString) {
    float f = paramInt1 / paramString.length();
    int i = Math.abs(paramInt3 - paramInt2);
    return (this.d == 0) ? ((i == 0) ? f : 1.0D) : (f + i / this.d);
  }
  
  protected Map<Character, Integer> a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    char[] arrayOfChar = paramString.toCharArray();
    for (char c : arrayOfChar)
      hashMap.put(Character.valueOf(c), Integer.valueOf(0)); 
    byte b = 0;
    for (char c : arrayOfChar) {
      hashMap.put(Character.valueOf(c), Integer.valueOf(((Integer)hashMap.get(Character.valueOf(c))).intValue() | 1 << paramString.length() - b - 1));
      b++;
    } 
    return (Map)hashMap;
  }
  
  protected void a(c paramc, String paramString) {
    if (paramString.length() == 0)
      return; 
    String str1 = paramString.substring(paramc.c, paramc.c + paramc.d);
    int i = 0;
    while (paramString.indexOf(str1) != paramString.lastIndexOf(str1) && str1.length() < this.h - this.f - this.f) {
      i += this.f;
      str1 = paramString.substring(Math.max(0, paramc.c - i), Math.min(paramString.length(), paramc.c + paramc.d + i));
    } 
    i += this.f;
    String str2 = paramString.substring(Math.max(0, paramc.c - i), paramc.c);
    if (str2.length() != 0)
      paramc.a.addFirst(new a(Operation.EQUAL, str2)); 
    String str3 = paramString.substring(paramc.c + paramc.d, Math.min(paramString.length(), paramc.c + paramc.d + i));
    if (str3.length() != 0)
      paramc.a.addLast(new a(Operation.EQUAL, str3)); 
    paramc.b -= str2.length();
    paramc.c -= str2.length();
    paramc.d += str2.length() + str3.length();
    paramc.e += str2.length() + str3.length();
  }
  
  public LinkedList<c> i(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      throw new IllegalArgumentException("Null inputs. (patch_make)"); 
    LinkedList<a> linkedList = a(paramString1, paramString2, true);
    if (linkedList.size() > 2) {
      a(linkedList);
      c(linkedList);
    } 
    return a(paramString1, linkedList);
  }
  
  public LinkedList<c> j(LinkedList<a> paramLinkedList) {
    if (paramLinkedList == null)
      throw new IllegalArgumentException("Null inputs. (patch_make)"); 
    String str = f(paramLinkedList);
    return a(str, paramLinkedList);
  }
  
  public LinkedList<c> a(String paramString1, String paramString2, LinkedList<a> paramLinkedList) {
    return a(paramString1, paramLinkedList);
  }
  
  public LinkedList<c> a(String paramString, LinkedList<a> paramLinkedList) {
    if (paramString == null || paramLinkedList == null)
      throw new IllegalArgumentException("Null inputs. (patch_make)"); 
    LinkedList<c> linkedList = new LinkedList();
    if (paramLinkedList.isEmpty())
      return linkedList; 
    c c = new c();
    int i = 0;
    int j = 0;
    String str1 = paramString;
    String str2 = paramString;
    for (a a : paramLinkedList) {
      if (c.a.isEmpty() && a.a != Operation.EQUAL) {
        c.b = i;
        c.c = j;
      } 
      switch (a.a[a.a.ordinal()]) {
        case 1:
          c.a.add(a);
          c.e += a.b.length();
          str2 = str2.substring(0, j) + a.b + str2.substring(j);
          break;
        case 2:
          c.d += a.b.length();
          c.a.add(a);
          str2 = str2.substring(0, j) + str2.substring(j + a.b.length());
          break;
        case 3:
          if (a.b.length() <= 2 * this.f && !c.a.isEmpty() && a != paramLinkedList.getLast()) {
            c.a.add(a);
            c.d += a.b.length();
            c.e += a.b.length();
          } 
          if (a.b.length() >= 2 * this.f && !c.a.isEmpty()) {
            a(c, str1);
            linkedList.add(c);
            c = new c();
            str1 = str2;
            i = j;
          } 
          break;
      } 
      if (a.a != Operation.INSERT)
        i += a.b.length(); 
      if (a.a != Operation.DELETE)
        j += a.b.length(); 
    } 
    if (!c.a.isEmpty()) {
      a(c, str1);
      linkedList.add(c);
    } 
    return linkedList;
  }
  
  public LinkedList<c> k(LinkedList<c> paramLinkedList) {
    LinkedList<c> linkedList = new LinkedList();
    for (c c1 : paramLinkedList) {
      c c2 = new c();
      for (a a1 : c1.a) {
        a a2 = new a(a1.a, a1.b);
        c2.a.add(a2);
      } 
      c2.b = c1.b;
      c2.c = c1.c;
      c2.d = c1.d;
      c2.e = c1.e;
      linkedList.add(c2);
    } 
    return linkedList;
  }
  
  public Object[] a(LinkedList<c> paramLinkedList, String paramString) {
    if (paramLinkedList.isEmpty())
      return new Object[] { paramString, new boolean[0] }; 
    paramLinkedList = k(paramLinkedList);
    String str = l(paramLinkedList);
    paramString = str + paramString + str;
    m(paramLinkedList);
    byte b = 0;
    int i = 0;
    boolean[] arrayOfBoolean = new boolean[paramLinkedList.size()];
    for (c c : paramLinkedList) {
      int k;
      int j = c.c + i;
      String str1 = f(c.a);
      int m = -1;
      if (str1.length() > this.h) {
        k = a(paramString, str1.substring(0, this.h), j);
        if (k != -1) {
          m = a(paramString, str1.substring(str1.length() - this.h), j + str1.length() - this.h);
          if (m == -1 || k >= m)
            k = -1; 
        } 
      } else {
        k = a(paramString, str1, j);
      } 
      if (k == -1) {
        arrayOfBoolean[b] = false;
        i -= c.e - c.d;
      } else {
        String str2;
        arrayOfBoolean[b] = true;
        i = k - j;
        if (m == -1) {
          str2 = paramString.substring(k, Math.min(k + str1.length(), paramString.length()));
        } else {
          str2 = paramString.substring(k, Math.min(m + this.h, paramString.length()));
        } 
        if (str1.equals(str2)) {
          paramString = paramString.substring(0, k) + g(c.a) + paramString.substring(k + str1.length());
        } else {
          LinkedList<a> linkedList = a(str1, str2, false);
          if (str1.length() > this.h && h(linkedList) / str1.length() > this.e) {
            arrayOfBoolean[b] = false;
          } else {
            b(linkedList);
            int n = 0;
            for (a a : c.a) {
              if (a.a != Operation.EQUAL) {
                int i1 = a(linkedList, n);
                if (a.a == Operation.INSERT) {
                  paramString = paramString.substring(0, k + i1) + a.b + paramString.substring(k + i1);
                } else if (a.a == Operation.DELETE) {
                  paramString = paramString.substring(0, k + i1) + paramString.substring(k + a(linkedList, n + a.b.length()));
                } 
              } 
              if (a.a != Operation.DELETE)
                n += a.b.length(); 
            } 
          } 
        } 
      } 
      b++;
    } 
    paramString = paramString.substring(str.length(), paramString.length() - str.length());
    return new Object[] { paramString, arrayOfBoolean };
  }
  
  public String l(LinkedList<c> paramLinkedList) {
    short s = this.f;
    String str = "";
    short s1;
    for (s1 = 1; s1 <= s; s1 = (short)(s1 + 1))
      str = str + String.valueOf((char)s1); 
    for (c c1 : paramLinkedList) {
      c1.b += s;
      c1.c += s;
    } 
    c c = paramLinkedList.getFirst();
    LinkedList<a> linkedList = c.a;
    if (linkedList.isEmpty() || ((a)linkedList.getFirst()).a != Operation.EQUAL) {
      linkedList.addFirst(new a(Operation.EQUAL, str));
      c.b -= s;
      c.c -= s;
      c.d += s;
      c.e += s;
    } else if (s > ((a)linkedList.getFirst()).b.length()) {
      a a = linkedList.getFirst();
      int i = s - a.b.length();
      a.b = str.substring(a.b.length()) + a.b;
      c.b -= i;
      c.c -= i;
      c.d += i;
      c.e += i;
    } 
    c = paramLinkedList.getLast();
    linkedList = c.a;
    if (linkedList.isEmpty() || ((a)linkedList.getLast()).a != Operation.EQUAL) {
      linkedList.addLast(new a(Operation.EQUAL, str));
      c.d += s;
      c.e += s;
    } else if (s > ((a)linkedList.getLast()).b.length()) {
      a a = linkedList.getLast();
      int i = s - a.b.length();
      a.b += str.substring(0, i);
      c.d += i;
      c.e += i;
    } 
    return str;
  }
  
  public void m(LinkedList<c> paramLinkedList) {
    short s = this.h;
    ListIterator<c> listIterator = paramLinkedList.listIterator();
    for (c c = listIterator.hasNext() ? listIterator.next() : null; c != null; c = listIterator.hasNext() ? listIterator.next() : null) {
      if (c.d <= this.h) {
        c = listIterator.hasNext() ? listIterator.next() : null;
        continue;
      } 
      listIterator.remove();
      int i = c.b;
      int j = c.c;
      String str = "";
      while (!c.a.isEmpty()) {
        String str1;
        c c1 = new c();
        boolean bool = true;
        c1.b = i - str.length();
        c1.c = j - str.length();
        if (str.length() != 0) {
          c1.d = c1.e = str.length();
          c1.a.add(new a(Operation.EQUAL, str));
        } 
        while (!c.a.isEmpty() && c1.d < s - this.f) {
          Operation operation = ((a)c.a.getFirst()).a;
          String str2 = ((a)c.a.getFirst()).b;
          if (operation == Operation.INSERT) {
            c1.e += str2.length();
            j += str2.length();
            c1.a.addLast(c.a.removeFirst());
            bool = false;
            continue;
          } 
          if (operation == Operation.DELETE && c1.a.size() == 1 && ((a)c1.a.getFirst()).a == Operation.EQUAL && str2.length() > 2 * s) {
            c1.d += str2.length();
            i += str2.length();
            bool = false;
            c1.a.add(new a(operation, str2));
            c.a.removeFirst();
            continue;
          } 
          str2 = str2.substring(0, Math.min(str2.length(), s - c1.d - this.f));
          c1.d += str2.length();
          i += str2.length();
          if (operation == Operation.EQUAL) {
            c1.e += str2.length();
            j += str2.length();
          } else {
            bool = false;
          } 
          c1.a.add(new a(operation, str2));
          if (str2.equals(((a)c.a.getFirst()).b)) {
            c.a.removeFirst();
            continue;
          } 
          ((a)c.a.getFirst()).b = ((a)c.a.getFirst()).b.substring(str2.length());
        } 
        str = g(c1.a);
        str = str.substring(Math.max(0, str.length() - this.f));
        if (f(c.a).length() > this.f) {
          str1 = f(c.a).substring(0, this.f);
        } else {
          str1 = f(c.a);
        } 
        if (str1.length() != 0) {
          c1.d += str1.length();
          c1.e += str1.length();
          if (!c1.a.isEmpty() && ((a)c1.a.getLast()).a == Operation.EQUAL) {
            ((a)c1.a.getLast()).b += str1;
          } else {
            c1.a.add(new a(Operation.EQUAL, str1));
          } 
        } 
        if (!bool)
          listIterator.add(c1); 
      } 
    } 
  }
  
  public String a(List<c> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (c c : paramList)
      stringBuilder.append(c); 
    return stringBuilder.toString();
  }
  
  public List<c> b(String paramString) throws IllegalArgumentException {
    LinkedList<c> linkedList = new LinkedList();
    if (paramString.length() == 0)
      return linkedList; 
    List<String> list = Arrays.asList(paramString.split("\n"));
    LinkedList<String> linkedList1 = new LinkedList<>(list);
    Pattern pattern = Pattern.compile("^@@ -(\\d+),?(\\d*) \\+(\\d+),?(\\d*) @@$");
    while (!linkedList1.isEmpty()) {
      Matcher matcher = pattern.matcher(linkedList1.getFirst());
      if (!matcher.matches())
        throw new IllegalArgumentException("Invalid patch string: " + (String)linkedList1.getFirst()); 
      c c = new c();
      linkedList.add(c);
      c.b = Integer.parseInt(matcher.group(1));
      if (matcher.group(2).length() == 0) {
        c.b--;
        c.d = 1;
      } else if (matcher.group(2).equals("0")) {
        c.d = 0;
      } else {
        c.b--;
        c.d = Integer.parseInt(matcher.group(2));
      } 
      c.c = Integer.parseInt(matcher.group(3));
      if (matcher.group(4).length() == 0) {
        c.c--;
        c.e = 1;
      } else if (matcher.group(4).equals("0")) {
        c.e = 0;
      } else {
        c.c--;
        c.e = Integer.parseInt(matcher.group(4));
      } 
      linkedList1.removeFirst();
      while (!linkedList1.isEmpty()) {
        char c1;
        try {
          c1 = ((String)linkedList1.getFirst()).charAt(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
          linkedList1.removeFirst();
          continue;
        } 
        String str = ((String)linkedList1.getFirst()).substring(1);
        str = str.replace("+", "%2B");
        try {
          str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          throw new Error("This system does not support UTF-8.", unsupportedEncodingException);
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new IllegalArgumentException("Illegal escape in patch_fromText: " + str, illegalArgumentException);
        } 
        if (c1 == '-') {
          c.a.add(new a(Operation.DELETE, str));
        } else if (c1 == '+') {
          c.a.add(new a(Operation.INSERT, str));
        } else if (c1 == ' ') {
          c.a.add(new a(Operation.EQUAL, str));
        } else {
          if (c1 == '@')
            break; 
          throw new IllegalArgumentException("Invalid patch mode '" + c1 + "' in: " + str);
        } 
        linkedList1.removeFirst();
      } 
    } 
    return linkedList;
  }
  
  public static class c {
    public LinkedList<DiffPatchMatch.a> a = new LinkedList<>();
    
    public int b;
    
    public int c;
    
    public int d;
    
    public int e;
    
    public String toString() {
      String str1;
      String str2;
      if (this.d == 0) {
        str1 = this.b + ",0";
      } else if (this.d == 1) {
        str1 = Integer.toString(this.b + 1);
      } else {
        str1 = (this.b + 1) + "," + this.d;
      } 
      if (this.e == 0) {
        str2 = this.c + ",0";
      } else if (this.e == 1) {
        str2 = Integer.toString(this.c + 1);
      } else {
        str2 = (this.c + 1) + "," + this.e;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("@@ -").append(str1).append(" +").append(str2).append(" @@\n");
      for (DiffPatchMatch.a a : this.a) {
        switch (a.a[a.a.ordinal()]) {
          case 1:
            stringBuilder.append('+');
            break;
          case 2:
            stringBuilder.append('-');
            break;
          case 3:
            stringBuilder.append(' ');
            break;
        } 
        try {
          stringBuilder.append(URLEncoder.encode(a.b, "UTF-8").replace('+', ' ')).append("\n");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          throw new Error("This system does not support UTF-8.", unsupportedEncodingException);
        } 
      } 
      return DiffPatchMatch.c(stringBuilder.toString());
    }
  }
  
  public static class a {
    public DiffPatchMatch.Operation a;
    
    public String b;
    
    public a(DiffPatchMatch.Operation param1Operation, String param1String) {
      this.a = param1Operation;
      this.b = param1String;
    }
    
    public String toString() {
      String str = this.b.replace('\n', '¶');
      return "Diff(" + this.a + ",\"" + str + "\")";
    }
    
    public int hashCode() {
      byte b = 31;
      int i = (this.a == null) ? 0 : this.a.hashCode();
      i += 31 * ((this.b == null) ? 0 : this.b.hashCode());
      return i;
    }
    
    public boolean equals(Object obj) {
      if (this == obj)
        return true; 
      if (obj == null)
        return false; 
      if (getClass() != obj.getClass())
        return false; 
      a a1 = (a)obj;
      return (this.a != a1.a) ? false : ((this.b == null) ? ((a1.b == null)) : this.b.equals(a1.b));
    }
  }
  
  protected static class b {
    protected String a;
    
    protected String b;
    
    protected List<String> c;
    
    protected b(String param1String1, String param1String2, List<String> param1List) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1List;
    }
  }
  
  public enum Operation {
    DELETE, INSERT, EQUAL;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/DiffPatchMatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */