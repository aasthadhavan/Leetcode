class Solution {
    int[][] a;
    int[] nxt;
    Node[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[1], y[1]);
        });

        nxt = new int[n];

        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int h = n;

            while (l < h) {
                int m = l + (h - l) / 2;

                if (a[m][0] > a[i][1]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }

            nxt[i] = l;
        }

        memo = new Node[n][5];

        Node ans = solve(0, 4);

        Collections.sort(ans.indices);

        return ans.indices.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private Node solve(int i, int k) {
        if (i == a.length || k == 0) {
            return new Node(0, new ArrayList<>());
        }

        if (memo[i][k] != null) {
            return memo[i][k];
        }

        Node skip = solve(i + 1, k);

        Node next = solve(nxt[i], k - 1);

        Node take = new Node(
                (long) a[i][2] + next.weight,
                new ArrayList<>(next.indices)
        );

        take.indices.add(a[i][3]);

        if (take.weight > skip.weight) {
            memo[i][k] = take;
        } else if (take.weight < skip.weight) {
            memo[i][k] = skip;
        } else {
            Collections.sort(take.indices);
            Collections.sort(skip.indices);

            if (isSmaller(take.indices, skip.indices)) {
                memo[i][k] = take;
            } else {
                memo[i][k] = skip;
            }
        }

        return memo[i][k];
    }

    private boolean isSmaller(List<Integer> x, List<Integer> y) {
        int n = Math.min(x.size(), y.size());

        for (int i = 0; i < n; i++) {
            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i);
            }
        }

        return x.size() < y.size();
    }

    class Node {
        long weight;
        List<Integer> indices;

        Node(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
}
