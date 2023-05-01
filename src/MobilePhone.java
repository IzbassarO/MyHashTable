public class MobilePhone {
    private int brandId;
    private int modelId;

    public MobilePhone(int brandId, int modelId) {
        this.brandId = brandId;
        this.modelId = modelId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MobilePhone)) {
            return false;
        }
        MobilePhone other = (MobilePhone) obj;
        return brandId == other.brandId && modelId == other.modelId;
    }

    @Override
    public int hashCode() {
        int result = 29;
        result = 31 * result + brandId;
        result = 31 * result + modelId;
        return result;
    }
}
