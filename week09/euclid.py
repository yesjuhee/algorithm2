# 최대공약수 계산
# 유클리드 대제법을 이용한 두 수의 최대공약수 구하기
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# 입력
a, b = map(int, input().split())

# 출력
print(f"gcd: {gcd(a, b)}")