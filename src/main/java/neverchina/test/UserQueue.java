package neverchina.test;
import java.lang.reflect.Array;
import java.util.Arrays;

public class UserQueue<E> {
    E[] arr;
    int head = -1;
    int tail = -1;
    int size;

    public UserQueue(Class<E> c, int size) {
        E[] newInstance = (E[]) Array.newInstance(c, size);
        this.arr = newInstance;
        this.size = 0;
    }

    /**
     * 向队列中添加元素
     *
     * @return boolean
     */
    boolean push(E e) {
        if (size == arr.length) {
            return false;
        }
        head = (head + 1) % arr.length;
        arr[head] = e;
        size++;
        if (tail == -1) {
            tail = head;
        }

        return true;
    }

    /**
     * 清空队列
     *
     * @return boolean
     */
    boolean clear() {
        if (size == 0) {
            return true;
        }
        arr = null;
        return true;
    }

    /**
     * 删除头部元素
     */
    boolean pop() {
        if (size == 0) {
            return false;
        }

        E result = arr[tail];
        arr[tail] = null;
        size--;
        tail = (tail + 1) % arr.length;
        if (size == 0) {
            head = -1;
            tail = -1;
        }

        return true;
    }

    /**
     * 获取队列的头部元素
     */
    E peek() {
        if (size == 0) {
            return null;
        }
        return arr[tail];
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}
