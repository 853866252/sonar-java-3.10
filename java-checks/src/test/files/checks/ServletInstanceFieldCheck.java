import javax.servlet.http.HttpServlet;
import org.apache.struts.action.Action;

class A {
  private String userName;
}

class B extends HttpServlet {
  
  private String userName; // Noncompliant [[sc=18;ec=26]] {{Remove this misleading mutable servlet instance fields or make it "static" and/or "final"}}
  private static String staticVar;
  private final String finalVar;
  private String storageType;

  public B(String x) {
    String localVar;
    finalVar = x;
  }

  void init(javax.servlet.ServletConfig config) {
    storageType = StorageType.valueOf(config.getInitParameter("storageType"));
  }
}

class C extends Action {
  
  private String userName; // Noncompliant
  private static String staticVar; 
  private final String finalVar;
  
  public C(String x) {
    finalVar = x;
  }
}