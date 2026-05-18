package main.java.coding.reference;

import java.util.*;

public class CheatSheet {

    // String, StringBuilder 사용법
    public void stringUsage() {

        // String (불변 객체)
        String str = "  Hello Java World11!!@";
        System.out.println("[String] " + str);
        System.out.println();

        // 길이 및 특정 인덱스 문자 추출
        System.out.println("길이(length): " + str.length());
        System.out.println("0번째 문자(charAt): " + str.charAt(0));

        // 부분 추출
        System.out.println("부분 추출(substring 6~10): " + str.substring(6, 10));
        System.out.println("부분 추출(substring 6부터 끝까지): " + str.substring(6));
        System.out.println();

        // 검색 및 비교
        System.out.println("'Java' 포함 여부(contains): " + str.contains("Java"));
        System.out.println("'J'의 첫 위치(indexOf): " + str.indexOf("J"));
        System.out.println("'He'로 시작하는지(startsWith): " + str.startsWith("He"));
        System.out.println("'!@'로 끝나는지(endsWith): " + str.endsWith("!@"));
        System.out.println();

        // 치환 및 대소문자 변환
        System.out.println("문자열 치환(replace): " + str.replace("Java", "Spring"));
        System.out.println("소문자로(toLowerCase): " + str.toLowerCase());
        System.out.println("대문자로(toUpperCase): " + str.toUpperCase());
        System.out.println();

        // 정규식을 이용한 치환
        System.out.println("정규식 치환(특수문자 및 숫자 제거): " + str.replaceAll("[^a-zA-Z ]", ""));

        // 기준 문자(공백)로 나누어 배열로 반환
        String[] words = str.split(" ");
        System.out.println("단어 분할(split): " + Arrays.toString(words));

        // 앞뒤 공백 제거
        System.out.println("앞뒤 공백 제거(trim): '" + str.trim() + "'");

        // 문자열을 char[] 배열로 변환 (문자 단위로 정렬하거나 조작할 때)
        char[] charArr = str.toCharArray();
        System.out.println("char 배열 변환(toCharArray): " + Arrays.toString(charArr));

        // char[] 배열을 다시 String으로 변환
        String fromCharArr = new String(charArr);
        // String fromCharArr = String.valueOf(charArr); // 이 방법도 가능
        System.out.println();


        // StringBuilder (가변 객체)
        StringBuilder sb = new StringBuilder("abc");
        System.out.println("[StringBuilder] " + sb);
        System.out.println();

        // String과 사용법 거의 동일
        // contains, split, startsWith, endsWith는 없음 (필요 시 toString 사용)

        // 뒤에 추가
        sb.append("def");
        System.out.println("append('def'): " + sb);

        // 특정 위치에 삽입
        sb.insert(2, "XYZ");
        System.out.println("insert(2, 'XYZ'): " + sb);

        // 특정 위치의 문자 하나 변경
        sb.setCharAt(0, 'A');
        System.out.println("setCharAt(0, 'A'): " + sb);

        // 특정 구간 삭제 (2부터 5 직전까지)
        sb.delete(2, 5);
        System.out.println("delete(2, 5): " + sb);
        System.out.println();

        // 순서 뒤집기
        sb.reverse();
        System.out.println("reverse(): " + sb);
        System.out.println();

        // StringBuilder 길이 확인 및 내부 비우기 (초기화)
        System.out.println("현재 길이: " + sb.length());

        sb.setLength(0);
        System.out.println("setLength(0)으로 초기화 후 길이: " + sb.length());
    }

