inserirfim(X,[],[X]).
inserirfim(X,[Y|L],[Y|N]) :- inserirfim(X,L,N).

