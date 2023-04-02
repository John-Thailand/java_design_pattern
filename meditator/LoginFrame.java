package meditator;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends Frame implements ActionListener, Meditator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;
    
    // コンストラクタ
    // Colleague たちを生成し、配置した後に表示を行う
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        // レイアウトマネージャを使って4x2のグリッドを作る
        setLayout(new GridLayout(4, 2));
        // Colleagueたちの生成
        createColleagues();
    }
    // Coleague たちを生成する
    public void createColleagues() {
        // 生成
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // Meditatorのセット
        checkGuest.setMeditator(this);
        checkLogin.setMeditator(this);
        textUser.setMeditator(this);
        textPass.setMeditator(this);
        buttonOk.setMeditator(this);
        buttonCancel.setMeditator(this);
        // Listenerのセット
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleagueからの通知で各Colleagueの有効/無効を判定する
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            if (checkGuest.getState()) {
                textUser.setColleagueEnabled(false);
                textPass.setColleagueEnabled(false);
                buttonOk.setColleagueEnabled(true);
            } else {
                textUser.setColleagueEnabled(true);
                userpassChanged();
            }
        }
    }

    // textUser または textPassの変更があった
    // 各Colleagueの有効/無効を判定する
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
    
}
