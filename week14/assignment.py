# 입력

# 교사의 상담 가능한 시간 입력
print("교사의 상담 가능 시간대를 입력하세요 (예: 9 10 11 13 14 15):")
teacher_times = list(map(int, input().split()))
# 학생 정보 입력
num_students = int(input("학생 수를 입력하세요: "))
students = []
for _ in range(num_students):
    print("\n학생 정보를 입력하세요:")
    name = input("이름: ")
    duration = int(input("상담 시간 (시간 단위로 입력): "))
    requested_times = list(map(int, input("요청 시간대 (시간별로 공백으로 구분하여 입력): ").split()))
    priority = int(input("우선순위 (높을수록 우선): "))
    students.append({
        'name': name,
        'duration': duration,
        'requested_times': requested_times,
        'priority': priority
    })
    
# 상담 시간 배정
schedule = {}
# 우선순위가 높은 순으로 학생 정렬
students.sort(key=lambda x: -x['priority'])
# 교사의 남은 상담 가능 시간 목록
available_times = teacher_times.copy()
for student in students:
    assigned = False
    # 학생이 요청한 시간대 중 가능한 시간 배정
    for time in student['requested_times']:
        if time in available_times:
            schedule[student['name']] = time
            available_times.remove(time)
            assigned = True
            break
    if not assigned:
        # 요청 시간대에 배정 불가 시, 가장 가까운 시간대에 배정
        if available_times:
            closest_time = min(available_times, key=lambda x: min([abs(x - t) for t in student['requested_times']]))
            schedule[student['name']] = closest_time
            available_times.remove(closest_time)
        else:
            # 배정 가능한 시간이 없을 경우
            schedule[student['name']] = None

# 출력
print("\n상담 일정 배정 결과:")
for student in students:
    name = student['name']
    time = schedule[name]
    if time is not None:
        print(f"학생 {name}: {time}시에 상담 배정됨")
    else:
        print(f"학생 {name}: 상담 시간을 배정할 수 없습니다.")
