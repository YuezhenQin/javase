public class SegmentTree<E> {
    private E[] tree;
    //将data转换为线段树tree
    private E[] data;
    //定义如何融合区间
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        //n个元素需要开辟长度为 4n 的数组，作为一颗满二叉树
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //在 curr 位置创建表示区间[left,right]的线段树
    private void buildSegmentTree(int curr, int left, int right) {
        if (left == right) {
            tree[curr] = data[left];
            return;
        }

        //创建左右子树
        int leftTree = leftChild(curr);
        int rightTree = rightChild(curr);

        int mid = left + (right - left) / 2;
        buildSegmentTree(leftTree, left, mid);
        buildSegmentTree(rightTree, mid + 1, right);

        tree[curr] = merger.merge(tree[leftTree], tree[rightTree]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) throw new IllegalArgumentException("index out of range.");
        return data[index];
    }

    private int leftChild(int k) {
        return k * 2 + 1;
    }
    private int rightChild(int k) {
        return k * 2 + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length) throw new IllegalArgumentException("index out of range");
        return query(0, 0, data.length -1, queryL, queryR);
    }
    //在以curr为根的线段树中[l..r]的范围内，搜索区间[L..R]的值
    private E query(int curr, int left, int right, int queryL, int queryR) {
        if (left == queryL && right == queryR) return tree[curr];
        int mid = left + (right - left) / 2;
        int leftTree = leftChild(curr);
        int rightTree = rightChild(curr);
        if (queryL >= mid + 1) {
            return query(rightTree, mid + 1, right, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTree, left, mid, queryL, queryR);
        }
        //去左孩子查询
        E leftResult = query(leftTree, left, mid, queryL, mid);
        //去右孩子查询
        E rightResult = query(rightTree, mid + 1, right, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentTree [");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
