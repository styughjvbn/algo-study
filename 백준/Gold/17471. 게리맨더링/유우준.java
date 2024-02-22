import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isSelected;
	static int[] peoples;
	static int[] regionA, regionB;
	static List<List<Integer>> li;
	static int diff = Integer.MAX_VALUE;
	static int min_diff = Integer.MAX_VALUE;
	static boolean is_answer;
	
	// 부분집합을 통해서 분리하고, BFS 탐색을 통해 2개의 지역으로 나눌 수 있는지 확인
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		li = new ArrayList<>();
		for(int i = 0; i <= N; i++) {List<Integer> temp = new ArrayList<>(); li.add(temp);}
		peoples = new int[N + 1];
		isSelected = new boolean[N + 1];
		String str = br.readLine();
		st = new StringTokenizer(str);
		for(int i = 1; i <= N; i++) {
			int people = Integer.parseInt(st.nextToken());
			peoples[i] = people;
		} // 구역의 인구 수 저장
		
		for(int i = 1; i <= N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				int r = Integer.parseInt(st.nextToken());
				li.get(i).add(r); 
			}
		} // 인접행렬을 통해 지역 연결 관계 입력
		
		subset(1);
		if(!is_answer) { System.out.println(-1); } // 만들 수 있는 모든 경우의 부분집합이 2구역으로 나뉘어지지 않을 경우를 체크
		else { System.out.println(min_diff); }
	}

	private static void subset(int index) {
		if(index == N + 1) {
			int A = 0; int B = 0;
			for(int i = 1; i <= N; i++) {
				if(isSelected[i]) {A++;}
				else {B++;}
			}
			
			if(A == 0 || B == 0) {return;} // 2구역 중, 한 구역에 모든 지역이 들어가는 경우는 제외
			
			regionA = new int[A]; regionB = new int[B];
			int idx_A = 0; int idx_B = 0;
			for(int i = 1; i <= N; i++) {
				if(isSelected[i]) {regionA[idx_A++] = i;}
				else {regionB[idx_B++] = i;}
			} // 지역 A,B의 지역번호를 각각에 분리하여 두 배열에 저장
			
			check();
			min_diff = Math.min(min_diff, diff);
			return;
		}
		
		isSelected[index] = true;
		subset(index + 1);
		isSelected[index] = false;
		subset(index + 1);
	}

	private static void check() {
		boolean[] visited = new boolean[N + 1];
		for(int i = 0; i < regionB.length; i++) {
			visited[regionB[i]] = true;
		} // A지역 탐색 중, B 지역 침범을 막기 위해 방문처리
		Queue<Integer> qA = new ArrayDeque<Integer>();
		qA.add(regionA[0]);
		visited[regionA[0]] = true;
		int cnt_A = 0; // A 지역의 인구수
		int qA_cnt = 0; // A 지역이 모두 방문 가능한지 비교하기 위한 변수
		while(!qA.isEmpty()) {
			int front = qA.poll();
			qA_cnt++; cnt_A += peoples[front];
			for(int i = 0; i < li.get(front).size(); i++) {
				if(!visited[li.get(front).get(i)]) {
					visited[li.get(front).get(i)] = true;
					qA.add(li.get(front).get(i));
				}
			}
		}
		if(qA_cnt != regionA.length) {return;} // 지역 A를 위와 같은 경우로 나눌 수 없으므로 리턴
		
		
		visited = new boolean[N + 1];
		for(int i = 0; i < regionA.length; i++) {
			visited[regionA[i]] = true;
		} // B지역 탐색 중, A 지역 침범을 막기 위해 방문처리
		Queue<Integer> qB = new ArrayDeque<Integer>();
		qB.add(regionB[0]);
		visited[regionB[0]] = true;
		int cnt_B = 0; // B 지역의 인구수
		int qB_cnt = 0; // B 지역이 모두 방문 가능한지 비교하기 위한 변수
		while(!qB.isEmpty()) {
			int front = qB.poll();
			qB_cnt++; cnt_B += peoples[front];
			for(int i = 0; i < li.get(front).size(); i++) {
				if(!visited[li.get(front).get(i)]) {
					visited[li.get(front).get(i)] = true;
					qB.add(li.get(front).get(i));
				}
			}
		}
		if(qB_cnt != regionB.length) {return;} // 지역 B를 위와 같은 경우로 나눌 수 없으므로 리턴

		diff = Math.abs(cnt_A - cnt_B);
		is_answer = true; // 한번이라도 구역을 나눌 수 있었다면 true;
	}
}
