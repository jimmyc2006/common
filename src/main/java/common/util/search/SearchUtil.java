package common.util.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * @author shuwei
 * @version 创建时间：2017年7月30日 上午11:07:41 搜索目录下文件中的字符串
 */
public class SearchUtil {

    public static List<FileSearchResult> search(String dir, String searchContent, String suffix,
            boolean isRecursionSearch, String charsetName, boolean isCaseSensitive) {
        List<File> files = findFiles(new File(dir), isRecursionSearch, suffix);
        List<FileSearchResult> results = search(files, searchContent, charsetName, isCaseSensitive);
        return results;
    }

    /**
     * 获取目录下所有文件,递归
     * 
     * @param dir
     * @return
     */
    private static void getFilesRecursion(File dir, final List<File> fileNames, String suffix) {
        if (dir.isFile()) {
            if (matchSuffix(dir.getName(), suffix)) {
                fileNames.add(dir);
            }
        } else {
            // 处理空目录
            if(dir.listFiles() == null) {
                return;
            }
            for (File f : dir.listFiles()) {
                getFilesRecursion(f, fileNames, suffix);
            }
        }
    }

    private static List<File> getFiles(File dir, String suffix) {
        List<File> fileNames = new ArrayList<>();
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                if (!f.isDirectory() && matchSuffix(f.getName(), suffix)) {
                    fileNames.add(f);
                }
            }
        } else {
            if (matchSuffix(dir.getName(), suffix)) {
                fileNames.add(dir);
            }
        }
        return fileNames;
    }

    static boolean matchSuffix(String fileName, String suffix) {
        if (StringUtils.isEmpty(suffix) || "*".equals(suffix)) {
            return true;
        } else {
            String realSuffix = fileName.substring(fileName.lastIndexOf('.') + 1);
            return suffix.equals(realSuffix);
        }

    }

    public static List<File> findFiles(File dir, boolean isRecursion, String suffix) {
        if (isRecursion) {
            List<File> result = new ArrayList<>();
            getFilesRecursion(dir, result, suffix);
            return result;
        } else {
            return getFiles(dir, suffix);
        }
    }

    /**
     * 查询文件中是否匹配某个字符串,如果有匹配的，就返回匹配上的行的列表
     * 
     * @param f 要检查的文件
     * @param searchContent 查询的内容
     * @return 行数列表
     * @throws IOException
     */
    protected static List<LineSearchResult> searchFile(File f, String searchContent, String charsetName,
            boolean isCaseSensitive) throws IOException {
        assert !StringUtils.isEmpty(searchContent);
        List<LineSearchResult> result = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = getBufferedReaderFromFile(f, charsetName);
            String line = br.readLine();
            int lineNumber = 1;
            while (line != null) {
                if (line.contains(searchContent)) {
                    result.add(new LineSearchResult(lineNumber, line));
                } else {
                    if (!isCaseSensitive && line.toUpperCase().contains(searchContent.toUpperCase())) {
                        result.add(new LineSearchResult(lineNumber, line));
                    }
                }
                line = br.readLine();
                lineNumber++;
            }
        } finally {
            try{
                if(br != null) {
                    br.close();
                }
            } catch(Exception e) {
                // pass
            }
        }
        return result;
    }

    private static List<FileSearchResult> search(List<File> files, String searchConent, String charsetname,
            boolean isCaseSensitive) {
        List<FileSearchResult> result = new ArrayList<>();
        for (File f : files) {
            try {
                List<LineSearchResult> fileRes = searchFile(f, searchConent, charsetname, isCaseSensitive);
                if (fileRes.size() > 0) {
                    result.add(new FileSearchResult(f.getPath(), fileRes));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    protected static BufferedReader getBufferedReaderFromFile(File file, String charsetName)
            throws FileNotFoundException {
        if (StringUtils.isEmpty(charsetName)) {
            return new BufferedReader(new FileReader(file));
        }
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName));
        } catch (UnsupportedEncodingException e) {
            // 如果编码有问题，就使用平台默认编码
            return new BufferedReader(new FileReader(file));
        }
    }
    public static void main(String[] args) {
        //List<FileSearchResult> result =  SearchUtil.search("D:/test", "aaa", "txt", true, null, false);
        //System.out.println(result);
    }
}
