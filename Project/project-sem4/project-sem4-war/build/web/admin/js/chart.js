$(document).ready(function() {
	// Load the Visualization API and the corechart package.
	google.charts.load('current', {'packages':['line']});
	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);
	
	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {
		
		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'month');
		data.addColumn('number', 'product');
		data.addRows([
			["Jan", 10],
			["Feb", 30],
			["Mar", 50],
			["Apr", 10],
			["May", 20],
			["Jun", 50],
			["Jul", 70],
			["Aug", 50],
			["Sep", 10],
			["Oct", 30],
			["Nov", 70],
			["Dec", 30]
		]);
		var chart_width = $(".chart-container").css("width");
		chart_width = chart_width.replace("px", "");
		// Set chart options
		var options = {
			chart: {
				title: 'test chart',
				subtitle: '(x 1 Product)'
			},
			width: chart_width - 32,
			height: 300
		};
		
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.charts.Line(document.getElementById('chart_div'));
		
		chart.draw(data, options);
	}
	// Make chart responsive
	window.addEventListener('resize', function() {
		drawChart();
	});
});