nelementos([], 0).
nelementos([X | L], S) :- nelementos(L, S1), S is S1+1.