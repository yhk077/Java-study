import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

//接口
class CounterListener implements ActionListener {
    homework520a frame; 
    public CounterListener(homework520a frame) {
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton =(JButton) e.getSource();
        if ("加1".equals(clickedButton.getText()) ) {
            frame.function1();
        } else if ("清零".equals(clickedButton.getText())) {
            frame.function2();
        }
    }
}
//界面
public class homework520a extends JFrame {
    JTextField displayField = new JTextField("0", 10);
    JButton plusButton = new JButton("加1");
    JButton clearButton = new JButton("清零");
    int count = 0;
    public homework520a() {
        super("简单计数器");
        this.setBounds(100, 200, 400, 300);
        this.setLayout(new FlowLayout()); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        displayField.setEditable(false); 
        this.add(displayField);
        this.add(plusButton);
        this.add(clearButton);
        CounterListener listener = new CounterListener(this);
        plusButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        displayField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    function1();
            }
        });
        this.setVisible(true); 
    }
    //+1
    public void function1() {
        if (count < 100) {
            count++;
            displayField.setText(String.valueOf(count));
            if (count == 100) {
                JOptionPane.showMessageDialog(this, "计数已达到上限100", "提示", JOptionPane.INFORMATION_MESSAGE);
                plusButton.setEnabled(false);
            }
        }
    }
    //清零
    public void function2() {
        count = 0;
        displayField.setText("0");
        plusButton.setEnabled(true);
    }
    //main
    public static void main(String[] args) {
        homework520a win = new homework520a();
    }
}
