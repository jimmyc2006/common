package common.util.search;

import java.util.List;

/**
 * @author shuwei
 * @version 创建时间：2017年7月30日 下午12:00:06
 * 类说明
 */
public class FileSearchResult {
    // 文件名称
    private String fileName;
    private List<LineSearchResult> matchLines;
    
    public FileSearchResult(String fileName, List<LineSearchResult> matchLines) {
        this.fileName = fileName;
        this.matchLines = matchLines;
    }
    public String getFileName() {
        return fileName;
    }
    public List<LineSearchResult> getMatchLines() {
        return matchLines;
    }
    @Override
    public String toString() {
        return "FileSearchResult [fileName=" + fileName + ", matchLines=" + matchLines + "]";
    }
}