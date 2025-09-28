import java.io.*;
import java.util.Scanner;

class SAE {

    Scanner in = new Scanner(System.in);

    public static int numJourInfinit = 0;
    public static int nbSemaine = 0;

    int[] jours_mois = {31,29,31,30,31,30,31,31,30,31,30,31};
    int[] jours_mois_b = {31,28,31,30,31,30,31,31,30,31,30,31};

    void genererCompteurJours(int j, int m, int a){ // nathan & jabir
        int cp = 0;
        if(a%4==0 && a%100 !=0 || a%400 == 0){
             for(int i = 0; i<m;i++){
                if(i==m-1){
                    int tem = 0;
                    while(tem<j){
                    cp++;
                    tem++;
                }
            }
            else{
                cp += jours_mois_b[i];
            }
            }
            int rest = 366-cp;
        System.err.println("il c'est ecoulais : " + cp);
        System.err.println("il reste : " + rest);

        }
        else{
            for(int i = 0; i<m;i++){
                if(i==m-1){
                    int tem = 0;
                    while(tem<j){
                        cp++;
                        tem++;
                    }
                }
                else{
                    cp += jours_mois[i];
                }
            }
            int rest = 365-cp;
        
        System.err.println("il c'est ecoulais : " + cp);
        System.err.println("il rest : " + rest );
        //nathan
        }
    }

    void genererLigne(int finDuMois) { // malik

        System.out.println("<ul>");

        for(int nbjours=1; nbjours<=finDuMois; nbjours++) {
            System.out.println("<li>");



            switch ((numJourInfinit-1)%7) { // malik & nathan
                case 0:
                    System.out.println("<li class\"lundi\"> Lun");
                    break;
                case 1:
                    System.out.println("<li> Mar");
                    break;
                case 2:
                    System.out.println("<li> Mer");
                    break;
                case 3:
                    System.out.println("<li> Jeu");
                    break;
                case 4:
                    System.out.println("<li> Ven");
                    break;
                case 5:
                    System.out.println("<li class='samedi'> Sam");
                    break;
                case 6:
                    System.out.println("<li class='dimanche'>D" );
                    break;
           }

           numJourInfinit++;

            System.out.println(nbjours);

            System.out.println("</li>");
        };

        for(int r = finDuMois; r<31;r++) { // jabir
            System.out.println("<li class='off'> x </li>");
        }

        System.out.println("</ul>");
    }

    void genererColonne(int annee) { // malik

        int infinitude=1; // malik

        for(int i=1; i<annee;i++) {

            if ((i%4 == 0 && i%100!=0) || i%400==0 ) {
                infinitude+=366;
            } else infinitude+=365;

        }

        numJourInfinit += infinitude;

        for(int nbMonth=1; nbMonth<=12; nbMonth++) { // jabir
            if (nbMonth >= 7) {
                
            }
            if (nbMonth == 2) {

                if ((annee%4 == 0 && annee%100!=0) || annee%400==0 ) {
                    genererLigne(29);
                }else {
                    genererLigne(28);
                }

            }else {

                if (nbMonth >= 8) {
                    if (nbMonth%2 == 0) {
                        genererLigne(31);
                    } else { genererLigne(30); }
                } else {

                    if (nbMonth%2 != 0) {
                        genererLigne(31);
                    } else { genererLigne(30); }

                }
            }
        }

    }

    void genererCSS() { // jabir & malik
        System.out.println("<style>");
        System.out.println(" * { padding : 0; margin : 0;} ");
        System.out.println("h1 { text-align: right; }");
        System.out.println("div { display: flex; justify-content: space-between;}");
        System.out.println("ul { width: calc(100% / 12); display: block; justiy-content: space-between; list-style-type: none;}");
        System.out.println(" ul.month li { text-align: center; color: blue;} ");
        System.out.println("li { width: calc(100%); font-weight: 800 ;text-align: left, padding-block: 15px;}");
        System.out.println(" li.samedi { background : #eee;}");
        System.out.println(" li.dimanche { background : #6fd7ff;}");
        System.out.println("span { text-align: right;}");
        System.out.println("</style>");
    }

    void genererCalendrier(int a) { // nathan

        System.out.println("<!DOCTYPE html>\n" + //
                        "<html lang=\"fr-FR\">\n" + //
                        "  <head>\n" + //
                        "    <meta charset=\"UTF-8\" />\n" + //
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" + //
                        "    <title>Calendrier</title>\n" + //
                        "  </head>\n" + //
                        "  <body>\n" + //
                        "<h1> Calendrier : " + (a-1+1) + "</h1>\n" + //
                        " <div> \n" + //
                        " <ul class=\"month\" style=\" width: 100% ;display: flex; font-size: larger;\"> \n" + //
                        " <li>Janvier</li> \n" + //
                        " <li>Février</li> \n" + //
                        " <li>Mars</li> \n" + //
                        " <li>Avril</li> \n" + //
                        " <li>Mai</li> \n" + //
                        " <li>Juin</li> \n" + //
                        " <li>Juillet</li> \n" + //
                        " <li>Aôut</li> \n" + //
                        " <li>Septembre</li> \n" + //
                        " <li>Octobre</li> \n" + //
                        " <li>Novembre</li> \n" + //
                        " <li>Décembre</li> \n" + //
                        "</ul> \n" + //
                        "</div>");

        System.out.println("<div >");


        genererColonne(a);

        genererCSS();

        System.out.println("</div>");
    }

    void run() {

        System.err.print("Quel annee ? :");
        int ask = in.nextInt();

        genererCalendrier(ask);
    }

    public static void main(String[] args) {
        new SAE().run();
    } 
}