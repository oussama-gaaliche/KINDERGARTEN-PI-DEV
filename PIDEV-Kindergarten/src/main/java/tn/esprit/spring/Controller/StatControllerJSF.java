package tn.esprit.spring.Controller;

import java.util.List;

import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.Axis;
import org.chartistjsf.model.chart.AxisType;
import org.chartistjsf.model.chart.BarChartModel;
import org.chartistjsf.model.chart.BarChartSeries;
import org.chartistjsf.model.chart.LineChartModel;
import org.chartistjsf.model.chart.LineChartSeries;
import org.chartistjsf.model.chart.PieChartModel;



import org.ocpsoft.rewrite.el.ELBeanName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.StatistcRepository;
import tn.esprit.spring.Services.StatService;
import tn.esprit.spring.entity.Jardin;

@Scope(value = "session")
@Controller(value = "statControllerJSF")
@ELBeanName(value = "statControllerjsf")

public class StatControllerJSF {

	@Autowired
	StatService statService;

	@Autowired
	private JardinRepository jardinRepository;

	@Autowired
	private StatistcRepository statRepository;
	private PieChartModel pieModel;
	private BarChartModel barChartModel;
	private LineChartModel lineChartModel;

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public PieChartModel createPieChart() {
		pieModel = new PieChartModel();

		List<Jardin> jardin = jardinRepository.findAll();
		for (Jardin j : jardin) {
			pieModel.addLabel(j.getNom());
			pieModel.set(j.getNombreEnfant());

		}
		pieModel.setShowTooltip(true);
		return pieModel;
	}

	public BarChartModel createBarModel() {
		barChartModel = new BarChartModel();
		barChartModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);
		List<Jardin> jardin = jardinRepository.findAll();
		for (Jardin j : jardin) {
			barChartModel.addLabel(j.getNom());
		}
		BarChartSeries series1 = new BarChartSeries();
		series1.setName("Year 2020");
		List<Jardin> jardinYear20 = jardinRepository.findAll();
		for (Jardin j : jardinYear20) {

			series1.set(statRepository.NbUser2020(j.getId()));
		}

		BarChartSeries series2 = new BarChartSeries();
		series2.setName("Year 2019");
		List<Jardin> jardinYear19 = jardinRepository.findAll();
		for (Jardin j : jardinYear19) {

			series2.set(statRepository.NbUser2019(j.getId()));
		}
		BarChartSeries series3 = new BarChartSeries();
		series3.setName("Year 2018");
		List<Jardin> jardinYear18 = jardinRepository.findAll();
		for (Jardin j : jardinYear18) {

			series3.set(statRepository.NbUser2018(j.getId()));
		}
		Axis xAxis = barChartModel.getAxis(AxisType.X);
		xAxis.setShowGrid(false);
		Axis yAxis = barChartModel.getAxis(AxisType.Y);

		yAxis.setShowGrid(true);
		barChartModel.addSeries(series1);
		barChartModel.addSeries(series2);
		barChartModel.addSeries(series3);
		barChartModel.setShowTooltip(true);
		barChartModel.setSeriesBarDistance(15);
		//barChartModel.setAnimateAdvanced(true);
		return barChartModel;
	}

	public LineChartModel createLineModel() {
		lineChartModel = new LineChartModel();
		lineChartModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);
		lineChartModel.addLabel("January");
		lineChartModel.addLabel("February");
		lineChartModel.addLabel("Mars");
		lineChartModel.addLabel("April");
		lineChartModel.addLabel("May");
		lineChartModel.addLabel("June");
		lineChartModel.addLabel("July");
		lineChartModel.addLabel("August");
		lineChartModel.addLabel("September");
		lineChartModel.addLabel("October");
		lineChartModel.addLabel("November");
		lineChartModel.addLabel("December");
		LineChartSeries lineChartSeries1 = new LineChartSeries();
		lineChartSeries1.setName("This Year");
		for (int i = 1; i <= 12; i++) {
			lineChartSeries1.set(statRepository.NbUser2020ByMonth(i));
		}

		LineChartSeries lineChartSeries2 = new LineChartSeries();
		lineChartSeries2.setName("Last Year");
		for (int i = 1; i <= 12; i++) {
			lineChartSeries2.set(statRepository.NbUser2019ByMonth(i));
		}

		lineChartModel.addSeries(lineChartSeries1);
		lineChartModel.addSeries(lineChartSeries2);
		// lineChartModel.setAnimateAdvanced(true);
		lineChartModel.setShowTooltip(true);
		lineChartModel.setShowArea(true);

		return lineChartModel;
	}

}
