def solution(n, money):

    dp = [0 for _ in range(n+1)]

    for m in sorted(money):
        for ii in range(m, n+1):
            if ii == m:
                dp[ii] = (dp[ii] + 1) % 1000000007
            else:
                dp[ii] = (dp[ii] + dp[ii-m]) % 1000000007
    
    answer = dp[n]
    return answer
