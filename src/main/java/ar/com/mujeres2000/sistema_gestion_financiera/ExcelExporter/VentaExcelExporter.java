package ar.com.mujeres2000.sistema_gestion_financiera.ExcelExporter;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Venta;
 
public class VentaExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Venta> listaVentas;

    public VentaExcelExporter(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "venta_id", style);      
        createCell(row, 1, "cantidad", style);       
        createCell(row, 2, "costo_variable_venta", style);    
        createCell(row, 3, "fecha", style);
        createCell(row, 4, "importe", style);
        createCell(row, 5, "producto_id", style);  
         
    }
    
    
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
      
        sheet.autoSizeColumn(columnCount);
        
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer && value.toString() !=null) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);

        } else if (value instanceof Double && value.toString()!=null) {
                cell.setCellValue(String.valueOf(value));
                
        }else if (value instanceof Timestamp && value.toString()!=null) {
            cell.setCellValue(value.toString().substring(0, value.toString().length() - 11));
        }
        else {
            cell.setCellValue((String) value);
        }
    
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Venta venta : listaVentas) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, venta.getVentaId(), style);
            createCell(row, columnCount++, venta.getCantidad(), style);
            createCell(row, columnCount++, venta.getCostoVariableVenta(), style);
            createCell(row, columnCount++, venta.getFecha(), style);
            createCell(row, columnCount++, venta.getImporte(), style);
            createCell(row, columnCount++, venta.getProductoId(), style); 
        }

       


    }
  
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
 
 

     

    
