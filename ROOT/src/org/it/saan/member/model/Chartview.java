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
		// ��Ʈ �����ؼ� ������
		DefaultPieDataset ds = new DefaultPieDataset();
		
		ds.setValue("man", c1);
		ds.setValue("woman", c2);
		// ChartFactory.creatXXXXXXX (chart ����)
		JFreeChart chart = ChartFactory.createPieChart3D("man : woman", ds);
			// chart data ���ڵ��� ���۸�
		// JFreeChart : ���� ���� ������ �� ������, �������� �پ����� ����
		OutputStream out = response.getOutputStream();
		ChartUtilities.writeChartAsPNG(out, chart, 400, 300);
		
		// JFreeChart : www.jfree.org ����
	}
}
