#include <stack>

using namespace std;

int getMaxArea(int h[], int n) {
  stack<int> s;
  int max_area = 0;
  int top;
  int area_with_top;

  for (int i = 0; i < n; i++) {
  	/* tim duoc so lon hon max dang co thi se dung so do de tinh */
    if (s.empty() || h[s.top()] <= h[i]) {
      s.push(i);
    } else {
    	
    /* khong thi, so dang xet nho hon max dang co, cap nhat lai dien tich lon nhat */	
    
      top = s.pop();
      area_with_top = h[top] * (i - s.top() - 1);
      max_area = max(max_area, area_with_top);
    }
  }

  while (!s.empty()) {
    top = s.pop();
    area_with_top = h[top] * (i - s.top() - 1);
    max_area = max(max_area, area_with_top);
  }

  return max_area;
}
int main() {
	return 0;
}
