class Solution {
	public int[] findRedundantConnection(int[][] edges) {
		if (edges == null) {
			return null;
		}
		int[] graph = new int[1001];
		int[] output = null;
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dst = edges[i][1];
			
			int parentSrc = src;
			while (graph[parentSrc] != 0) {
				parentSrc = graph[parentSrc];
			}
			
			int parentDst = dst;
			while (graph[parentDst] != 0) {
				parentDst = graph[parentDst];
			}

			if (parentSrc == parentDst) {
				output = edges[i];
			} else {
				if (parentSrc < parentDst) {
					graph[parentDst] = parentSrc;
				} else {
					graph[parentSrc] = parentDst;
				}
			}
		}
		return output;
	}
}