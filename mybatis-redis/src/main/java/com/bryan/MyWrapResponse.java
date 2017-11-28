package com.bryan;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MyWrapResponse extends HttpServletResponseWrapper {

    private ByteArrayOutputStream buffer;
    private PrintWriter writer;
    ServletOutputStream out;
    public MyWrapResponse(HttpServletResponse response) {
        super(response);
        buffer = new ByteArrayOutputStream();
    }

    //修改增强getWtier方法
    @Override
    public PrintWriter getWriter() throws IOException {
        writer = new PrintWriter(new OutputStreamWriter(buffer, "UTF-8"));
        return writer;
    }


    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        out = new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {

            }

            //所有IO最终都是一个个字节写出信息
            @Override
            public void write(int b) throws IOException {
               // System.out.println(">>>:"+b);
                buffer.write(b);//写到自己的缓存中去-相当于StringBuffer.append(""+b);
            }
        };
        return out;
    }


    @Override
    public void reset() {
        buffer.reset();
    }

    //提供一个方法获取原生 的数据
    public byte[] getSrc(){
        if(writer!=null){
            writer.close();
        }
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toByteArray();
    }
}
