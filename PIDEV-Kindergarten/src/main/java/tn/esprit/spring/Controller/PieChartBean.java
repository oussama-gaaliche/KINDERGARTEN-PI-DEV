package tn.esprit.spring.Controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.chartistjsf.model.chart.PieChartModel;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.ItemSelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.CountWord;

import tn.esprit.spring.repository.PostStatRepository;
import tn.esprit.spring.repository.WordCountRepository;
import tn.esprit.spring.services.PostStatService;

@Scope(value = "session")
@Controller(value = "PieChartBean")
@ELBeanName(value = "PieChartBean")
public class PieChartBean {
	
	
	
	
	@Autowired
	PostStatService statService;

	@Autowired
	private PostStatRepository poststatrepository;
	@Autowired
	private WordCountRepository wordcountrepository;

	private PieChartModel pieModel;



	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}



	public PieChartModel createPieChart() {
		pieModel = new PieChartModel();
		List<CountWord> count = wordcountrepository.findAll();
		for (CountWord c : count) {
			pieModel.addLabel(c.getWord());

			pieModel.set(c.getNbrRepi());

		}
		pieModel.setShowTooltip(true);
		return pieModel;
	}

	public void pieItemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Value: " + pieModel.getData().get(event.getItemIndex()));
		FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
	}

}