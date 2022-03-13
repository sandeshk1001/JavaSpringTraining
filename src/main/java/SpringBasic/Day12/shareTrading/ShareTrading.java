package SpringBasic.Day12.shareTrading;

import java.util.List;

public class ShareTrading {
    private List<String> shareName;
    private Strategy strategy;

    public ShareTrading() {
    }

    public ShareTrading(List<String> shareName, Strategy strategy) {
        this.shareName = shareName;
        this.strategy = strategy;
    }

    public List<String> getShareName() {
        return shareName;
    }

    public void setShareName(List<String> shareName) {
        this.shareName = shareName;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
