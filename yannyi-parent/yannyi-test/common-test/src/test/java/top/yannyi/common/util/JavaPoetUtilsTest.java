package top.yannyi.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yannyi.common.CommonTestApplication;
import top.yannyi.util.poet.JavaPoetUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LeahAna
 * @Date: 2023/5/23 15:31
 * @Desc:
 */

@SpringBootTest(classes = CommonTestApplication.class)
public class JavaPoetUtilsTest {
    @Test
    public void testCreateEntitiesFromXlsx() throws Exception {
//        JavaPoetUtils.createEntitiesFromXlsx(PoetTable.class,PoetColumn.class,"top.yannyi.model","src/test/resources/data/test.xlsx","./");
    }
}

@PoetTable(
        value = "Site"
)
 class SiteEntity {
    @PoetColumn("名称")
    private String name;

    @PoetColumn("全局名称")
    private String fullName;

    @PoetColumn("所属区域")
    private String parZone;

    @PoetColumn("简称")
    private String abbrName;
}



/**
 * @Author: LeahAna
 * @Date: 2023/5/23 15:24
 * @Desc: 表格行
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PoetColumn {
    /**
     * 例：
     * @PoetColumn("名称")
     * private String name;
     */
    String value();
}
/**
 * @Author: LeahAna
 * @Date: 2023/5/23 15:24
 * @Desc: 表格sheet名
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface PoetTable {
    /**
     * 例：
     * @PoetTable("xxx")
     * public class xxxEntity{}
     */
    String value();
}

