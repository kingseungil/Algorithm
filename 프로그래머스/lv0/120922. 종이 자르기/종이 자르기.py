def solution(M, N):
    # N-1+N(M-1) = M-1+M(N-1) = MN-1
    count = M*N-1 
    return count