import java.util.*;
public class AtmIInterface {
    public static Scanner  sc = new Scanner(System.in);
    public static ArrayList<String> list= new ArrayList<>();

    //to display the last transaction--->> trans funnction
    public static void transac (int balance){
        for (String i: list) {
            System.out.println(i);
        }
        ask(balance);
    } 
    public static void login(String username, int pin){
        if(username.contains ("test") && pin == 0000){
            list.add("logged in");
            ask(10000);


        }
        else{
            System.out.println("Enter valid info");
            login(sc.next(),sc.nextInt());

        }
    }
 
public static void withdraw(int balance,int amount){
    if(amount <= balance && amount>=0){
        balance -= amount;
        System.out.println("current balance is tesr :" +balance);
        list.add("Ruppes"+ amount +"withdrawn.");
        ask(balance);
    }else{
        System.out.println("insufficient balance");
        withdraw(balance,sc.nextInt());

    }
}
    public static void deposit(int balance,int amount){
        if(amount>=0){
            balance+= amount;
        System.out.println("transaction successful"+ balance);
        list.add(amount +"money deposited");
        ask(balance);
        }else {
            System.out.println("enter a valid amount");
            deposit(balance,sc.nextInt());
        }
    }
    //transfer function allow -- amount condition check jisko bhejna h acc no lnge  balnce ko update msg show krnge phir list m transaction add krnge or ask balance kr dnhge else same rhega
   
    public static void transfer(int balance,int amount){
        if((amount<=balance) && (amount>=0)){
            System.out.print("Enter reciver's name: ");
            String accname = sc.next();
            balance -= amount;
            System.out.println(amount+ "ruppes sent to" + accname);
            System.out.println("transaction succesful & your current balance is "+ balance);

        list.add(amount+ " transfered to account "+ accname);
        ask(balance);    
        } else{
            System.out.print("Enter a valid amount");
            transfer(balance,sc.nextInt());
        }
    }
    // quit
    public static void quit(int balance, char qresponse){

        if(qresponse =='y'|| qresponse=='Y'){
            System.out.println("\\\\logged out\\\\");
            System.out.println();
        }else{
            ask(balance);
        }
    }
    public static void ask(int bal){
        System.out.println();
        System.out.println("1-> Transaction History");
        System.out.println("2->Withdraw");
        System.out.println("3-> Deposit");
        System.out.println("4-> Transfer");
        System.out.println("5-> Quit");
        System.out.println("choose the following option");
        int opt = sc.nextInt();
        System.out.println();
        if(1>opt || opt>5){
            System.out.println("enter valid input");
            ask(bal);

        }
        else {
            switch(opt){
                case 1:
                System.out.println("...Transaction history...");
       transac(bal);
       break;
       case 2:
       System.out.println("...enter amount to be withdrawn...");
       withdraw(bal, sc.nextInt());
       break;
       case 3 :
       System.out.println("...enter amount to be deposit...");
       deposit(bal,sc.nextInt());
       break;
       case 4:
       System.out.print("..enter amount to transfer..");
       transfer(bal,sc.nextInt());
       break;
       case 5:
       System.out.println("...do you want to exit?(Y/n)...");
       char qresponse= sc.next().charAt(0);
       quit(bal,qresponse);
       break;
        }
        
            }
            



    }
    public static void main (String []args){
        System.out.println();
        System.out.println("Use username as 'test' and pin as 0000 for testing");
        System.out.println("enter your username");
        String username = sc.next();
        System.out.print("enter pin");
        int pin = sc.nextInt();
        login(username,pin);

    }

 }


