package meditator;
import java.awt.TextField;
import java.awt.Color;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Meditator meditator;
    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }
    public void setMeditator(Meditator meditator) {
        this.meditator = meditator;
    }
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }
    public void textValueChanged(TextEvent e) {
        meditator.colleagueChanged();
    }
}
