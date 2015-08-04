package org.it.saan.member.model;

import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class Chartview extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int c1 = (Integer)model.get("man");
		int c2 = (Integer)model.get("woman");
		// System.out.println(c1 + "/" + c2);
		// 차트 생성해서 내보냄
		DefaultPieDataset ds = new DefaultPieDataset();
		
		ds.setValue("man", c1);
		ds.setValue("woman", c2);
		// ChartFactory.creatXXXXXXX (chart 종류)
		JFreeChart chart = ChartFactory.createPieChart3D("man : woman", ds);
			// chart data 인코딩은 구글링
		// JFreeChart : 직접 만들어서 보내줄 수 있지만, 디자인이 다양하지 않음
		OutputStream out = response.getOutputStream();
		ChartUtilities.writeChartAsPNG(out, chart, 400, 300);
		
		// JFreeChart : www.jfree.org 참고
	}
}
