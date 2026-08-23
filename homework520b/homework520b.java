import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//接口
class ChooseListener implements ActionListener{
    homework520b frame;
    public ChooseListener(homework520b frame){
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e){
        JCheckBox checkBox = (JCheckBox)e.getSource();
        int total = 0;
        StringBuilder s = new StringBuilder();
        if(frame.apple.isSelected()){
            total += 5;
            s.append("苹果5元\n");
        }
        if(frame.milk.isSelected()){
            total += 8;
            s.append("牛奶8元\n");
        }
        if(frame.bread.isSelected()){
            total += 12;
            s.append("面包12元\n");
        }
        if(s.length() == 0){
            frame.textArea.setText("当前没有选择商品");
            frame.textField.setText("0元");
        }else{
            frame.textArea.setText(s.toString());
            frame.textField.setText(total + "元");
        }
    }
}
//界面
public class homework520b extends JFrame{
    JTextArea textArea = new JTextArea(5,20);
    JTextField textField = new JTextField("0元",10);
    JCheckBox apple = new JCheckBox("苹果(5元)");
    JCheckBox milk = new JCheckBox("牛奶(8元)");
    JCheckBox bread = new JCheckBox("面包(12元)");

    public homework520b(){ 
        super("商品选择结算系统");
        this.setBounds(100,200,400,300);
        this.setLayout(new BorderLayout());   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea.setEditable(false);
        textField.setEditable(false); 
        //写上面三个按钮
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(apple);
        topPanel.add(milk);
        topPanel.add(bread);
        //写下面的输出
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(textArea);
        bottomPanel.add(new JLabel("总价:"));
        bottomPanel.add(textField);
        //调整方向
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);
        //添加监听
        ChooseListener listener = new ChooseListener(this);
        apple.addActionListener(listener);    
        bread.addActionListener(listener);
        milk.addActionListener(listener);
        textArea.setText("当前未选择商品");
        this.setVisible(true);
    }
    //main
    public static void main(String[] args) { 
        homework520b frame = new homework520b();
    }
}