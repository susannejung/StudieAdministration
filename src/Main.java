import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Skole skole=new Skole();

        indlaesStuderendeFraFil(skole);
        indlaesFagFraFil(skole);
        indlaesLaererFraFil(skole);

       /* ArrayList<Studerende> liste;
        liste=skole.getStuderendeListe();
        for(int i=0;i<liste.size();i++)
            System.out.println(liste.get(i));

        ArrayList<Fag> liste1;
        liste1=skole.getFagListe();
        for(int i=0;i<liste1.size();i++)
            System.out.println(liste1.get(i));

        ArrayList<Laerer> liste2;
        liste2=skole.getLaererListe();
        for(int i=0;i<liste2.size();i++)
            System.out.println(liste2.get(i));*/

        skole.tilmeldLaererFag(1,1);
        skole.tilmeldLaererFag(2,2);
        skole.tilmeldLaererFag(3,3);
        skole.tilmeldStuderendeFag(1,1);
        skole.tilmeldStuderendeFag(1,2);
        skole.tilmeldStuderendeFag(1,3);
        skole.tilmeldStuderendeFag(2,1);
        skole.tilmeldStuderendeFag(2,2);
        skole.tilmeldStuderendeFag(3,1);
        udskrivStuderendeFagListe(skole,1);
        udskrivFagKlasseliste(skole,1);
        udskrivFagKlasseliste(skole,3);
        skole.frameldStuderendeFag(1,3);
        udskrivStuderendeFagListe(skole,1);
        udskrivFagKlasseliste(skole,3);
        udskrivFagKlasseliste(skole,2);
        skole.frameldStuderendeFag(2,2);
        udskrivStuderendeFagListe(skole,2);
        udskrivFagKlasseliste(skole,2);



    }

    public static void indlaesStuderendeFraFil(Skole skole) throws FileNotFoundException {
        File fil=new File("studerende.txt");
        Scanner scanner=new Scanner(fil);
        int n;
        String f,e,a,p,m,x;
        char k;
        while(scanner.hasNext()){
            n=scanner.nextInt();
            f=scanner.next();
            e=scanner.next();
            a=scanner.next();
            p=scanner.next();
            m=scanner.next();
            x=scanner.next();
            k=x.charAt(0);
            Studerende s=new Studerende(n,f,e,a,p,m,k);
            skole.tilmeldStuderendeSkole(s);
        }

    }

    public static void indlaesFagFraFil(Skole skole) throws FileNotFoundException {
        File fil=new File("fag.txt");
        Scanner scanner=new Scanner(fil);
        int nr;
        String fnavn;
        while(scanner.hasNext()){
            nr=scanner.nextInt();
            fnavn=scanner.next();
            Fag fag=new Fag(nr,fnavn);
            skole.tilmeldFagSkole(fag);
        }

    }

    public static void indlaesLaererFraFil(Skole skole) throws FileNotFoundException {
        File fil=new File("laerer.txt");
        Scanner scanner=new Scanner(fil);
        int n;
        String f,e,a,p,m;
        while(scanner.hasNext()){
            n=scanner.nextInt();
            f=scanner.next();
            e=scanner.next();
            a=scanner.next();
            p=scanner.next();
            m=scanner.next();
            Laerer l=new Laerer(n,f,e,a,p,m);
            skole.tilmeldLaererSkole(l);
        }
    }

    public static void udskrivStuderendeFagListe(Skole skole,int stdnr){
        System.out.println();
        System.out.print("Studerende: ");
        Studerende s=skole.getStuderende(stdnr);
        System.out.println(s);
        System.out.println("Går til følgende fag: ");
        System.out.println(s.getFagListe());
    }

    public static void udskrivFagKlasseliste(Skole skole,int fagnr){
        System.out.println();
        System.out.print("Faget: ");
        Fag f=skole.getFag(fagnr);
        System.out.println(f);
        System.out.println("Har følgende deltagere: ");
        System.out.println(f.getKlasseListe());
    }
}