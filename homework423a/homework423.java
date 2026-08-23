class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void showInfo(){
        System.out.println("姓名："+ name +";"+"年龄："+age);
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
interface Payable{
    double getSalary();
}
class Teacher extends Person implements Payable{
    protected double baseSalary;
    public Teacher(String name,int age,double baseSalary){
        super(name,age);
        this.baseSalary = baseSalary;
    }
    public double getSalary(){
        return baseSalary+1000;
    }
    public void showInfo(){
        System.out.println("姓名："+ getName()+";"+"年龄："+getAge()+"基本工资："+baseSalary);
    }
}
public class homework423{
    public static void main (String[] args){
        Teacher A = new Teacher("LiHua", 25,10000);
        A.showInfo();
        System.out.println("工资:"+A.getSalary());
    }
}