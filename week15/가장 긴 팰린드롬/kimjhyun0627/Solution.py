def solution(s: str) -> int:

    if len(s) == 1 or s == s[::-1]:
        return len(s)
    
    def pointer(left: int, right: int) -> int:
        while 0 <= left and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        
        return len(s[left+1: right])

    answer = 0
    for ii in range(len(s)-1):
        answer = max(answer, pointer(ii, ii), pointer(ii, ii+1))

    return answer
