def solution(n, k):
    service = 2000
    service_count = 0
    def sum(n, k): return 12000*n + 2000*k
    
    service_count = n // 10
        
    result = sum(n,k) - service_count * service
    
    return result