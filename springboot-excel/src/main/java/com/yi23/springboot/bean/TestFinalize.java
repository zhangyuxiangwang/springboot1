package com.yi23.springboot.bean;

/**
 * 测试finalize
 * 在对象垃圾回收的时候，第一次会调用finalize方法，进行一次挽救的机会，只会调用一次，
 * 第二次就真的被gc了。
 */
public class TestFinalize {

    public static TestFinalize testFinalize = null;


    public  void way(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize--");
        testFinalize=this;
    }

    public static void main(String[] args) throws Exception{
        testFinalize=new TestFinalize();

        testFinalize=null;
        System.gc();

        Thread.sleep(200);

        if(testFinalize==null){
            System.out.println("wo dead le");
        }else{
            testFinalize.way();
        }

        testFinalize=null;
        System.gc();


        if(testFinalize==null){
            System.out.println("wo dead le");
        }else{
            testFinalize.way();
        }


    }
}
