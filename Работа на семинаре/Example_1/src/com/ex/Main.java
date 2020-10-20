import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

class Main {
    public static Object[] filter(Object[] array, Filter filter) {
        int offset = 0;

        for (int i=0; i< array.length; i++) {
            if (!filter.apply(array[i])){
                offset++;
            }else{
                array[i-offset] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length-offset);
    }

    public static  <T> T[] filter2(T[] array, Function<? super T, Boolean> filter){
        int offset = 0;

        for (int i=0; i< array.length; i++) {
            if (!filter.apply(array[i])){
                offset++;
            }else{
                array[i-offset] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length-offset);
    }

    public static void main(String[] args]){
        String array[] = {"qweqwe","qweqweasd"};
        String newArray[] = (String[]) filter(array, new Filter() {
            @Override
            public boolean apply(Object o) {
                return o == Integer.valueOf(5);
            }
        });
        String newArray2[] = filter2(array, s -> s.lenght() > 5);
        for(int i = 0; newArray2.length() > i;)
    }



}