    // List 사용법
    public void listUsage() {

        // 선언
        ArrayList<Integer> list = new ArrayList<>();  // ArrayList (기본적으로 대부분 사용)
//        LinkedList<Integer> list = new LinkedList<>();  // LinkedList (중간에 삽입, 삭제 할때 사용)

        // 저장(추가)
        list.add(10);
        list.add(35);
        list.add(50);
        list.addFirst(20);  // LinkedList (ArrayList는 Java 21 버전부터 도입)
        list.addLast(30);  // LinkedList (ArrayList는 Java 21 버전부터 도입)
        System.out.println("초기 리스트: " + list);
        System.out.println();

        // 수정
        list.set(1, 40);
        System.out.println("set(1,40): " + list);
        System.out.println();

        // 크기, 조회, 탐색
        System.out.println("size: " + list.size());
        System.out.println("get(1): " + list.get(1));
        System.out.println("getFirst(): " + list.getFirst());  // LinkedList (ArrayList는 Java 21 버전부터 도입)
        System.out.println("getLast(): " + list.getLast());  // LinkedList (ArrayList는 Java 21 버전부터 도입)
        System.out.println("contains(40): " + list.contains(40));
        System.out.println("indexOf(30): " + list.indexOf(30));
        System.out.println();

        // 최대값, 최솟값
        System.out.println("최댓값(max): " + Collections.max(list));
        System.out.println("최솟값(min): " + Collections.min(list));
        System.out.println();

        // 정렬 (오름차순)
        Collections.sort(list);
        System.out.println("오름차순 정렬(sort): " + list);

        // 정렬 (내림차순)
        list.sort(Collections.reverseOrder());
        System.out.println("내림차순 정렬(reverseOrder): " + list);

        // 뒤집기
        Collections.reverse(list);
        System.out.println("순서 뒤집기(reverse): " + list);
        System.out.println();

        // 부분 리스트 추출
        List<Integer> sub = list.subList(1, 3);
        System.out.println("부분 리스트(subList 1~2) : " + sub);
        System.out.println();

        // int[] 배열로 변환
        int[] intArray = list.stream().mapToInt(i -> i).toArray();
        System.out.print("int[] 배열로 변환 : ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 값으로 삭제
        list.remove(Integer.valueOf(40));
        System.out.println("remove(Integer.valueOf(40)): " + list);

        list.remove(1);
        System.out.println("remove(1): " + list);

        // 처음 끝 삭제 (ArrayList는 Java 21 버전부터 도입)
        list.removeFirst();
        list.removeLast();

        // 조건부 삭제 (짝수만 모두 삭제)
        list.removeIf(n -> n % 2 == 0);
        System.out.println("짝수 삭제(removeIf): " + list);

        // 전체 삭제, 비어있는지 체크
        System.out.println("현재 비어있는지(isEmpty): " + list.isEmpty());
        list.clear();
        System.out.println("clear로 전부 삭제 후 isEmpty: " + list.isEmpty());
    }

    // ArrayDeque 사용법 (Queue, Stack, Deque)
    public void arrayDequeUsage() {

        // 선언
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // ==========================================
        // Queue (큐 - 선입선출 FIFO) 방식 : BFS 탐색 등
        // ==========================================
        System.out.println("--- Queue 방식 ---");
        deque.offer(10);
        deque.offer(20);
        deque.offer(30);
        System.out.println("offer(10, 20, 30): " + deque);

        System.out.println("peek() [맨 앞 확인]: " + deque.peek());
        System.out.println("poll() [맨 앞 꺼내기 및 삭제]: " + deque.poll());
        System.out.println("poll() 이후 큐: " + deque);

        deque.clear();
        System.out.println();


        // ==========================================
        // Stack (스택 - 후입선출 LIFO) 방식 : DFS, 괄호 검사 등
        // ==========================================
        System.out.println("--- Stack 방식 ---");
        deque.push(10);  // 스택에 삽입 (맨 앞에 들어감)
        deque.push(20);
        deque.push(30);
        System.out.println("push(10, 20, 30): " + deque);

        System.out.println("peek() [맨 위 확인]: " + deque.peek());
        System.out.println("pop() [맨 위 꺼내기 및 삭제]: " + deque.pop());
        System.out.println("pop() 이후 스택: " + deque);

        deque.clear();
        System.out.println();


        // ==========================================
        // Deque (덱 - 양방향 조작) 방식 : 슬라이딩 윈도우 등
        // ==========================================
        System.out.println("--- Deque 방식 (양끝단 조작) ---");
        deque.offerLast(20);  // 맨 뒤에 삽입
        deque.offerFirst(10);  // 맨 앞에 삽입
        deque.offerLast(30);
        System.out.println("offerFirst(10), offerLast(20, 30): " + deque);

        System.out.println("peekFirst() [맨 앞 확인]: " + deque.peekFirst());
        System.out.println("peekLast() [맨 뒤 확인]: " + deque.peekLast());

        System.out.println("pollFirst() [맨 앞 꺼내기]: " + deque.pollFirst());
        System.out.println("pollLast() [맨 뒤 꺼내기]: " + deque.pollLast());
        System.out.println("양끝 poll 이후 덱: " + deque);
        System.out.println();


        // ==========================================
        // List와 중복되는(공통) 기능들
        // ==========================================
        System.out.println("--- 리스트와 공통 기능 ---");
        deque.offer(40);
        deque.offer(50);

        System.out.println("size() [크기]: " + deque.size());
        System.out.println("isEmpty() [비었는지 체크]: " + deque.isEmpty());
        System.out.println("contains(40) [포함 여부]: " + deque.contains(40));

        deque.clear();
        System.out.println("clear() 이후 isEmpty: " + deque.isEmpty());
    }

    // PriorityQueue (우선순위 큐/힙) 사용법
    public void priorityQueueUsage() {

        // 선언
//        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());  // 최대 힙 - 큰 값이 먼저 나옴
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); // 최소 힙 - 기본값, 작은 값이 먼저 나옴

        pqMin.offer(30);
        pqMin.offer(10);
        pqMin.offer(20);

        // 트리 구조로 저장되기 때문이며, 꺼낼 때만 정렬 순서가 보장
        System.out.println("그냥 출력했을 때 (정렬 보장 안 됨): " + pqMin);
        System.out.println();

        // 큐 상태 확인
        System.out.println("현재 크기(size): " + pqMin.size());
        System.out.println("비어있는지 확인(isEmpty): " + pqMin.isEmpty());
        System.out.println();

        // Min Heap (최소 힙) 으로 테스트
        System.out.println("peek() [루트 값 확인]: " + pqMin.peek());
        System.out.println("poll() [루트 꺼내기]: " + pqMin.poll());
        System.out.println("남은 데이터 poll(): " + pqMin.poll() + " -> " + pqMin.poll());
        System.out.println();

        // 큐 초기화 (모두 비우기)
        pqMin.clear();
        System.out.println("clear() 호출 후 isEmpty: " + pqMin.isEmpty());
        System.out.println();
    }

