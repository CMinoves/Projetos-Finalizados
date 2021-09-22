rotacionar(List, R):- rotacionar(List, R1, H), R = [H|R1].
rotacionar([H], [], H).
rotacionar([H|T], L, R) :- rotacionar(T, T1, R), L = [H|T1]. 