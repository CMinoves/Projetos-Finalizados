adjacente(X,Y,[X,Y|_]).
adjacente(X,Y,[N,R|L]) :- adjacente(X,Y,[R|L]).
