layui.use(['echarts',"jquery",'context'], function() {
	let echarts = layui.echarts;
	let $ = layui.jquery;
	const context = layui.context;
	const token = sessionStorage.getItem('token');
	var hostUrl = context.get("hostUrl")
	var line1 = echarts.init(document.getElementById('line1'));
	var devName = []
	var sum =[]
	$.ajax({
		url:hostUrl+'/statistics/getDevApplicationQuantity',
		async:false,
		dataType:'json',
		contentType:'application/json',
		type:'get',
		success:function(result){

			var data3 =result.data;
			data3.forEach(function (v,i) {
				devName.push(v.devName)
				sum.push(v.sum)
			})
			console.log(result.data)
		}
	})
	const colorList = ["#9E87FF", '#73DDFF', '#fe9a8b', '#F56948', '#9E87FF']
	option = {
		title: {
				text: '单个设备借出数量统计表',
			// subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
				},
	            backgroundColor: '#fff',
	            tooltip: {
	           		show: false
	            },
	            grid: {
	            	top: '10%',
	                bottom: '6%',
	                left: '6%',
	                right: '6%',
	                containLabel: true
	            },
	            xAxis: [{
	                type: 'category',
	                boundaryGap: false,
	                axisLine: {
	                    show: false
	                },
	                axisTick: {
	                	show: false
	                },
	                axisLabel: {
	                    margin: 10,
	                    textStyle: {
	                        fontSize: 14,
	                        color: '#999',
	                    }
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#999',
	                        // opacity: .15
	                    }
	                },
	                data:devName
	            },],
	            yAxis: [{
	                type: 'value',
	                offset: 15,
	                max: 50,
	                min: 0,
	                axisTick: {
	                    show: false
	                },
	                axisLine: {
	                    show: false
	                },
	                axisLabel: {
	                    margin: 10,
	                    textStyle: {
	                        fontSize: 14,
	                        color: '#000',
	                    }
	                },
	                splitLine: {
	                    show: false
	                }
	
	            }],
	            series: [{
	                name: '2',
	                type: 'line',
	                z: 3,
	                showSymbol: false,
	                smoothMonotone: 'x',
	                lineStyle: {
	                        width: 3,
	                        color: {
	                            type: 'linear',
	                            x: 0,
	                            y: 0,
	                            x2: 0,
	                            y2: 1,
	                            colorStops: [{
	                                offset: 0, color: 'rgba(59,102,246)' // 0% 处的颜色
	                            }, {
	                                offset: 1, color: 'rgba(118,237,252)' // 100% 处的颜色
	                            }]
	                        },
	                        shadowBlur: 4,
	                        shadowColor: 'rgba(69,126,247,.2)',
	                        shadowOffsetY: 4
	                },
	                areaStyle: {
	                    normal: {
	                        color: {
	                            type: 'linear',
	                            x: 0,
	                            y: 0,
	                            x2: 0,
	                            y2: 1,
	                            colorStops: [{
	                                offset: 0, color: 'rgba(227,233,250,.9)' // 0% 处的颜色
	                            }, {
	                                offset: 1, color: 'rgba(248,251,252,.3)' // 100% 处的颜色
	                            }]
	                        }
	                    }
	                },
	                smooth: true,
	                data: sum
	            }]
	        
	};

	line1.setOption(option);

	window.onresize = function() {
		line1.resize();
	}
})
