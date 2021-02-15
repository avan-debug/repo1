package com.avan.web.servletContext;

import com.avan.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/*
* 1.通过this.getServletContext获取到ServletContent对象
* 2.通过ServletContent对象的文件在项目中的绝对路径：在out目录下， 一般即为项目中的web目录下为端点
* 3.ServletContent对象获取到下载文件所需的类型，并设置到resp的响应头的content-type中
* 4.resp设置请求头中的content-disposition属性为attachment;filename=下载的文件名称
* 5.字节流传输即可
* */

/**
 * @ClassName DownloadServlet
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/9 16:11
 * @Version 1.0
 **/
@WebServlet("/downloadservlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        String type = servletContext.getMimeType(filename);

        String header = req.getHeader("user-agent");
        String fileName = DownLoadUtils.getFileName(header, filename);

        resp.setContentType(type);
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);
        ServletOutputStream os = resp.getOutputStream();
        byte[] bytes = new byte[1024*5];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes, 0, len);
        }
        fis.close();
    }
}
