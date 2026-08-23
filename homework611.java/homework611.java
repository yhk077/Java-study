import java.sql.*;   
import java.io.*;       
public class homework611 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String filePath = "考试成绩.txt"; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Student_DB?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Score (" +
                                    "id VARCHAR(20) PRIMARY KEY, " +
                                    "name VARCHAR(50), " +
                                    "math DOUBLE, " +
                                    "chinese DOUBLE, " +
                                    "english DOUBLE)";
            stmt.execute(createTableSQL);
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            String insertSQL = "insert into score (id, name, math, chinese, english) values (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; 
                String[] parts = line.split("\\s+");
                if (parts.length < 5) continue;
                String id = parts[0];
                String name = parts[1];
                double math = Double.parseDouble(parts[2]);
                double chinese = Double.parseDouble(parts[3]);
                double english = Double.parseDouble(parts[4]);
                double total = math + chinese + english;
                if (total > 240) {
                    pstmt.setString(1, id);
                    pstmt.setString(2, name);
                    pstmt.setDouble(3, math);
                    pstmt.setDouble(4, chinese);
                    pstmt.setDouble(5, english);
                    pstmt.executeUpdate(); 
                }
            }
            br.close();
            pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { 
                if (stmt != null) stmt.close(); 
            } catch (SQLException e) { e.printStackTrace(); }
            try { 
                if (conn != null) conn.close(); 
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}