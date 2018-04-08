package com.iss.common.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @author: David Zhang
 * @description: 文件操作工具类
 * @date: 2017/11/4
 * @time: 14:24
 * @email: 990860210@qq.com
 */
public class FileUtils {

    /**
     * 判断文件是否存在，不存在就创建
     * @param file
     */
    public static void judeFileExists(File file) {

        if (file.exists()) {
            System.out.println("file exists");
        } else {
            System.out.println("file not exists, create it ...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * 判断文件夹是否存在，不存在就创建
     * @param file
     */
    public static void judeDirExists(File file) {

        if (!file.exists()) {
            System.out.println("dir not exists, create it ...");
            file.mkdir();
        }
    }


    public static Workbook getWorkbookFromRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        InputStream is=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile multipartFile = multiRequest.getFile(iterator.next());
                if(multipartFile !=null){
                    is=new ByteArrayInputStream(multipartFile.getBytes());
                }
            }
        }
        Workbook wb=new XSSFWorkbook(is);
        return wb;
    }


    public static String getCellValue(Cell cell) {
        String result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                // 数字类型 +日期类型
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                        SimpleDateFormat sdf = null;
                        if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                .getBuiltinFormat("h:mm")) {
                            sdf = new SimpleDateFormat("HH:mm");
                        } else {// 日期
                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                        }
                        Date date = cell.getDateCellValue();
                        result = sdf.format(date);
                    } else if (cell.getCellStyle().getDataFormat() == 58) {
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = org.apache.poi.ss.usermodel.DateUtil
                                .getJavaDate(value);
                        result = sdf.format(date);
                    } else {
                        DecimalFormat df = new DecimalFormat();
                        df.setGroupingUsed(false);
                        result = String.valueOf(df.format(cell
                                .getNumericCellValue()));
                    }
                    break;
                // String类型
                case HSSFCell.CELL_TYPE_STRING:
                    result = String.valueOf(cell.getStringCellValue());
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    result = "";
                default:
                    result = "";
                    break;
            }
        }

        return result;
    }

}
