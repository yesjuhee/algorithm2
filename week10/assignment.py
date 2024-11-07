# 청소 주기 자동 생성 프로그램

# 최대공약수 계산
# 유클리드 대제법을 이용한 두 수의 최대공약수 구하기
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# 세 수의 최대공약수 구하기
def gcd_of_three(x, y, z):
    # 먼저 x와 y의 최대공약수를 구하고, 그 결과를 z와 다시 gcd로 구함
    return gcd(gcd(x, y), z) 

# 최소공배수 계산
# 최소공배수 구하기 (최대공약수 이용)
def lcm(a, b):
    return abs(a * b) // gcd(a, b)

# 세 수의 최소공배수 구하용
def lcm_of_three(x, y, z):
    # x와 y의 최소공배수를 구하고 그 결과와 z의 최소공배수를 구함
    return lcm(lcm(x, y), z)

# 입력 : 방 청소 주기, 화장실 청소 주기, 분리수거 주기
# ex: 3 6 9
print("방 청소 주기, 화장실 청소 주기, 분리수거 주기를 띄어쓰기로 구분하여 입력해주세요")
room, bathroom, recycle = map(int, input().split())

# 출력
print(f"공통 청소 주기는 {lcm_of_three(room, bathroom, recycle)}일 입니다.")



