import java.util.Scanner;
public class Algorithms {

    public static void main(String[] args) {

        int[] m = new int[10];
        System.out.println("Был создан массив состоящий из 10 элементов");
        Creat(m);
        See(m);
        System.out.println("Выберите какую сортировку использовать?");
        System.out.println(" 1 - Selection sort; 2 - Gnome sort; 3 - Cocktail sort");
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt()) {
            int t = sc.nextInt();
            if (t == 1) {
                System.out.println(" Selection sort");
                Select(m);
                See(m);

            }
            if (t == 2){
                System.out.println(" Gnome sort");
                Gnome(m);
                See(m);
            }
            if (t == 3){
                System.out.println(" Cocktail sort");
                Cocktail(m);
                See(m);
            }
            if ((t != 1) & (t != 2) & (t != 3)){
                System.out.println("В данный момент имеется только три сортировки с номерами 1,2,3 ");
            }
        }
        else {
            System.out.println("Выбрать нужно из трёх вариантов! ");
        }




    }

    public static void Creat(int n[]){ // создать массив

        for (int i=0; i < n.length; i++) {
            n[i] = (int)(Math.random() * 10);
        }
    }

    public static void See(int n[]){ //смотреть массив
        for(int i=0; i < n.length; i++) {
            System.out.print(n[i]+"  ");
        }
        System.out.println(" ");
    }

    public static void Select(int n[]) { // сортировкой selection sort
        int min, mini, z;
        for (int i = 0; i < n.length; i++) {
            min = n[i];
            mini = i;
            for (int j = i + 1; j < n.length; j++) {
                if (n[j] < min) {
                    min = n[j];
                    mini = j;
                }
            }
            if (i != mini) {
                z = n[i];
                n[i] = n[mini];
                n[mini] = z;
            }
        }
    }

    public static void Gnome(int n[]){
        int max;
        for(int i = n.length-1 ; i > 0; i--) {
            for(int j = 0; j < i ; j++){
                if (n[j] > n[j+1]){
                    max = n[j];
                    n[j] = n[j+1];
                    n[j+1] = max;
                }
            }
        }
    }

    public static void Cocktail(int n[]){
        int min = 0, max = n.length-1;
        do {
            for(int i = min; i < max; i++){
                if (n[i] > n[i+1]){
                    n[i] ^= n[i+1];
                    n[i+1] ^= n[i];
                    n[i] ^= n[i+1];
                }
            }max--;
            for(int i = max; i > min; i--){
                if (n[i] < n[i-1]){
                    n[i] ^= n[i-1];
                    n[i-1] ^= n[i];
                    n[i] ^= n[i-1];
                }
            }min++;
        }while(min <= max);
    }
}

