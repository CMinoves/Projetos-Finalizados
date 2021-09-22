package planner;

import java.util.HashMap;

/**
 *
 * @author Cristhian Sala Minoves
 */
public class Dia {

    private final HashMap<String, Compromisso> dia;

    public Dia() {
        dia = new HashMap<>();
        String aux = new String();
        for (int x = 9; x < 19; x++) {
            aux = String.valueOf(x);
            Compromisso vazio = new Compromisso(1, "horario livre", x);
            dia.put(aux, vazio);
        }
    }

    public void addCompromisso(int du, String de, int h) {
        Compromisso comp = new Compromisso(du, de, h);
        boolean test = true;
        String string = new String();
        for (int x = h; x < h+du; x++) {
            string = String.valueOf(x);
            if (dia.get(string).getDescricao().equals("horario livre") == false) {
                System.out.println("false");
                test = false;
            }
        }
        if (test == true) {
            for (int x = h; x < h+du; x++) {
            string = String.valueOf(x);
            dia.replace(string, comp);
            }
            System.out.println("Compromisso adicionado com sucesso");
        } else {
            System.out.println("Não foi possível adicionar o compromisso, horário já comprometido");
        }
    }

    public void removerCompromisso(String h) {
        String desc = dia.get(h).getDescricao();
        boolean verifica = false;
        if (desc.equals("horario livre") == true) {
            System.out.println("Não há nenhum compromisso nesse horário");
        } else {
            for (int x = 9; x < 19; x++) {
                String aux = new String();
                aux = String.valueOf(x);
                if (dia.get(aux).getDescricao().equals(desc) == true) {
                    Compromisso vazio = new Compromisso(1, "horario livre", x);
                    dia.replace(aux, vazio);
                    verifica = true;
                }
            }
            if (verifica == true) {
                System.out.println("Compromisso removido com sucesso!");
            }
        }
    }
    public void exibir(){
        String aux = new String();
        for(int x = 9;x<19;x++){
            aux = String.valueOf(x);
            System.out.println(x+":00 -->"+dia.get(aux).getDescricao());
        }
    }
    public void exibirVagos(){
        String aux = new String();
        for(int x = 9;x<19;x++){
            aux = String.valueOf(x);
            if (dia.get(aux).getDescricao().equals("horario livre") == true){
                System.out.println(x+":00 -->"+dia.get(aux).getDescricao());
            }
        }
    }
}
