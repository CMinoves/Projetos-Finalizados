package planner;

/**
 *
 * @author Cristhian Sala Minoves
 */
public class Compromisso {
    int duracao;
    String descricao;
    int horario;

    public int getDuracao() {
        return duracao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public Compromisso(int duracao, String descrição, int horario) {
        this.duracao = duracao;
        this.descricao = descrição;
        this.horario = horario;
    }

    public int getHorario() {
        return horario;
    }
}

