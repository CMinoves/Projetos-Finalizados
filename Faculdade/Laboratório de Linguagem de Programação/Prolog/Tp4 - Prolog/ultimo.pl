ultimo([X], X).
ultimo([X | L], S) :- ultimo(L, S1), S is S1.