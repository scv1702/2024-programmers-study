# 문제 풀이

## 문제 해설
옷의 종류마다 개수를 dictionary 자료형에 저장해준다.
<br> 선택할 수 있는 모든 경우의 수는 각 갯수 + 1 의 곱들이다. 그러나 문제의 조건에서 아무것도 안 입는 경우는 없으니깐 곱들의 합에 1을 빼주면 모든 경우의 수를 구할 수 있다.

## 시간 복잡도
O(V)