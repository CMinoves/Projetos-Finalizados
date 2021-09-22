package planner;

/**
 *
 * @author Cristhian Sala Minoves
 */
public class Semana {
    Dia [] semana;
    String[] s;
    public Semana(){
     semana = new Dia[5];
     Dia segunda = new Dia();
     Dia terca = new Dia();
     Dia quarta = new Dia();
     Dia quinta = new Dia();
     Dia sexta = new Dia();
     semana[0] = segunda;
     semana[1] = terca;
     semana[2] = quarta;
     semana[3] = quinta;
     semana[4] = sexta;
     s = new String[5];
     s[0] = "Segunda-feira";
     s[1] = "Terça-feira";
     s[2] = "Quarta-feira";
     s[3] = "Quinta-feira";
     s[4] = "Sexta-feira";
    }
    public void exibir(int x){
        if(x!=6){
            System.out.println(s[x-1]);
            semana[x-1].exibir();
        }else{
            for(int y = 0;y<5;y++){
                System.out.println(s[y]);
                semana[y].exibir();
            }
        }
    }
    public void adicionar(int day, int du, String de, int h){
        semana[day-1].addCompromisso(du, de, h);
    }
    public void remover(int day, int h){
        String aux = String.valueOf(h);
        semana[day-1].removerCompromisso(aux);
    }
    public void exibirVagos(){
        for(int x = 0;x<5;x++){
            System.out.println(s[x]);
            semana[x].exibirVagos();
        }
    }
}
