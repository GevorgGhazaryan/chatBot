package com.aca.chatBot.helper.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.replaceAll("\\s","");
        int pas1 =0;
        char operator1 = ' ';
        char operator2 = ' ';
        while(pas1<text.length()){
            if(text.charAt(pas1) == '+' || text.charAt(pas1)== '-' || text.charAt(pas1) == '*' || text.charAt(pas1)=='/'){
                operator1 = text.charAt(pas1);
                break;
            }
            pas1++;
        }
        int pas2= pas1+1;
        while(pas2<text.length()){
            if(text.charAt(pas2) == '+' || text.charAt(pas2)== '-' || text.charAt(pas2) == '*' || text.charAt(pas2)=='/'){
                operator2 = text.charAt(pas2);
                break;
            }
            pas2++;
        }
        int Var1 = Integer.parseInt(text.substring(0,pas1));
        int Var2 = Integer.parseInt(text.substring(pas1+1,pas2));
        int Var3 = Integer.parseInt(text.substring(pas2+1,text.length()));
        int result = 0;
        if(operator1 == '*'){
            result = Var1 *Var2;
        }
        if(operator1 == '/'){
            result = Var1 / Var2;
        }
        if(result == 0){
            if(operator2 == '*'){
                result = Var2 *Var3;
            }
            if(operator2 == '/'){
                result = Var2 /Var3;
            }
            if(operator2 == '+'){
                result = Var2 +Var3;
            }
            if(operator2 == '-'){
                result = Var2 -Var3;
            }
            if(operator1 == '+'){
                result += Var1;
            }
            if(operator2 == '-'){
                result -= Var1;
            }
        }
        System.out.println(result);
    }
}
