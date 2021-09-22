package lista1;

/**
 *
 * @author aluno
 */
public class ArvoreBinaria {
    
    private static class No {
        Item reg;
        No esq, dir;
    }
    
    private No raiz;
    private long comparacoes;

    public ArvoreBinaria() {
        this.raiz = null;
        this.comparacoes = 0;
    }
    
    private No insere(Item reg,No p){
        
        if(p == null){
            this.comparacoes++;
            p = new No();
            p.reg = reg;
            p.esq = null;
            p.dir = null;
        }
        
        else if (reg.compara(p.reg)<0){
            this.comparacoes++;
            p.esq = insere(reg,p.esq);
        }
        
        else if (reg.compara(p.reg)>0){
            this.comparacoes++;
            p.dir = insere(reg,p.dir);
        }
        
        else{
            this.comparacoes++;
            System.out.println("Erro: Registro ja existente");
        }
        
        return p;
    }
    
    private Item pesquisa(Item reg,No p){
       
        if(p==null){
            this.comparacoes++;
            return null;
        }
        else if (reg.compara(p.reg)<0){
            this.comparacoes++;
            return pesquisa(reg,p.esq);
        }
        
        else if(reg.compara(p.reg)>0){
            this.comparacoes++;
            return pesquisa(reg,p.dir);
        }
        else{
            this.comparacoes++;
            return p.reg;
        }
    }
    
    public void insere(Item reg){
    
        this.raiz = this.insere(reg,this.raiz);
    }
    
    public boolean pesquisa(Item reg){
        
        if(pesquisa(reg, raiz)!=null)
            return true;
        else
            return false;
    }
    

    public long getComparacoes() {
        return comparacoes;
    }
    
}
