#include <limits.h>

int reverse(int x){
  long long result;
  for(result=0; x; x=x/10)
    result = x%10 + result*10;
  return (result < INT_MAX && result > INT_MIN) ? result : 0;
}

int main(){
  return reverse(7331) == 1337;
}
