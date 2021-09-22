reverter([],[]).
reverter([X|L],N) :-  reverter(L,L1), concatenar(L1,[X],N).

concatenar([], L, L).
concatenar([X|L1], L2, [X|L3]) :- concatenar(L1, L2, L3).
