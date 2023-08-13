import java.io.Serializable;
import java.util.*;

class Company implements Serializable {
    private String name;
    public Company(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
class CloneTest implements Cloneable{
    private String name;
    private int value;
    private Company company;
    public CloneTest(String name, int value,Company company){
        this.name = name;
        this.value = value;
        this.company = company;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public Company getCompany(){
        return this.company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    @Override
    public CloneTest clone() {
        try {
            CloneTest clone = (CloneTest) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
public class Test {
    public static void main(String[] args){
    ArrayList<Character> ch  = new ArrayList<>();
    ch.add('n');
        ch.add('g');
        ch.add('q');
        ch.add('t');
        ch.add('a');
        ch.add('z');
        Collections.sort(ch);
        System.out.println(ch);
        Map<Integer,String> hm = new HashMap<>();
        hm.put(1,"12");
        hm.put(2,"12");
        hm.put(3,"12");
        hm.put(4,"12");
        hm.put(5,"12");

        Iterator<Map.Entry<Integer,String>> iterator = hm.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<Integer,String> e = iterator.next();
            System.out.println(e.getKey()+" "+e.getValue());

        }

        hm.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }

}
