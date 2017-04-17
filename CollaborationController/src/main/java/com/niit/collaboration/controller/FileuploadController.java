package com.niit.collaboration.controller;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.collaboration.dao.FileuploadDAO;
import com.niit.collaboration.dao.User_DetailDAO;
import com.niit.collaboration.model.Fileupload;
import com.niit.collaboration.model.User_Detail;



/** Handles requests for the file upload page. */

@RestController
public class FileuploadController
{
	
	@Autowired
	private FileuploadDAO fileuploadDAO;

	@Autowired
	private User_DetailDAO user_DetailDAO;
	
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public ModelAndView handleFileUpload(HttpServletRequest request,HttpSession session,@RequestParam("uploadFile") CommonsMultipartFile uploadFile) throws Exception 
    {
    	
    	 User_Detail user_Detail= user_DetailDAO.getUser(session.getAttribute("loggedInUserID").toString());
         if(user_Detail==null)
        	 throw new RuntimeException("Not logged in");
         System.out.println("USER is " + user_Detail.getId());
         
         if (uploadFile != null ) {
             CommonsMultipartFile aFile = uploadFile;
            
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                
                Fileupload fileupload = new Fileupload();
                fileupload.setFileName(aFile.getOriginalFilename());
                fileupload.setData(aFile.getBytes());//image 
                fileupload.setUsername(user_Detail.getId());//login details
                fileuploadDAO.save(fileupload);
                //select * from proj2_profie_pics where id='smith'
                Fileupload getFileUpload=fileuploadDAO.getFile(user_Detail.getId());
            	String name=getFileUpload.getFileName();
            	System.out.println(getFileUpload.getData());
            	byte[] imagefiles=getFileUpload.getData();  //image
            	try{
            		//change the path according to your workspace and the name of your project
            		String path="D:/SecondProject/CollaborationFrontEnd/WebContent/images/"+user_Detail.getId();
            		File file=new File(path);
            		//file.mkdirs();
            		FileOutputStream fos = new FileOutputStream(file);
            		fos.write(imagefiles);// write the array of bytes in id file.
            		fos.close();
            		}catch(Exception e){
            		e.printStackTrace();
            		}
             }
         ModelAndView mv = new ModelAndView("/imgFromHome");
        return mv;
    }
}
