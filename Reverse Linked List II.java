class Solution {
public ListNode reverseBetween(ListNode head, int left, int right) {
ListNode r;
ListNode l;
while(left<right) {
l=getVal(head, left);
r=getVal(head, right);
int t=l.val;
l.val=r.val;
r.val=t;
left++;
right--;
}
return head;
}
public ListNode getVal(ListNode head, int idx) {
ListNode temp=head;
for(int i=0; i<idx-1; i++)
temp=temp.next;
return temp;
}
}