# 입력 예시: 문제 데이터 (n*5 배열 형태) 
# [1, 1, 1, 23, 68] (대단원 / 중단원 / 소단원 / 문제번호 / 중요도(오답률 등))
input_problems = [
    [1, 1, 1, 23, 68], [1, 1, 1, 25, 75], [1, 1, 2, 12, 80],
    [1, 2, 1, 34, 60], [1, 2, 1, 40, 90], [1, 2, 2, 11, 45],
    [2, 1, 1, 18, 55], [2, 1, 2, 17, 77], [2, 2, 1, 29, 85],
    [2, 2, 2, 21, 95], [3, 1, 1, 5, 35], [3, 1, 2, 7, 50]
]

# 1. Divide - 문제들을 대단원, 중단원, 소단원으로 분할
divided = {}
for problem in input_problems:
    main, mid, sub, num, importance = problem
    key = (main, mid, sub)  # 대단원, 중단원, 소단원 키로 사용
    
    if key not in divided:
        divided[key] = []
    
    divided[key].append((num, importance))

# 2. Conquer - 각 소단원에서 중요도가 가장 높은 문제 선택
selected_problems = []
for key, problems in divided.items():
    # 중요도 순으로 문제를 정렬하여 가장 중요한 문제 선택
    problems.sort(key=lambda x: x[1], reverse=True)  # 중요도 기준으로 내림차순 정렬
    most_important_problem = problems[0]  # 중요도가 가장 높은 문제 선택
    main, mid, sub = key
    num, importance = most_important_problem
    
    selected_problems.append([main, mid, sub, num, importance])

# 3. Combine - 선택된 문제들을 결합하여 최종 시험 문제 세트 생성
# 최종 시험지 구성: 대단원 -> 중단원 -> 소단원 순 정렬
selected_problems.sort(key=lambda x: (x[0], x[1], x[2]))

# 최종 시험 문제 세트 출력
print("최종 시험 문제 세트:")
for problem in selected_problems:
    print(f"대단원: {problem[0]}, 중단원: {problem[1]}, 소단원: {problem[2]}, 문제번호: {problem[3]}, 중요도: {problem[4]}")