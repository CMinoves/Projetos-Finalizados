maior([M],M).
maior([X|L],M) :- maior(L,N), (N > X -> M is N; M is X).
