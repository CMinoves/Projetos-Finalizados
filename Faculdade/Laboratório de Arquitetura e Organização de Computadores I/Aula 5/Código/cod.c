#include<stdio.h>

int g(int x, int y){
int a[32] = {1,2,3,4,32,43,12,98}; // a[8] até a[31] = 0
int i;
for(i = x; i < y; i++){
a[i] = i + y;
}
return(a[i-1]);
}
void main(){
int result = g(31, 34);
printf("Resultado: %i",result);
}