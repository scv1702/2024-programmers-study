def solution(sequence):

    p1 = [sequence[ii] * ((-1) ** ii) for ii in range(len(sequence))]
    p2 = [sequence[ii] * ((-1) ** (ii+1)) for ii in range(len(sequence))]

    dp1 = [0 for _ in range(len(sequence))]
    dp2 = [0 for _ in range(len(sequence))]

    for ii in range(len(sequence)):
        dp1[ii] = max(dp1[ii], dp1[ii-1] + p1[ii])
        dp2[ii] = max(dp2[ii], dp2[ii-1] + p2[ii])

    answer = max(max(dp1), max(dp2))
    return answer
