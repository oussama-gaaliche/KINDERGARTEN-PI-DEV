package tn.esprit.spring.Controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.UploadedFile;

import tn.esprit.spring.Services.PublicityServiceImpl;
import tn.esprit.spring.entity.Publicity;

//@WebServlet("/images/*")
//public class TestServelet extends HttpServlet {
	/*
	 @Inject
	    private PublicityServiceImpl cms;

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	          
	        String imageId = String.valueOf(request.getPathInfo().substring(1)); // Gets string that goes after "/images/".
	        Uploaded image = cms.findImage(imageId); // Get Image from DB.

	        response.setHeader("Content-Type", getServletContext().getMimeType(image.getName()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");

	        BufferedInputStream input = null;
	        BufferedOutputStream output = null;

	        try {
	            input = new BufferedInputStream(image.getData()); // Creates buffered input stream.
	            output = new BufferedOutputStream(response.getOutputStream());
	            byte[] buffer = new byte[8192];
	            for (int length = 0; (length = input.read(buffer)) > 0;) {
	                output.write(buffer, 0, length);
	            }
	        } finally {
	            if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
	            if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
	        }
	    }*/

//}
