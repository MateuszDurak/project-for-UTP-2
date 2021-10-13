package Zad3_1;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {

    List<T> list;



    ListCreator(List<T> list) {
        this.list = list;
    }





    public static <T> ListCreator<T> collectFrom(List<T> list){

        return new ListCreator<>(list);
    }

    public List<T> mapEvery(Function<T, T> fun){
        List<T> res = new ArrayList<>();
        for (T t : this.list) {

            res.add(fun.apply(t));

        }
        this.list = res;

        return this.list;
    }

    public ListCreator<T> when(Predicate<T> pre){
        List<T> res = new ArrayList<>();

        for (T t : this.list) {

            if(pre.test(t)){
                res.add(t);
            }
        }
        this.list = res;
        return this;
    }




}