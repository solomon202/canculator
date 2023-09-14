package ser.Canculytor;

import java.util.Scanner;

//гипотэтический механизм как например блютуз как блок со своими физическими запчастями 
public class Canculytor {
	// поле статично, значит оно принадлежит классу, если метод статичный — аналогично: он принадлежит классу. Исходя из этого, можно обращаться к статическому методу или полю, используя имя класса. Например, если поле count статично в классе Counter, 
	//значит, вы можете обратиться к переменной запросом вида: Counter.count. 
	//Если этого не делать, то значение переменной будет привязываться к объекту, созданному по этому классу разная переменная 
	//обьект который считывает с консоли  
	static Scanner scanner = new Scanner(System.in);
	
	//основа задачи
	//метод запуска
    public static void main( String[] args ){
    	// присваеваем переменной через метод который внутрений и к нему  обращаемся просто через имя а не ссылку
    	 int operand1 = nextInt();
    	 //методы сканера число один число два
         int operand2 = nextInt();
         // + - 
         char operation = getOperation();
         //результат 
        int result = calc(operand1,operand2,operation);
         System.out.println("Результат операции: "+result);
    }
    //сначало запускаются статические методы 
    //метод число и запись его тоесть он пока пуст но после вычеслений получает аргумент 
    public static int nextInt(){
        System.out.println("Введите число:");
        int operand;
     

        //  hasNextInt() - возвращает true если с потока ввода можно считать целое число.
        // и сначало обработка ошибки если все ок то происходит запись 
      //  Метод hasNextLine() проверяет, есть ли другая строка во входных данных 
        if(scanner.hasNextInt()){
            operand = scanner.nextInt();
            
        }
        // или 
        else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operand = nextInt();
        }
        // после манипуляций уже возвращаем методу конкретный ответ
        return operand;
    }
    // метод плюс минус знак метод получает данные в своем внутренм вычеслении
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        //обработка ошибки 
        //Пустые строки в конце ввода не печатаются, то есть функция hasNext() возвращает false для пустых строк .
        if(scanner.hasNext()){
        	//если все ок то 
        	//next()берет первый сивол до пробела charAt(0);выборка символа первого 
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
           // остоется тотже результат 
            operation = getOperation();
        }
        //возвращаем  новый 
        return operation;
    }
  //  метод получает уже имеющися данные из переменных
    public static int calc(int operand1, int operand2, char operation){
        int result;
        switch (operation){
            case '+':
                result = operand1+operand2;
                break;
            case '-':
                result = operand1-operand2;
                break;
            case '*':
                result = operand1*operand2;
                break;
            case '/':
                result = operand1/operand2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(operand1, operand2, getOperation());//рекурсия
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
}
