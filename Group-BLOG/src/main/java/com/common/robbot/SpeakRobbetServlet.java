package com.common.robbot;


import java.io.IOException;  
import java.util.Map;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

/**
 * 语言合成
 * @author Administrator
 *
 */
public class SpeakRobbetServlet extends HttpServlet{  
	  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException { 
        req.setCharacterEncoding("UTF-8");  
        String voiceName="xiaoyan";  
        String backgoundSound="0";  
        String speed=null;  
        String pitch=null;  
        String volume=null;  
        String mText=null;  
      /*  if(req.getParameter("VOICE_NAME")!=null || req.getParameter("VOICE_NAME").trim().length()!=0){  
            voiceName=req.getParameter("VOICE_NAME").trim();  
        }  
        if(req.getParameter("BACKGROUND_SOUND")!=null || req.getParameter("BACKGROUND_SOUND").trim().length()!=0){  
            backgoundSound = req.getParameter("BACKGROUND_SOUND").trim();  
        }  */
        if(req.getParameter("SPEED")!=null ||req.getParameter("SPEED").trim().length()!=0){  
            speed =  req.getParameter("SPEED").trim();  
        }  
        if(req.getParameter("PITCH")!=null ||req.getParameter("PITCH").trim().length()!=0){  
            pitch = req.getParameter("PITCH").trim();  
        }  
        if(req.getParameter("VOLUME")!=null ||req.getParameter("VOLUME").trim().length()!=0){  
            volume = req.getParameter("VOLUME").trim();  
        }  
        if(req.getParameter("mText")!=null || req.getParameter("mText").trim().length()!=0){  
            mText = req.getParameter("mText");  
        }  

        Map<String, String> mParamMap=SpeakUtil.initiateParam(voiceName,backgoundSound,speed,pitch,volume);  

        new SpeakService().start(mParamMap,mText);  
          
        //请求转发，服务器行为，转发后的对象仍存在  
        req.getRequestDispatcher("../view/dispatch/algorithms/77e8cd58965f1f329ed33cdd36a7c0bd").forward(req, resp);  
          
        //请求转发  
        //resp.sendRedirect("../3.jsp");  
    }  
  
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        this.doGet(req, resp);  
          
    }  
  
  
  
}  

