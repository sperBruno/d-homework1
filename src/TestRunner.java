import java.io.File;
import java.io.PrintWriter;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
  public TestRunner() {}
  
  public static void main(String[] args)
  {
    /*Class tests = args[0].equals("myTests") ? MyTests.class : args[0].equals("private") ? PrivateTests.class : null;
    if (tests == null) {
      throw new IllegalArgumentException("must provide one of two arguments, 'private' or 'myTests'");
    }*/
    

    PrintWriter out = null;
    try {
      out = new PrintWriter(new File("result.txt"));
    }
    catch (Exception e) {
      e.printStackTrace();
      return;
    }
    
    Result result = JUnitCore.runClasses(new Class[] { PrivateTests.class });
    
    int fail = result.getFailureCount();
    int pass = result.getRunCount() - fail;
    
    if (pass == 1) {
      out.println("1 test passed.");
    } else {
      out.println(pass + " tests passed.");
    }
    if (fail == 1)
      out.println("1 test failed."); else {
      out.println(fail + " tests failed.");
    }
    if (fail == 0) {
      out.println("Great job!");
    }
    else {
      int count = 1;
      for (Failure failure : result.getFailures()) {
        if (failure.getMessage() == null) {
          Throwable t = failure.getException();
          out.println("#" + count + ". A test threw " + t + " at " + t.getStackTrace()[0]);

        }
        else
        {
          Throwable t = failure.getException();
          if ((t instanceof AssertionError)) {
            out.println("#" + count + ". " + failure.getMessage());
          }
          else {
            String except = failure.getException().toString();
            if (except.contains("TestTimedOutException")) {
              out.println("#" + count + ".  One of the test cases timed out, probably due " + 
                "to an inefficient solution (" + failure.getTestHeader() + ")");
            } else {
              out.println("#" + count + ". " + failure.getException() + 
                " occurs at " + failure.getException().getStackTrace()[0]);
            }
          }
        }
        count++;
      }
    }
    

    out.flush();
    out.close();
  }
}