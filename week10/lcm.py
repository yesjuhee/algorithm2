# 최대공약수 계산
# 유클리드 대제법을 이용한 두 수의 최대공약수 구하기
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# 최소공배수 구하기 (최대공약수 이용)
def lcm(a, b):
    return abs(a * b) // gcd(a, b)

print(lcm(569482193847, 781935476203))