gerar(X,X,[X]).
gerar(X,Y,[X|Xs]) :-
    X =< Y,
    Z is X+1,
    gerar(Z,Y,Xs).