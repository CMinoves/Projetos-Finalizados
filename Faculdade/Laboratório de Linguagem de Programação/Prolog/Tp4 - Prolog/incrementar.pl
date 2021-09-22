incrementar([] ,[] ).
incrementar([H|T] ,[A|B]) :- soma(H,A),incrementar(T,B).

soma(H,K):- number(H)-> K is H+1; K = H.