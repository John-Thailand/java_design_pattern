package meditator;
import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Meditator meditator;
    public ColleagueButton(String caption) {
        super(caption);
    }
    public void setMeditator(Meditator meditator) {
        this.meditator = meditator;
    }
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
