public class MyClassLoader extends ClassLoader
{
  @Override
  protected synchronized Class<?> loadClass(final String className, final boolean resolve)
      throws ClassNotFoundException
  {
    if (className.startsWith("secret.class"))
    {
      throw new RuntimeException();
    }

    return MyClassLoader.getSystemClassLoader().loadClass(className);
  }

  public static void main(String[] args) {
    MyClassLoader myClassLoader = new MyClassLoader();
    try {
      myClassLoader.loadClass("java.lang.String", true);
      System.out.println("java.lang.String loaded successfully");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      myClassLoader.loadClass("secret.class.SomeSecretClass", true);
    } catch (RuntimeException e) {
      System.out.println("RuntimeException caught: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}