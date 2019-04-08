package bankaccountapp;

public interface IBaseRate {

    //Write a method returns he base rate
    default double getBaseRate(){
        return 2.5;
    }



}
