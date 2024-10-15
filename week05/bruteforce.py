from itertools import permutations
from itertools import product

'''
숫자 리스트와 연산자 리스트를 받아서 문자열 조합으로 반환하는 함수
'''
def make_expression(num_list, op_list):
    result = ""
    for i in range(n - 1):
        result += num_list[i]
        result += op_list[i]
    result += num_list[n - 1]
    return result

# 입력
n = int(input())
inputs = list(input().split())

# 숫자 조합 생성 (순열)
numbers = []
for num_list in permutations(inputs, n):
    numbers.append(num_list)

# 연산자 조합 생성 (중복 순열)
operators = []
for op_list in product(['+', '-', '*', '/'], repeat=(n - 1)):
    operators.append(op_list)

# 생성한 숫자 조합과 연산자 조합을 모두 조합시켜서 계산
result_list = []
for num_list in numbers:
    for op_list in operators:
        exp = make_expression(num_list, op_list)
        result = eval(exp)
        if (int(result) == result):
            result_list.append(int(result)) # 결과가 정수일 경우만 result_list에 포함시킴

# 결과 출력
result_set = sorted(set(result_list)) # 중복 숫자 제거, 정렬
count_list = [result_list.count(num) for num in result_set] # 각 숫자의 등장 횟수 카운트
print(' '.join(map(str, result_set)))
print(' '.join(map(str, count_list)))
