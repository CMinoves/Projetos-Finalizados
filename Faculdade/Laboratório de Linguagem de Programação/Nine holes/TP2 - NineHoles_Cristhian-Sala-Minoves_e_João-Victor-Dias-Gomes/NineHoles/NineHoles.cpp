#include "NineHoles.h"
#include "ui_NineHoles.h"
#include<QSignalMapper>
#include<QMessageBox>
NineHoles::NineHoles(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::NineHoles){
    ui->setupUi(this);

    this->adjustSize();
    this->setFixedSize(this->size());
    //criacao dos sinais e do map de sinais
    QObject::connect(ui->actionSair,SIGNAL(triggered(bool)),qApp,SLOT(quit()));
    QObject::connect(ui->actionNovo,SIGNAL(triggered(bool)),this,SLOT(reset()));
    QObject::connect(ui->actionAjuda,SIGNAL(triggered(bool)),this,SLOT(showAbout()));
    QSignalMapper *map = new QSignalMapper(this);

    //carregando os holes no map de holes
    for(int id = 0;id<9;id++){
       int r = id/3;
        int c = id%3;
        Hole *hole = this->findChild<Hole*>(QString("hole%1%2").arg(r).arg(c));
        Q_ASSERT(hole!=0);
        m_holes[id] = hole;
        map->setMapping(hole,id);
        QObject::connect(hole,SIGNAL(clicked(bool)),map,SLOT(map()));
    }
    QObject::connect(map,SIGNAL(mapped(int)),this,SLOT(play(int)));
    RedTurn = true;
    stage = 1;
    plays = 0;
    hold_id = -1;
    stagetxt = "Colocar";
    playertxt = "Vermelho";
    updateStatusBar();

}

NineHoles::~NineHoles() {
    delete ui;
}

void NineHoles::updateStatusBar(){
    ui->statusbar->showMessage(QString("Fase de %1. Vez do jogador %2").arg(stagetxt).arg(playertxt));
}

void NineHoles::play(int id){
    Hole *hole = m_holes[id];
    int selectableHoles = 0;

    if(stage == 1){//estagio 1: colocacao das pecas iniciais
        if(hole->state()==Hole::Empty){
            if(RedTurn){
                hole->setState(Hole::Red);
                RedTurn = false;
                plays++;
                playertxt = "azul";
            }else{
                hole->setState(Hole::Blue);
                RedTurn = true;
                playertxt = "vermelho";
                plays++;
            }
          }
        }else{//estagio 2: movimentacao das pecas
            if(RedTurn){
                if(hole->state() == Hole::Red){//aqui será o primeiro estado, o de escolhe de qual peca mover
                    hold_id = id;
                    int sel = Empty2Selectable();
                    if(sel == 1){//quando so tiver uma opcao, a peca vai direta para la
                        for(int i = 0;i<9;i++){
                            if(m_holes[i]->state()==Hole::State::Selectable){
                                m_holes[i]->setState(Hole::State::Red);
                                m_holes[hold_id]->setState(Hole::State::Empty);
                                RedTurn = false;
                                playertxt = "azul";
                            }
                        }
                    }
                }else{
                    if(hole->state()==Hole::Selectable){
                        hole->setState(Hole::Red);
                        m_holes[hold_id]->setState(Hole::Empty);
                        RedTurn = false;
                        playertxt = "azul";
                        Selectable2Empty();
                        hold_id = -1;
                }
                }

            }else{
                if(hole->state() == Hole::Blue){//aqui será o primeiro estado, o de escolhe de qual peca mover
                    hold_id = id;
                    int sel = Empty2Selectable();
                    if(sel == 1){//quando so tiver uma opcao, a peca vai direta para la
                        for(int i = 0;i<9;i++){
                            if(m_holes[i]->state()==Hole::State::Selectable){
                                m_holes[i]->setState(Hole::State::Blue);
                                m_holes[hold_id]->setState(Hole::State::Empty);
                                RedTurn = true;
                                playertxt = "vermelho";
                            }
                        }
                    }
                }else{
                    if(hole->state()==Hole::Selectable){
                        hole->setState(Hole::Blue);
                        m_holes[hold_id]->setState(Hole::Empty);
                        RedTurn = true;
                        playertxt = "vermelho";
                        Selectable2Empty();
                        hold_id = -1;
                }
                }
            }
        }
    if(plays==6){
        stage = 2;
        stagetxt = "movimentar";
    }
    VerificaGanhador();
    updateStatusBar();
}

void NineHoles::reset(){
    for(int id=0;id<9;id++){
        Hole *hole = m_holes[id];
        hole->setState(Hole::Empty);
    }
    stage = 1;
    plays = 0;
    RedTurn = true;
    stagetxt = "colocar";
    playertxt = "Vermelho";
    updateStatusBar();
}



void NineHoles::showAbout() {
    QMessageBox::information(this, tr("Sobre"), tr("Nine Holes\n\nCristhian Sala Minoves - cminoves26@gmail.com \n João Victor Dias Gomes - jaovdg@gmail.com"));
}

void NineHoles::VerificaGanhador(){

    int win = 0;

    for(int i = 0;i<3;i++){//verificando as colunas primeiramente
        if(m_holes[i]->state()==m_holes[i+3]->state() && m_holes[i]->state()==m_holes[i+6]->state() && m_holes[i]->state() != Hole::State::Empty){
            if(m_holes[i]->state() == Hole::State::Red){
                win = 1;
            }else{
                win = 2;
            }
        }
    }
    for(int i = 0;i<7;i+=3){//verificando as linhas
        if(m_holes[i]->state()==m_holes[i+1]->state() && m_holes[i]->state()==m_holes[i+2]->state() && m_holes[i]->state() != Hole::State::Empty){
            if(m_holes[i]->state() == Hole::State::Red){
                win = 1;
            }else{
                win = 2;
            }
        }
    }
    if(win==1){//vitoria do vermelho
        QMessageBox::information(this,tr("Fim de jogo!"), tr("PELA HORDA!\nParabéns, vermelho, você venceu!"));
        reset();
    }else{
        if(win == 2){
            QMessageBox::information(this,tr("Fim de jogo!"), tr("PELA ALIANÇA!\nParabéns, azul, você venceu!"));
            reset();
        }
    }
}

void NineHoles::Selectable2Empty(){
    for(int i = 0;i<9;i++){
        if(m_holes[i]->state()==Hole::State::Selectable){
            m_holes[i]->setState(Hole::State::Empty);
        }
    }
}

int NineHoles::Empty2Selectable(){
    Selectable2Empty();
    int a = 0;
    for(int i = 0;i<9;i++){
        if(m_holes[i]->state()==Hole::State::Empty){
            if(m_holes[i]->col() == m_holes[hold_id]->col()){
                if((m_holes[i]->row()-1)==m_holes[hold_id]->row() ||(m_holes[i]->row()+1)==m_holes[hold_id]->row()){
                    a++;
                    m_holes[i]->setState(Hole::State::Selectable);
                }
            }else{
                if(m_holes[i]->row() == m_holes[hold_id]->row()){
                    if((m_holes[i]->col()-1)==m_holes[hold_id]->col() ||(m_holes[i]->col()+1)==m_holes[hold_id]->col()){
                        a++;
                        m_holes[i]->setState(Hole::State::Selectable);
                    }
            }
        }
    }

}
        return a;
}


