package faen.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Support rank, select the Kth smallest key, operations.
public class TreeMap<K extends Comparable<K>, V> {
    private Entry<K, V> root = null;
    private int size = 0;

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    public TreeMap() {
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return getEntry(key) != null;
    }

    public V get(K key) {
        Entry<K, V> p = getEntry(key);
        return (p == null ? null : p.value);
    }

    // base 1
    public K select(int order) {
        if (order <= 0 || order > size)
            return null;
        Entry<K, V> p = root;
        while (true) {
            int left = 1;
            if (p.left != null)
                left += p.left.weight;
            if (left == order) {
                return p.key;
            }
            if (left > order) {
                p = p.left;
            }
            if (left < order) {
                order -= left;
                p = p.right;
            }
        }
    }

    // number of all keys that less than or equal to key.
    public int rank(K key) {
        if (key == null)
            return -1;
        int re = 0;
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = p.key.compareTo(key);
            if (cmp == 0) {
                re += 1;
                if (p.left != null)
                    re += p.left.weight;
                return re;
            } else if (cmp < 0) {
                re += 1;
                if (p.left != null)
                    re += p.left.weight;
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return re;
    }

    /**
     * find the smallest entry which is strictly larger than key
     * 
     * @param key
     * @return
     */
    public Entry<K, V> largeSmall(K key) {
        Entry<K, V> p = root;
        Entry<K, V> res = null;
        while (p != null) {
            int cmp = compare(p.key, key);
            if (cmp > 0) {
                res = p;
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return res;
    }

    /**
     * find the largest entry which is strictly smaller than key
     * 
     * @param key
     * @return
     */
    public Entry<K, V> smallLarge(K key) {
        Entry<K, V> p = root;
        Entry<K, V> res = null;
        while (p != null) {
            int cmp = compare(p.key, key);
            if (cmp < 0) {
                res = p;
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return res;
    }

    private Entry<K, V> getEntry(K key) {
        Entry<K, V> p = root;
        K k = key;
        while (p != null) {
            int cmp = compare(k, p.key);
            if (cmp == 0)
                return p;
            else if (cmp < 0)
                p = p.left;
            else
                p = p.right;
        }
        return null;
    }

    public V put(K key, V value) {
        Entry<K, V> t = root;
        if (t == null) {
            incrementSize();
            root = new Entry<K, V>(key, value, null);
            root.weight = 1;
            return null;
        }
        while (true) {
            int cmp = compare(key, t.key);
            if (cmp == 0) {
                // 发现存在，回退
                while (t.parent != null) {
                    t.parent.weight--;
                    t = t.parent;
                }
                return t.setValue(value);
            } else if (cmp < 0) {
                t.weight++;
                if (t.left != null) {
                    t = t.left;
                } else {
                    incrementSize();
                    t.left = new Entry<K, V>(key, value, t);
                    t.left.weight = 1;
                    fixAfterInsertion(t.left);
                    return null;
                }
            } else { // cmp > 0
                t.weight++;
                if (t.right != null) {
                    t = t.right;
                } else {
                    incrementSize();
                    t.right = new Entry<K, V>(key, value, t);
                    t.right.weight = 1;
                    fixAfterInsertion(t.right);
                    return null;
                }
            }
        }
    }

    public V remove(K key) {
        Entry<K, V> p = getEntry(key);
        if (p == null)
            return null;
        V oldValue = p.value;
        deleteEntry(p);
        return oldValue;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public Iterator<K> iterator() {
        return new KeyIterator();
    }

    private abstract class PrivateEntryIterator<T> implements Iterator<T> {
        private Entry<K, V> lastReturned = null;
        Entry<K, V> next;

        PrivateEntryIterator() {
            next = firstEntry();
        }

        public boolean hasNext() {
            return next != null;
        }

        final Entry<K, V> nextEntry() {
            if (next == null)
                throw new NoSuchElementException();
            lastReturned = next;
            next = successor(next);
            return lastReturned;
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    private class KeyIterator extends PrivateEntryIterator<K> {
        public K next() {
            return nextEntry().key;
        }
    }

    private int compare(K k1, K k2) {
        return ((Comparable<K>) k1).compareTo(k2);
    }

    private static boolean valEquals(Object o1, Object o2) {
        return (o1 == null ? o2 == null : o1.equals(o2));
    }

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public static class Entry<K, V> {
        K key;
        V value;
        int weight = 1;
        Entry<K, V> left = null;
        Entry<K, V> right = null;
        Entry<K, V> parent;
        boolean color = BLACK;

        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Entry))
                return false;
            @SuppressWarnings("rawtypes")
            Entry e = (Entry) o;
            return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
        }

        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    public Entry<K, V> firstEntry() {
        Entry<K, V> p = root;
        if (p != null)
            while (p.left != null)
                p = p.left;
        return p;
    }

    public Entry<K, V> successor(Entry<K, V> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Entry<K, V> p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Entry<K, V> p = t.parent;
            Entry<K, V> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private static <K, V> boolean colorOf(Entry<K, V> p) {
        return (p == null ? BLACK : p.color);
    }

    private static <K, V> Entry<K, V> parentOf(Entry<K, V> p) {
        return (p == null ? null : p.parent);
    }

    private static <K, V> void setColor(Entry<K, V> p, boolean c) {
        if (p != null)
            p.color = c;
    }

    private static <K, V> Entry<K, V> leftOf(Entry<K, V> p) {
        return (p == null) ? null : p.left;
    }

    private static <K, V> Entry<K, V> rightOf(Entry<K, V> p) {
        return (p == null) ? null : p.right;
    }

    /** From CLR * */
    private void rotateLeft(Entry<K, V> p) {
        Entry<K, V> r = p.right;
        r.weight = p.weight;
        p.weight = 1;
        if (p.left != null) {
            p.weight += p.left.weight;
        }
        if (r.left != null) {
            p.weight += r.left.weight;
        }
        p.right = r.left;
        if (r.left != null)
            r.left.parent = p;
        r.parent = p.parent;
        if (p.parent == null)
            root = r;
        else if (p.parent.left == p)
            p.parent.left = r;
        else
            p.parent.right = r;
        r.left = p;
        p.parent = r;
    }

    /** From CLR * */
    private void rotateRight(Entry<K, V> p) {
        Entry<K, V> l = p.left;
        l.weight = p.weight;
        p.weight = 1;
        if (l.right != null)
            p.weight += l.right.weight;
        if (p.right != null)
            p.weight += p.right.weight;
        p.left = l.right;
        if (l.right != null)
            l.right.parent = p;
        l.parent = p.parent;
        if (p.parent == null)
            root = l;
        else if (p.parent.right == p)
            p.parent.right = l;
        else
            p.parent.left = l;
        l.right = p;
        p.parent = l;
    }

    /** From CLR * */
    private void fixAfterInsertion(Entry<K, V> x) {
        x.color = RED;
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Entry<K, V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    if (parentOf(parentOf(x)) != null)
                        rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Entry<K, V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    if (parentOf(parentOf(x)) != null)
                        rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    /**
     * Delete node p, and then rebalance the tree.
     */
    private void deleteEntry(Entry<K, V> p) {
        decrementSize();
        // If strictly internal, copy successor's element to p and then make
        // p
        // point to successor.
        if (p.left != null && p.right != null) {
            Entry<K, V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        } // p has 2 children
          // Start fixup at replacement node, if it exists.
        Entry<K, V> replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {
            // Link replacement to parent
            Entry<K, V> q = p;
            while (q != null) {
                q.weight--;
                q = q.parent;
            }
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left = replacement;
            else
                p.parent.right = replacement;
            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;
            // Fix replacement
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { // No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK)
                fixAfterDeletion(p);
            Entry<K, V> q = p;
            while (q != null) {
                q.weight--;
                q = q.parent;
            }
            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    /** From CLR * */
    private void fixAfterDeletion(Entry<K, V> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Entry<K, V> sib = rightOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }
                if (colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                Entry<K, V> sib = leftOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }
                if (colorOf(rightOf(sib)) == BLACK && colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }
        setColor(x, BLACK);
    }

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(2, "");
        map.put(3, "");
        map.put(4, "");
        map.put(1, "");
        map.put(0, "");
        // the 3rd key is 2
        System.out.println(map.select(3));
        // key 3 is the 4th in ranks of all keys
        System.out.println(map.rank(3));
    }
}