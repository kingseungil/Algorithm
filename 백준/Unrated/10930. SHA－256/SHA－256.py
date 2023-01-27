import sys
import hashlib
input = sys.stdin.readline().strip()

result = hashlib.sha256(input.encode())
print(result.hexdigest())
