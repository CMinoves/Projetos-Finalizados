nelementos([], 0).
nelementos([X | L], S) :- nelementos(L, S1), S is S1+1.

soma([], 0).
soma([X | L], S) :- soma(L, S1), S is X+S1.

medio(L,M):- soma(L,S), nelementos(L,X), M is S/X.
