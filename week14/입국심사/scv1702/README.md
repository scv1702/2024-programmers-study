# 문제 풀이

## 문제 해설

문제의 조건을 봤을 때 시뮬레이션을 통해 최소값을 찾는 것은 절대 불가능하다. 조건이 터무니 없이 큰 것을 보고 parametric search를 떠올렸다. 정답의 최대값은 심사위원 1명이 심사를 하는데 걸리는 시간이 $10^9$분이고, 심사 대기 인원이 $10^9$명인 경우인 $10^{18}$분이다. 최소값은 $1$분이다. 또한 정답을 $t$라고 했을 때 주어진 시간이 $t$보다 이상인 경우 시간 내 심사가 가능하고 $t$보다 미만인 경우 시간 내 심사가 불가능하기 때문에 parametric search가 가능하다.

```java
public long solution(int n, int[] times) {
    long start = 1;
    long end = pow(10, 18);
    
    while (start <= end) {
        long mid = (start + end) / 2;
        long tp = 0;
        for (int time: times) {
            tp += mid / time;
        }
        if (tp < n) {
            start = mid + 1;
        } else { 
            end = mid - 1;
        }
    }
    
    return start;
}
```

`tp`는 시간 내 최대한 처리 가능한 사람 수를 의미한다. 

## 시간 복잡도

심사관 수를 $m$, 최대 심사 소요 시간을 $a$, 최대 심사 대기 인원을 $b$라고 했을 때 $O(a \times b \times \log{m})$이다.