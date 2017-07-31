package common.util.search;
/**
 * @author shuwei
 * @version 创建时间：2017年7月30日 下午1:35:31
 * 类说明
 */
public class LineSearchResult {
    private int lineNumber;
    private String content;
    public LineSearchResult(int lineNumber, String content) {
        this.lineNumber = lineNumber;
        this.content = content;
    }
    public int getLineNumber() {
        return lineNumber;
    }
    public String getContent() {
        return content;
    }
    @Override
    public String toString() {
        return "LineSearchResult [lineNumber=" + lineNumber + ", content=" + content + "]";
    }
}
