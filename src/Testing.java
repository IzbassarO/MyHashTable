public class Testing {
    private int key;

    public Testing(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Testing)) {
            return false;
        }
        Testing other = (Testing) obj;
        return key == other.key;
    }

    @Override
    public int hashCode() {
        int result = 21;
        result = 31 * result + key;
        return result;
    }

}
