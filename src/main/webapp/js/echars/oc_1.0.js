/**
 * 
 * 2016-04-28
 * 注释只写了第一层，里面几层均相同
 * 此js的前提是数据中id必须唯一，因为是根据id加以判断的。
 * 目前只实现到第六层（包括root），可扩充
 * 下面所有注释的代码供调试使用
 * 未使用递归，是因为本人觉得使用递归在操作（增删）data数据的时候，会出现问题（未测）
 * 如有大神有其他简单办法，希望告诉我一下。
 * 
 */
var clickMap={};//用来存储子节点（供收缩，打开节点使用）
//点击时 调用
function a(ecData){
	//alert("2");
	var _name = ecData.name;//当前点击节点的名称
	var _id = ecData.data.id;//当前点击节点的id
	if(_posarr){
		var _posarr=null;
	}
	var _posarr_=_posarr;//所有老节点的信息{[id,x,y],[id,x,y]..}//貌似没啥用
	
	// for(var iii= 0 ; iii<_posarr_.length;iii++){
	//	 alert(_posarr_[iii]);
	// }
	//console.log(ecData.data);
	var isChild=ecData.data.children;//是否存在子节点
	//alert(!(!isChild));
	var _option=option;
	var len1=_option.series[0].data.length;
	var d1=_option.series[0].data;//所有的d*在下面代码中均为使用到。
	var f=false;//是否找到对应节点【循环所有数据，查找到 be clicked node 在option中的位置】//----f=true.跳出所有循环
	//循环clickMap中所有的节点信息
	//for(var prop in clickMap){
	//	if(clickMap.hasOwnProperty(prop)){
	//		alert(prop+'-'+clickMap[prop]);
	//	}
	//}
	//开始循环_option中的信息，用来查找当前点击的节点
	for(var j=0;j<len1;j++){
		//alert('d1[j].id='+d1[j].id);
		//第一个节点不让关闭（收起）
		if(_option.series[0].data[j].id==_id){
			//alert('can\'t be closed.');
			//alert(_option.series[0].data[j].id==_id);
			//console.log(_option.series[0].data[j].id);
			//console.log(_id);
			alert('根节点不能收缩！');
			break;
		}
		//alert(d1[j].children);
		if(_option.series[0].data[j].children!==undefined && _option.series[0].data[j].children.length>0){//若存在子节点
			var len2=_option.series[0].data[j].children.length;
			var d2=_option.series[0].data[j].children;
			for(var k=0;k<len2;k++){
				//alert('j:'+j+'--k:'+k+'-'+d2[k].id);
				//根据id判断节点是否是当前所点击的节点，
				if(_option.series[0].data[j].children[k].id==_id){
					//判断该节点是否已关闭，若clickMap中存在k为当前节点名称的数据，并且不为空。则说明已关闭，要打开。
					if(clickMap.hasOwnProperty(_id) && clickMap[_id]!=null){
						//alert(_id+' has closed . open now.');
						//将clickMap中的该节点的子节点信息重新赋值给当前节点
						_option.series[0].data[j].children[k].children=clickMap[_id];
						clickMap[_id]=null;//成功打开后，将clickMap中的数据赋null
						f=true;
						//跳出所有循环。
						_option.series[0].data[j].children[k]["itemStyle"] = {normal:{color: '#4883b4'},emphasis:{color: '#4883b4'}};
						_option.series[0].data[j].children[k]["symbol"] = 'circle';
						break;
					}
					//执行到这里，说明未关闭。执行关闭操作
					f=true;
					//若所点击的节点存在子节点，则
					if(_option.series[0].data[j].children[k].children!==undefined && _option.series[0].data[j].children[k].children.length>0){
						//将子节点信息存入clickMap，形式【当前点击节点的id为key，子节点数据为value】
						clickMap[_option.series[0].data[j].children[k].id]=_option.series[0].data[j].children[k].children;
						//然后将_option中的当前子节点删除。
						_option.series[0].data[j].children[k]["itemStyle"] = {normal:{color: 'red'},emphasis:{color: 'red'}};
						_option.series[0].data[j].children[k]["symbol"] = 'diamond';
						delete _option.series[0].data[j].children[k].children;
					}
					//alert('find the node.j='+j+';k='+k);
					
					//跳出所有循环
					break;
				}//else{alert(' not find the node.j='+j+';k='+k);}
				if(f)break;
				if(_option.series[0].data[j].children[k].children!==undefined && _option.series[0].data[j].children[k].children.length>0){
					var len3=_option.series[0].data[j].children[k].children.length;
					var d3=_option.series[0].data[j].children[k].children;

					//debugger;
					for(var l=0;l<len3;l++){
						//alert('j:'+j+'--k:'+k+'--l:'+l+'-'+d3[l].id);
						if(_option.series[0].data[j].children[k].children[l].id==_id){
							if(clickMap.hasOwnProperty(_id) && clickMap[_id]!=null){
								//alert(_id+'has closed . open now.');
								_option.series[0].data[j].children[k].children[l].children=clickMap[_id];
								clickMap[_id]=null;
								f=true;
								_option.series[0].data[j].children[k].children[l]["itemStyle"] = {normal:{color: '#4883b4'},emphasis:{color: '#4883b4'}};
								_option.series[0].data[j].children[k].children[l]["symbol"] = 'circle';
							    //console.log(_option.series[0].data[j].children[k].children[l].children);
		                        //console.log("1-----");
								break;
							}
							f=true;
							//alert('find the node.j='+j+';k='+k+';l='+l+'--'+_option.series[0].data[j].children[k].children[l].id);
							if(_option.series[0].data[j].children[k].children[l].children!==undefined && _option.series[0].data[j].children[k].children[l].children.length>0){
								clickMap[_option.series[0].data[j].children[k].children[l].id]=_option.series[0].data[j].children[k].children[l].children;
								_option.series[0].data[j].children[k].children[l]["itemStyle"] = {normal:{color: 'red'},emphasis:{color: 'red'}};
								_option.series[0].data[j].children[k].children[l]["symbol"] = 'diamond';
								//console.log(_option.series[0].data[j].children[k].children[l].children.length>0);
								//console.log("2-----");
								delete _option.series[0].data[j].children[k].children[l].children;
							}
							break;
						}//else{alert(' not find the node.j='+j+';k='+k+';l='+l+'--'+d3[l].id);}
						if(f)break;
						if(_option.series[0].data[j].children[k].children[l].children){
							var len4=_option.series[0].data[j].children[k].children[l].children.length;
							var d4=_option.series[0].data[j].children[k].children[l].children;
							for(var m=0;m<len4;m++){
								if(_option.series[0].data[j].children[k].children[l].children[m].id==_id){
									if(clickMap.hasOwnProperty(_id) && clickMap[_id]!=null){
										//alert(_id+'has closed . open now.');
										_option.series[0].data[j].children[k].children[l].children[m].children=clickMap[_id];
										clickMap[_id]=null;
										f=true;
										_option.series[0].data[j].children[k].children[l].children[m]["itemStyle"] = {normal:{color: '#4883b4'},emphasis:{color: '#4883b4'}};
										_option.series[0].data[j].children[k].children[l].children[m]["symbol"] = 'circle';
										//console.log(_option.series[0].data[j].children[k].children[l].children[m]);
		                                //console.log("3-----");
										break;
									}
									f=true;
									//alert('find the node.j='+j+';k='+k+';l='+l+';m='+m+'--'+_option.series[0].data[j].children[k].children[l].children[m].id);
									if(_option.series[0].data[j].children[k].children[l].children[m].children!==undefined && _option.series[0].data[j].children[k].children[l].children[m].children.length>0){
										clickMap[_option.series[0].data[j].children[k].children[l].children[m].id]=_option.series[0].data[j].children[k].children[l].children[m].children;
										_option.series[0].data[j].children[k].children[l].children[m]["itemStyle"] = {normal:{color: 'red'},emphasis:{color: 'red'}};
										_option.series[0].data[j].children[k].children[l].children[m]["symbol"] = 'diamond';
										//console.log(_option.series[0].data[j].children[k].children[l].children[m]);
										//console.log("4-----");
										delete _option.series[0].data[j].children[k].children[l].children[m].children;
									}
									break;
								}//else{alert(' not find the node.j='+j+';k='+k+';l='+l+';m='+m+'--'+d4[m].id);}
								if(f)break;
								if(_option.series[0].data[j].children[k].children[l].children[m].children){
									var len5=_option.series[0].data[j].children[k].children[l].children[m].children.length;
									var d5=_option.series[0].data[j].children[k].children[l].children[m].children;
									for(var n = 0 ; n<len5;n++){
										/**
										 * 最后一层循环
										 * 若有需要，可扩充
										 */
										if(_option.series[0].data[j].children[k].children[l].children[m].children[n].id==_id){
											if(clickMap.hasOwnProperty(_id)&&clickMap[_id]!=null){
												//alert(_id+'has closed . open now.');
												_option.series[0].data[j].children[k].children[l].children[m].children[n].children=clickMap[_id];
												clickMap[_id]=null;
												f=true;
												_option.series[0].data[j].children[k].children[l].children[m].children[n]["itemStyle"] = {normal:{color: '#4883b4'},emphasis:{color: '#4883b4'}};
												_option.series[0].data[j].children[k].children[l].children[m].children[n]["symbol"] = 'circle';
												//console.log(_option.series[0].data[j].children[k].children[l].children[m].children[n]);
		                                        //console.log("5-----");
												break;
											}
											f=true;
											//alert('find the final node .'+_option.series[0].data[j].children[k].children[l].children[m].children[n].id);
											if(_option.series[0].data[j].children[k].children[l].children[m].children[n].children!==undefined && _option.series[0].data[j].children[k].children[l].children[m].children[n].children.length>0){
												clickMap[_option.series[0].data[j].children[k].children[l].children[m].children[n].id]=_option.series[0].data[j].children[k].children[l].children[m].children[n].children;
												_option.series[0].data[j].children[k].children[l].children[m].children[n]["itemStyle"] = {normal:{color: 'red'},emphasis:{color: 'red'}};
												_option.series[0].data[j].children[k].children[l].children[m].children[n]["symbol"] = 'diamond';
												//console.log(_option.series[0].data[j].children[k].children[l].children[m].children[n]);
												//console.log("6-----");
												delete _option.series[0].data[j].children[k].children[l].children[m].children[n].children;
											}
											
											break;
										}//else{alert(' not find the final node .'+d5[n].id);}
										if(f)break;
									}
								}//else{alert('d4[m]:'+d4[m].id +'-下没有子级');}
								if(f)break;
							}
						}//else{alert('d3[l]:'+d3[l].id+'-没有子级');}
						if(f)break;
					}
				}//else{alert('d2[k]:'+d2[k].id+'没有子级');}
				if(f)break;
			}
		}//else{alert('d1[j]:'+d1[j].id+'下没有子级');}
		if(f)break;
	}
	 //ecData.data["itemStyle"] = {normal:{color: 'red'},emphasis:{color: 'red'}};
	 //myChart._option.series[0].data = myChart._chartList[1].series[0].data;
	// _option.series[0].data = myChart._chartList[1].series[0].data;
	//alert('over.');
	//清空当前echarts
	 myChart.clear();
	 //重新赋值，渲染图表
	 //console.log(myChart._option);
	 //console.log(_option);
     myChart.setOption(_option);
	// _posarr_=_posarr;//新的坐标？？？//待开发功能。
	// for(var ii= 0 ; ii<_posarr_.length;ii++){
	//	 alert(_posarr_[ii]);
	// }
	 //刷新，没啥用。。
	 myChart.refresh();
	//for(var i=0;i<_posarr_.length;i++){
	//	if(_id==_posarr_[i][0]){
	//		alert('当前点击：'+_posarr_[i]);
	//		break;
	//	}
	//}
}