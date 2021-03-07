layui.use(['echarts',"jquery",'context'], function() {
	let echarts = layui.echarts;
	let $ = layui.jquery;
	const context = layui.context;
	const token = sessionStorage.getItem('token');
	var hostUrl = context.get("hostUrl")
	var line2 = echarts.init(document.getElementById('line2'));
	var chartDom = document.getElementById('main');
	// var myChart = echarts.init(chartDom);
	// var option;
	var s = []
	s.push('aa')
	s.push('bb')
	var dataAxis = [];
	var data = [];
	$.ajax({
		url:hostUrl+'/statistics/getDevApplicationNum',
		async:false,
		dataType:'json',
		contentType:'application/json',
		type:'get',
		success:function(result){

			var data3 =result.data;
			data3.forEach(function (v,i) {
				dataAxis.push(v.devName)
				data.push(v.count)
			})
			console.log(result.data)
		}
	})

	var yMax = 500;
	var dataShadow = [];

	for (var i = 0; i < data.length; i++) {
		dataShadow.push(yMax);
	}

	option = {
		title: {
			text: '单个设备借出次数统计表',
			// subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
		},
		xAxis: {
			data: dataAxis,
			axisLabel: {
				inside: true,
				textStyle: {
					color: '#fff'
				}
			},
			axisTick: {
				show: false
			},
			axisLine: {
				show: false
			},
			z: 10
		},
		yAxis: {
			axisLine: {
				show: false
			},
			axisTick: {
				show: false
			},
			axisLabel: {
				textStyle: {
					color: '#999'
				}
			}
		},
		dataZoom: [
			{
				type: 'inside'
			}
		],
		series: [
			{
				type: 'bar',
				showBackground: true,
				itemStyle: {
					color: new echarts.graphic.LinearGradient(
						0, 0, 0, 1,
						[
							{offset: 0, color: '#83bff6'},
							{offset: 0.5, color: '#188df0'},
							{offset: 1, color: '#188df0'}
						]
					)
				},
				emphasis: {
					itemStyle: {
						color: new echarts.graphic.LinearGradient(
							0, 0, 0, 1,
							[
								{offset: 0, color: '#2378f7'},
								{offset: 0.7, color: '#2378f7'},
								{offset: 1, color: '#83bff6'}
							]
						)
					}
				},
				data: data
			}
		]
	};
// // Enable data zoom when user click bar.
// 	var zoomSize = 6;
// 	myChart.on('click', function (params) {
// 		console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
// 		myChart.dispatchAction({
// 			type: 'dataZoom',
// 			startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
// 			endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
// 		});
// 	});
// 	option && myChart.setOption(option);
	line2.setOption(option);

	window.onresize = function() {
		line2.resize();
	}
})
