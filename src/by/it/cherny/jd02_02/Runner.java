package by.it.cherny.jd02_02;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Dispatcher dispatcher = new Dispatcher(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("Sosedi"+i, dispatcher, customerQueue);
            store.start();
        }
    }
}
