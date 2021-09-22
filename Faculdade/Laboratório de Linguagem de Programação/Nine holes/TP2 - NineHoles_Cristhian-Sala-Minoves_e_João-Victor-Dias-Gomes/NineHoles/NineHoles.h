#ifndef NINEHOLES_H
#define NINEHOLES_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class NineHoles; }
QT_END_NAMESPACE

class Hole;

class NineHoles : public QMainWindow{
    Q_OBJECT

public:
    NineHoles(QWidget *parent = nullptr);
    int Empty2Selectable();
    void Selectable2Empty();
    void VerificaGanhador();
    void updateStatusBar();
    ~NineHoles();


private:
    Ui::NineHoles *ui;
    Hole* m_holes[9];
    bool RedTurn;
    int stage;
    int plays;
    int hold_id;
    QString stagetxt;
    QString playertxt;


private slots:
    void play(int id);
    void reset();
    void showAbout();

};


#endif // NINEHOLES_H
