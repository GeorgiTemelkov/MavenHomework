package com.mentormate;




import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestsNGDemo {

    @DataProvider(name = "AB-sum")
    public Object[][] MethodSum(){ return new Object[][]{{1, 5, 9}, {2, 5, 7}};}

    @DataProvider(name = "AB-subtract")
    public Object[][] MethodSub(){ return new Object[][]{{6, 3, 3}, {5, 2, 4}};}

    @DataProvider(name = "AB-multiplication")
    public Object[][] MethodMul(){ return new Object[][]{{3, 4, 12}, {2, 4, 7}};}

       @DataProvider(name = "AB-division")
    public Object[][] MethodDiv(){ return new Object[][]{{9, 3, 2}, {8, 2, 4}};}


    @DataProvider(name = "AB-modul")
    public Object[][] MethodMod(){ return new Object[][]{{25, 5, 5}, {20, 5, 15}};}



    @Test (dataProvider = "AB-sum", groups = "sum", priority=-1)
    public void sum(int a,int b, int result){
        int sum = a+b;
        System.out.println("Running tests sor addition: ");
        Assert.assertEquals(sum,result);
    }

    @Test(dataProvider = "AB-subtract" , groups = "sub")
    public void subtract(int a,int b, int result){
        int sub = a-b;
        System.out.println("Running tests for subtracting: ");
        Assert.assertEquals(sub,result);
    }

    @Test(dataProvider = "AB-multiplication", groups = "mul")
    public void multiply(int a,int b, int result){
        int mul = a*b;
        System.out.println("Running tests for multiplication");
        Assert.assertEquals(mul,result);
    }

    @Test(dataProvider = "AB-division", groups = "div", priority=1)
    public void divide(int a,int b, int result){
        int div = a/b;
        System.out.println("Running tests for division");
        Assert.assertEquals(div,result);
    }

    @Test(dataProvider = "AB-modul", groups = "mod", priority=2)
    public void modul(int a,int b, int result){
        int mod = a%b;
        System.out.println("Running tests for modulation");
        Assert.assertEquals(mod,result);
    }








}
