package tn.esprit.spring.Controller;

import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.Axis;
import org.chartistjsf.model.chart.AxisType;
import org.chartistjsf.model.chart.BarChartModel;
import org.chartistjsf.model.chart.BarChartSeries;
import org.chartistjsf.model.chart.PieChartModel;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.ItemSelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.CountWord;
import tn.esprit.spring.repository.WordCountRepository;
import tn.esprit.spring.services.PostStatService;

@Scope(value = "session")
@Controller(value = "statControllerJSF")
@ELBeanName(value = "statControllerjsf")
public class PostStatControllerJSF {

private BarChartModel barChartModel;
private PieChartModel pieChartModel;
public PostStatControllerJSF() {
	createPieChart();
}
	
public void createPieChart() {
    pieChartModel = new PieChartModel();
    pieChartModel.addLabel("Area 1");
    pieChartModel.addLabel("Area 2");
    pieChartModel.addLabel("Area 3");
    pieChartModel.set(20);
    pieChartModel.set(25);
    pieChartModel.set(15);
    pieChartModel.setShowTooltip(true);
}
public void pieItemSelect(ItemSelectEvent event) {
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", "Item Value: "
            + pieChartModel.getData().get(event.getItemIndex()));
    FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
}
public PieChartModel getPieChartModel() {
    return pieChartModel;
}
public void setPieChartModel(PieChartModel pieChartModel) {
    this.pieChartModel = pieChartModel;
}
}

