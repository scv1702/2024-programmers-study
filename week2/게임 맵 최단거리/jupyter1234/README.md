  # 문제 풀이

## 문제 해설
bfs방식을 사용하여 해결하였다. 
<br> 시작점으로부터 동,서,남,북 방향으로 이동 가능하기에 지도 내에서 이동할 수 있는 칸은 탐색하였다.

<br> visited라는 방문 여부를 체크할 수 있는 배열을 생성하였고 해당 칸을 방문할 때마다 체크 하였다.

<p> 각 칸의 거리는 모두 동일하게 1이기에 map에 현재 위치까지 거리를 두었고 다음칸으로 갈 때는 해당 칸에 +1를 하여 최종 목적지에선 maps에 저장된 거리를 출력하였다.
<br> 만약 목적지까지 도착하지 못하는 경우라면 1이 저장되어 있을 것이다.  (n과 m 모두가 1인 경우는 존재하지 않으니깐)
그럴경우엔 -1를 반환한다.

## 시간 복잡도
$$O(m * n)$$