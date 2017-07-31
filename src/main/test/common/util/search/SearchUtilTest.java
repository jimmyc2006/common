package common.util.search;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2017年7月30日 下午2:08:40
 * 类说明
 */
public class SearchUtilTest {
    
    @Test
    public void testMatchSuffix() {
        Assert.assertEquals(true, SearchUtil.matchSuffix("aa.java", "java"));
        Assert.assertEquals(false, SearchUtil.matchSuffix("aa.", "java"));
        Assert.assertEquals(true, SearchUtil.matchSuffix("aa.java", "*"));
        Assert.assertEquals(true, SearchUtil.matchSuffix("aa.aa", "*"));
        Assert.assertEquals(true, SearchUtil.matchSuffix("aa.java", null));
        Assert.assertEquals(true, SearchUtil.matchSuffix("aa.java", ""));
        Assert.assertEquals(false, SearchUtil.matchSuffix("aa.java", " "));
        Assert.assertEquals(true, SearchUtil.matchSuffix("D:/dddd.dmdmf/aa.lisp", "lisp"));
        Assert.assertEquals(false, SearchUtil.matchSuffix("D:/dddd.dmdmf/aa.lis", "lisp"));
    }
}
