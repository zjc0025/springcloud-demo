package easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelMergeTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        //获取数据源
        List<DemoData> data = data();

        File outFile = new File("D:\\测试合并行.xlsx");
        //需要合并的列
        int[] mergeColumeIndex = {0, 1, 2};
        //需要从第一行开始，列头第一行
        int mergeRowIndex = 1;
        EasyExcel//将数据映射到DownloadDTO实体类并响应到浏览器
                .write(outFile, DemoData.class)
                //07的excel版本,节省内存
                .excelType(ExcelTypeEnum.XLSX)
                //是否自动关闭输入流
                .autoCloseStream(Boolean.TRUE)
                .registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex))
//               // 自定义列宽度，有数字会
//                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                //设置excel保护密码
//                .password("123456")
                .sheet().doWrite(data);
    }

    //获取数据的地方
    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}
