/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Main {
    public static void main(String[] args) {
        PlayWindow playWindow = new PlayWindow();
        Thread thread = new Thread(playWindow);
        thread.start();
    }
}
