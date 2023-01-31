package DTO;

public class ResultTopJenres<K> {
    private K key;
    private int count;

    public ResultTopJenres(K key) {
        this.key = key;
    }

    public ResultTopJenres(K key, int count) {
        this.key = key;
        this.count = count;
    }

    public K getKey() {
        return key;
    }

    public int getCount() {
        return count;
    }
    public void inc(){
        count++;
    }
    public void dec(){
        count--;
    }

}
