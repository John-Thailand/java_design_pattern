import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList observer = new ArrayList();
    public void addObserver(Observer observer) {
        observer.add(observer);
    }
    public void deleteObserver(Observer observer) {
        observer.remove(observer);
    }
    public void notifyObserver() {
        Iterator it = observer.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }
    public abstract int getNumber();
    public abstract void execute();
}