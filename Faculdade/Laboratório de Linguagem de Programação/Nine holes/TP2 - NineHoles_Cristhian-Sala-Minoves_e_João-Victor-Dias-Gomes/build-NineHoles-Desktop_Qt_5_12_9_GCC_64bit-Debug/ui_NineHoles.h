/********************************************************************************
** Form generated from reading UI file 'NineHoles.ui'
**
** Created by: Qt User Interface Compiler version 5.12.9
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_NINEHOLES_H
#define UI_NINEHOLES_H

#include <Hole.h>
#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_NineHoles
{
public:
    QAction *actionNovo;
    QAction *actionSair;
    QAction *actionAjuda;
    QWidget *centralwidget;
    QGridLayout *gridLayout;
    Hole *hole00;
    Hole *hole01;
    Hole *hole02;
    Hole *hole10;
    Hole *hole11;
    Hole *hole12;
    Hole *hole20;
    Hole *hole21;
    Hole *hole22;
    QMenuBar *menubar;
    QMenu *menuJogo;
    QMenu *menuSobre;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *NineHoles)
    {
        if (NineHoles->objectName().isEmpty())
            NineHoles->setObjectName(QString::fromUtf8("NineHoles"));
        NineHoles->resize(300, 344);
        NineHoles->setStyleSheet(QString::fromUtf8("#centralwidget{\n"
"	background: url(':/grid')\n"
"}"));
        actionNovo = new QAction(NineHoles);
        actionNovo->setObjectName(QString::fromUtf8("actionNovo"));
        actionSair = new QAction(NineHoles);
        actionSair->setObjectName(QString::fromUtf8("actionSair"));
        actionAjuda = new QAction(NineHoles);
        actionAjuda->setObjectName(QString::fromUtf8("actionAjuda"));
        centralwidget = new QWidget(NineHoles);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        centralwidget->setMinimumSize(QSize(300, 300));
        centralwidget->setMaximumSize(QSize(300, 300));
        gridLayout = new QGridLayout(centralwidget);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        hole00 = new Hole(centralwidget);
        hole00->setObjectName(QString::fromUtf8("hole00"));
        hole00->setMinimumSize(QSize(100, 100));
        hole00->setMaximumSize(QSize(100, 100));
        hole00->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/empty"), QSize(), QIcon::Normal, QIcon::Off);
        hole00->setIcon(icon);
        hole00->setIconSize(QSize(50, 50));
        hole00->setFlat(true);
        hole00->setProperty("row", QVariant(0));
        hole00->setProperty("col", QVariant(0));

        gridLayout->addWidget(hole00, 0, 0, 1, 1);

        hole01 = new Hole(centralwidget);
        hole01->setObjectName(QString::fromUtf8("hole01"));
        hole01->setMinimumSize(QSize(100, 100));
        hole01->setMaximumSize(QSize(100, 100));
        hole01->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole01->setIcon(icon);
        hole01->setIconSize(QSize(50, 50));
        hole01->setFlat(true);
        hole01->setProperty("row", QVariant(0));
        hole01->setProperty("col", QVariant(1));

        gridLayout->addWidget(hole01, 0, 1, 1, 1);

        hole02 = new Hole(centralwidget);
        hole02->setObjectName(QString::fromUtf8("hole02"));
        hole02->setMinimumSize(QSize(100, 100));
        hole02->setMaximumSize(QSize(100, 100));
        hole02->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole02->setIcon(icon);
        hole02->setIconSize(QSize(50, 50));
        hole02->setFlat(true);
        hole02->setProperty("row", QVariant(0));
        hole02->setProperty("col", QVariant(2));

        gridLayout->addWidget(hole02, 0, 2, 1, 2);

        hole10 = new Hole(centralwidget);
        hole10->setObjectName(QString::fromUtf8("hole10"));
        hole10->setMinimumSize(QSize(100, 100));
        hole10->setMaximumSize(QSize(100, 100));
        hole10->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole10->setIcon(icon);
        hole10->setIconSize(QSize(50, 50));
        hole10->setFlat(true);
        hole10->setProperty("row", QVariant(1));
        hole10->setProperty("col", QVariant(0));

        gridLayout->addWidget(hole10, 1, 0, 1, 1);

        hole11 = new Hole(centralwidget);
        hole11->setObjectName(QString::fromUtf8("hole11"));
        hole11->setMinimumSize(QSize(100, 100));
        hole11->setMaximumSize(QSize(100, 100));
        hole11->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole11->setIcon(icon);
        hole11->setIconSize(QSize(50, 50));
        hole11->setFlat(true);
        hole11->setProperty("row", QVariant(1));
        hole11->setProperty("col", QVariant(1));

        gridLayout->addWidget(hole11, 1, 1, 1, 2);

        hole12 = new Hole(centralwidget);
        hole12->setObjectName(QString::fromUtf8("hole12"));
        hole12->setMinimumSize(QSize(100, 100));
        hole12->setMaximumSize(QSize(100, 100));
        hole12->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole12->setIcon(icon);
        hole12->setIconSize(QSize(50, 50));
        hole12->setFlat(true);
        hole12->setProperty("row", QVariant(1));
        hole12->setProperty("col", QVariant(2));

        gridLayout->addWidget(hole12, 1, 3, 1, 1);

        hole20 = new Hole(centralwidget);
        hole20->setObjectName(QString::fromUtf8("hole20"));
        hole20->setMinimumSize(QSize(100, 100));
        hole20->setMaximumSize(QSize(100, 100));
        hole20->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole20->setIcon(icon);
        hole20->setIconSize(QSize(50, 50));
        hole20->setFlat(true);
        hole20->setProperty("row", QVariant(2));
        hole20->setProperty("col", QVariant(0));

        gridLayout->addWidget(hole20, 2, 0, 1, 1);

        hole21 = new Hole(centralwidget);
        hole21->setObjectName(QString::fromUtf8("hole21"));
        hole21->setMinimumSize(QSize(100, 100));
        hole21->setMaximumSize(QSize(100, 100));
        hole21->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole21->setIcon(icon);
        hole21->setIconSize(QSize(50, 50));
        hole21->setFlat(true);
        hole21->setProperty("row", QVariant(2));
        hole21->setProperty("col", QVariant(1));

        gridLayout->addWidget(hole21, 2, 1, 1, 2);

        hole22 = new Hole(centralwidget);
        hole22->setObjectName(QString::fromUtf8("hole22"));
        hole22->setMinimumSize(QSize(100, 100));
        hole22->setMaximumSize(QSize(100, 100));
        hole22->setStyleSheet(QString::fromUtf8("QPushButton{\n"
"	border: none;\n"
"	outline: none;\n"
"}"));
        hole22->setIcon(icon);
        hole22->setIconSize(QSize(50, 50));
        hole22->setFlat(true);
        hole22->setProperty("row", QVariant(2));
        hole22->setProperty("col", QVariant(2));

        gridLayout->addWidget(hole22, 2, 3, 1, 1);

        NineHoles->setCentralWidget(centralwidget);
        menubar = new QMenuBar(NineHoles);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 300, 22));
        menuJogo = new QMenu(menubar);
        menuJogo->setObjectName(QString::fromUtf8("menuJogo"));
        menuSobre = new QMenu(menubar);
        menuSobre->setObjectName(QString::fromUtf8("menuSobre"));
        NineHoles->setMenuBar(menubar);
        statusbar = new QStatusBar(NineHoles);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        QFont font;
        font.setPointSize(9);
        statusbar->setFont(font);
        NineHoles->setStatusBar(statusbar);

        menubar->addAction(menuJogo->menuAction());
        menubar->addAction(menuSobre->menuAction());
        menuJogo->addAction(actionNovo);
        menuJogo->addAction(actionSair);
        menuSobre->addAction(actionAjuda);

        retranslateUi(NineHoles);

        QMetaObject::connectSlotsByName(NineHoles);
    } // setupUi

    void retranslateUi(QMainWindow *NineHoles)
    {
        NineHoles->setWindowTitle(QApplication::translate("NineHoles", "NineHoles", nullptr));
        actionNovo->setText(QApplication::translate("NineHoles", "Novo", nullptr));
        actionSair->setText(QApplication::translate("NineHoles", "Sair", nullptr));
        actionAjuda->setText(QApplication::translate("NineHoles", "Sobre", nullptr));
        menuJogo->setTitle(QApplication::translate("NineHoles", "Jogo", nullptr));
        menuSobre->setTitle(QApplication::translate("NineHoles", "Ajuda", nullptr));
    } // retranslateUi

};

namespace Ui {
    class NineHoles: public Ui_NineHoles {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_NINEHOLES_H
