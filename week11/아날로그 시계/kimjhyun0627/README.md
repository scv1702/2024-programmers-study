  # 문제 풀이

## 문제 해설

***구현***

1. 시간을 모두 초 단위로 바꾼다. 이때 12시와 24시를 지날 때 시침과 분침이 겹치므로 answer++ 해준다.
2. 시 - 분 - 초침의 현재 위치와 1초 후의 각도를 모두 구해준다.
3. 1초 사이에 시침과 초침 사이 혹은 분침과 초침 각도가 뒤집어졌다면(??? 뭔지 이해했으리라 생각합니다) answer++해준다. 이때 초침이 시침과 분침 모두와 겹칠 수 있으므로 이를 고려해 answer-=1 해준다.

## 시간 복잡도

$$O(diff(t1, t2))$$

