package leetcode.problems;

import java.util.*;

public class FlattenNestedListIterator {

    public static void main(String[] args) {
        FlattenNestedListIterator iterator = new FlattenNestedListIterator();
        List<NestedInteger> outer = new ArrayList<>();
        outer.add(iterator.createNestedInteger(1, 1));
        outer.add(iterator.createNestedInteger(2));
        outer.add(iterator.createNestedInteger(1, 1));

        NestedIterator nestedIterator = new NestedIterator(outer);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }

    }

    private NestedInteger createNestedInteger(int integer) {
        return new NestedInteger(integer);
    }

    private NestedInteger createNestedInteger(int... integers) {
        NestedInteger nestedInteger = new NestedInteger();
        for (int integer : integers) {
            nestedInteger.addInteger(integer);
        }
        return nestedInteger;
    }

}

class NestedInteger {
    Integer i;
    List<NestedInteger> list;

    public NestedInteger() {
        i = null;
        list = new ArrayList<>();
    }

    public NestedInteger(int i) {
        this.i = i;
        this.list = new ArrayList<>();
    }

    public NestedInteger(List<NestedInteger> list) {
        this.i = null;
        this.list = list;
    }

    public void addInteger(int i) {
        this.list.add(new NestedInteger(i));
    }

    public void addNestedInteger(NestedInteger integer) {
        this.list.add(integer);
    }

    public int getInteger() {
        return i;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public boolean isInteger() {
        return i != null;
    }

    @Override
    public String toString() {
        return "NestedInteger{" +
                "i=" + i +
                '}';
    }
}

class NestedIterator implements Iterator<Integer> {
    Queue<NestedInteger> queue = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        load(nestedList);
    }

    private void load(List<NestedInteger> nestedIntegers) {
        for (NestedInteger integer : nestedIntegers) {
            if (integer.isInteger()) {
                queue.add(integer);
                continue;
            }
            load(integer.getList());
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        return queue.poll().getInteger();
    }
}