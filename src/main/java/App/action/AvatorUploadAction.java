package App.action;

import App.vo.User;
import App.mysqlservice.UserService;
import MongoDBUtils.MD5Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@Scope("prototype")
public class AvatorUploadAction extends ActionSupport {
    // 上传文件域
    private File image;
    // 上传文件类型
    private String imageContentType;//三个特殊属性名，应与android中的UploadUtil中的name=image对应。
    // 封装上传文件名
    private String imageFileName;
    //
    private String savePath;

    public ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    public UserService userService=(UserService)ctx.getBean("userservice");

    public String getSavepath() {
        return "/www/server/tomcat/webapps/EnglishProject/Avator";
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    //
    private String savepath;

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public void uploadavator(){
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            String phonenumber=request.getParameter("phonenumber");//手机号
            //先查询MySQL获得头像路径
            User user=(User)userService.getUserByPhonenumber(phonenumber);
            String avatorname="";
            if(user.getAvator().equals("")){
                //当路径为空时创建路径
                String timestamp=String.valueOf(System.currentTimeMillis());
                String imageName= MD5Utils.md5Password(phonenumber+timestamp);
                avatorname=imageName+".jpg";//图片存放路径
                userService.UpdateAvatorByPhonenumber(phonenumber,avatorname);//更新图片路径
            }else{
                //当路径存在时获得数据库中的路径
                avatorname=user.getAvator();
            }
            //上传到服务器
            String serverpath=getSavepath()+"/"+avatorname;
            fos=new FileOutputStream(serverpath);
            fis=new FileInputStream(getImage());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("文件上传成功");
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.print("保存成功");
        } catch (Exception e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
        }
    }

    private void close(FileOutputStream fos, FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
                fis=null;
            } catch (IOException e) {
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
                fis=null;
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }
    }


}
