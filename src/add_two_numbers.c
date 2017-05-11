#include<stdlib.h>
#include<stdbool.h>

struct ListNode{
  int val;
  struct ListNode *next;
};

//IN-PLACE SOLUTION O(a) SPACE, WHERE a IS THE NUMBER OF NODES FOR LONGER LIST
//RUNTIME O(b) WHERE b IS THE SIZE OF LONGER LISTS

struct ListNode *addTwoNumbers(struct ListNode *list1, struct ListNode *list2){
  int remainder = 0;
  struct ListNode *head = list1;
  struct ListNode *prev = list1;

  while(list1){
    if(!list1->next && (list2 ? list2->next : 0)){
      list1->next = list2->next;
      list2->next = NULL;
    }

    int value = list1->val + (list2 ? list2->val : 0) + remainder;
    list1->val = value % 10;
    remainder = value/10;

    prev = list1;
    list1 = list1->next;
    list2 = list2 ? list2->next : NULL;
  }

  if(remainder){
    prev->next = (struct ListNode *) malloc(sizeof(struct ListNode));
    prev->next->val = 1;
    prev->next->next = NULL;
  }

  return head;
};


