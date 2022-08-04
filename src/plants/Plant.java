package plants;

public abstract class Plant {

    private boolean bitten = false;

    public boolean isBitten() {
        return bitten;
    }

    public void setBitten(boolean bitten) {
        this.bitten = bitten;
    }


}
