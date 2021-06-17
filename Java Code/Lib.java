package com.aryan;

//import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

//name, studentid, book name, book author, acc no
//usage of vector, inheritance, exception-handling, wrapper classes
//JAVA MICROPROJECT
class myException extends  Exception {

    public String toString(){
        return ("Invalid Admin") ;
    }
}

class IssueBook {
    String fname,lname,bookname,author;
    int accno,stuid;
    Scanner s = new Scanner(System.in);


    void issue(){
        System.out.println("Enter student ID:");
        stuid = Integer.parseInt(s.nextLine());//wrapper class
        System.out.println("Enter First name:");
        fname= s.nextLine();
        System.out.println("Enter Last name:");
        lname= s.nextLine();
        System.out.println("Enter Book name:");
        bookname= s.nextLine();
        System.out.println("Enter Author name:");
        author= s.nextLine();
        System.out.println("Enter Accession no:");
        accno = s.nextInt();

    }

}

class IssuedBook extends IssueBook{ //inheritance

    void display(IssuedBook obj){

        System.out.println("The book issued by "+obj.fname+" "+obj.lname+" with Student ID: "+obj.stuid+" is: ");
        System.out.println(obj.bookname+" by "+obj.author);
        System.out.println("Accession No.:"+obj.accno);
    }
}


public class Lib {

    public static void main(String[] args) {
        IssuedBook[] issueObjects = new IssuedBook[20];

        int flag = 1;
        int j = 0;
        Vector v = new Vector();
        System.out.println("Enter credentials=> "); //Admin Login
        Scanner s = new Scanner(System.in);
        System.out.print("Username: ");
        String s1 = s.nextLine(); //admin //aDMIN //ADMIN //AdMiN
        System.out.print("Password: ");
        String s2 = s.nextLine();
        String s1_lower = s1.toLowerCase();
        String s2_lower = s2.toLowerCase();
        try{

            if(s1_lower.equals("admin")&&s2_lower.equals("admin")){
                System.out.println("\n\n\n******Welcome to the Library Management System******");
            }
            else{
                throw new myException(); //User-defined Exception Handling
            }



            while(true){


                System.out.print("For new record, Press 1\nFor checking records, Press 0 - ");
                flag = s.nextInt();
                if(flag == 1){
                    issueObjects[j] = new IssuedBook();
                    issueObjects[j].issue(); //array of objects
                    v.addElement(issueObjects[j]); //Use of vector
                    j++;

                }
                else{
                    break;
                }

            }

            for(int i=0;i<v.size();i++){
                IssuedBook show = new IssuedBook();
                show.display((IssuedBook) v.elementAt(i));

            }



        }
        catch(myException e){
            System.out.println(e);
        }
        catch(NumberFormatException n){

            System.out.println(n);
        }



    }



}