    // HashSet 사용법
    public void hashSetUsage() {

        // 선언
        HashSet<Integer> set = new HashSet<>();

        // 저장 (추가)
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);  // 중복 삽입 시도 (무시됨)

        System.out.println("초기 셋 (중복 무시, 순서 보장 안 됨): " + set);
        System.out.println();

        // 상태 확인 및 탐색 O(1)
        System.out.println("현재 크기(size): " + set.size());
        System.out.println("10 포함 여부(contains): " + set.contains(10));
        System.out.println();

        // 데이터 삭제 (인덱스가 없으므로 '값'을 넣어서 삭제
        set.remove(10);
        System.out.println("10 삭제 후 셋: " + set);
        System.out.println();

        // 데이터 순회 (인덱스가 없으므로 for문 불가)
        System.out.println("순회: ");
        for (int num : set) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();

        // 전체 비우기
        set.clear();
        System.out.println("clear() 후 isEmpty: " + set.isEmpty());
    }

    // HashMap 사용법
    public void hashMapUsage() {

        // 선언
        HashMap<String, Integer> map = new HashMap<>();

        // 데이터 저장 및 수정
        map.put("사과", 100);
        map.put("바나나", 200);
        map.put("사과", 150);  // 이미 존재하는 키에 put을 하면 값이 수정됨
        map.putIfAbsent("바나나", 1);  // 키가 없을 때만 값을 넣음 (이미 있으면 무시)

        System.out.println("초기 맵: " + map);
        System.out.println();


        // 데이터 조회 및 탐색 (O(1))
        System.out.println("현재 크기(size): " + map.size());
        System.out.println("사과 가격(get): " + map.get("사과"));
        System.out.println("바나나 키 존재 여부(containsKey): " + map.containsKey("바나나"));
        System.out.println("값 150 존재 여부(containsValue): " + map.containsValue(150));  // 시간 복잡도 O(N)

        // 데이터 삭제
        map.remove("바나나");
        System.out.println("바나나 삭제 후: " + map);
        System.out.println();


        // getOrDefault를 이용한 빈도수 계산
        String[] fruits = {"사과", "포도", "사과", "딸기", "포도", "사과"};
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String f : fruits) {
            // f라는 키가 있으면 기존 값에 +1, 없으면 0을 가져와서 +1
            countMap.put(f, countMap.getOrDefault(f, 0) + 1);
        }
        System.out.println("과일 등장 빈도수: " + countMap);
        System.out.println();

        // 데이터 순회
        // entrySet() - 키와 값을 동시에 가장 빠르게 가져올 때
        System.out.println("--- entrySet() 순회 ---");
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println("키: " + entry.getKey() + ", 값: " + entry.getValue());
        }
        System.out.println();

        // keySet() - 키만 필요하거나, 키를 배열로 변환할 때
        System.out.println("--- keySet() 순회 ---");
        for (String key : countMap.keySet()) {
            System.out.println("키: " + key);
        }
        System.out.println();

        // values() - 값만 필요할 때 (예: 빈도수들 중 최댓값 찾기 등)
        System.out.println("--- values() 순회 ---");
        for (int val : countMap.values()) {
            System.out.println("값: " + val);
        }
        System.out.println();

        countMap.clear(); // 전체 비우기
        System.out.println("clear 후 isEmpty: " + countMap.isEmpty());
    }
}
