import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class example extends JFrame {
    public example() {
        //设置窗口属性
        this.setTitle("JDBC");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);//创建滚动面板
        this.add(scrollPane);

        //1.加载JDBC数据库驱动软件
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载驱动（可省略）
            //定义连接信息（地址，用户，密码）
            String url = "jdbc:mysql://localhost:3306/school_db?useSSL=true&serverTimezone=CST";
            String user = "root";
            String password = "123456";

            //2.建立连接数据库
            // DriverManager 是 JDBC 的管理类，getConnection 会尝试连接数据库
            Connection con = DriverManager.getConnection(url,user,password); 
            
            //3.执行SQL语句，查询数据
            String sql = "select * from student";
            
            Statement stmt = con.createStatement(); 
             //创建statement
             // con.createStatement() 创建一个用于发送 SQL 语句的对象

            ResultSet rs = stmt.executeQuery(sql);    
            //4.执行sql指令，返回结果集
            
            //5.准备表格
            DefaultTableModel model = new DefaultTableModel();
            
            ResultSetMetaData meta = rs.getMetaData();  //获取表结构
            int columnCount = meta.getColumnCount();
            //System.out.println(coloumnCount+"列");

            //获取列名
            String [] columnNames = new String[columnCount];
            for(int i=1;i<=columnCount;i++) {
                columnNames[i-1] = meta.getColumnName(i);
            }
            model.setColumnIdentifiers(columnNames);
            
            //6.处理遍历结果集
            while(rs.next()) {
                Object[] row = new Object[columnCount];
                for(int i=1;i<=columnCount;i++) {
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            table.setModel(model);
            rs.close();
            stmt.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败");
        }

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new example();
    }
}