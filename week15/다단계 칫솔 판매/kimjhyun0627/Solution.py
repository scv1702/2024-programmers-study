def solution(enroll: list, referral: list, seller: list, amount: list) -> list:

    recommend = {}
    profit = {}
    
    for ii in range(len(enroll)):
        recommend[enroll[ii]] = referral[ii]
        profit[enroll[ii]] = 0

    for ii in range(len(seller)):
        cur = seller[ii]
        p = amount[ii] * 100
        profit[cur] += p
        while recommend[cur] != '-':
            if p == 0:
                break
            p //= 10
            profit[cur] -= p
            profit[recommend[cur]] += p
            cur = recommend[cur]
        if recommend[cur] == '-':
            profit[cur] -= (p // 10)

    answer = []
    for e in enroll:
        answer.append(profit[e])
    
    return answer
