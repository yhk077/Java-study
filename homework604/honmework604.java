import java.sql.*;
public class QueryHighPriceProducts {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
           //请同学们补全此处缺失的代码

            //1.驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "123456";

            //2.连接数据库
            conn = DriverManager.getConnection(url, user, password);
            
            //3.创建Statement
            Statement stmt = conn.createStatement();

            //4.SQL
            String sql = "select * from products where price > (select AVG(price) from products) order by price desc";
            //select 字段 from 表 where 条件 order by 字段 desc/asc
            //符合某个条件的记录，按照某个字段降序/升序排列

            //5.执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(sql);
            
            //6.遍历结果集，输出
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                System.out.printf("产品ID: %d, 名称: %s, 价格: %.2f, 类别: %s\n",id,name,price,type);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("未找到JDBC驱动！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接或查询出错！");
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}