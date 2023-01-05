package Singleton;

public class SingleObject {
    //creating object of this class
    private static SingleObject instance = new SingleObject();
    //making private constructor so the class can't be instanced
    private SingleObject(){}

    //get the only object available

    public static SingleObject getInstance() {
        return instance;
    }
    public void showMessage(){
        System.out.println("Singleton");
    }
}
