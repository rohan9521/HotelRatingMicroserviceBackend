import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamPracs {

    public static void main(String[] args) throws Exception {
//        Predicate<Integer> pred = i-> i%2==0;
//        Predicate<Integer> pred2 = i-> i%2!=0;
//        System.out.println(pred.test(2));
//        System.out.println(pred.negate().test(4));
        Consumer<List<Integer>> modify = list->{
            for(int i=0;i<list.size();i++){
                list.set(i,list.get(i)*10);
            }
        };
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        modify.accept(list);

        Consumer<List<Integer>> show = listArr->{
            listArr.forEach(element -> System.out.println(element));
        };

        show.accept(list);

        modify.andThen(show).accept(list);


        //Function
        Function<Integer,Double> half = i-> i / 2.0;

        Function<Double,Integer> toStr = i-> i.intValue();

       System.out.println( half.compose(toStr).apply(10.0));
    }
}
