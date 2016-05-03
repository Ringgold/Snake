public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        new Thread(handler).start();
    }
}
