import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

class GroovyExcelParser {
  //http://poi.apache.org/spreadsheet/quick-guide.html#Iterator

  def parse(path) {
    InputStream inp = new FileInputStream(path)
    Workbook wb = WorkbookFactory.create(inp);
    Sheet sheet = wb.getSheetAt(0);

    Iterator<Row> rowIt = sheet.rowIterator()
    Row row = rowIt.next()
    def headers = getRowData(row)

    def rows = []
    while(rowIt.hasNext()) {
      row = rowIt.next()
      rows << getRowData(row)
    }
    [headers, rows]
  }

  /**
   * Returns an array of cell values
   * @param row
   * @return
   */
  def getRowData(Row row) {
    def data = []
    for (Cell cell : row) {
      getValue(row, cell, data)
    }
    data
  }

  def getValue(Row row, Cell cell, List data) {
    def rowIndex = row.getRowNum()
    def colIndex = cell.getColumnIndex()
    def value = ""
    switch (cell.getCellType()) {
      case Cell.CELL_TYPE_STRING:
        value = cell.getRichStringCellValue().getString();
        break;
      case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
            value = cell.getDateCellValue();
        } else {
            value = cell.getNumericCellValue();
        }
        break;
      case Cell.CELL_TYPE_BOOLEAN:1
        value = cell.getBooleanCellValue();
        break;
      case Cell.CELL_TYPE_FORMULA:
        value = cell.getCellFormula();
        break;
      default:
        value = ""
    }
    data[colIndex] = value
    data
  }

  def toXml(header, row) {
    def obj = "<row>\n"
    row.eachWithIndex { datum, i -> 
      def headerName = header[i]
      obj += "\t<$headerName>$datum</$headerName>\n" 
    } 
    obj += "</row>"
  }
  
  def printOut(header, row) {
	  def obj = ""
	  row.eachWithIndex { datum, i ->
		def headerName = header[i]
		obj += "$headerName: $datum\t"
	  }
	  obj
  }
  
  def toJson(header, row) {
	  //TODO
  }

  public static void main(String[]args) {
    def filename = 'testsheet.xlsx'
    GroovyExcelParser parser = new GroovyExcelParser()
    def (headers, rows) = parser.parse(filename)
    println 'Headers'
    println '------------------'
    headers.each { header -> 
      print '"' + header + '" ' 
    }
    println "\n"
    println 'Rows'
    println '------------------'
    rows.eachWithIndex { row, i ->
		print "Row $i: "
		println parser.printOut(headers, row)
    }
  }
}