package tn.esprit.spring.Controller;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


import tn.esprit.spring.Services.PublicityServiceImpl;



@ManagedBean(name = "productBean")
@RequestScoped
public class ImageStreamer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private StreamedContent productImage;



	public void setProductImage(StreamedContent productImage) {
		this.productImage = productImage;
	}


	

	

	public StreamedContent getProductImage() throws IOException, SQLException {

		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}

		else {

		

			byte[] image = new PublicityServiceImpl().findImage(1);

			productImage = new DefaultStreamedContent(new ByteArrayInputStream(image));
			return productImage;

		}
	}

}