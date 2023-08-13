import java.util.*;
import java.util.stream.Collectors;
class Emp{
    private String gender;
    public Emp(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
}
public class Practs {
    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("a",5);
        hm.put("b",4);
        hm.put("c",3);
        hm.put("d",2);
        hm.put("e",1);
        hm.forEach((k,v)->{
            System.out.println(v);
        });

        try{
            try{
                throw new Exception("try Exception");
            }catch (Exception e){
                throw new Exception("catch Exception");
            }finally {
                throw new Exception("Finally Exception");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       ArrayList<Emp> empArrayList = new ArrayList<>();
        empArrayList.add(new Emp("Male"));
        empArrayList.add(new Emp("Female"));
        empArrayList.add(new Emp("Male"));
        empArrayList.add(new Emp("Male"));
        empArrayList.add(new Emp("Female"));
        empArrayList.notify();
        System.out.println(empArrayList.stream().collect(Collectors.groupingBy(Emp::getGender)).get("Female").size());
//
//        ArrayList<Map.Entry<String,Integer>> set;
//     hm.entrySet()
//                .stream()
//                .collect(Collectors.toList())
//                .stream()
//                .sorted(new Comparator<Map.Entry<String, Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                        if(o1.getValue() > o2.getValue())
//                                return 1;
//                        else if(o1.getValue() < o2.getValue())
//                                return -1;
//                        return 0;
//                    }
//                })
//                .forEach(x->System.out.println(x.getKey()+" "+x.getValue()));

    }
}
