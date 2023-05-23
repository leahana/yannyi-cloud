package top.yannyi.util.poet;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LeahAna
 * @Date: 2023/5/9 09:23
 * @Desc: 读取xlsx文件 以第一列中文为注解value，第二列小驼峰为字段值 生成java类
 */

public class JavaPoetUtils {


    public static String createEntitiesFromXlsx(Class<? extends Annotation> poetTable, Class<? extends Annotation> poetColumn,
                                                String packageName, InputStream inputStream) throws Exception {

        List<String> list = new ArrayList<>();
        // 读取表格数据
        Workbook workbook = WorkbookFactory.create(inputStream);
        // 遍历所有Sheet
        for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            // 解析Sheet并生成Java实体类
            TypeSpec entity = parseSheetAndCreateEntity(sheet, poetTable, poetColumn);
            JavaFile javaFile = JavaFile.builder(packageName, entity).build();
            list.add(javaFile.toString());
        }
        return String.join("\n", list);
    }

    private static TypeSpec parseSheetAndCreateEntity(Sheet sheet, Class<? extends Annotation> poetTable, Class<? extends Annotation> poetColumn) {
        String sheetName = sheet.getSheetName();
        // 读取第一行数据用于封装类名
        Row row = sheet.getRow(0);
        String className = getStringCellValue(row.getCell(0));
        // 类注解
        AnnotationSpec poetTableAnnotation = AnnotationSpec.builder(poetTable)
                .addMember("value", "\"" + sheetName + "\"")
                .build();
        // 生成实体类
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(className + "Entity")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Data.class)
                .addAnnotation(poetTableAnnotation)
                .addJavadoc("<p>" + sheetName + "</p>\n");

        // 读取后续行的数据并生成字段
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            String column1 = getStringCellValue(row.getCell(0));
            String column2 = toCamelCase(getStringCellValue(row.getCell(1)));
            String column3 = getStringCellValue(row.getCell(2));
            String column4 = getStringCellValue(row.getCell(3));

            // 属性注解
            AnnotationSpec annotation = AnnotationSpec.builder(poetColumn)
                    .addMember("value", "\"" + column1 + "\"")
                    .build();
            FieldSpec fieldSpec = FieldSpec.builder(ConvertMapCache.getClassFromName(column3), column2, Modifier.PRIVATE)
                    .addAnnotation(annotation)
                    .addJavadoc(column4 + "\n")
                    .build();
            typeSpecBuilder.addField(fieldSpec);
        }

        return typeSpecBuilder.build();
    }

    private static String getStringCellValue(Cell cell) {
        return cell == null ? "" : cell.getStringCellValue();

    }

    private static String toCamelCase(String s) {
        if (s.contains("_")) {
            String[] parts = s.split("_");
            StringBuilder camelCaseString = new StringBuilder(parts[0].toLowerCase());
            for (int i = 1; i < parts.length; i++) {
                camelCaseString.append(parts[i].substring(0, 1).toUpperCase());
                camelCaseString.append(parts[i].substring(1).toLowerCase());
            }
            return camelCaseString.toString();
        } else {
            return s.toLowerCase();
        }
    }

}
