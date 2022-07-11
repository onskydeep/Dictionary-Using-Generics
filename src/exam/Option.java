package exam;

public class Option<T> {

    private T val;

    private Option(T value){
        this.val=value;
    }

    private Option(){
        // mark option as empty
    }

    static <T> Option <T> none(){
        return new Option();
    }

    static <T> Option <T> some (T value){
        return new Option(value);
    }

    public T get() throws EmptyOptionException {
        if(!this.isNone()) return this.val;
        else{
            throw new EmptyOptionException("Returning Option is none!");
        }
    }

    public T getOrDefault(T defaultValue){
        if(!this.isNone()) return this.val;
        else{
            return defaultValue;
        }
    }

    boolean isNone(){
        return(this.val==null);
    }

}
