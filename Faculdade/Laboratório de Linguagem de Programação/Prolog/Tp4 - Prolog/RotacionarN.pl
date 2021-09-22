rotacionarn(0,L,L).
rotacionarn(_,[],[]).
rotacionarn(X,[Y|L],Z) :- inserirfim(Y,L,N), X1 is X - 1,rotacionarn(X1,N,Z).

concatenar([], L, L).
concatenar([X|L1], L2, [X|L3]) :- concatenar(L1, L2, L3).

remover(X,[X|L],L).
remover(X, [Y|L], [Y|N]) :- X \== Y, remover(X,L,N).

inserirfim(X, [], [X]).
inserirfim(X,[Y|L],[Y|N]) :- inserirfim(X,L,N).
