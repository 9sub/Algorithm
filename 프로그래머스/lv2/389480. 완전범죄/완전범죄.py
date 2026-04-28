def solution(info, n, m):
    total_a = sum(a for a,b in info)
    
    capacity = m
    dp = [-1]*capacity
    dp[0] = 0
    
    for a,b in info:
        for curr_trace in range(capacity-1, -1, -1):
            if dp[curr_trace] == -1:
                continue
            new_trace = curr_trace +b
            if new_trace < capacity:
                dp[new_trace] = max(dp[new_trace], dp[curr_trace]+a)
    max_saving = max(dp)
    
    required = total_a -n+1
    if max_saving < required:
        return -1
    else:
        return total_a - max_saving