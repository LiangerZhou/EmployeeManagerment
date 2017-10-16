function submitPage() {
	
		 var cpname = $("#status").val()
		 
		 $.ajax({
	    	dataType: "json",
	        data: {
	       	cpname: cpname,
	        },
	        type: "post", 
	        url: 'task_findByCpname.action',
	        success : function (data) {
	        	console.log(data);
	        	var a = JSON.stringify(data);
	        	console.log(a);
	       }
	   })
}


//导出考核表
function exportE() {

	$.ajax({
	    dataType: "",
	    data: {

	    },
	    type: "post", 
	    url: 'task_exportExcel.action',
	    success: function (data) {
	    }
	});
}