package appUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;import java.io.*;
public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;
    private static String excelPath = ConfigReader.getExcelfile();
    public static void createExcelFile() {
        File file = new File(excelPath);
        if (!file.exists()) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Results");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("TestName");
            header.createCell(1).setCellValue("Status");
            header.createCell(2).setCellValue("Message");

            try (FileOutputStream fos = new FileOutputStream(excelPath)) {
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  public static void writeResult(String testName, String status, String message) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Results");

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(rowCount + 1);

            row.createCell(0).setCellValue(testName);
            row.createCell(1).setCellValue(status);
            row.createCell(2).setCellValue(message);

            fis.close();

            FileOutputStream fos = new FileOutputStream(excelPath);
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
