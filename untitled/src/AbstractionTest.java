abstract  class TestAbs{
    static public void stm(){

    }
    static private int val;
    public TestAbs(){
        System.out.println("TestAbsConst");
    }
    public void print(){
        System.out.println("test");
    }
    abstract public void Imp() throws Exception;
}
interface TestInterface1{
   default  public void print(){
        System.out.println("TestInterface1");
    }
}
interface TestInterface2{
    default  public void print(){
        System.out.println("TestInterface2");
    }
}
class Wrapper{
    int x;
}
class Main extends TestAbs implements TestInterface1,TestInterface2{
   {
       System.out.println("Main1");
    }
    {
        System.out.println("Main2");
    }
    {
        System.out.println("Main3");
    }
    {
        System.out.println("Main4");
    }

    public Main(){
        super();
        System.out.println("MainConstructor");


    }
    public void rec(Wrapper w){
       if(w.x>100)
           return;
       System.out.println(w.hashCode());
        w.x = w.x*10;
       rec(w);
    }
    @Override
    public void Imp() {
        System.out.println("Main Imp");
        try{
            throw new NullPointerException("");
        }catch (NullPointerException e){
          //  throw new NullPointerException("as");
        }catch (Exception e2){
            //throw new Exception("as");
            System.out.println(e2.getMessage());
        }

    }

}
public class AbstractionTest {

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.Imp();
        m.print();
        String str1  = "ROhan";
        String str2 = new String("ROhan");
        System.out.println(str1.hashCode()+" "+str2.hashCode());
        int x=1;
        Wrapper wrapper = new Wrapper();
        wrapper.x = x;
        m.rec(wrapper);
        System.out.println(wrapper.x);
    }
}
