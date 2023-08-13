import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalPractice {
    static class Customer{
        String name;
        String email;

        public Customer(String name,String email){
            this.name = name;
            this.email = email;
        }
        @Override
        public String toString(){
            return this.email+" "+this.name;
        }
    }
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Rohan","hey");
        Customer customer2 = new Customer("Rohan","hey");
        Optional<Customer> op = Optional.ofNullable(customer);
       // op.filter(x->x.name!="sd");
        List<Customer> arr = new ArrayList<>();
        arr.add(customer);
        arr.add(customer2);
        Optional<List<Customer>> op2 = Optional.of(arr);
       System.out.println(op2.map(cust->cust.get(0).name));
        System.out.println(op2.stream());
    }
}
