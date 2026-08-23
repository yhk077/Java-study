class Employee {
private String sid;
private String sname;
private String sex;
private int age;

public Employee(String sid, String sname, String sex, int age) {
     this.sid = sid;
     this.sname = sname;
     this.sex = sex;
     this.age = age;
 }   
 public String getSid() {
     return sid;
 }   
 public String getSname() {
     return sname;
 }   
 public String getSex() {
     return sex; 
 }
 public int getAge() {
     return age;
}
public void setSid(String sid) {
    this.sid = sid;
}
public void setSname(String sname) {
    this.sname = sname;
}
public void setSex(String sex) {
    this.sex = sex;
}
public void setAge(int age) {
    this.age = age;
}
public String toString() {
        return "Employee{sid='" + sid + "', sname='" + sname + "', sex='" + sex + "', age=" + age + "}";
    }
}

public class homework3162 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("E001", "张三", "男", 30);
        /*System.out.println(emp1.getSid());
        System.out.println(emp1.getSname());
        System.out.println(emp1.getSex());
        System.out.println(emp1.getAge());*/
        System.out.println(emp1.toString());   
        }
}
