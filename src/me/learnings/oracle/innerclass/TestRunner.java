package me.learnings.oracle.innerclass;



/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 10/06/13
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestRunner {

    static {
        System.out.println("STATIC BLOCK");

    }

    private static class InnerClass{

        static {
            System.out.println("STATIC BLOCK");

        }

        private int innerPrivateVariable;
        public int innerPublicVariable;

        public InnerClass(){
            innerPrivateVariable = 0;
            innerPublicVariable =0;
        }

        public InnerClass(int privateVariable, int publicVariable){
            innerPrivateVariable = privateVariable;
            innerPublicVariable = publicVariable;
        }




    }

    public static void printInnerObject(InnerClass innerClass){
        System.out.printf("%s %s \n", innerClass.innerPrivateVariable, innerClass.innerPublicVariable);
    }

    public void runner(){
        InnerClass innerClass = new InnerClass();
        printInnerObject(innerClass);

        InnerClass innerClass1 = new InnerClass(5,10);
        printInnerObject(innerClass1);
        printInnerObject(innerClass);

        InnerClass2 innerClass21 = new InnerClass2(innerClass);
        InnerClass2 innerClass22 = new InnerClass2(innerClass1);

        innerClass21.printInnerClass2();
        innerClass22.printInnerClass2();
    }

    private static class InnerClass2{

        static {
            System.out.println("STATIC BLOCK");

        }

        private InnerClass innerClass;

        public InnerClass2(){
            innerClass = new InnerClass();
        }

        public InnerClass2(InnerClass ic){
            innerClass = ic;

        }

        public void printInnerClass2(){
            System.out.printf("%s %s innerclass 2\n", innerClass.innerPrivateVariable, innerClass.innerPublicVariable);
        }
    }


    public static void main(String[] args){

        TestRunner tr = new TestRunner();
        tr.runner();


    }


}

//class TestRunner2 extends TestRunner{
//
//    public static void main(String[] args){
//
//        TestRunner tr = new TestRunner();
//        tr.runner();
//
//        InnerClass innerClass = new InnerClass();
//        printInnerObject(innerClass);
//
//        InnerClass innerClass1 = new InnerClass(5,10);
//        printInnerObject(innerClass1);
//        printInnerObject(innerClass);
//
//    }
//
//
//}
