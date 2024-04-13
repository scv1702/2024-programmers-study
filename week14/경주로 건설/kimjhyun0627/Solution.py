from collections import deque

def solution(board: list):
    
    direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    def bfs(board: list, dir: int):
        cost = [[1e9 for _ in range(len(board))] for _ in range(len(board))]
        cost[0][0] = 0
        
        queue = deque()
        queue.append((0, 0, 0, dir))
        
        while queue:
            x, y, c, d = queue.popleft()
            
            if x == len(board)- 1  and y == len(board) - 1:
                continue
            for ii in range(4):
                new_x = x + direction[ii][1]
                new_y = y + direction[ii][0]
                new_d = ii

                if new_x < 0 or new_x >= len(board) or new_y < 0 or new_y >= len(board):
                    continue
                if board[new_x][new_y] == 1:
                    continue
                
                if new_d == d:
                    new_c = c + 100
                else:
                    new_c = c + 600
                    
                if new_c < cost[new_x][new_y]:
                    cost[new_x][new_y] = new_c
                    queue.append((new_x, new_y, new_c, new_d))
            
        return cost[-1][-1]
        
    answer = min(bfs(board, 1), bfs(board, 3))
    return answer
