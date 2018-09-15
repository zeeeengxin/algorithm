package leetcode;
import java.util.*;

public class LRUCache<K, V> {
    Map<K, Node<K, V>> map;
    Node<K, V> head, tail;
    int capacity, size;
    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be zero!");
        }
        map = new HashMap<K, Node<K, V>>();
        this.capacity = capacity;
        head = new Node<K, V>(null,null);
        tail = new Node<K, V>(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> cur = map.get(key);
        if (cur == null) {
            return null;
        } else {
            remove(cur);
            insert(cur);
        }
        return cur.value;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = map.get(key);
        if (newNode != null) {
            newNode.value = value;
            remove(newNode);
        } else {
            newNode = new Node<K, V>(key, value);
            map.put(key, newNode);
            if (size == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            } else {
                size++;
            }
        }
        insert(newNode);
    }
    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        Node (K k, V v) {
            key = k;
            value = v;
        }
    }
    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    private void insert(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
}
