/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasdaoras;

import java.util.*;


/**
 *
 * @author Cristhian
 */
public class TratarFormas {

    ArrayList<Forma> Formas;

    public TratarFormas() {
        Formas = new ArrayList<>();
    }

    public void Criacao() {
        Scanner input = new Scanner(System.in);
        int op;
        double raio;
        double lado;
        char resp = 's';
        do {
            System.out.println("Vamos criar formas? Digite a opção desejada");
            System.out.println("1-Círculo");
            System.out.println("2-Triâgulo");
            System.out.println("3-Quadrado");
            System.out.println("4-Esfera");
            System.out.println("5-Cubo");
            System.out.println("6-Tetraedro");
            op = input.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Digite o raio do círculo");
                    raio = input.nextDouble();
                    Forma a = new Circulo(raio);
                    Formas.add(a);
                    break;

                case 2:
                    System.out.println("Digite o lado do triângulo");
                    lado = input.nextDouble();
                    Forma b = new Triangulo(lado);
                    Formas.add(b);
                    break;

                case 3:
                    System.out.println("Digite o lado do quadrado");
                    lado = input.nextDouble();
                    Forma c = new Quadrado(lado);
                    Formas.add(c);
                    break;

                case 4:
                    System.out.println("Digite o raio da esfera");
                    raio = input.nextDouble();
                    Forma d = new Esfera(raio);
                    Formas.add(d);
                    break;

                case 5:
                    System.out.println("Digite a aresta do cubo");
                    lado = input.nextDouble();
                    Forma e = new Cubo(lado);
                    Formas.add(e);
                    break;

                case 6:
                    System.out.println("Digite a aresta do tetraedro");
                    lado = input.nextDouble();
                    Forma f = new Tetraedro(lado);
                    Formas.add(f);
            }
            System.out.println("Deseja inserir outra forma?");
            resp = input.next().charAt(0);
        }while(resp == 'S' || resp =='s');
    }
    
    public void AreasVolumes(){
        int x = 1;
        Iterator<Forma> it = Formas.iterator();
        while(it.hasNext()){
            Forma aux = it.next();
            if(aux instanceof Circulo){
                System.out.println("Forma "+x+": "+((Circulo)aux).getNome());
                System.out.println("Área: "+((Circulo)aux).calculoArea());
                System.out.println("Volume: O círculo não tem volume");
            }
            if(aux instanceof Quadrado){
                System.out.println("Forma "+x+": "+((Quadrado)aux).getNome());
                System.out.println("Área: "+((Quadrado)aux).calculoArea());
                System.out.println("Volume: O quadrado não tem volume");            
            }
            if(aux instanceof Triangulo){
                System.out.println("Forma "+x+": "+((Triangulo)aux).getNome());
                System.out.println("Área: "+((Triangulo)aux).calculoArea());
                System.out.println("Volume: O triângulo não tem volume");            
            }
            if(aux instanceof Cubo){
                System.out.println("Forma "+x+": "+((Cubo)aux).getNome());
                System.out.println("Área: "+((Cubo)aux).calculoArea());
                System.out.println("Volume: "+((Cubo)aux).calculoVolume() );            
            }
            if(aux instanceof Esfera){
                System.out.println("Forma "+x+": "+((Esfera)aux).getNome());
                System.out.println("Área: "+((Esfera)aux).calculoArea());
                System.out.println("Volume: "+((Esfera)aux).calculoVolume() );            
            }
            if(aux instanceof Tetraedro){
                System.out.println("Forma "+x+": "+((Tetraedro)aux).getNome());
                System.out.println("Área: "+((Tetraedro)aux).calculoArea());
                System.out.println("Volume: "+((Tetraedro)aux).calculoVolume() );            
            }
            x++;
        }
    }
}
