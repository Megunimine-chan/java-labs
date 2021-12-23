public class Tuple implements Comparable<Tuple>{

    private String first;
    private Integer distinctCount;

    public Tuple(String first, int distinctCount) {
        this.first = first;
        this.distinctCount = distinctCount;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getDistinctCount() {
        return distinctCount;
    }

    public void setDistinctCount(int distinctCount) {
        this.distinctCount = distinctCount;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.distinctCount.compareTo(o.distinctCount);
    }
}
