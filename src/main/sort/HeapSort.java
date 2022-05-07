// 출처: https://hmkim829.tistory.com/9
package main.sort;

public class HeapSort {
	public static void main(String[] args) {
		
		// 미정렬 배열
		int[] arr = { 5, 8, 4, 7, 10, 9, 2, 1, 6, 3 };

		// maxHeap 만들기(부모노드의 값이 자식노드의 값들보다 큰 형태)
		// i의 초기값은 배열의 제일 끝 자식노드의 부모노드부터 시작.
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
		// 초기 힙
		/*
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		*/
		
		int cnt = 1;
		// 정렬
		for (int i = arr.length - 1; i >= 0; i--) {
			// 최상단 노드와 최하단 노드 값을 교환
			swap(arr, i, 0);

			// 루트 노드를 기준으로 최대힙을 만든다
			heapify(arr, i, 0);
			System.out.println(cnt++ + "번째 수행 후");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println("\n");
		}

		// 최종 출력
		System.out.println("최종");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void heapify(int[] arr, int size, int pNode) {
		int parent = pNode; // 부모노드
		int lNode = pNode * 2 + 1; // 왼쪽 자식노드
		int rNode = pNode * 2 + 2; // 오른쪽 자식노드
		int childNode = 0;

		// 자식 노드 중 가장 큰 노드 찾기
		if (size > lNode && size > rNode) {
			childNode = arr[lNode] > arr[rNode] ? lNode : rNode;
		} else if (size > lNode && size <= rNode) {
			childNode = lNode;
		} else if (size <= lNode && size > rNode) {
			childNode = rNode;
		} else { // 자식 노드가 없는 경우
			return;
		}

		// 자식 노드 중 큰 값과 비교
		if (arr[parent] < arr[childNode]) {
			parent = childNode;
		}

		// parent에 저장된 값은 자식노드 중 큰 값이 있다면 큰 값의 인덱스 값이 남아있을 것이다.
		// 초기에 설정한 부모노드의 인덱스와 다르다면 교환한다.
		if (parent != pNode) {
			swap(arr, pNode, parent);

			// 노드와 자리를 바꾸면 최대힙 기준에 맞지 않을 수 있기 때문에
			// 바뀐 자식노드 아래 최대힙으로 맞춰주기 위한 과정 추가
			heapify(arr, size, parent);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}
}