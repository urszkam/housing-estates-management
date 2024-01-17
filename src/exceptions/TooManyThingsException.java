package exceptions;

public class TooManyThingsException extends Exception{
    public TooManyThingsException() {
            super("\n*Remove some old items to insert a new item*\n");
    }
}
