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

class Manager extends Employee{
    private String department;
    private double bonus;
    public String toString(){
        return "Manager{sid='" + getSid() + "', sname='" + getSname() + "', sex='" + getSex() + "', age=" + getAge() + ", department='" + getDepartment() + "', bonus=" + getBonus() + "}";
    }//此处的getSid()等方法是调用父类的get方法获取属性值，因为父类的属性是私有的，子类无法直接访问，所以必须通过父类提供的公共方法来获取属性值。
    @Override
    public void setAge(int age){
        if(age > 25 ){
            System.out.println("false");
        }else{
            super.setAge(age);
        }
    }
    public Manager(String sid, String sname,String sex, int age, String department, double bonus) {
        super(sid, sname, sex, age);//调用父类构造方法，初始化父类属性(必要)
        this.department = department;
        this.bonus = bonus;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
public class homework402 {
    public static void main(String[] args) {
       Employee emp1 = new Employee("E001", "张三", "男", 30);
       System.out.println(emp1.toString());
       Manager m1 = new Manager("E002", "李四", "女", 26, "销售部", 10000.0);
       System.out.println(m1.toString());
    }
}